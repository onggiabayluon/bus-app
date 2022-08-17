/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.controllers;

import com.temtree.pojo.Bus;
import com.temtree.pojo.Bustrip;
import com.temtree.pojo.Location;
import com.temtree.services.BusService;
import com.temtree.utils.utils;
import com.temtree.services.BustripService;
import com.temtree.services.LocationService;
import com.temtree.services.RouteService;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author admin
 */
@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    private LocationService locationService;
    @Autowired
    private RouteService routeService;
    @Autowired
    private BustripService bustripService;
    @Autowired
    private BusService busService;

    @RequestMapping("/")
    public String admin(Model model, @RequestParam Map<String, String> params) {

        return "admin";
    }

    @RequestMapping("/list")
    public String list(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("locations", this.locationService.getLocations());
        model.addAttribute("routes", this.routeService.getRoutes());
        model.addAttribute("bustrips", this.bustripService.getBustrips());
      

        return "list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("locations", this.locationService.getLocations());
        model.addAttribute("routes", this.routeService.getRoutesName());
        model.addAttribute("bustrips", this.bustripService.getBustrips());
        model.addAttribute("bustrip", new Bustrip());
        
        return "add";
    }
    
    
//    @GetMapping("/bustrip")
//    public String list(Model model) {
//        model.addAttribute("bustrip", new Bustrip());
//        
//        return "bustrip";
//    }
    
    @PostMapping("/add-bustrip")
    public String add(
            @ModelAttribute(value = "bustrip") Bustrip bustrip,
            BindingResult r,
            @RequestParam("departTime") String departTime,
            @RequestParam("endTime") String endTime) throws ParseException {
        
        // Reformat Date
        Date formattedDepartTime = utils.stringInTimeToDateObject(departTime);
        Date formattedEndTime = utils.stringInTimeToDateObject(endTime);
         
        // System.out.println("/save | registerDate : " + formattedDepartTime);
         
        bustrip.setDepartTime(formattedDepartTime); 
        bustrip.setEndTime(formattedEndTime); 
        if (this.bustripService.addBustrip(bustrip) == true)
            return "redirect:list";
        
        if (r.hasErrors()) {
            return "add";
        }
        
        
        
        return "list";
    }
    
    
    @PostMapping("/add-bus")
    public String addBus(
            @ModelAttribute(value = "bus") Bus bus,
            BindingResult r) throws ParseException {
        
        if (this.busService.addBus(bus) == true)
            return "redirect:list";
        
        if (r.hasErrors()) {
            return "add";
        }
        
        
        return "list";
    }


}
