/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.temtree.repository;

import com.temtree.pojo.Bustrip;
import com.temtree.pojo.User;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface BustripRepository{
    
    Bustrip findById(int id);
    
    List<Bustrip> getBustrips();
    
    List<Bustrip> getTicketBustrips(int startLocationId, int endLocationId, Date departDate);
    
    boolean addBustrip(Bustrip bustrip);

    boolean deleteBustrip(int id);
}
