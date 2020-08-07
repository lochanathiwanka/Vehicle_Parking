package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import model.StageList;

import javax.swing.*;

public class CashierLoginFormController extends StageList {
    public JFXTextField txtUsername;
    public JFXPasswordField pwdPassword;

    public void loginValidationCashier() throws Exception{
        int userName = txtUsername.getText().length();
        int password = pwdPassword.getText().length();
        if (userName!=0&&password!=0){
            if (txtUsername.getText().equalsIgnoreCase("c")&&pwdPassword.getText().equalsIgnoreCase("c")){
                vehicleExitStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/VehicleExitForm.fxml"))));
                vehicleExitStage.setResizable(false);
                vehicleExitStage.show();
                mainStage.close();
            }
            else{
                JOptionPane.showMessageDialog(null,"User Name or Password might be wrong.please try again!","",JOptionPane.WARNING_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"User Name and Password fields cannot be empty!","",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws Exception {
        loginValidationCashier();
        txtUsername.setText(null);
        pwdPassword.setText(null);
    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }
}
