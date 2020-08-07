package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import model.StageList;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class SecurityLoginFormController extends StageList{
    public JFXTextField txtUsername;
    public JFXPasswordField pwdPassword;
    public AnchorPane loginPane;

    public void loginValidationSecuirity() throws Exception{
        int userName = txtUsername.getText().length();
        int password = pwdPassword.getText().length();
        if (userName!=0&&password!=0){
            if (txtUsername.getText().equalsIgnoreCase("s")&&pwdPassword.getText().equalsIgnoreCase("s")){
                vehicleEntryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/VehicleEntryForm.fxml"))));
                vehicleEntryStage.setResizable(false);
                vehicleEntryStage.show();
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
        loginValidationSecuirity();
        txtUsername.setText(null);
        pwdPassword.setText(null);
    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

}
