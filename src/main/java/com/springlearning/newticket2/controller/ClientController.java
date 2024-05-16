package com.springlearning.newticket2.controller;

import com.springlearning.newticket2.model.Ticket;
import com.springlearning.newticket2.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @CrossOrigin(origins = "https://mingli.greenriverdev.com", allowedHeaders = "*")
    @PostMapping("/add")
    public String addTicket(@RequestBody Ticket ticket) {
        ticketService.addTicket(ticket);
        return "Ticket added";
    }

    /**
     * Gets all the tickets form the database
     * @return
     */
    @CrossOrigin(origins = "https://mingli.greenriverdev.com", allowedHeaders = "*")
    @RequestMapping("/tickets")
    public List<Ticket> getTickets() {
        return ticketService.getTickets();
    }

    @CrossOrigin(origins = "https://mingli.greenriverdev.com", allowedHeaders = "*")
    @GetMapping("/ticket/{id}")
    public Ticket getTicketById(@PathVariable long id) {
        return ticketService.getTicketById(id);
    }
}
