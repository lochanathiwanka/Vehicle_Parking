package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.StageList;
import java.net.URL;
import java.util.ResourceBundle;

public class VehicleEntryFormController extends StageList implements Initializable {

    public AnchorPane childPane;
    public JFXButton btnAvailableSlots;

    public void btnBackOnAction(MouseEvent mouseEvent) throws Exception{
        backConfirmStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/BackConfirmForm.fxml"))));
        backConfirmStage.setResizable(false);
        backConfirmStage.setX(200);
        backConfirmStage.setY(140);
        backConfirmStage.show();
    }

    public void slotsCheck() throws Exception{
        btnAvailableSlots.setCursor(Cursor.WAIT);
        childPane.getChildren().clear();
        AnchorPane newCheckSlotsPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/CheckSlotsForm.fxml"));
        childPane.getChildren().setAll(newCheckSlotsPane.getChildren());
        btnAvailableSlots.setCursor(Cursor.HAND);
    }

    public void btnCheckSlotsOnAction(ActionEvent actionEvent) throws Exception {
        slotsCheck();
    }

    public void btnSearchVehicleOnAction(ActionEvent actionEvent) throws Exception {
        childPane.getChildren().clear();
        AnchorPane newCheckSlotsPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/SearchVehicleForm.fxml"));
        childPane.getChildren().setAll(newCheckSlotsPane.getChildren());
    }

    public void btnAddNewVehicleOnAction(ActionEvent actionEvent) throws Exception {
        childPane.getChildren().clear();
        AnchorPane newCheckSlotsPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/AddNewVehicleForm.fxml"));
        childPane.getChildren().setAll(newCheckSlotsPane.getChildren());
    }

    public void btnViewParkingHistoryOnAction(ActionEvent actionEvent) throws Exception {
        childPane.getChildren().clear();
        AnchorPane newCheckSlotsPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/ViewParkingHistoryForm.fxml"));
        childPane.getChildren().setAll(newCheckSlotsPane.getChildren());
    }

    public void btnPaymentsCheckOnAction(ActionEvent actionEvent) throws Exception {
        paymentsCheckStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/PaymentsCheckForm.fxml"))));
        paymentsCheckStage.setResizable(false);
        paymentsCheckStage.show();
        vehicleEntryStage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            slotsCheck();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
