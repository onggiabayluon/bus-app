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
    List<Route> getRoutes();

    boolean addRoute(Route location);

    boolean deleteRoute(int id);
}
