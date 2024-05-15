package com.springlearning.newticket2.repository;

import com.springlearning.newticket2.model.TicketMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketMessageRepository extends JpaRepository<TicketMessage, Long> {
    // Basically the select everything by if in the ticket database
    List<TicketMessage> findAllByTicketId(Long ticketId);
}
