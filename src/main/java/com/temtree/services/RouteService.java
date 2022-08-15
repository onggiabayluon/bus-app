/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.temtree.services;

import com.temtree.pojo.Route;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface RouteService {
    List<Route> getRoutesName();
    
    List<Route> getRoutes();
    
    List<Route> getRoutesByLocationId(int locationId);
    
    boolean addRoute(Route route);

    boolean deleteRoute(int id);
}
