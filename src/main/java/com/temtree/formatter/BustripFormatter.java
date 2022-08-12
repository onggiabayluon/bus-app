/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.temtree.formatter;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;
import com.temtree.pojo.Bustrip;
/**
 *
 * @author admin
 */
public class BustripFormatter implements Formatter<Bustrip> {

    @Override
    public String print(Bustrip t, Locale locale) {
        return String.valueOf(t.getId());
    }

//    @Override
//    public Bustrip parse(String departTime, String endTime, Locale locale) throws ParseException {
//        Bustrip c = new Bustrip();
//        c.setDepartTime(Integer.parseInt(id));
//        
//        return c;
//    }

    @Override
    public Bustrip parse(String string, Locale locale) throws ParseException {
        System.out.println("com.temtree.formatter.BustripFormatter.parse()");
        System.out.println(string);
        return null;
    }
    
}