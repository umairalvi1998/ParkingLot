package parkingLot.Controllers;


import parkingLot.DTOs.IssueTicketRequestDTO;
import parkingLot.DTOs.IssueTicketResponseDTO;
import parkingLot.DTOs.ResponseStatus;
import parkingLot.Models.Ticket;
import parkingLot.Service.TicketService;

public class TicketController {

    TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO requestDTO) {
        IssueTicketResponseDTO responseDTO = new IssueTicketResponseDTO();

        try {
           Ticket ticket =  ticketService.issueTicket(requestDTO.getGateId(), requestDTO.getVehicleNumber(), requestDTO.getOwnerName(),requestDTO.getVehicleType());
           responseDTO.setTicket(ticket);
           responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
           return responseDTO;
        }
        catch (Exception e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}
