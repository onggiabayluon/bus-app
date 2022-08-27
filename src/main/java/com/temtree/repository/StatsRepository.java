/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.temtree.repository;

import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public interface StatsRepository{
    Object[] todayRevenue(Date fromDate, Date toDate);
    
    List<Object[]> revenueStats(Date fromDate, Date toDate);
    
    List<Object[]> revenueStatsByMonth(Date fromDate, Date toDate);
    
    List<Object[]> revenueStatsByRoute(Date fromDate, Date toDate);
}
