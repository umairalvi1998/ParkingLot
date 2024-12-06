package parkingLot.Repositories;

import parkingLot.Models.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TicketRepository {
    private Map<Long, Ticket> tickets;
    private Long id;
    public TicketRepository() {
        this.tickets = new HashMap<>();
        this.id = 0L;
    }

    public Ticket save(Ticket ticket) {

        if(ticket.getId() == 0) {
            this.tickets.put(++id, ticket);
            ticket.setId(id);
            return ticket;
        }

        this.tickets.put(ticket.getId(), ticket);
        return ticket;
    }

    Optional<Ticket> findById(Long id) {
        return Optional.ofNullable(this.tickets.get(id));
    }


}
