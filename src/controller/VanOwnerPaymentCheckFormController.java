package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Van;
import model.Vehicle;

import javax.swing.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class VanOwnerPaymentCheckFormController implements Initializable {
    public TextField txtVanNumberField;
    public TextField txtFirstNameField;
    public TextField txtLastNameField;
    public TextField txtPaymentField;
    public JFXTextField txtSearch;
    public JFXButton btnRemove;

    public void btnRemoveOnAction(ActionEvent actionEvent) {
        Vehicle vehicle = new Van();
        vehicle.setSQL("Delete from vanParkingTempory where number = ?");
        try{
            boolean isRemoved = VehicleController.removeVehicleFromParkingTempory(vehicle,txtVanNumberField.getText());
            if (isRemoved){
                JOptionPane.showMessageDialog(null,"Van was removed from parking","",JOptionPane.INFORMATION_MESSAGE);
                textFieldsReset();
            }
        }catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Driver Not Found");
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void searchKeyPressed(KeyEvent keyEvent) {
        forSearchField();
    }

    public void searchKeyReleased(KeyEvent keyEvent) {
        forSearchField();
    }

    public void searchKeyTyped(KeyEvent keyEvent) {
        forSearchField();
    }

    public void textFieldsReset(){
        txtVanNumberField.setText(null);
        txtFirstNameField.setText(null);
        txtLastNameField.setText(null);
        txtPaymentField.setText(null);
        btnRemove.setDisable(true);
    }

    public void forSearchField(){
        Vehicle vehicle = new Van();
        vehicle.setSQL("Select number,firstName,lastName,paymentStatus from vanParkingTempory where number = ?");
        try {
            String[] list = VehicleController.getAllValuesFromParkingHistory(vehicle,txtSearch.getText());
            if (list!=null){
                txtVanNumberField.setText(list[0]);
                txtFirstNameField.setText(list[1]);
                txtLastNameField.setText(list[2]);
                txtPaymentField.setText(list[3]);
                if (txtPaymentField.getText().length()==0){
                    btnRemove.setDisable(true);
                }else {
                    btnRemove.setDisable(false);
                }
                list=null;
            }else{
                textFieldsReset();
            }
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }catch (SQLException ex){
            ex.printStackTrace();
        }catch (NullPointerException ex){
            txtPaymentField.setText("Not Payed yet!");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textFieldsReset();
    }
}
