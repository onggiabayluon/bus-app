/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.services.impl;

import com.temtree.pojo.Bus;
import com.temtree.repository.BusRepository;
import com.temtree.services.BusService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class BusServiceImpl implements BusService {
    @Autowired
    private BusRepository busRepository;
    
    @Override
    public boolean addBus(Bus bus) {
        return this.busRepository.addBus(bus); 
    }

    @Override
    public boolean deleteBus(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Bus> getBus() {
        return this.busRepository.getBus();
    }
}
    
    

   