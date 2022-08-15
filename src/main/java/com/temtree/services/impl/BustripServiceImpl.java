/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.services.impl;

import com.temtree.pojo.Bustrip;
import com.temtree.repository.BustripRepository;
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

    @Override
    public boolean addBustrip(Bustrip bustrip) {
        return this.bustripRepository.addBustrip(bustrip);
    }

    @Override
    public boolean deleteBustrip(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Bustrip> getBustrips() {
        return this.bustripRepository.getBustrips();
    }

    @Override
    public List<Bustrip> getTicketBustrips(int startLocationId, int endLocationId, Date departDate) {
        return this.bustripRepository.getTicketBustrips(startLocationId, endLocationId, departDate);
    }

}
