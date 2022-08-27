/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.utils;


import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author admin
 */
public class utils {
//    public static JsonArray ticketListToJSONArray(List<Ticket> list) throws IOException {
//        Gson gson = new GsonBuilder().create();
//        com.google.gson.JsonArray myCustomArray = gson.toJsonTree(list).getAsJsonArray();
//        
//        return myCustomArray;
//    }
    
    public static String toSHA256(String secretkey, String data) {
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secretkey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            sha256_HMAC.init(secret_key);

            return Hex.encodeHexString(sha256_HMAC.doFinal(data.getBytes(StandardCharsets.UTF_8)));

        } catch (NoSuchAlgorithmException | InvalidKeyException  e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public static Date stringInTimeToDateObject(String time) throws ParseException {
        //String time = "15:30";

        DateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date = sdf.parse(time);

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
