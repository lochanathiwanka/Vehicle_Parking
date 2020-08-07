package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import model.StageList;

public class MainFormController extends StageList {
    public AnchorPane stagePane;
    public JFXButton btnVehicleEntry;

    public void setSecurityLoginPane() throws Exception{
        stagePane.getChildren().clear();
        AnchorPane newLoginPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/SecurityLoginForm.fxml"));
        stagePane.getChildren().setAll(newLoginPane.getChildren());
    }

    public void setCashierLoginPane() throws Exception{
        stagePane.getChildren().clear();
        AnchorPane newLoginPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/CashierLoginForm.fxml"));
        stagePane.getChildren().setAll(newLoginPane.getChildren());
    }

    public void vehicleEntryOnAction(ActionEvent actionEvent) throws Exception {
        setSecurityLoginPane();
    }

    public void vehicleExitOnAction(ActionEvent actionEvent) throws Exception{
        setCashierLoginPane();
    }

    public void paymentOnAction(ActionEvent actionEvent) throws Exception{
        mainMenuPaymentStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/CustomerPaymentsForm.fxml"))));
        mainMenuPaymentStage.setResizable(false);
        mainMenuPaymentStage.show();
        mainStage.close();
    }

    public void exitOnAction(ActionEvent actionEvent) {
        System.exit(0 );
    }
}
