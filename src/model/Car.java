package model;

public class Car extends Vehicle {
    public Car(String ID) {
        super(ID);
    }

    public Car(String vehicleNumber, String firstName, String lastName, String date, String arrivalTime, String departureTime, String parkingFee, String paymentStatus) {
        super(vehicleNumber, firstName, lastName, date, arrivalTime, departureTime, parkingFee, paymentStatus);
    }

    public Car(String vehicleNumber, String firstName, String lastName, String arrivalTime, String departureTime) {
        super(vehicleNumber, firstName, lastName, arrivalTime, departureTime);
    }

    public Car(String vehicleNumber, String firstName, String lastName, String arrivalTime) {
        super(vehicleNumber, firstName, lastName, arrivalTime);
    }

    public Car(String carNumber, String firstName, String lastName){
        super(carNumber,firstName,lastName);
    }
    public Car(){}
    @Override
    public void park() { }

    @Override
    public String getSQL() {
        return super.getSQL();
    }

    @Override
    public void setSQL(String SQL) {
        super.setSQL(SQL);
    }

    @Override
    public String getDepartureTime() {
        return super.getDepartureTime();
    }

    @Override
    public void setDepartureTime(String departureTime) {
        super.setDepartureTime(departureTime);
    }

    @Override
    public String getParkingFee() {
        return super.getParkingFee();
    }

    @Override
    public void setParkingFee(String parkingFee) {
        super.setParkingFee(parkingFee);
    }
}
