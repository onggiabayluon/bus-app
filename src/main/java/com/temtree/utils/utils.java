/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author admin
 */
public class utils {
    public static Date stringInTimeToDateObject(String time) throws ParseException {
        //String time = "15:30";

        DateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date = sdf.parse(time);

//        System.out.println("date: " + date);
//        System.out.println("Time: " + sdf.format(date));

        return date;
    }
    public static Date stringInDateToJavaDate(String strDate) throws ParseException {
        //String date = "15/08/2022";
        try {
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(strDate);

            System.out.println("date: " + date);
            System.out.println("Time: " + sdf.format(date));

            return date;
        }
        catch (Exception e) {
            System.err.println(e);
        }
        
        return null;
    }
    
    public static Date stringInDateToJavaDate2(String strDate) throws ParseException {
        //String date = "15/08/2022";
        try {
            DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date date = sdf.parse(strDate);

            return date;
        }
        catch (Exception e) {
            System.err.println(e);
        }
        
        return null;
    }
    
    public static Date getCurrentDateTime() throws ParseException {
        //String date = "15/08/2022";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            formatter.format(date);

            return date;
        }
        catch (Exception e) {
            System.err.println(e);
        }
        
        return null;
    }
}
