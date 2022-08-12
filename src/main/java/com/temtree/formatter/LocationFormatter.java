/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.temtree.formatter;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;
import com.temtree.pojo.Location;
/**
 *
 * @author admin
 */
public class LocationFormatter implements Formatter<Location> {

    @Override
    public String print(Location t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Location parse(String id, Locale locale) throws ParseException {
        Location c = new Location();
        c.setId(Integer.parseInt(id));
        
        return c;
    }
    
}