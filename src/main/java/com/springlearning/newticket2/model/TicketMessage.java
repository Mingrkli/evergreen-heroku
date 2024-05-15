package com.springlearning.newticket2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Here is the TicketMessage which would be connected to the Ticket
 */
@Entity
// We are putting the details in the database table named ticket_list
@Table(name = "ticket_messages_list")
@AllArgsConstructor // Creates Constructor with arguments
@NoArgsConstructor // Creates Default Constructors
@Data // Creates Setters, Getters, toString, Equals, and HashCode
@Builder
public class TicketMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long messageId;
    private String message;
    private String created;
    private String username;
    // We won't add the image now... since I don't blow up my database storage. Plz don't :(
    // private String img;

    // Many messages to one ticket
    // "FetchType.LAZY" means that it will load the relationship but don't load the whole entire object which is nice
    // since it saves memory and the database performance
    @ManyToOne(fetch = FetchType.LAZY)
    // "ticket_id" because the "ticket_" is needed since it need the entity there to match it
    @JoinColumn(name = "ticket_id")
    // @JsonIgnore annotation to specify a method or field that should be ignored during serialization and
    // deserialization processes. This marker annotation belongs to the Jackson library. We often apply this annotation
    // to exclude fields that may not be relevant or could contain sensitive information
    @JsonIgnore
    private Ticket ticket;
}
