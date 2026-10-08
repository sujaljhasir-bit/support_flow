package com.sujal.supportflow.controller;

import com.sujal.supportflow.entity.Ticket;
import com.sujal.supportflow.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }
    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id);
    }
    @PutMapping("/{id}")
    public Ticket updateTicket(
            @PathVariable Long id,
            @RequestBody Ticket ticket
    ) {
        return ticketService.updateTicket(id, ticket);
    }
    @DeleteMapping("/{id}")
    public String deleteTicket(@PathVariable Long id) {

        ticketService.deleteTicket(id);

        return "Ticket deleted successfully";
    }
}
