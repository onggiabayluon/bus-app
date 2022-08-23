/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.controllers;

import com.temtree.pojo.Bustrip;
import com.temtree.pojo.Location;
import com.temtree.pojo.Route;
import com.temtree.pojo.Seat;
import com.temtree.pojo.User;
import com.temtree.repository.BustripRepository;
import com.temtree.repository.SeatRepository;
import com.temtree.services.BustripService;
import com.temtree.services.LocationService;
import com.temtree.services.RouteService;
import com.temtree.services.TicketService;
import com.temtree.utils.utils;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    private BustripService bustripService;
    @Autowired
    private RouteService routeService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private BustripRepository bustripRepository;
    @Autowired
    private SeatRepository seatRepository;

    @ModelAttribute
    public void commonAttr(Model model, HttpSession session) {
        // inject currentUser from session after login
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
    }

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

    @RequestMapping("/bustrip")
    public String bustrip(Model model, @RequestParam Map<String, String> params) throws ParseException {
        int startLocationId = Integer.parseInt(params.getOrDefault("from", "0"));
        int endLocationId = Integer.parseInt(params.getOrDefault("to", "0"));
        Date departDate = utils.stringInDateToJavaDate2(params.getOrDefault("date", null));

//        System.out.println(startLocationId);
//        System.out.println(endLocationId);
//        System.out.println(departDate);
        List<Bustrip> bustrips = this.bustripService.getAvailableBustrips(startLocationId, endLocationId, departDate);

        List<Route> routes = this.routeService.getRoutesByLocationId(startLocationId);

        model.addAttribute("selectedLocationId", Integer.parseInt(params.getOrDefault("from", "0")));
        model.addAttribute("selectedEndId", Integer.parseInt(params.getOrDefault("to", "0")));
        model.addAttribute("departDate", params.getOrDefault("date", null));
        model.addAttribute("routes", routes);
        model.addAttribute("locations", this.locationService.getLocations());
        model.addAttribute("bustrips", bustrips);
        return "bustrip";
    }

    @PostMapping("/confirm")
    public String confirm(Model model,
            @RequestParam Map<String, String> params,
            HttpServletRequest request) throws ParseException {
        String referer = request.getHeader("Referer");
        String[] seats = request.getParameterValues("seatId");
        String departDate = params.getOrDefault("departDate", null);
        int bustripId = Integer.parseInt(params.getOrDefault("bustripId", null));
        Bustrip selectedBustrip = bustripService.findById(bustripId);
        long totalPrice = selectedBustrip.getPrice() * seats.length;

        for (String seat : seats) {
            int seatId = Integer.parseInt(seat);
            System.out.println(seatId);
        }

        model.addAttribute("selectedDate", departDate);
        model.addAttribute("referer", referer);
        model.addAttribute("bustripId", bustripId);
        model.addAttribute("selectedSeats", seats);
        model.addAttribute("totalPrice", totalPrice);

        model.addAttribute("selectedBustrip", selectedBustrip);
        return "confirm";
    }

    @PostMapping("/book-ticket")
    public String bookTicket(Model model,
            @RequestParam Map<String, String> params,
            HttpServletRequest request,
            HttpSession session) throws ParseException {
        // Get query params
        String[] seats = request.getParameterValues("seatIds");
        Date bookedDate = utils.stringInDateToJavaDate2(params.getOrDefault("bookedDate", null));
        int bustripId = Integer.parseInt(params.getOrDefault("bustripId", null));
        String errMsg = "";

        // Get pojo class
        Bustrip bustrip = bustripRepository.findById(bustripId);
        User user = (User) session.getAttribute("currentUser");
        long price = bustrip.getPrice();

        // save multiple ticket by seat
        for (String s : seats) {
            int seatId = Integer.parseInt(s);
            boolean isBooked = seatRepository.checkBooked(seatId);

            if (isBooked == true) {
                errMsg = "Ghế đã có người đặt";
                model.addAttribute("errMsg", errMsg);
                // move to confirm page if error
                return "confirm";
            }
            
            if (isBooked == false) {
                Seat seat = seatRepository.findById(seatId);
                seatRepository.updateIsBooked(seat.getId());
                
                if (this.ticketService.addTicket(price, bookedDate, bustrip, user, seat) == false) {
                    errMsg = "Đã có lỗi xảy ra";
                    model.addAttribute("errMsg", errMsg);
                    // move to confirm page if error
                    return "confirm";
                }
            }

        }

        // move to payment page if success
        return "redirect:/";
    }

//    @RequestMapping("/pay/{receiptId}")
//    public String pay(Model model, @PathVariable(value = "receiptId") int id) {
//        System.out.println(id);
//        return "pay";
//    }
}
