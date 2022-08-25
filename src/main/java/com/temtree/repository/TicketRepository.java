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
    
    List<Ticket> getTickets();
    
    Ticket getTicketByUserId(int id);
    
    List<Ticket> getTicketBustrips(int startLocationId, int endLocationId, Date departDate);
    
    boolean addTicket(Ticket ticket);
    
    boolean checkBookedSeat(int id, Date bookedDate);
    
    int getTotalBookedSeatByDateAndBusTrip(Date bookedDate, int bustripId);

    boolean deleteTicket(int id);
}
