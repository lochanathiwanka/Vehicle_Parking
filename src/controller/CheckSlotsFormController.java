package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import model.DBConnection;

import javax.swing.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class CheckSlotsFormController implements Initializable {
    public JFXTextField txtCarField;
    public JFXTextField txtvanField;
    public JFXTextField txtBusField;
    public JFXTextField txtLorryField;
    private int carSlots;
    private int vanSlots;
    private int busSlots;
    private int lorrySlots;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String carSQL = "Select count(*) from carParkingTempory";
        String vanSQL = "Select count(*) from vanParkingTempory";
        String busSQL = "Select count(*) from busParkingTempory";
        String lorrySQL = "Select count(*) from lorryParkingTempory";
        try {
            Statement carStm = DBConnection.getInstance().getConnection().createStatement();
            Statement vanStm = DBConnection.getInstance().getConnection().createStatement();
            Statement busStm = DBConnection.getInstance().getConnection().createStatement();
            Statement lorryStm = DBConnection.getInstance().getConnection().createStatement();

            ResultSet carRst = carStm.executeQuery(carSQL);
            ResultSet vanRst = vanStm.executeQuery(vanSQL);
            ResultSet busRst = busStm.executeQuery(busSQL);
            ResultSet lorryRst = lorryStm.executeQuery(lorrySQL);

            if (carRst.next()){
                carSlots = carRst.getInt(1);
                int count = 40-carSlots;
                txtCarField.setText(Integer.toString(count));
            }
            if (vanRst.next()){
                vanSlots = vanRst.getInt(1);
                int count = 30-vanSlots;
                txtvanField.setText(Integer.toString(count));
            }
            if (busRst.next()){
                busSlots = busRst.getInt(1);
                int count = 20-busSlots;
                txtBusField.setText(Integer.toString(count));
            }
            if (lorryRst.next()){
                lorrySlots = lorryRst.getInt(1);
                int count = 10-lorrySlots;
                txtLorryField.setText(Integer.toString(count));
            }
            carStm.close();
            vanStm.close();
            busStm.close();
            lorryStm.close();

            carRst.close();
            vanRst.close();
            busRst.close();
            lorryRst.close();

        }catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Driver not found","",JOptionPane.ERROR_MESSAGE);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error","",JOptionPane.WARNING_MESSAGE);
        }
    }

    public void btnViewCarsOnAction(ActionEvent actionEvent) {
    }

    public void btnViewVansOnAction(ActionEvent actionEvent) {
    }

    public void btnViewBusesOnAction(ActionEvent actionEvent) {
    }

    public void btnViewLorriesOnAction(ActionEvent actionEvent) {
    }
}
