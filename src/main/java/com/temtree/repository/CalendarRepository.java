/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.temtree.repository;

import com.temtree.pojo.Calendar;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface CalendarRepository {
    List<Calendar> getCalendars();

    boolean addCalendar(Calendar calendar);

    boolean deleteCalendar(int id);
}
