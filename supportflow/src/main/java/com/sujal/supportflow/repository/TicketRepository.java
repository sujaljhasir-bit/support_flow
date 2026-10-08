package com.sujal.supportflow.repository;

import com.sujal.supportflow.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
