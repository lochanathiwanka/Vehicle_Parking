package controller;

import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.StageList;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PaymentsCheckFormController extends StageList implements Initializable {

    public JFXRadioButton rdbtnVan;
    public JFXRadioButton rdbtnBus;
    public JFXRadioButton rdbtnLorry;
    public JFXRadioButton rdbtnCar;
    public AnchorPane childPane;

    public void btnBackOnAction(MouseEvent mouseEvent) throws Exception {
        vehicleEntryStage.show();
        paymentsCheckStage.close();
    }

    public void carOnAction(ActionEvent actionEvent) throws Exception {
        rdbtnVan.setSelected(false);
        rdbtnBus.setSelected(false);
        rdbtnLorry.setSelected(false);

        childPane.getChildren().clear();
        AnchorPane newCarAddPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/CarOwnerPaymentCheckForm.fxml"));
        childPane.getChildren().setAll(newCarAddPane.getChildren());
    }

    public void vanOnAction(ActionEvent actionEvent) throws Exception {
        rdbtnCar.setSelected(false);
        rdbtnBus.setSelected(false);
        rdbtnLorry.setSelected(false);

        childPane.getChildren().clear();
        AnchorPane newVanAddPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/VanOwnerPaymentCheckForm.fxml"));
        childPane.getChildren().setAll(newVanAddPane.getChildren());
    }

    public void busOnAction(ActionEvent actionEvent) throws Exception {
        rdbtnCar.setSelected(false);
        rdbtnVan.setSelected(false);
        rdbtnLorry.setSelected(false);

        childPane.getChildren().clear();
        AnchorPane newBusAddPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/BusOwnerPaymentCheckForm.fxml"));
        childPane.getChildren().setAll(newBusAddPane.getChildren());
    }

    public void lorryOnAction(ActionEvent actionEvent) throws Exception{
        rdbtnCar.setSelected(false);
        rdbtnVan.setSelected(false);
        rdbtnBus.setSelected(false);

        childPane.getChildren().clear();
        AnchorPane newCarAddPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/LorryOwnerPaymentCheckForm.fxml"));
        childPane.getChildren().setAll(newCarAddPane.getChildren());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rdbtnCar.setSelected(true);
        childPane.getChildren().clear();
        AnchorPane newCarAddPane = null;
        try {
            newCarAddPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/CarOwnerPaymentCheckForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        childPane.getChildren().setAll(newCarAddPane.getChildren());
    }
}
