package com.springlearning.newticket2.controller;

import com.springlearning.newticket2.model.Ticket;
import com.springlearning.newticket2.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://mingli.greenriverdev.com", allowedHeaders = "*")
@RestController
public class ClientController {
    // Repository
    @Autowired
    private TicketService ticketService;

    /**
     * Adds the ticket
     * @param ticket
     * @return
     */
    @PostMapping("/add")
    public String addTicket(@RequestBody Ticket ticket) {
        ticketService.addTicket(ticket);
        return "Ticket added";
    }

    /**
     * Gets all the tickets form the database
     * @return
     */
    @RequestMapping("/tickets")
    public List<Ticket> getTickets() {
        return ticketService.getTickets();
    }

    @GetMapping("/ticket/{id}")
    public Ticket getTicketById(@PathVariable long id) {
        return ticketService.getTicketById(id);
    }

    // add server side validation
}

