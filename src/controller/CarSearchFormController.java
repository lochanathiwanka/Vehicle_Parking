package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import model.Car;
import model.Vehicle;
import javax.swing.*;
import java.sql.SQLException;
import java.util.logging.Logger;

public class CarSearchFormController {
    public JFXTextField txtSearch;
    public TextField txtCarNumber;
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
        Vehicle vehicle = new Car(txtCarNumber.getText(),txtFirstName.getText(),txtLastName.getText());
        vehicle.setSQL("Insert into carParkingTempory (number,firstName,lastName,date,arrivalTime) Values(?,?,?,?,?)");
        try{
            boolean isAddedtoPark = VehicleController.addVehicletoPark(vehicle,txtDate.getText(),txtArrivalTime.getText());
            if (isAddedtoPark){
                JOptionPane.showMessageDialog(null, "Car was Successfully added to the Parking","",JOptionPane.INFORMATION_MESSAGE);
                vehicle.setSQL("Insert into carParking (number,firstName,lastName,date,arrivalTime) Values(?,?,?,?,?)");
                VehicleController.addVehicletoPark(vehicle,txtDate.getText(),txtArrivalTime.getText());
                    textFieldsClear();
                    vehicle = null;
                    txtSearch.setText(null);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Can't added Car","",JOptionPane.WARNING_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver not found","",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void textFieldsClear(){
        txtCarNumber.setText(null);
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
        Vehicle v = new Car();
        v.setSQL("Select number,firstName,lastName From carDetails where number=?");
        try {
            Vehicle vehicle=VehicleController.searchVehicle(txtSearch.getText(),"Car",v);
            if(vehicle!=null){
                txtCarNumber.setText(vehicle.getVehicleNumber());
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
        Vehicle v = new Car();
        v.setSQL("Select number from carParkingTempory where number =?");
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
