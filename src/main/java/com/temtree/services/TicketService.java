/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.temtree.services;

import com.temtree.pojo.Bustrip;
import com.temtree.pojo.Seat;
import com.temtree.pojo.Ticket;
import com.temtree.pojo.User;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface TicketService {

    List<Ticket> getTickets();
    
    List<Ticket> getTicketBustrips(int startLocationId, int endLocationId, Date departDate);

    boolean addTicket(long price, Date bookedDate, Bustrip bustrip, User user, Seat seat);
    
    Ticket addTicket2(long price, Date bookedDate, Bustrip bustrip, User user, Seat seat);

    boolean deleteTicket(int id);
}
