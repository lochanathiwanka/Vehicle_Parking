package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Car;
import model.Vehicle;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ViewCarDepartureTimeFormController {
    public JFXTextField txtSearchNumber;
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtArrivalTime;
    public TextField txtDepartureTime;
    public JFXTextField txtCarNumber;
    public JFXTextField txtTotParkingFee;
    public JFXTextField txtTotParkingTime;

    public void searchKeyPressedOnAction(KeyEvent keyEvent) {
        forSearchField();
    }

    public void searchKeyReleasedOnAction(KeyEvent keyEvent) {
        forSearchField();
    }

    public void searchKeyTypedOnAction(KeyEvent keyEvent) {
        forSearchField();
    }

    public void textFieldsReset(){
        txtCarNumber.setText(null);
        txtFirstName.setText(null);
        txtLastName.setText(null);
        txtArrivalTime.setText(null);
        txtDepartureTime.setText(null);
        txtTotParkingTime.setText(null);
        txtTotParkingFee.setText(null);
    }

    public void forSearchField(){
        Vehicle vehicle = new Car();
        vehicle.setSQL("Select number,firstName,lastName,arrivalTime,departureTime from carParkingTempory where number = ?");
        try {
            Vehicle v = VehicleController.getValuesForCashier(vehicle,txtSearchNumber.getText(),"Car");
            if (v!=null) {
                txtCarNumber.setText(v.getVehicleNumber());
                txtFirstName.setText(v.getFirstName());
                txtLastName.setText(v.getLastName());
                txtArrivalTime.setText(v.getArrivalTime());
                txtDepartureTime.setText(v.getDepartureTime());

                String date1 = "2020/08/02";
                String arrivalTime = txtArrivalTime.getText();
                String date2 = "2020/08/02";
                String departureTime = txtDepartureTime.getText();
                String format = "yyyy/MM/dd hh:mm a";

                SimpleDateFormat sdf = new SimpleDateFormat(format);
                Date dateObj1 = sdf.parse(date1 + " " + arrivalTime);
                Date dateObj2 = sdf.parse(date2 + " " + departureTime);
                DecimalFormat crunchifyFormatter = new DecimalFormat("###,###");
                long diff = dateObj2.getTime() - dateObj1.getTime();

                int diffhours = (int) (diff / (60 * 60 * 1000));
                txtTotParkingTime.setText(crunchifyFormatter.format(diffhours)+" Hours");

                int diffmin = (int) (diff / (60 * 1000));
                String totMinitues = crunchifyFormatter.format(diffmin);

                double setFee = Double.parseDouble(totMinitues)*(50/60d);
                String totFee = String.format("%.2f",setFee);
                txtTotParkingFee.setText(totFee+" rs");


            }else {
                textFieldsReset();
            }
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }catch (SQLException ex){
            ex.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
