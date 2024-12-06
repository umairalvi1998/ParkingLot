package parkingLot.SpotAssignmentStrategy;

import parkingLot.Models.Gate;
import parkingLot.Models.VehicleType;
import parkingLot.Models.parkingSpot;

public interface SpotAssignmentStrategy {
 parkingSpot assignSpot(VehicleType vehiclType, Gate gate);
}
