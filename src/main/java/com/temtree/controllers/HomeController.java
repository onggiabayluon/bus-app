/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.controllers;

import com.temtree.pojo.Bustrip;
import com.temtree.pojo.Location;
import com.temtree.pojo.Route;
import com.temtree.pojo.Ticket;
import com.temtree.services.BustripService;
import com.temtree.services.LocationService;
import com.temtree.services.RouteService;
import com.temtree.services.TicketService;
import com.temtree.utils.utils;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author admin
 */
@Controller
public class HomeController {

    @Autowired
    private LocationService locationService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private RouteService routeService;

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        List<Location> startLocations = this.locationService.getLocations();
        Location firstStartLocationItem = startLocations.get(0);
        int startLocationId = firstStartLocationItem.getId();

        List<Route> routes = this.routeService.getRoutesByLocationId(startLocationId);
        model.addAttribute("locations", startLocations);
        model.addAttribute("routes", routes);

        return "index";
    }

    @PostMapping("/ticket")
    public String bustrip(Model model, @RequestParam Map<String, String> params) throws ParseException {
        int startLocationId = Integer.parseInt(params.getOrDefault("from", null));
        int endLocationId = Integer.parseInt(params.getOrDefault("to", null));
        Date departDate = utils.stringInDateToJavaDate(params.getOrDefault("date", null));

//        System.out.println(startLocationId);
//        System.out.println(endLocationId);
//        System.out.println(departDate);

        List<Ticket> tickets = this.ticketService.getTicketBustrips(startLocationId, endLocationId, departDate);

        List<Route> routes = this.routeService.getRoutesByLocationId(startLocationId);
        
        model.addAttribute("selectedLocationId", Integer.parseInt(params.getOrDefault("from", null)));
        model.addAttribute("departDate", params.getOrDefault("date", null));
        model.addAttribute("routes", routes);
        model.addAttribute("locations", this.locationService.getLocations());
        model.addAttribute("tickets", tickets);
        return "ticket";
    }

    @RequestMapping("/pay/{receiptId}")
    public String pay(Model model, @PathVariable(value = "receiptId") int id) {
        System.out.println(id);
        return "pay";
    }
}
