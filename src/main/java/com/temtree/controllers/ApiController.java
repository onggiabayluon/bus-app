/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.controllers;

import com.temtree.pojo.Bustrip;
import com.temtree.pojo.Location;
import com.temtree.pojo.Route;
import com.temtree.pojo.Comment;
import com.temtree.services.BustripService;
import com.temtree.services.CommentService;
import com.temtree.services.LocationService;
import com.temtree.services.RouteService;
import com.temtree.utils.utils;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author admin
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private LocationService locationService;
    @Autowired
    private RouteService routeService;
    @Autowired
    private BustripService bustripService;
    @Autowired
    private CommentService commentService;

    @RequestMapping("/momo-notify")
    public void payMomo2() {
        System.out.println("test pay momo notify");

//        System.err.println(params);

    }

    @PostMapping(value = "/momo-notify"
//            , consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void payMomo() {
        System.out.println("test pay momo notify");

//        System.err.println(params);

    }

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

    @PostMapping("/comment")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment addComment(@RequestBody Map<String, String> params) {

        String content = params.getOrDefault("content", null);
        int bustripId = Integer.parseInt(params.getOrDefault("bustripId", null));
        int userId = Integer.parseInt(params.getOrDefault("userId", null));

        Comment comment = this.commentService.addComment(content, bustripId, userId);
        return comment;
    }

//    @PostMapping(value = "/bustrip")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Bustrip addBustrip(@RequestBody Map<String, String> params) throws ParseException
//    {
//        Date departTime = utils.stringInTimeToDateObject(params.getOrDefault("departTime", null));
//        Date endTime = utils.stringInTimeToDateObject(params.getOrDefault("endTime", null));
//        int routeId = Integer.parseInt(params.getOrDefault("routeId", null));
//        int driverId = Integer.parseInt(params.getOrDefault("driverId", null));
//        
//         
//        System.out.println("/save | registerDate : " + departTime);
//        
//        Bustrip bustrip = this.bustripService.addBustrip(departTime, endTime, routeId, driverId);
//         
//       return bustrip;
//    }
    @GetMapping("/routes")
    @ResponseStatus(HttpStatus.OK)
    public List<Route> getRoutes(@RequestParam String id) {
        System.out.println("Check value: " + id);
        int startLocationId = Integer.parseInt(id);

        List<Route> routes = this.routeService.getRoutesByLocationId(startLocationId);
        return routes;
    }

}
