/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.temtree.services;

import com.temtree.pojo.Bustrip;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface BustripService {

    Bustrip findById(int id);
    
    List<Bustrip> getBustrips();

    List<Bustrip> getAvailableBustrips(int startLocationId, int endLocationId, Date departDate);

//    Bustrip addBustrip(Date departTime, Date endTime, int routeId, int driverId);
    
    boolean addBustrip(Bustrip bustrip);

    boolean deleteBustrip(int id);
}
