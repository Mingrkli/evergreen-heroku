package com.springlearning.newticket2.controller;

import com.springlearning.newticket2.dto.AddTicketRequest;
import com.springlearning.newticket2.model.Ticket;
import com.springlearning.newticket2.model.TicketMessage;
import com.springlearning.newticket2.service.TicketMessageService;
import com.springlearning.newticket2.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "https://mingli.greenriverdev.com//", allowedHeaders = "*")
@RestController
public class ClientController {
    // Repository
    @Autowired
    private TicketService ticketService;
    @Autowired
    private TicketMessageService ticketMessageService;

    /**
     * Adds the ticket
     *
     * @param AddTicketRequest
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<Map<String, String>> addTicket(
            @Valid @RequestBody AddTicketRequest AddTicketRequest,
            BindingResult bindingResult) {

        // Ticket and Message
        Ticket ticket = AddTicketRequest.getTicket();
        TicketMessage message = AddTicketRequest.getMessage();

        // Checks if the ticket fields has errors
        if (bindingResult.hasFieldErrors()) {
            Map<String, String> errors = new HashMap<>();

            bindingResult.getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });

            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

//        if (bindingResult.hasFieldErrors("ticket")) {
//            Map<String, String> errors = new HashMap<>();
//
//            bindingResult.getFieldErrors("ticket").forEach((error) -> {
//                String fieldName = error.getField();
//                String errorMessage = error.getDefaultMessage();
//                errors.put(fieldName, errorMessage);
//            });
//
//            System.out.println("ERROR 1");
//            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//        }
//        else if (bindingResult.hasFieldErrors("message")) {
//            Map<String, String> errors = new HashMap<>();
//
//            bindingResult.getFieldErrors("message").forEach((error) -> {
//                String fieldName = error.getField();
//                String errorMessage = error.getDefaultMessage();
//                errors.put(fieldName, errorMessage);
//            });
//
//            System.out.println("ERROR 2");
//            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//        }

        Ticket ticketAddedInfo = ticketService.addTicket(ticket);
        ticketMessageService.addTicketMessage(message, ticketAddedInfo.getId());

        return new ResponseEntity<>(HttpStatus.CREATED);
        // return "Ticket added";
        // return ResponseEntity.ok("Ticket added successfully.");
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

//    /**
//     * Handles exception for invalid user input and displays
//     * a Map of errors recieved while trying to process
//     * the request
//     * @param ex Exception class to be resolved
//     * @return Map of errors regarding invalid input
//     */
//    @ResponseStatus (HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String,String> validationErrors(MethodArgumentNotValidException ex) {
//
//        Map<String, String> errors = new HashMap<>();
//
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }

    @DeleteMapping("/ticket/delete/{id}")
    public String deleteTicket(@PathVariable long id) {
        ticketService.deleteTicket(id);
        return "Ticket deleted";
    }
}

