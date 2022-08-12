/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.controllers;

import com.temtree.utils.utils;
import com.temtree.pojo.Bustrip;
import com.temtree.pojo.Location;
import com.temtree.pojo.Route;
import com.temtree.services.BustripService;
import com.temtree.services.LocationService;
import com.temtree.services.RouteService;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author admin
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private LocationService locationService;
    @Autowired
    private RouteService routeService;
    @Autowired
    private BustripService bustripService;

    @PostMapping("/location")
    @ResponseStatus(HttpStatus.CREATED)
    public Location addLocation(@RequestBody Location location) {

        System.out.println("Check value: " + location.getName());
        this.locationService.addLocation(location);
        return location;
    }

    @PostMapping("/route")
    @ResponseStatus(HttpStatus.CREATED)
    public Route addRoute(@RequestBody Route route) {

        System.out.println("Check value: " + route.getStartLocationId());
        this.routeService.addRoute(route);
        return route;
    }

//    @PostMapping(value = "/bustrip")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Bustrip addBustrip(
//            @RequestBody Bustrip bustrip,
//            BindingResult r,
//            @RequestBody String departTime,
//            @RequestBody String endTime) throws ParseException
//    {
//        // Reformat Date
//        Date formattedDepartTime = utils.stringInTimeToDateObject(departTime);
//        Date formattedEndTime = utils.stringInTimeToDateObject(endTime);
//         
//        // System.out.println("/save | registerDate : " + formattedDepartTime);
//         
//        bustrip.setDepartTime(formattedDepartTime); 
//        bustrip.setEndTime(formattedEndTime); 
//        if (this.bustripService.addBustrip(bustrip) == true)
//            return bustrip;
//        
//        if (r.hasErrors()) {
//            return null;
//        }
//        
//        
//        
//        return bustrip;
//    }

}
