/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.services.impl;

import com.temtree.pojo.Ticket;
import com.temtree.repository.TicketRepository;
import com.temtree.services.TicketService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public boolean addTicket(Ticket ticket) {
        return this.ticketRepository.addTicket(ticket);
    }

    @Override
    public boolean deleteTicket(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Ticket> getTickets() {
        return this.ticketRepository.getTickets();
    }

    @Override
    public List<Ticket> getTicketBustrips(int startLocationId, int endLocationId, Date departDate) {
        return this.ticketRepository.getTicketBustrips(startLocationId, endLocationId, departDate);
    }

}
