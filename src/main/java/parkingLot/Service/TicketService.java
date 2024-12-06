package parkingLot.Service;

import parkingLot.Exceptions.GateNotFoundException;
import parkingLot.Exceptions.SpotNotAvailableException;
import parkingLot.Factory.SpotAssignmentStrategyFactory;
import parkingLot.Models.*;
import parkingLot.Repositories.GateRepository;
import parkingLot.Repositories.ParkingLotRepository;
import parkingLot.Repositories.TicketRepository;
import parkingLot.Repositories.VehicleRepository;
import parkingLot.SpotAssignmentStrategy.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

public class TicketService {
    private GateRepository gateRepo;
    private VehicleRepository vehicleRepo;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingLotRepository parkingLotRepo;
    private TicketRepository ticketRepo;

    public TicketService(GateRepository gateRepo, VehicleRepository vehicleRepo,ParkingLotRepository parkingLotRepo, TicketRepository ticketRepo) {
        this.gateRepo = gateRepo;
        this.vehicleRepo = vehicleRepo;
        this.parkingLotRepo = parkingLotRepo;
        this.ticketRepo = ticketRepo;
    }

    public Ticket issueTicket(Long gateId, String vehicleNumber, String ownerName, VehicleType vehicleType) {
       Optional<Gate> gateOptional = gateRepo.findById(gateId);
       Optional<Vehicle> vehicleOptional = vehicleRepo.findByVehicleNumber(vehicleNumber);
       Ticket ticket = new Ticket();

       ticket.setEntryTime(new Date());

       if(gateOptional.isEmpty()) {
           throw new GateNotFoundException("Ggate with ID "+gateId+ " not found");
       }

       Vehicle newVehicle = null;
       if(vehicleOptional.isEmpty()) {
           //Create a new vehicle and save it in the DB
           Vehicle vehicle = new Vehicle();
           vehicle.setVehicleNumber(vehicleNumber);
           vehicle.setOwnerName(ownerName);
           vehicle.setVehicleType(vehicleType);

           newVehicle = vehicleRepo.save(vehicle);
       }
       else {
           newVehicle = vehicleOptional.get();
       }

       Gate gate = gateOptional.get();
       ticket.setVehicle(newVehicle);
       ticket.setGeneratedAt(gate);
       ticket.setNumber(generateTicketNumber());

       Optional<parkingLot> ParkingLotOptional = parkingLotRepo.findByGateId(gateId);
       if(ParkingLotOptional.isEmpty()) {
           throw new RuntimeException("PArking Lot Not Found");
       }

       parkingLot lot = ParkingLotOptional.get();
       SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentStrategyFactory.getSpotAssignmentStrategy(lot.getSpotAssignmentStrategy());
       parkingSpot spot = spotAssignmentStrategy.assignSpot(vehicleType,gate);

       if(spot.getSpotStatus().equals(parkingSpotStatus.NOT_AVAILABLE))
           throw new SpotNotAvailableException("Spot Not Available");


        return ticketRepo.save(ticket);
    }

    private  String generateTicketNumber() {
        return "PL-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase(); // Example: PL-1A2B3C4D
    }
}
