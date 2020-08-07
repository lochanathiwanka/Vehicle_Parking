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
import model.Bus;
import model.BusParkingHistory;
import model.Vehicle;
import model.VehicleParkingHistory;

import javax.swing.*;
import java.sql.SQLException;

public class BusParkingHistoryViewFormController {
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtBusNumber;
    public JFXTextField txtSearch;

    @FXML
    private TableView <VehicleParkingHistory> tblBusDetails;

    @FXML
    private TableColumn <VehicleParkingHistory,String> clmDate;

    @FXML
    private TableColumn <VehicleParkingHistory,String> clmArrivalTime;

    @FXML
    private TableColumn <VehicleParkingHistory,String> clmDepatureTime;

    @FXML
    private TableColumn <VehicleParkingHistory,String> clmParkingFee;

    @FXML
    private TableColumn <VehicleParkingHistory,String> clmPaymentStatus;

    ObservableList <VehicleParkingHistory> row;;

    public void textFieldsClear(){
        txtBusNumber.setText(null);
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
        VehicleParkingHistory vehicleHistory = new BusParkingHistory();
        vehicleHistory.setSQL("select * from busParking where number=? order by bID");

        Vehicle v = new Bus();
        v.setSQL("Select number,firstName,lastName From busDetails where number=?");

        try {
            row = VehicleController.getVehicleParkingHistory(vehicleHistory,txtSearch.getText());
            Vehicle vehicle=VehicleController.searchVehicle(txtSearch.getText(),"Bus",v);
            if(vehicle!=null){
                txtBusNumber.setText(vehicle.getVehicleNumber());
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
        clmDepatureTime.setCellValueFactory(new PropertyValueFactory<VehicleParkingHistory,String>("departuretime"));
        clmParkingFee.setCellValueFactory(new PropertyValueFactory<VehicleParkingHistory,String>("parkingfee"));
        clmPaymentStatus.setCellValueFactory(new PropertyValueFactory<VehicleParkingHistory,String>("paymentstatus"));
        tblBusDetails.setItems(row);
    }
}
