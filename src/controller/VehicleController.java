package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehicleController {

    public static boolean addVehicle(Vehicle vehicle) throws ClassNotFoundException, SQLException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement(vehicle.getSQL());
        stm.setObject(1,vehicle.getVehicleNumber());
        stm.setObject(2,vehicle.getFirstName());
        stm.setObject(3,vehicle.getLastName());
        return stm.executeUpdate()>0;
    }

    public static Vehicle searchVehicle(String vehicleNumber,String type,Vehicle vehicle) throws ClassNotFoundException, SQLException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement(vehicle.getSQL());
        stm.setObject(1,vehicleNumber);
        ResultSet rst = stm.executeQuery();
        if (rst.next()){
            if (type.equalsIgnoreCase("Car")) {
                Vehicle v = new Car(rst.getString("number"), rst.getString("firstName"), rst.getString("LastName"));
                return v;
            }
            if (type.equalsIgnoreCase("Van")) {
                Vehicle v = new Van(rst.getString("number"), rst.getString("firstName"), rst.getString("LastName"));
                return v;
            }
            if (type.equalsIgnoreCase("Bus")) {
                Vehicle v = new Bus(rst.getString("number"), rst.getString("firstName"), rst.getString("LastName"));
                return v;
            }
            if (type.equalsIgnoreCase("Lorry")) {
                Vehicle v = new Lorry(rst.getString("number"), rst.getString("firstName"), rst.getString("LastName"));
                return v;
            }
        }
        return null;
    }

    public static boolean findNumberfromParkingTempory(Vehicle vehicle,String vehicleNumber)throws ClassNotFoundException, SQLException{
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement(vehicle.getSQL());
        stm.setObject(1,vehicleNumber);
        ResultSet rst = stm.executeQuery();
        String number="no number";
        while (rst.next()){
            if (vehicleNumber.equalsIgnoreCase(rst.getString("number"))){
                return true;
            }
        }
        return false;
    }

    public static boolean addVehicletoPark(Vehicle vehicle,String arrivalDate,String arrivalTime)throws ClassNotFoundException, SQLException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement(vehicle.getSQL());
        stm.setObject(1,vehicle.getVehicleNumber());
        stm.setObject(2,vehicle.getFirstName());
        stm.setObject(3,vehicle.getLastName());
        stm.setObject(4,arrivalDate);
        stm.setObject(5,arrivalTime);
        return stm.executeUpdate()>0;
    }

    public static ObservableList<VehicleParkingHistory> getVehicleParkingHistory(VehicleParkingHistory vehicleHistory,String vehicleNumber) throws ClassNotFoundException,SQLException{
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement(vehicleHistory.getSQL());
        stm.setObject(1,vehicleNumber);
        ResultSet rst = stm.executeQuery();
        ObservableList<VehicleParkingHistory>vehicleParkingHistoryList = FXCollections.observableArrayList();
        while (rst.next()){
            vehicleParkingHistoryList.add(new CarParkingHistory(rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9)));
        }
        return vehicleParkingHistoryList;
    }

    public static Vehicle getParkingHistoryforUpdateDeparture(Vehicle vehicle,String vehicleNumber,String type) throws ClassNotFoundException,SQLException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement(vehicle.getSQL());
        stm.setObject(1,vehicleNumber);
        ResultSet rst = stm.executeQuery();
        if (rst.next()){
            if (type.equalsIgnoreCase("Car")) {
                Vehicle v = new Car(rst.getString("number"), rst.getString("firstName"), rst.getString("lastName"),rst.getString("arrivalTime"));
                return v;
            }
            if (type.equalsIgnoreCase("Van")) {
                Vehicle v = new Van(rst.getString("number"), rst.getString("firstName"), rst.getString("lastName"),rst.getString("arrivalTime"));
                return v;
            }
            if (type.equalsIgnoreCase("Bus")) {
                Vehicle v = new Bus(rst.getString("number"), rst.getString("firstName"), rst.getString("lastName"),rst.getString("arrivalTime"));
                return v;
            }
            if (type.equalsIgnoreCase("Lorry")) {
                Vehicle v = new Lorry(rst.getString("number"), rst.getString("firstName"), rst.getString("lastName"),rst.getString("arrivalTime"));
                return v;
            }
        }
        return null;
    }

    public static boolean addDepartureTime(Vehicle vehicle,String departureTime,String Number) throws ClassNotFoundException,SQLException{
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement(vehicle.getSQL());
        stm.setObject(1,departureTime);
        stm.setObject(2,Number);
        return stm.executeUpdate()>0;
    }

    public static boolean addParkingPayment(Vehicle vehicle,String payment,String vehiclenumber) throws ClassNotFoundException,SQLException{
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement(vehicle.getSQL());
        stm.setObject(1,payment);
        stm.setObject(2,vehiclenumber);
        return stm.executeUpdate()>0;
    }

    public static boolean addPaymentStatus(Vehicle vehicle,String paymentStatus,String vehiclenumber)throws ClassNotFoundException,SQLException{
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement(vehicle.getSQL());
        stm.setObject(1,paymentStatus);
        stm.setObject(2,vehiclenumber);
        return stm.executeUpdate()>0;
    }

    public static Vehicle getValuesForCashier(Vehicle vehicle,String vehicleNumber,String vehicleType) throws ClassNotFoundException,SQLException{
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement(vehicle.getSQL());
        stm.setObject(1,vehicleNumber);
        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            if (vehicleType.equalsIgnoreCase("Car")) {
                Vehicle v = new Car(rst.getString("number"), rst.getString("firstName"), rst.getString("lastName"), rst.getString("arrivalTime"), rst.getString("departureTime"));
                return v;
            }
            if (vehicleType.equalsIgnoreCase("Van")) {
                Vehicle v = new Van(rst.getString("number"), rst.getString("firstName"), rst.getString("lastName"), rst.getString("arrivalTime"), rst.getString("departureTime"));
                return v;
            }
            if (vehicleType.equalsIgnoreCase("Bus")) {
                Vehicle v = new Bus(rst.getString("number"), rst.getString("firstName"), rst.getString("lastName"), rst.getString("arrivalTime"), rst.getString("departureTime"));
                return v;
            }
            if (vehicleType.equalsIgnoreCase("Lorry")) {
                Vehicle v = new Lorry(rst.getString("number"), rst.getString("firstName"), rst.getString("lastName"), rst.getString("arrivalTime"), rst.getString("departureTime"));
                return v;
            }
        }
            return null;
    }

    public static String[] getAllValuesFromParkingHistory(Vehicle vehicle,String vehicleNumber) throws ClassNotFoundException,SQLException{
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement(vehicle.getSQL());
        stm.setObject(1,vehicleNumber);
        ResultSet rst = stm.executeQuery();
        String[] detailsList=new String[4];
        if (rst.next()) {
                String [] colomns = {"number","firstName","lastName","paymentStatus"};
                for (int i=0;i<4;i++) {
                    detailsList[i]=rst.getString(colomns[i]);
                }
                return detailsList;
        }
        return null;
    }

    public static boolean removeVehicleFromParkingTempory(Vehicle vehicle,String vehicleNumber)throws ClassNotFoundException,SQLException{
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement(vehicle.getSQL());
        stm.setObject(1,vehicleNumber);
        return stm.executeUpdate()>0;
    }
}
