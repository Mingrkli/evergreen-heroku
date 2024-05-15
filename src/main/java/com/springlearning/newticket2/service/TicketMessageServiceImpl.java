package com.springlearning.newticket2.service;

import com.springlearning.newticket2.model.Ticket;
import com.springlearning.newticket2.model.TicketMessage;
import com.springlearning.newticket2.repository.TicketMessageRepository;
import com.springlearning.newticket2.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketMessageServiceImpl implements TicketMessageService {
    // Repository
    @Autowired
    private TicketMessageRepository ticketMessageRepository;

    @Autowired
    private TicketRepository ticketRepository;

    /**
     * Adds a message to the ticket which should be the current ticket that the user is at
     *
     * @param ticketMessage
     * @return
     */
    @Override
    public TicketMessage addTicketMessage(TicketMessage ticketMessage, long id) {
        // Retrieve the Ticket object by its ID
        Ticket ticket = ticketRepository.findById(id).get();

        // Set the Ticket object for the TicketMessage
        ticketMessage.setTicket(ticket);

        // Save the TicketMessage
        return ticketMessageRepository.save(ticketMessage);
    }

    /**
     * Gets the list of messages by the Ticket ID
     *
     * @param id
     * @return
     */
    @Override
    public List<TicketMessage> getTicketMessagesByTicketId(Long id) {
        return new ArrayList<>(ticketMessageRepository.findAllByTicketId(id));
    }
}
