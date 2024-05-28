package com.springlearning.newticket2.dto;

import com.springlearning.newticket2.model.Ticket;
import com.springlearning.newticket2.model.TicketMessage;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for when we add the ticket we would also add the message to the ticket created
 */
@AllArgsConstructor // Creates Constructor with arguments
@NoArgsConstructor // Creates Default Constructors
@Data // Creates Setters, Getters, toString, Equals, and HashCode
public class AddTicketRequest {
    @Valid
    private Ticket ticket;
    @Valid
    private TicketMessage message;
}
