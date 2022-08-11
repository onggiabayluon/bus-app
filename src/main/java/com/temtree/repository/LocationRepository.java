/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.temtree.repository;

import com.temtree.pojo.Location;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface LocationRepository {
    List<Location> getLocations();

    boolean addLocation(Location location);

    boolean deleteLocation(int id);
}
