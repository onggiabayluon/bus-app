/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.temtree.services;

import com.temtree.pojo.Bus;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface BusService {
    List<Bus> getBus();
    
    boolean addBus(Bus bus);

    boolean deleteBus(int id);
}
