package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.Van;
import model.Vehicle;
import javax.swing.*;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class UpdateVanDepartureTimeFormController {
    public JFXTextField txtSearchNumber;
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtArrivalTime;
    public JFXTextField txtVanNumber;
    public JFXTextField txtPaymentField;
    public Label lblTotalPayment;
    public Label lblRS;
    public JFXButton btnPay;
    public JFXRadioButton rbCard;
    public JFXRadioButton rbCash;
    public JFXTextField lblSelectPaymentMethod;
    public TextField txtCardNumber;
    public TextField txtMonthYear;
    public TextField txtCVV;
    public JFXButton btnPay2;
    public Label txtThankYou;

    private Logger logger = Logger.getLogger("ConfirmController");

    @FXML
    private JFXTextField txtDepartureTime;

    @FXML
    private JFXButton btnAdd;

    @FXML
    public void initialize() {
        btnAdd.disableProperty().bind(
                txtDepartureTime.textProperty().isEqualTo(txtDepartureTime.textProperty()).not()
                        .or(
                                txtDepartureTime.textProperty().isEmpty()
                        )
        );
    }

    @FXML
    public void save(ActionEvent evt) {
        logger.info("confirmed " + txtDepartureTime.getText());
        hide(evt);
    }

    @FXML
    public void cancel(ActionEvent evt) {
        hide(evt);
    }

    private void hide(ActionEvent evt) {
        ((Node)evt.getSource()).getScene().getWindow().hide();
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        Vehicle vehicle = new Van();
        vehicle.setSQL("Update vanParkingTempory set departureTime=? where number=?");
        try {
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
            int diffmin = (int) (diff / (60 * 1000));
            String totMinitues = crunchifyFormatter.format(diffmin);
            double setFee = Double.parseDouble(totMinitues)*(75/60d);
            String totFee = String.format("%.2f",setFee);
            txtPaymentField.setText(totFee);

            boolean isAddedDepartureTime = VehicleController.addDepartureTime(vehicle,txtDepartureTime.getText(),txtVanNumber.getText());
            if (isAddedDepartureTime){
                vehicle.setSQL("Update vanParking set departureTime=? where number=? order by vID desc limit 1");
                VehicleController.addDepartureTime(vehicle,txtDepartureTime.getText(),txtVanNumber.getText());
                JOptionPane.showMessageDialog(null,"Departure Time was added SuccessFully","",JOptionPane.INFORMATION_MESSAGE);
                btnAdd.setVisible(false);
                btnPay.setVisible(true);
                txtPaymentField.setVisible(true);
                lblTotalPayment.setVisible(true);
                lblRS.setVisible(true);
            }
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }catch (SQLException ex){
            ex.printStackTrace();
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null,"*Time format should be '00:00 AM' or '00:00 am'\n*Arrival Date should not be empty","",JOptionPane.WARNING_MESSAGE);
        }
    }

    public void btnPayOnAction(ActionEvent actionEvent) throws Exception {
        Vehicle vehicle = new Van();
        vehicle.setSQL("Update vanParkingTempory set parkingFee = ? where number = ?");
        try {
            boolean isAddedPayment = VehicleController.addParkingPayment(vehicle,txtPaymentField.getText(),txtVanNumber.getText());
            if (isAddedPayment){
                vehicle.setSQL("Update vanParking set parkingFee = ? where number = ? order by vID desc limit 1");
                VehicleController.addParkingPayment(vehicle,txtPaymentField.getText(),txtVanNumber.getText());
                rbCash.setVisible(true);
                rbCard.setVisible(true);
                lblSelectPaymentMethod.setVisible(true);

                rbCash.setVisible(true);
                rbCard.setVisible(true);
                lblSelectPaymentMethod.setVisible(true);
            }
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void searchKeyPressedOnAction(KeyEvent keyEvent) {
        searchFieldSet();
        visibleSet();
    }

    public void searchKeyReleasedOnAction(KeyEvent keyEvent) {
        searchFieldSet();
        visibleSet();
    }

    public void searchKeyTypedOnAction(KeyEvent keyEvent) {
        searchFieldSet();
        visibleSet();
    }

    public void searchFieldSet(){
        Vehicle vehicle = new Van();
        vehicle.setSQL("Select number,firstName,lastName,arrivalTime From vanParkingTempory where number=?");
        try {
            Vehicle v = VehicleController.getParkingHistoryforUpdateDeparture(vehicle,txtSearchNumber.getText(),"Van");
            if (v!=null){
                txtVanNumber.setText(v.getVehicleNumber());
                txtFirstName.setText(v.getFirstName());
                txtLastName.setText(v.getLastName());
                txtArrivalTime.setText(v.getArrivalTime());

            }else{
                textFieldsClear();
            }
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void visibleSet(){
        btnAdd.setVisible(true);
        btnPay.setVisible(false);
        txtPaymentField.setVisible(false);
        lblTotalPayment.setVisible(false);
        lblRS.setVisible(false);
        rbCash.setVisible(false);
        rbCard.setVisible(false);
        lblSelectPaymentMethod.setVisible(false);
        txtCardNumber.setVisible(false);
        txtMonthYear.setVisible(false);
        txtCVV.setVisible(false);
        btnPay2.setVisible(false);
        txtThankYou.setVisible(false);
    }
    public void textFieldsClear(){
        txtVanNumber.setText(null);
        txtFirstName.setText(null);
        txtLastName.setText(null);
        txtArrivalTime.setText(null);
        txtDepartureTime.setText(null);
    }

    public void departureTimeKeyPressedOnAction(KeyEvent keyEvent) {
        visibleSet();
    }

    public void departureTimeKeyReleasedOnAction(KeyEvent keyEvent) {
        visibleSet();
    }

    public void departureTimeKeyTypedOnAction(KeyEvent keyEvent) {
        visibleSet();
    }

    public void rbCashOnAction(ActionEvent actionEvent) {
        Vehicle vehicle = new Van();
        vehicle.setSQL("Update vanParkingTempory set paymentStatus = ? where number = ?");
        try {
            boolean isAddedPaymentStatus = VehicleController.addPaymentStatus(vehicle,"Payed via CASH",txtVanNumber.getText());
            if (isAddedPaymentStatus){
                vehicle.setSQL("Update vanParking set paymentStatus = ? where number = ? order by vID desc limit 1");
                VehicleController.addPaymentStatus(vehicle,"Payed via CASH",txtVanNumber.getText());
                txtThankYou.setVisible(true);
                txtThankYou.setLayoutY(300);
            }
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        rbCard.setSelected(false);
        txtCardNumber.setVisible(false);
        txtMonthYear.setVisible(false);
        txtCVV.setVisible(false);
        btnPay2.setVisible(false);
    }

    public void rbCardOnAction(ActionEvent actionEvent) {
        rbCash.setSelected(false);
        txtCardNumber.setVisible(true);
        txtMonthYear.setVisible(true);
        txtCVV.setVisible(true);
        btnPay2.setVisible(true);
        txtThankYou.setVisible(false);
    }

    public void btnPay2OnAction(ActionEvent actionEvent) {
        Vehicle vehicle = new Van();
        vehicle.setSQL("Update vanParkingTempory set paymentStatus = ? where number = ?");
        try {
            boolean isAddedPaymentStatus = VehicleController.addPaymentStatus(vehicle,"Payed via VISA CARD",txtVanNumber.getText());
            if (isAddedPaymentStatus){
                vehicle.setSQL("Update vanParking set paymentStatus = ? where number = ? order by vID desc limit 1");
                VehicleController.addPaymentStatus(vehicle,"Payed via VISA CARD",txtVanNumber.getText());
                txtThankYou.setVisible(true);
                txtThankYou.setLayoutY(400);
            }
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
