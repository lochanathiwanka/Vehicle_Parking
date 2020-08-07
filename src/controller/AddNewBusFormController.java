package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import model.Bus;
import model.Vehicle;

import javax.swing.*;
import java.sql.SQLException;
import java.util.logging.Logger;

public class AddNewBusFormController {
    public JFXTextField txtBusNumber;
    public JFXTextField txtLastName;

    private Logger logger = Logger.getLogger("ConfirmController");

    @FXML
    private JFXTextField txtFirstName;

    @FXML
    private JFXButton btnAdd;

    @FXML
    public void initialize() {
        btnAdd.disableProperty().bind(
                txtFirstName.textProperty().isEqualTo(txtFirstName.textProperty()).not()
                        .or(
                                txtFirstName.textProperty().isEmpty()
                        )
        );
    }

    @FXML
    public void save(ActionEvent evt) {
        logger.info("confirmed " + txtFirstName.getText());
        hide(evt);
    }

    @FXML
    public void cancel(ActionEvent evt) {
        hide(evt);
    }

    private void hide(ActionEvent evt) {
        ((Node)evt.getSource()).getScene().getWindow().hide();
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        Vehicle vehicle = new Bus(txtBusNumber.getText(),txtFirstName.getText(),txtLastName.getText());
        vehicle.setSQL("Insert into busDetails (number,firstName,lastName) Values(?,?,?)");
        try {
            boolean isBusAdded = VehicleController.addVehicle(vehicle);
            if (isBusAdded){
                JOptionPane.showMessageDialog(null,"Bus was registered to the system","",JOptionPane.INFORMATION_MESSAGE);
                clearTextFields();
            }
        }catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Error","",JOptionPane.ERROR_MESSAGE);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Bus is already added to the system","",JOptionPane.WARNING_MESSAGE);
        }
    }

    public void clearTextFields(){
        txtBusNumber.setText(null);
        txtFirstName.setText(null);
        txtLastName.setText(null);
    }

    public void numberKeyPressedOnAction(KeyEvent keyEvent) {
        forSearchField();
    }

    public void numberKeyReleasedOnAction(KeyEvent keyEvent) {
        forSearchField();
    }

    public void numberKeyTypedOnAction(KeyEvent keyEvent) {
        forSearchField();
    }

    public void forSearchField(){
        Vehicle v = new Bus();
        v.setSQL("Select number,firstName,lastName From busDetails where number=?");
        try {
            Vehicle vehicle=VehicleController.searchVehicle(txtBusNumber.getText(),"Bus",v);
            if(vehicle!=null){
                txtFirstName.setText(vehicle.getFirstName());
                txtFirstName.setEditable(false);
                txtLastName.setText(vehicle.getLastName()+"");
                txtLastName.setEditable(false);
                btnAdd.setVisible(false);
            }else{
                txtFirstName.setText(null);
                txtLastName.setText(null);
                txtFirstName.setEditable(true);
                txtLastName.setEditable(true);
                btnAdd.setVisible(true);
            }
        } catch (SQLException ex) { } catch (ClassNotFoundException ex) { }
    }
}
