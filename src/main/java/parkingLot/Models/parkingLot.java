package parkingLot.Models;

import java.util.List;

public class parkingLot extends  BaseModel {
       private List<parkingFloor>  parkingFloors;
       private List<Gate> gates;
       private List<VehicleType> supportedVehicleTypes;
       private FeesCalculationStrategyType feesCalculationStrategy;
       private SpotAssignmentStrategyType spotAssignmentStrategy;
       private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<parkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<parkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public SpotAssignmentStrategyType getSpotAssignmentStrategy() {
        return spotAssignmentStrategy;
    }

    public void setSpotAssignmentStrategy(SpotAssignmentStrategyType spotAssignmentStrategy) {
        this.spotAssignmentStrategy = spotAssignmentStrategy;
    }

    public FeesCalculationStrategyType getFeesCalculationStrategy() {
        return feesCalculationStrategy;
    }

    public void setFeesCalculationStrategy(FeesCalculationStrategyType feesCalculationStrategy) {
        this.feesCalculationStrategy = feesCalculationStrategy;
    }

    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(List<VehicleType> supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }
}
