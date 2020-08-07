package model;

public class Vehicle {
    private String ID;
    private String vehicleNumber;
    private String firstName;
    private String lastName;
    private String date;
    private String arrivalTime;
    private String departureTime;
    private String parkingFee;
    private String paymentStatus;
    private String SQL;
    public Vehicle() {
    }

    public Vehicle(String ID) {
        this.ID = ID;
    }

    public Vehicle(String vehicleNumber, String firstName, String lastName, String date, String arrivalTime, String departureTime, String parkingFee, String paymentStatus) {
        this.vehicleNumber = vehicleNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.parkingFee = parkingFee;
        this.paymentStatus = paymentStatus;
    }

    public Vehicle(String vehicleNumber, String firstName, String lastName, String arrivalTime) {
        this.vehicleNumber = vehicleNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.arrivalTime = arrivalTime;
    }

    public Vehicle(String vehicleNumber, String firstName, String lastName, String arrivalTime,String departureTime) {
        this.vehicleNumber = vehicleNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public Vehicle(String vehicleNumber, String firstName, String lastName) {
        this.vehicleNumber = vehicleNumber;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(String parkingFee) {
        this.parkingFee = parkingFee;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String number) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void park(){};

    public String getSQL() {
        return SQL;
    }

    public void setSQL(String SQL) {
        this.SQL = SQL;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
