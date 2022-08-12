/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.temtree.formatter;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;
import com.temtree.pojo.Route;
/**
 *
 * @author admin
 */
public class RouteFormatter implements Formatter<Route> {

    @Override
    public String print(Route t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Route parse(String id, Locale locale) throws ParseException {
        Route c = new Route();
        c.setId(Integer.parseInt(id));
        
        return c;
    }
    
}