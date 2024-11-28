package parkingLot.Models;

import java.util.List;

public class parkingSpot extends  BaseModel {
    private int parkingSpotNumber;
    private parkingSpotStatus spotStatus;
    private List<VehicleType> supportedVehicleTypes;

    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(List<VehicleType> supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }

    public parkingSpotStatus getSpotStatus() {
        return spotStatus;
    }

    public void setSpotStatus(parkingSpotStatus spotStatus) {
        this.spotStatus = spotStatus;
    }

    public int getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(int parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }
}
