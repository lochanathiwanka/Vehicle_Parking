package model;

public class Bus extends Vehicle {
    public Bus(String ID) {
        super(ID);
    }

    public Bus(String vehicleNumber, String firstName, String lastName, String date, String arrivalTime, String departureTime, String parkingFee, String paymentStatus) {
        super(vehicleNumber, firstName, lastName, date, arrivalTime, departureTime, parkingFee, paymentStatus);
    }

    public Bus(String vehicleNumber, String firstName, String lastName, String arrivalTime, String departureTime) {
        super(vehicleNumber, firstName, lastName, arrivalTime, departureTime);
    }

    public Bus(String vehicleNumber, String firstName, String lastName, String arrivalTime) {
        super(vehicleNumber, firstName, lastName, arrivalTime);
    }

    public Bus(String busNumber, String firstName, String lastName){
        super(busNumber,firstName,lastName);
    }
    public Bus(){}
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
