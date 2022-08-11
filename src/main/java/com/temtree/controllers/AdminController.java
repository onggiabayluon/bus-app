/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.controllers;

import com.temtree.pojo.Location;
import com.temtree.services.LocationService;
import com.temtree.services.RouteService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author admin
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private LocationService locationService;
    @Autowired
    private RouteService routeService;
    
    @RequestMapping("/")
    public String admin(Model model, @RequestParam Map<String, String> params) {
        
        return "admin";
    }
    
    @RequestMapping("/list")
    public String list(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("locations", this.locationService.getLocations());
        model.addAttribute("routes", this.routeService.getRoutes());
        
        return "list";
    }
    
    @GetMapping("/add")
    public String add(Model model) {
//        model.addAttribute("product", new Product());
        
        return "add";
    }
    
}
