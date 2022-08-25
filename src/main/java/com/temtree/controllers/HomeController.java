/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.controllers;

import com.mservice.allinone.models.PayATMResponse;
import com.mservice.allinone.processor.allinone.PayATM;
import com.mservice.shared.sharedmodels.Environment;
import com.temtree.pojo.Bustrip;
import com.temtree.pojo.Location;
import com.temtree.pojo.Route;
import com.temtree.pojo.Seat;
import com.temtree.pojo.Ticket;
import com.temtree.pojo.User;
import com.temtree.repository.BustripRepository;
import com.temtree.repository.SeatRepository;
import com.temtree.repository.TicketRepository;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    @Autowired
    private TicketRepository ticketRepository;

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
    public String bustrip(Model model,
            @RequestParam Map<String, String> params,
            HttpSession session) throws ParseException {
        int startLocationId = Integer.parseInt(params.getOrDefault("from", "0"));
        int endLocationId = Integer.parseInt(params.getOrDefault("to", "0"));
        Date departDate = utils.stringInDateToJavaDate2(params.getOrDefault("date", null));
        
        
        List<Bustrip> bustrips = this.bustripService.getAvailableBustrips(startLocationId, endLocationId, departDate);
        
        // Seat Calculating: remainingSeat = totalBusSeat - totalBookedSeat(filter by bustripId and bookedDate);
        int busId = bustrips.get(0).getBusId().getId();
        int totalBusSeat = seatRepository.getTotalSeatByBus(busId);
        
        for (Bustrip bustrip : bustrips) {
            int totalBookedSeat = ticketRepository.getTotalBookedSeatByDateAndBusTrip(departDate, bustrip.getId());
            int remainingSeat = totalBusSeat - totalBookedSeat;
            bustrip.setRemainingSeat(remainingSeat);
        }
                
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
            boolean isBooked = ticketRepository.checkBookedSeat(seatId, bookedDate);

            if (isBooked == true) {
                errMsg = "Ghế đã có người đặt";
                model.addAttribute("errMsg", errMsg);
                // move to confirm page if error
                return "confirm";
            }

            if (isBooked == false) {
                Seat seat = seatRepository.findById(seatId);
//                seatRepository.updateIsBooked(seat.getId());

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

    @RequestMapping("/pay-momo")
    public String payMomo(Model model,
            HttpSession session) throws Exception {
        User user = (User) session.getAttribute("currentUser");
        Ticket ticket = ticketRepository.getTicketByUserId(user.getId());

        String requestId = String.valueOf(System.currentTimeMillis());
        String orderId = (ticket.getId()).toString();
        Long transId = 2L;
        long amount = ticket.getPrice();

        String partnerClientId = "partnerClientId";
        String orderInfo = "Pay With MoMo";
        String returnURL = "https://google.com.vn";
        String notifyURL = "https://google.com.vn";
        String callbackToken = "callbackToken";
        String token = "";
        String bankCode = "SML";

        Environment environment = Environment.selectEnv("dev", Environment.ProcessType.PAY_GATE);

//        CaptureMoMoResponse captureMoMoResponse = CaptureMoMo.process(environment, orderId, requestId, Long.toString(amount), "", returnURL, notifyURL, "");
//        QueryStatusTransactionResponse queryStatusTransactionResponse = QueryStatusTransactionResponse.process(environment, "1561972787557", "1562135830002");
        String publicKey = "INuJ7l7h3DkVrjWk";
        String privateKey = "G68L1mxpHZFLKu3zFhPWuNzRx1emVCFE/0rpq21IhyVNkwQZ+rqCYmbYGiBUm0+SO+uLn+P2YGe0DyoozPNqdJBoERuvwXIHIed/bbp2wu3VFslIwuMJ3dQLWfRirwoq98eG+a9VsZxZ+mB+juJBNWYvSvV5DHOCdKrfUQvXJg0y5pmOkeZC5PbgebGX1b16dG0nJVNSHAqG2M5I6xHTewyexySkVP2mfX9X0ETYp/esUapzom6ReSorplb2a2YYtKrcr4lFGrbDw9WZxty9Ov9p1bgQvbJzWqT0Rzge2IOG1Jh3r+i/zEtWQoBCMtW3sTHf9qBE98+s3AgMBAAECggEAQxBiU9aFgnk5HFGDTwJrDRlASRNrOBUu3odCS6MDD2e6T67daYWw+HRy4zxDTu1r4JsbijMA6wUPEG/SnWanD8f26DAcGC5vFKvZv5Ki8bQIXVzDGhr5MRS/E3lDxuEqljSPN+1+Ch6CV9r/vmN/YBV6zC1hH3IrTRPD71Jj1KMITCDQlKcDbZqgFTY0wq2ONrzQ5lF0u1sSrdnHLny2kayIAocWqSVbfcSE/9iKN4jkc2/zBQOAFgBQVPuZOdLL+rf1PTKus75aJm/TzaCcoxF496kTw/mRJ77rOxB8mNDEhGULTopG0Bk12upA+QXzxsWJKm8pgv/iXV+0Hi27oQKBgQDCMAydxOCybtOnTkRQ66typlRJQDVgBCD4yhNchOd6jWk34GRY64MuNbyyrD8A5P/ioI4OvRs00S28Sb/G/w3ldciR0j7lm9FgbjkTDCrVVbp4P8gczgL+z5mPdCua1KQD+2C5RA2tMRJlAfczIVekoxCriuCQSO9RltsGT7LmEQKBgQDBP/bzTD+PKWmxeBOTLeNGH8IM63DeccWtowxRgeF1xohFK1ipi5RKxoKOVLxku0U3tKOe6thE2IhpaqYFcCRs2TFZidChyytEjD4LVlECfe9OvCqfVL8IvDUzw8B3850HYrGUh8y4Mmry3JJYLOKoAPBqEg9NLe9c8yI9rI3UxwKBgGVQjnSOMLHH8vPaePhDTUtfDqC9OFvlK5LCU8G0sdUWDKyTjad7ERE+BjqudZyw3fTO0e9MqPIwpQ0U6VMY5ZYvkrrKF/jSCDaoq2yNr5doyAZPOMgWkCeEBtl6wflhMkXFlNx0bjJLZQ6ALQpnPgPu9BacObft5bcK3zF2yZ8RAoGBAIgkYfuBKf3XdQh7yX6Ug1qxoOmtLHTpvhPXnCQH1ig811+za+D13mDXfL5838QvUlIuRl78n6PQ0DlD0vZdzKuKT4P+3SY+lZrTGhqukp+ozOCxG23oLDUhMnHnZD6dN3EujGBRU14o1sOFtOu9o2gsUTLIylLbG5hmCSdd2wWdAoGBAIvddYHkS1b8B8TCv1+CVObe5WCUvqpZgbHo3oztD0KxlgWvl+f6y8DUToK3KU9sp512Ivk43mn1Xv2QftBx8E4vyhWeltdiKOJOhMsk6djjoyb8AOuyPVumXTQBuue1yRrTKLAl1SaZnzdrKzpXsI8OBpnI0bjFxA2SNnU/iD0R";

        String partnerCode = "MOMOIOBJ20220825";
        String phoneNumber = "0846478332";
        String username = "duc.huy";

        orderId = String.valueOf(System.currentTimeMillis());

//        PaymentResponse captureWalletMoMoResponse = CreateOrderMoMo.process(environment, orderId, requestId, Long.toString(amount), orderInfo, returnURL, notifyURL, "", RequestType.CAPTURE_WALLET, Boolean.TRUE);
        PayATMResponse payATMResponse = PayATM.process(environment, requestId, orderId, bankCode, "35000", "Pay With MoMo", returnURL, notifyURL, "");

//        PayGate.generateRSA(customerNumber, "247", "247", "nhatnguyen", environment.getPartnerInfo().getPartnerCode(), amount, publicKey);
        return null;
    }
}
