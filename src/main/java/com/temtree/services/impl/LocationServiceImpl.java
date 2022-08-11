/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.services.impl;

import com.temtree.pojo.Location;
import com.temtree.repository.LocationRepository;
import com.temtree.services.LocationService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;
    
    @Override
    public boolean addLocation(Location location) {
        return this.locationRepository.addLocation(location); 
    }

    @Override
    public boolean deleteLocation(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Location> getLocations() {
        return this.locationRepository.getLocations();
    }
    
}
