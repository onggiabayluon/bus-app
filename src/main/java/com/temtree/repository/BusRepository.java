/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.temtree.repository;

import com.temtree.pojo.Bus;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface BusRepository {
    List<Bus> getBuss();

    boolean addBus(Bus location);

    boolean deleteBus(int id);

    public List<Bus> getBus();
}
