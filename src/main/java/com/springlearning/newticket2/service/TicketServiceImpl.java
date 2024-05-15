package com.springlearning.newticket2.service;

import com.springlearning.newticket2.model.Ticket;
import com.springlearning.newticket2.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    // Repository
    @Autowired
    private TicketRepository ticketRepository;

    /**
     * Adds a Ticket
     *
     * @param ticket
     * @return
     */
    @Override
    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    /**
     * Gets the list of Tickets
     *
     * @return
     */
    @Override
    public List<Ticket> getTickets() {
        return (List<Ticket>) ticketRepository.findAll();
    }
}
