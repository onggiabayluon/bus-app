/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.services.impl;

import com.temtree.pojo.Route;
import com.temtree.repository.RouteRepository;
import com.temtree.services.RouteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public boolean addRoute(Route route) {
        return this.routeRepository.addRoute(route);
    }

    @Override
    public boolean deleteRoute(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Route> getRoutesName() {
        return this.routeRepository.getRoutesName();
    }

    @Override
    public List<Route> getRoutes() {
        return this.routeRepository.getRoutes();
    }

    @Override
    public List<Route> getRoutesByLocationId(int i) {
        return this.routeRepository.getRoutesByLocationId(i);
    }

}
