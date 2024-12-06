package parkingLot;

import parkingLot.Controllers.TicketController;
import parkingLot.DTOs.IssueTicketRequestDTO;
import parkingLot.DTOs.IssueTicketResponseDTO;
import parkingLot.Models.Gate;
import parkingLot.Models.GateStatus;
import parkingLot.Models.GateType;
import parkingLot.Models.VehicleType;
import parkingLot.Repositories.GateRepository;
import parkingLot.Repositories.ParkingLotRepository;
import parkingLot.Repositories.TicketRepository;
import parkingLot.Repositories.VehicleRepository;
import parkingLot.Service.TicketService;

public class Main {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        TicketService ticketService = new TicketService(gateRepository,
                vehicleRepository,
                parkingLotRepository,
                ticketRepository);

        TicketController ticketController = new TicketController(ticketService);
        Gate gate = new Gate();
        gate.setGateNumber("1");
        gate.setId(1L);
        gate.setGateStatus(GateStatus.OPEN);
        gate.setGateType(GateType.ENTRY);

        gateRepository.save(gate);

        IssueTicketRequestDTO requestDTO = new IssueTicketRequestDTO();

        requestDTO.setOwnerName("Umair");
        requestDTO.setGateId(1L);;
        requestDTO.setVehicleNumber("DL-3dS34");
        requestDTO.setVehicleType(VehicleType.LARGE);

       IssueTicketResponseDTO response =  ticketController.issueTicket(requestDTO);
       System.out.println(response.getTicket());

    }
}