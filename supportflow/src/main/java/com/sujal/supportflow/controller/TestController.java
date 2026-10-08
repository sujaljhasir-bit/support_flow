package com.sujal.supportflow.controller;


import com.sujal.supportflow.entity.Ticket;
import com.sujal.supportflow.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TestController {
   private final TicketService ticketService;
   public TestController(TicketService ticketService){
       this.ticketService=ticketService;
   }
   @PostMapping
    public Ticket createTicket(@Valid @RequestBody Ticket ticket){
       return ticketService.createTicket(ticket);
   }
   @GetMapping
    public List<Ticket> getAllTicket(){
       return ticketService.getAllTickets();
   }
}
