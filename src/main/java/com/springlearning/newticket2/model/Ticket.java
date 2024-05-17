package com.springlearning.newticket2.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Here is the information and details about Ticket
 */
@Entity
// We are putting the details in the database table named ticket_list
@Table(name = "ticket_list")
@AllArgsConstructor // Creates Constructor with arguments
@NoArgsConstructor // Creates Default Constructors
@Data // Creates Setters, Getters, toString, Equals, and HashCode
@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String created;
    private String lastMessage; // chnaged to date
    private String status;
    private String groupID;
    private String priority;
    private String type;

    // "orphanRemoval = true" means that when the parent is gone the childs are too :(
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    // We will have a list here since we would have many messages
    private List<TicketMessage> ticketMessages = new ArrayList<TicketMessage>();
}