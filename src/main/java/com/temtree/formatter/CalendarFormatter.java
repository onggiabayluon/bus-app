/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.temtree.formatter;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;
import com.temtree.pojo.Calendar;
/**
 *
 * @author admin
 */
public class CalendarFormatter implements Formatter<Calendar> {

    @Override
    public String print(Calendar t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Calendar parse(String id, Locale locale) throws ParseException {
        Calendar c = new Calendar();
        c.setId(Integer.parseInt(id));
        
        return c;
    }
    
}