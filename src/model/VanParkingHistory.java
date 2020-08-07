package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class VanParkingHistory extends VehicleParkingHistory{
    public VanParkingHistory(String date, String arrivaltime, String departuretime, String parkingfee, String paymentstatus) {
        super(date, arrivaltime, departuretime, parkingfee, paymentstatus);
    }

    public VanParkingHistory() {
    }

    @Override
    public String getSQL() {
        return super.getSQL();
    }

    @Override
    public void setSQL(String SQL) {
        super.setSQL(SQL);
    }
}
