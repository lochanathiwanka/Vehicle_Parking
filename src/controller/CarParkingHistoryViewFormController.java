package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Car;
import model.CarParkingHistory;
import model.Vehicle;
import model.VehicleParkingHistory;

import javax.swing.*;
import java.sql.SQLException;

public class CarParkingHistoryViewFormController{
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtCarNumber;
    public JFXTextField txtSearch;

    @FXML
    private TableView <VehicleParkingHistory> tblCarDetails;

    @FXML
    private TableColumn <VehicleParkingHistory,String> clmDate;

    @FXML
    private TableColumn <VehicleParkingHistory,String> clmArrivalTime;

    @FXML
    private TableColumn <VehicleParkingHistory,String> clmDepartureTime;

    @FXML
    private TableColumn <VehicleParkingHistory,String> clmParkingFee;

    @FXML
    private TableColumn <VehicleParkingHistory,String> clmPaymentStatus;

    ObservableList <VehicleParkingHistory> row;;

    public void textFieldsClear(){
        txtCarNumber.setText(null);
        txtFirstName.setText(null);
        txtLastName.setText(null);
    }
    public void searchKeyPressedOnAction(KeyEvent keyEvent) {
        forSearchField();
    }

    public void searchKeyReleasedOnAction(KeyEvent keyEvent) {
        forSearchField();
    }

    public void searchKeyTypedOnAction(KeyEvent keyEvent) {
        forSearchField();
    }

    public void forSearchField(){
        VehicleParkingHistory vehicleHistory = new CarParkingHistory();
        vehicleHistory.setSQL("select * from carParking where number=? order by cID");

        Vehicle v = new Car();
        v.setSQL("Select number,firstName,lastName From carDetails where number=?");

        try {
            row = VehicleController.getVehicleParkingHistory(vehicleHistory,txtSearch.getText());
            Vehicle vehicle=VehicleController.searchVehicle(txtSearch.getText(),"Car",v);
            if(vehicle!=null){
                txtCarNumber.setText(vehicle.getVehicleNumber());
                txtFirstName.setText(vehicle.getFirstName());
                txtLastName.setText(vehicle.getLastName()+"");
                v=null;
            }else{
                textFieldsClear();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        clmDate.setCellValueFactory(new PropertyValueFactory<VehicleParkingHistory,String>("date"));
        clmArrivalTime.setCellValueFactory(new PropertyValueFactory<VehicleParkingHistory,String>("arrivaltime"));
        clmDepartureTime.setCellValueFactory(new PropertyValueFactory<VehicleParkingHistory,String>("departuretime"));
        clmParkingFee.setCellValueFactory(new PropertyValueFactory<VehicleParkingHistory,String>("parkingfee"));
        clmPaymentStatus.setCellValueFactory(new PropertyValueFactory<VehicleParkingHistory,String>("paymentstatus"));
        tblCarDetails.setItems(row);
    }
}
