package com.springlearning.newticket2.controller;

import com.springlearning.newticket2.model.TicketMessage;
import com.springlearning.newticket2.service.TicketMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://mingli.greenriverdev.com/", allowedHeaders = "*")
@RestController
public class TicketMessageController {
    // Repository
    @Autowired
    private TicketMessageService ticketMessageService;

    /**
     * Adds the ticket message to the ticketID which so it connects to the ticketID
     * @param ticketMessage
     * @param ticketId
     * @return
     */
    @PostMapping("/add/message/{ticketId}")
    public String addTicketMessage(@RequestBody TicketMessage ticketMessage, @PathVariable("ticketId") int ticketId) {
        ticketMessageService.addTicketMessage(ticketMessage, ticketId);
        return "Message added";
    }

    /**
     * Gets all the messages by the ticket id
     * @param ticketId
     * @return
     */
    @GetMapping("/ticket/{ticketId}/messages")
    public List<TicketMessage> getTicketMessagesByTicketId(@PathVariable(value = "ticketId") Long ticketId) {
        return ticketMessageService.getTicketMessagesByTicketId(ticketId);
    }
}