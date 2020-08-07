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
import model.Van;
import model.VanParkingHistory;
import model.Vehicle;
import model.VehicleParkingHistory;

import javax.swing.*;
import java.sql.SQLException;

public class VanParkingHistoryViewFormController {
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtVanNumber;
    public JFXTextField txtSearch;

    @FXML
    private TableView <VehicleParkingHistory> tblVanDetails;

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

    ObservableList<VehicleParkingHistory> row;;

    public void textFieldsClear(){
        txtVanNumber.setText(null);
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
        VehicleParkingHistory vehicleHistory = new VanParkingHistory();
        vehicleHistory.setSQL("select * from vanParking where number=? order by vID");

        Vehicle v = new Van();
        v.setSQL("Select number,firstName,lastName From vanDetails where number=?");

        try {
            row = VehicleController.getVehicleParkingHistory(vehicleHistory,txtSearch.getText());
            Vehicle vehicle=VehicleController.searchVehicle(txtSearch.getText(),"Van",v);
            if(vehicle!=null){
                txtVanNumber.setText(vehicle.getVehicleNumber());
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
        tblVanDetails.setItems(row);
    }
}
