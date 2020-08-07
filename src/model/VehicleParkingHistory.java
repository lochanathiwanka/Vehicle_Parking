package model;

import javafx.beans.property.SimpleStringProperty;

public class VehicleParkingHistory {
    private SimpleStringProperty number;
    private SimpleStringProperty firstname;
    private SimpleStringProperty lastname;
    private SimpleStringProperty date;
    private SimpleStringProperty arrivaltime;
    private SimpleStringProperty departuretime;
    private SimpleStringProperty parkingfee;
    private SimpleStringProperty paymentstatus;
    private String SQL;

    /*public VehicleParkingHistory(String number, String firstname, String lastname, String date, String arrivaltime, String departuretime, String parkingfee, String paymentstatus) {
        this.number = new SimpleStringProperty(number);
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.date = new SimpleStringProperty(date);
        this.arrivaltime = new SimpleStringProperty(arrivaltime);
        this.departuretime = new SimpleStringProperty(departuretime);
        this.parkingfee = new SimpleStringProperty(parkingfee);
        this.paymentstatus = new SimpleStringProperty(paymentstatus);
    }*/

    public VehicleParkingHistory(String date, String arrivaltime, String departuretime, String parkingfee, String paymentstatus) {
        this.date = new SimpleStringProperty(date);
        this.arrivaltime = new SimpleStringProperty(arrivaltime);
        this.departuretime = new SimpleStringProperty(departuretime);
        this.parkingfee = new SimpleStringProperty(parkingfee);
        this.paymentstatus = new SimpleStringProperty(paymentstatus);
    }


    public VehicleParkingHistory() {
    }

    public String getNumber() {
        return number.get();
    }

    public SimpleStringProperty numberProperty() {
        return number;
    }

    public void setNumber(String number) {
        this.number.set(number);
    }

    public String getFirstname() {
        return firstname.get();
    }

    public SimpleStringProperty firstnameProperty() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }

    public String getLastname() {
        return lastname.get();
    }

    public SimpleStringProperty lastnameProperty() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getArrivaltime() {
        return arrivaltime.get();
    }

    public SimpleStringProperty arrivaltimeProperty() {
        return arrivaltime;
    }

    public void setArrivaltime(String arrivaltime) {
        this.arrivaltime.set(arrivaltime);
    }

    public String getDeparturetime() {
        return departuretime.get();
    }

    public SimpleStringProperty departuretimeProperty() {
        return departuretime;
    }

    public void setDeparturetime(String departuretime) {
        this.departuretime.set(departuretime);
    }

    public String getParkingfee() {
        return parkingfee.get();
    }

    public SimpleStringProperty parkingfeeProperty() {
        return parkingfee;
    }

    public void setParkingfee(String parkingfee) {
        this.parkingfee.set(parkingfee);
    }

    public String getPaymentstatus() {
        return paymentstatus.get();
    }

    public SimpleStringProperty paymentstatusProperty() {
        return paymentstatus;
    }

    public void setPaymentstatus(String paymentstatus) {
        this.paymentstatus.set(paymentstatus);
    }

    public String getSQL() {
        return SQL;
    }

    public void setSQL(String SQL) {
        this.SQL = SQL;
    }
}
