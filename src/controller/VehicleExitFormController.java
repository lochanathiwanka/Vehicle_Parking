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

public class VehicleExitFormController extends StageList implements Initializable {

    public AnchorPane childPane;
    public JFXRadioButton rdbtnCar;
    public JFXRadioButton rdbtnVan;
    public JFXRadioButton rdbtnBus;
    public JFXRadioButton rdbtnLorry;

    public void carOnAction(ActionEvent actionEvent) throws Exception {
        rdbtnVan.setSelected(false);
        rdbtnBus.setSelected(false);
        rdbtnLorry.setSelected(false);

        childPane.getChildren().clear();
        AnchorPane newCarAddPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/ViewCarDepartureTimeForm.fxml"));
        childPane.getChildren().setAll(newCarAddPane.getChildren());
    }

    public void vanOnAction(ActionEvent actionEvent) throws Exception {
        rdbtnCar.setSelected(false);
        rdbtnBus.setSelected(false);
        rdbtnLorry.setSelected(false);

        childPane.getChildren().clear();
        AnchorPane newCarAddPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/ViewVanDepartureTimeForm.fxml"));
        childPane.getChildren().setAll(newCarAddPane.getChildren());
    }

    public void busOnAction(ActionEvent actionEvent) throws Exception {
        rdbtnCar.setSelected(false);
        rdbtnVan.setSelected(false);
        rdbtnLorry.setSelected(false);

        childPane.getChildren().clear();
        AnchorPane newCarAddPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/ViewBusDepartureTimeForm.fxml"));
        childPane.getChildren().setAll(newCarAddPane.getChildren());
    }

    public void lorryOnAction(ActionEvent actionEvent) throws Exception{
        rdbtnCar.setSelected(false);
        rdbtnVan.setSelected(false);
        rdbtnBus.setSelected(false);

        childPane.getChildren().clear();
        AnchorPane newCarAddPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/ViewLorryDepartureTimeForm.fxml"));
        childPane.getChildren().setAll(newCarAddPane.getChildren());
    }

    public void btnBackOnAction(MouseEvent mouseEvent) throws Exception {
        backConfirmStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/BackConfirmForm.fxml"))));
        backConfirmStage.setResizable(false);
        backConfirmStage.setX(200);
        backConfirmStage.setY(140);
        backConfirmStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rdbtnCar.setSelected(true);
        childPane.getChildren().clear();
        AnchorPane newCarAddPane = null;
        try {
            newCarAddPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/ViewCarDepartureTimeForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        childPane.getChildren().setAll(newCarAddPane.getChildren());
    }
}
