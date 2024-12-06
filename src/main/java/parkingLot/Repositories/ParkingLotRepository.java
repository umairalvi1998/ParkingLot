package parkingLot.Repositories;

import parkingLot.Models.Gate;
import parkingLot.Models.parkingLot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ParkingLotRepository {
    Map<Long,parkingLot> parkingLots;
    Long id = 0l;

    public ParkingLotRepository() {
        this.parkingLots = new HashMap<>();
    }

    parkingLot save(parkingLot parkingLot) {
        if(parkingLot.getId()==0) {
            parkingLots.put(++id,parkingLot);
            parkingLot.setId(id);
            return  parkingLot;
        }

        parkingLots.put(parkingLot.getId(),parkingLot);
        return  parkingLot;
    }

    public Optional<parkingLot> findByGateId(Long gateId) {
        for(parkingLot parkingLot : parkingLots.values()) {
            List<Gate> gates = parkingLot.getGates();

            for(Gate gate : gates) {
                if(gate.getId() == gateId) {
                    return Optional.of(parkingLot);
                }
            }
        }

        return Optional.empty();
    }
}
