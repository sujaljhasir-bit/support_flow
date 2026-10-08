package com.sujal.supportflow.service;


import com.sujal.supportflow.entity.Ticket;
import com.sujal.supportflow.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository=ticketRepository;
    }
    public Ticket createTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }
    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
    }
    public Ticket updateTicket(Long id, Ticket updatedTicket) {

        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        ticket.setTitle(updatedTicket.getTitle());
        ticket.setDescription(updatedTicket.getDescription());
        ticket.setStatus(updatedTicket.getStatus());
        ticket.setPriority(updatedTicket.getPriority());

        return ticketRepository.save(ticket);
    }
    public void deleteTicket(Long id) {

        if (!ticketRepository.existsById(id)) {
            throw new RuntimeException("Ticket not found");
        }

        ticketRepository.deleteById(id);
    }
}
