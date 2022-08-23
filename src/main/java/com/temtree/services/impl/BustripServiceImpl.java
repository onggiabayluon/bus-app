/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.services.impl;

import com.temtree.pojo.Bustrip;
import com.temtree.pojo.Comment;
import com.temtree.pojo.Route;
import com.temtree.pojo.User;
import com.temtree.repository.BustripRepository;
import com.temtree.repository.RouteRepository;
import com.temtree.repository.UserRepository;
import com.temtree.services.BustripService;
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
public class BustripServiceImpl implements BustripService {

    @Autowired
    private BustripRepository bustripRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RouteRepository routeRepository;

//    @Override
//    public Bustrip addBustrip(Date departTime, Date endTime, int routeId, int driverId) {
//        User driver = this.userRepository.findById(driverId);
//        Route route = this.routeRepository.findById(routeId);
//        
//        Bustrip bustrip = new Bustrip();
//        bustrip.setDepartTime(departTime);
//        bustrip.setEndTime(endTime);
//        bustrip.setRouteId(route);
//        bustrip.setDriverId(driver);
//        
//        return this.bustripRepository.addBustrip(bustrip);
//    }

    @Override
    public boolean deleteBustrip(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Bustrip> getBustrips() {
        return this.bustripRepository.getBustrips();
    }

    @Override
    public List<Bustrip> getAvailableBustrips(int startLocationId, int endLocationId, Date departDate) {
        return this.bustripRepository.getAvailableBustrips(startLocationId, endLocationId, departDate);
    }

    @Override
    public Bustrip findById(int i) {
        return this.bustripRepository.findById(i);
    }

    @Override
    public boolean addBustrip(Bustrip bustrip) {
        return this.bustripRepository.addBustrip(bustrip);
    }

}
