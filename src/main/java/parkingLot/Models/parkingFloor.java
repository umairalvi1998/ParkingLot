package parkingLot.Models;

import java.util.List;

public class parkingFloor extends BaseModel {
    List<parkingSpot> parkingSpots;
    parkingFloorStatus floorStatus;
    private int floorNumber;

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public parkingFloorStatus getFloorStatus() {
        return floorStatus;
    }

    public void setFloorStatus(parkingFloorStatus floorStatus) {
        this.floorStatus = floorStatus;
    }

    public List<parkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<parkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
}
