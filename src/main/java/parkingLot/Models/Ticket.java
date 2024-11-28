package parkingLot.Models;

import java.util.Date;

public class Ticket extends BaseModel {

    private String number;
    private Date entryTime;
    private Vehicle vehicle;
    private parkingSpot parkingSpot;
    private Gate generatedAt;

    public Gate getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(Gate generatedAt) {
        this.generatedAt = generatedAt;
    }

    public parkingLot.Models.parkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(parkingLot.Models.parkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
