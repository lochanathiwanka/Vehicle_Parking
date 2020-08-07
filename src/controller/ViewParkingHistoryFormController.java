package controller;

import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ViewParkingHistoryFormController implements Initializable {
    public AnchorPane childPane;
    public JFXRadioButton rdbtnVan;
    public JFXRadioButton rdbtnBus;
    public JFXRadioButton rdbtnLorry;
    public JFXRadioButton rdbtnCar;

    public void setCarAddPane() throws ClassNotFoundException, SQLException, IOException {
        childPane.getChildren().clear();
        AnchorPane newCarAddPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/CarParkingHistoryViewForm.fxml"));
        childPane.getChildren().setAll(newCarAddPane.getChildren());
    }

    public void carOnAction(ActionEvent actionEvent) throws Exception {
        rdbtnVan.setSelected(false);
        rdbtnBus.setSelected(false);
        rdbtnLorry.setSelected(false);

        setCarAddPane();
    }

    public void vanOnAction(ActionEvent actionEvent) throws Exception {
        rdbtnCar.setSelected(false);
        rdbtnBus.setSelected(false);
        rdbtnLorry.setSelected(false);

        childPane.getChildren().clear();
        AnchorPane newCarAddPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/VanParkingHistoryViewForm.fxml"));
        childPane.getChildren().setAll(newCarAddPane.getChildren());
    }

    public void busOnAction(ActionEvent actionEvent) throws Exception {
        rdbtnCar.setSelected(false);
        rdbtnVan.setSelected(false);
        rdbtnLorry.setSelected(false);

        childPane.getChildren().clear();
        AnchorPane newCarAddPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/BusParkingHistoryViewForm.fxml"));
        childPane.getChildren().setAll(newCarAddPane.getChildren());
    }

    public void lorryOnAction(ActionEvent actionEvent) throws Exception {
        rdbtnCar.setSelected(false);
        rdbtnVan.setSelected(false);
        rdbtnBus.setSelected(false);

        childPane.getChildren().clear();
        AnchorPane newCarAddPane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/LorryParkingHistoryViewForm.fxml"));
        childPane.getChildren().setAll(newCarAddPane.getChildren());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rdbtnCar.setSelected(true);
        try {
            setCarAddPane();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
