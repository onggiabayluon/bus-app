/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.services.impl;

import com.temtree.pojo.Bustrip;
import com.temtree.pojo.Seat;
import com.temtree.pojo.Ticket;
import com.temtree.pojo.User;
import com.temtree.repository.BustripRepository;
import com.temtree.repository.SeatRepository;
import com.temtree.repository.TicketRepository;
import com.temtree.repository.UserRepository;
import com.temtree.services.TicketService;
import com.temtree.utils.utils;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private BustripRepository bustripRepository;

    
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

    @Override
    public boolean addTicket(long price, Date bookedDate, Bustrip bustrip, User user, Seat seat) {
        try {
            
            Ticket ticket = new Ticket();
            
            ticket.setActive(true);
            ticket.setPaymentStatus(false);
            ticket.setPrice(price);
            ticket.setCreatedDate(utils.getCurrentDateTime());
            ticket.setBookedDate(bookedDate);
            ticket.setUserId(user);
            ticket.setSeatId(seat);
            ticket.setBustripId(bustrip);
            
            System.out.println("com.temtree.services.impl.TicketServiceImpl.addTicket()");
            System.err.println(ticket.getId());
            System.err.println(ticket.getBustripId());
            System.err.println(ticket.getBookedDate());
            System.err.println(ticket.getUserId());
            System.err.println(ticket.getSeatId());
            
            return this.ticketRepository.addTicket(ticket);
        } catch (ParseException ex) {
            Logger.getLogger(TicketServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

}
