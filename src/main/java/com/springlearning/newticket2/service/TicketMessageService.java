package com.springlearning.newticket2.service;

import com.springlearning.newticket2.model.TicketMessage;

import java.util.List;

public interface TicketMessageService {
    /**
     * Adds a message to the ticket which should be the current ticket that the user is at
     * @param ticketMessage
     * @return
     */
    TicketMessage addTicketMessage(TicketMessage ticketMessage, long id);

    /**
     * Gets the list of messages by the Ticket ID
     * @param id
     * @return
     */
    List<TicketMessage> getTicketMessagesByTicketId(Long id);
}
