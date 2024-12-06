package parkingLot.Repositories;

import parkingLot.Models.Vehicle;

import java.util.Map;
import java.util.Optional;

public class VehicleRepository {

    private Map<String, Vehicle> vehiclesNumberToVehicle;
    private Map<Long,Vehicle> vehicleMap;
    private Long id= 0l;



    public Optional<Vehicle> findByVehicleNumber(String vehicleNumber) {
        return Optional.ofNullable(vehiclesNumberToVehicle.get(vehicleNumber));
    }

    public Optional<Vehicle> findById(Long id) {
        if(vehicleMap.containsKey(id)){
            return Optional.ofNullable(vehicleMap.get(id));
        }

        return Optional.empty();
    }

    public Vehicle save(Vehicle vehicle) {
        if(vehicle.getId()==0) {
            vehicleMap.put(++id, vehicle);
            vehicle.setId(id);
            vehiclesNumberToVehicle.put(vehicle.getVehicleNumber(), vehicle);
            return vehicle;
        }

        vehicleMap.put(id,vehicle);
        vehiclesNumberToVehicle.put(vehicle.getVehicleNumber(), vehicle);
        return vehicle;


    }
}
