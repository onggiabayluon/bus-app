/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.controllers;

import com.temtree.pojo.Bus;
import com.temtree.pojo.Bustrip;
import com.temtree.pojo.Calendar;
import com.temtree.pojo.CalendarDates;
import com.temtree.pojo.Location;
import com.temtree.pojo.Route;
import com.temtree.pojo.Seat;
import com.temtree.pojo.User;
import com.temtree.repository.BusRepository;
import com.temtree.repository.BustripRepository;
import com.temtree.repository.CalendarDatesRepository;
import com.temtree.repository.CalendarRepository;
import com.temtree.repository.LocationRepository;
import com.temtree.repository.SeatRepository;
import com.temtree.repository.StatsRepository;
import com.temtree.repository.TicketRepository;
import com.temtree.repository.UserRepository;
import com.temtree.services.BusService;
import com.temtree.utils.utils;
import com.temtree.services.BustripService;
import com.temtree.services.LocationService;
import com.temtree.services.RouteService;
import com.temtree.services.UserService;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private CalendarRepository calendarRepository;
    @Autowired
    private CalendarDatesRepository calendarDatesRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private BustripRepository bustripRepository;

    @Autowired
    private StatsRepository statsRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @RequestMapping("/")
    public String admin(Model model, @RequestParam Map<String, String> params) throws ParseException {
        boolean paymentStatus = Boolean.parseBoolean(params.getOrDefault("paymentStatus", "false"));
        Date fromDate = utils.stringInDateToJavaDate3(params.getOrDefault("fromDate", null), "yyyy-MM-dd");
        Date toDate = utils.stringInDateToJavaDate3(params.getOrDefault("toDate", null), "yyyy-MM-dd");

        if (fromDate == null && toDate == null) {
            fromDate = utils.getCurrentDate("yyyy-MM-dd");
            toDate = utils.getCurrentDate("yyyy-MM-dd");
        }

        model.addAttribute("fromDate", params.getOrDefault("fromDate", null));
        model.addAttribute("toDate", params.getOrDefault("toDate", null));
        model.addAttribute("paymentStatus", params.getOrDefault("paymentStatus", null));
        model.addAttribute("totalRevenueStats", statsRepository.totalRevenue());
        model.addAttribute("todayRevenueStats", statsRepository.todayRevenue(utils.getCurrentDate("yyyy-MM-dd"), utils.getCurrentDate("yyyy-MM-dd")));
        model.addAttribute("monthRevenueStats", statsRepository.revenueStatsByMonth(fromDate, toDate));
        model.addAttribute("routeRevenueStats", statsRepository.revenueStatsByRoute(fromDate, toDate));
        model.addAttribute("tickets", ticketRepository.getTicketsWithFilter(paymentStatus, fromDate, toDate));
        return "admin";
    }

    @RequestMapping("/list")
    public String list(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("locations", this.locationService.getLocations());
        model.addAttribute("routes", this.routeService.getRoutes());
        model.addAttribute("bustrips", this.bustripService.getBustrips());
        model.addAttribute("users", this.userRepository.getUsers());
        
        
        
        model.addAttribute("bustrip", new Bustrip());
        model.addAttribute("user", new User());
        model.addAttribute("location", new Location());
        

        return "list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("locations", this.locationService.getLocations());
        model.addAttribute("routes", this.routeService.getRoutesName());
        model.addAttribute("bustrips", this.bustripService.getBustrips());
        model.addAttribute("drivers", this.userRepository.getUsersByRole(User.DRIVER));
        model.addAttribute("calendars", this.calendarRepository.getCalendars());
        model.addAttribute("buses", this.busRepository.getBuses());
        model.addAttribute("bus", new Bus());
        model.addAttribute("bustrip", new Bustrip());
        model.addAttribute("calendar", new Calendar());
        model.addAttribute("calendarDates", new CalendarDates());
        model.addAttribute("user", new User());
        model.addAttribute("location", new Location());
        model.addAttribute("route", new Route());
        model.addAttribute("seat", new Seat());

        return "add";
    }
    
    @PostMapping("/add-bustrip")
    public String add(
            @ModelAttribute(value = "bustrip") Bustrip bustrip,
            BindingResult r,
            HttpServletRequest request
    //            @RequestParam("departTime") String departTime,
    //            @RequestParam("endTime") String endTime
    )
            throws ParseException {

        String[] departTimes = request.getParameterValues("departTime");
        String[] endTimes = request.getParameterValues("endTime");
        boolean result = false;

        for (int i = 0; i < departTimes.length; i++) {
            // Reformat Date
            Date formattedDepartTime = utils.stringInTimeToDateObject(departTimes[i]);
            Date formattedEndTime = utils.stringInTimeToDateObject(endTimes[i]);

            // Re-set bustrip date 
            bustrip.setDepartTime(formattedDepartTime);
            bustrip.setEndTime(formattedEndTime);

            result = this.bustripService.addBustrip(bustrip);

        }

        if (result == true) {
            return "redirect:list";
        }

        if (r.hasErrors()) {
            return "add";
        }

        return "list";
    }
    

    @PostMapping("/add-seat")
    public String addSeats(
            @ModelAttribute(value = "seat") Seat seat,
            BindingResult r,
            HttpServletRequest request
    )
            throws ParseException {

        if (this.seatRepository.addSeat(seat) == true) {
            return "redirect:add";
        }

        if (r.hasErrors()) {
            return "add";
        }

        return "list";
    }
    
    
    @PostMapping("/update-user")
    public String updateUser(
            @ModelAttribute(value = "user") User user,
            BindingResult r) throws ParseException {

        if (this.userRepository.updateUser(user) == true) {
            return "redirect:list";
        }

        if (r.hasErrors()) {
            return "redirect:add";
        }

        return "redirect:list";
    }
    
    

    @PostMapping("/update-bustrip")
    public String updateBustrip(
            @ModelAttribute(value = "bustrip") Bustrip bustrip,
            BindingResult r) throws ParseException {
        

        if (this.bustripRepository.updateBustrip(bustrip) == true) {
            return "redirect:list";
        }

        if (r.hasErrors()) {
            return "redirect:add";
        }

        return "redirect:list";
    }
    
    @PostMapping("/update-location")
    public String updateLocation(
            @ModelAttribute(value = "bustrip") Location location,
            BindingResult r) throws ParseException {
        

        if (this.locationRepository.updateLocation(location) == true) {
            return "redirect:list";
        }

        if (r.hasErrors()) {
            return "redirect:add";
        }

        return "redirect:list";
    }

    @PostMapping("/add-bus")
    public String addBus(
            @ModelAttribute(value = "bus") Bus bus,
            BindingResult r) throws ParseException {

        if (this.busService.addBus(bus) == true) {
            return "redirect:list";
        }

        if (r.hasErrors()) {
            return "add";
        }

        return "list";
    }

    @PostMapping("/add-calendar")
    public String addCalendar(
            @ModelAttribute(value = "calendar") Calendar calendar,
            BindingResult r,
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate) throws ParseException {

        // Reformat Date
        Date formattedStartDate = utils.stringInDateToJavaDate(startDate);
        Date formattedEndDate = utils.stringInDateToJavaDate(endDate);
        // Re-set bustrip date 
        calendar.setStartDate(formattedStartDate);
        calendar.setEndDate(formattedEndDate);

        if (this.calendarRepository.addCalendar(calendar) == true) {
            return "redirect:list";
        }

        if (r.hasErrors()) {
            return "add";
        }

        return "list";
    }

    @PostMapping("/add-calendar-dates")
    public String addCalendarDates(
            @ModelAttribute(value = "calendar") CalendarDates calendarDates,
            BindingResult r,
            @RequestParam("date") String date) throws ParseException {

        // Reformat Date
        Date formattedDate = utils.stringInDateToJavaDate(date);
        // Re-set bustrip date 
        calendarDates.setDate(formattedDate);

        if (this.calendarDatesRepository.addCalendarDates(calendarDates) == true) {
            return "redirect:list";
        }

        if (r.hasErrors()) {
            return "add";
        }

        return "list";
    }

    @PostMapping("/add-user")
    public String addUser(
            @ModelAttribute(value = "user") User user,
            BindingResult r) throws ParseException {

        if (this.userService.addUser(user) == true) {
            return "redirect:list";
        }

        if (r.hasErrors()) {
            return "add";
        }

        return "list";
    }

    @PostMapping("/add-location")
    public String addLocation(
            @ModelAttribute(value = "location") Location location,
            BindingResult r) throws ParseException {

        if (this.locationService.addLocation(location) == true) {
            return "redirect:list";
        }

        if (r.hasErrors()) {
            return "add";
        }

        return "list";
    }
    
    @PostMapping("/add-route")
    public String addRoute(
            @ModelAttribute(value = "route") Route route,
            BindingResult r) throws ParseException {

        if (this.routeService.addRoute(route) == true) {
            return "redirect:list";
        }

        if (r.hasErrors()) {
            return "add";
        }

        return "list";
    }

}
