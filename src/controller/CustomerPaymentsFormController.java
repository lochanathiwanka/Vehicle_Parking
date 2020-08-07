package controller;

import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.StageList;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerPaymentsFormController extends StageList implements Initializable {
    public JFXRadioButton rdbtnCar;
    public JFXRadioButton rdbtnVan;
    public JFXRadioButton rdbtnBus;
    public JFXRadioButton rdbtnLorry;
    public AnchorPane childPane;

    public void carPaymentPaneSet() throws Exception{
        childPane.getChildren().clear();
        AnchorPane newCarPaymentPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/UpdateCarDepartureTimeForm.fxml"));
        childPane.getChildren().setAll(newCarPaymentPane.getChildren());
    }

    public void carOnAction(ActionEvent actionEvent) throws Exception {
        rdbtnVan.setSelected(false);
        rdbtnBus.setSelected(false);
        rdbtnLorry.setSelected(false);
        carPaymentPaneSet();
    }

    public void vanOnAction(ActionEvent actionEvent) throws Exception {
        rdbtnCar.setSelected(false);
        rdbtnBus.setSelected(false);
        rdbtnLorry.setSelected(false);

        childPane.getChildren().clear();
        AnchorPane newVanPaymentPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/UpdateVanDepartureTimeForm.fxml"));
        childPane.getChildren().setAll(newVanPaymentPane.getChildren());
    }

    public void busOnAction(ActionEvent actionEvent) throws Exception {
        rdbtnCar.setSelected(false);
        rdbtnVan.setSelected(false);
        rdbtnLorry.setSelected(false);

        childPane.getChildren().clear();
        AnchorPane newBusPaymentPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/UpdateBusDepartureTimeForm.fxml"));
        childPane.getChildren().setAll(newBusPaymentPane.getChildren());
    }

    public void lorryOnAction(ActionEvent actionEvent) throws Exception{
        rdbtnCar.setSelected(false);
        rdbtnVan.setSelected(false);
        rdbtnBus.setSelected(false);

        childPane.getChildren().clear();
        AnchorPane newLorryPaymentPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/UpdateLorryDepartureTimeForm.fxml"));
        childPane.getChildren().setAll(newLorryPaymentPane.getChildren());
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
        try {
            carPaymentPaneSet();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
