package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Van;
import model.Vehicle;

import javax.swing.*;
import java.sql.SQLException;
import java.util.logging.Logger;

public class VanSearchFormController {
    public JFXTextField txtSearch;
    public TextField txtVanNumber;
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtDate;
    public JFXTextField txtWarning;
    public String number;

    private Logger logger = Logger.getLogger("ConfirmController");

    @FXML
    private TextField txtArrivalTime;

    @FXML
    private JFXButton btnAddToParking;

    @FXML
    public void initialize() {
        btnAddToParking.disableProperty().bind(
                txtArrivalTime.textProperty().isEqualTo(txtArrivalTime.textProperty()).not()
                        .or(
                                txtArrivalTime.textProperty().isEmpty()
                        )
        );
    }

    @FXML
    public void save(ActionEvent evt) {
        logger.info("confirmed " + txtArrivalTime.getText());
        hide(evt);
    }

    @FXML
    public void cancel(ActionEvent evt) {
        hide(evt);
    }

    private void hide(ActionEvent evt) {
        ((Node)evt.getSource()).getScene().getWindow().hide();
    }

    public void btnAddToParkingOnAction(ActionEvent actionEvent) {
        Vehicle vehicle = new Van(txtVanNumber.getText(),txtFirstName.getText(),txtLastName.getText());
        vehicle.setSQL("Insert into vanParkingTempory (number,firstName,lastName,date,arrivalTime) Values(?,?,?,?,?)");
        try{
            boolean isAddedtoPark = VehicleController.addVehicletoPark(vehicle,txtDate.getText(),txtArrivalTime.getText());
            if (isAddedtoPark){
                JOptionPane.showMessageDialog(null, "Van was Successfully added to the Parking","",JOptionPane.INFORMATION_MESSAGE);
                vehicle.setSQL("Insert into vanParking (number,firstName,lastName,date,arrivalTime) Values(?,?,?,?,?)");
                VehicleController.addVehicletoPark(vehicle,txtDate.getText(),txtArrivalTime.getText());
                textFieldsClear();
                vehicle = null;
                txtSearch.setText(null);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Can't added Van","",JOptionPane.WARNING_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver not found","",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void textFieldsClear(){
        txtVanNumber.setText(null);
        txtFirstName.setText(null);
        txtLastName.setText(null);
        txtDate.setText(null);
        txtArrivalTime.setText(null);
    }

    public void searchKeyPressedOnAction(KeyEvent keyEvent) {
        findIsVehicleInParking();
        forSearchField();
    }

    public void searchKeyReleasedOnAction(KeyEvent keyEvent) {
        findIsVehicleInParking();
        forSearchField();
    }

    public void searchKeyTypedOnAction(KeyEvent keyEvent) {
        findIsVehicleInParking();
        forSearchField();
    }

    public void forSearchField(){
        Vehicle v = new Van();
        v.setSQL("Select number,firstName,lastName From vanDetails where number=?");
        try {
            Vehicle vehicle=VehicleController.searchVehicle(txtSearch.getText(),"Van",v);
            if(vehicle!=null){
                txtVanNumber.setText(vehicle.getVehicleNumber());
                txtFirstName.setText(vehicle.getFirstName());
                txtLastName.setText(vehicle.getLastName()+"");
                v=null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void findIsVehicleInParking(){
        Vehicle v = new Van();
        v.setSQL("Select number from vanParkingTempory where number =?");
        try {
            boolean isFind = VehicleController.findNumberfromParkingTempory(v,txtSearch.getText());
            if (isFind){
                txtWarning.setVisible(true);
                txtDate.setVisible(false);
                txtArrivalTime.setVisible(false);
                btnAddToParking.setVisible(false);
                v=null;
            }
            else {
                txtDate.setVisible(true);
                txtArrivalTime.setVisible(true);
                btnAddToParking.setVisible(true);
                textFieldsClear();
                txtWarning.setVisible(false);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
