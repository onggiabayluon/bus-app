/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.temtree.repository;

import com.temtree.pojo.CalendarDates;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface CalendarDatesRepository {
    List<CalendarDates> getCalendarDatess();

    boolean addCalendarDates(CalendarDates calendarDates);
    
    float getCDByBustrip(int bustripId, Date bookedDate);

    boolean deleteCalendarDates(int id);
}
