/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.temtree.repository;

import com.temtree.pojo.Seat;
import com.temtree.pojo.Ticket;
import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public interface TicketRepository {
    Ticket getTicketById(int id);
    
    List<Ticket> getTickets();
    
    List<Ticket> getTicketsByUserId(int userId);
    
    Ticket getTicketByUserId(int id);
    
    List<Ticket> getTicketBustrips(int startLocationId, int endLocationId, Date departDate);
    
    boolean addTicket(Ticket ticket);
    
    Ticket addTicket2(Ticket ticket);
    
    boolean checkBookedSeat(int id, Date bookedDate, int bustripId);
    
    int getTotalBookedSeatByDateAndBusTrip(Date bookedDate, int bustripId);
    
    boolean updateTicket(Ticket ticket);

    boolean deleteTicket(int id);
}
