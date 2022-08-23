/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.temtree.repository;

import com.temtree.pojo.Route;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface RouteRepository {
    
    List<Route> getRoutesName();
    List<Route> getRoutes();
    List<Route> getRoutesByLocationId(int locationId);

    Route findById(int id);
    
    boolean addRoute(Route location);

    boolean deleteRoute(int id);
}
