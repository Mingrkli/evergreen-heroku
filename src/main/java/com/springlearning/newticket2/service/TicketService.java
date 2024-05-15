package com.springlearning.newticket2.service;

import com.springlearning.newticket2.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {
    /**
     * Adds a Ticket
     * @param ticket
     * @return
     */
    Ticket addTicket(Ticket ticket);

    /**
     * Gets the list of Tickets
     * @return
     */
    List<Ticket> getTickets();

    /**
     * Get the ticket by id
     * @param id
     * @return
     */
    Ticket getTicketById(long id);
}
