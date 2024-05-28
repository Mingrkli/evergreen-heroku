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

    // explain more in javadoc @return :D

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
     * @return all tickets in the database
     */
    @Override
    // change to findAllTickets
    public List<Ticket> getTickets() {
        return (List<Ticket>) ticketRepository.findAll();
    }

    /**
     * Get the ticket by id
     *
     * @param id ticket id
     * @return
     */
    @Override
    public Ticket getTicketById(long id) {
        return ticketRepository.findById(id).get();
    }

    /**
     * Deletes the ticket by id
     * @param id ticket id
     */
    @Override
    public void deleteTicket(long id) { ticketRepository.deleteById(id); }
}
