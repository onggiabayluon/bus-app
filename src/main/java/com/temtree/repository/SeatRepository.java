/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.temtree.repository;

import com.temtree.pojo.Seat;
import java.util.List;

/**
 *
 * @author admin
 */
public interface SeatRepository {
    List<Seat> getSeats();

    boolean addSeat(Seat seat);

    boolean deleteSeat(int id);
    
    Seat findById(int id);
    
    boolean checkBooked(int id);
    
    boolean updateIsBooked(int id);

    public List<Seat> getSeat();
}
