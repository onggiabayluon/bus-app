/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temtree.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.temtree.pojo.Bustrip;
import com.temtree.pojo.Location;
import com.temtree.pojo.Receipt;
import com.temtree.pojo.Route;
import com.temtree.pojo.Seat;
import com.temtree.pojo.Ticket;
import com.temtree.pojo.User;
import com.temtree.repository.BustripRepository;
import com.temtree.repository.CalendarDatesRepository;
import com.temtree.repository.ReceiptRepository;
import com.temtree.repository.SeatRepository;
import com.temtree.repository.TicketRepository;
import com.temtree.services.BustripService;
import com.temtree.services.LocationService;
import com.temtree.services.RouteService;
import com.temtree.services.TicketService;
import com.temtree.utils.utils;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

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
    @Autowired
    private CalendarDatesRepository calendarDatesRepository;
    @Autowired
    private ReceiptRepository receiptRepository;

    @ModelAttribute
    public void commonAttr(Model model, HttpSession session, HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        // inject currentUser from session after login
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        model.addAttribute("referer", referer);
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

    @RequestMapping("/carts")
    public String carts(Model model,
            HttpSession session) throws ParseException {

        User user = (User) session.getAttribute("currentUser");
        List<Ticket> tickets = this.ticketRepository.getTicketsByUserId(user.getId());

        model.addAttribute("tickets", tickets);
        return "carts";
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
        for (Bustrip bustrip : bustrips) {
            int busId = bustrip.getBusId().getId();
            int totalBusSeat = seatRepository.getTotalSeatByBus(busId);
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
        String[] seats = request.getParameterValues("seatId");
        String departDate = params.getOrDefault("departDate", null);
        int bustripId = Integer.parseInt(params.getOrDefault("bustripId", null));
        Bustrip selectedBustrip = bustripService.findById(bustripId);

        Date bookedDate = utils.stringInDateToJavaDate2(departDate);
        float ratio = calendarDatesRepository.getCDByBustrip(bustripId, bookedDate);
        long totalPrice = (long) (selectedBustrip.getPrice() * seats.length * ratio);

        model.addAttribute("selectedDate", departDate);
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
        float ratio = calendarDatesRepository.getCDByBustrip(bustripId, bookedDate);
        long price = (long) (bustrip.getPrice() * ratio);

        // save multiple ticket by seat
        for (String s : seats) {
            int seatId = Integer.parseInt(s);
            boolean isBooked = ticketRepository.checkBookedSeat(seatId, bookedDate, bustripId);

            if (isBooked == true) {
                errMsg = "Ghế đã có người đặt";
                model.addAttribute("errMsg", errMsg);
                // move to confirm page if error
                return "confirm";
            }

            if (isBooked == false) {
                Seat seat = seatRepository.findById(seatId);

                if (this.ticketService.addTicket(price, bookedDate, bustrip, user, seat) == false) {
                    errMsg = "Đã có lỗi xảy ra";
                    model.addAttribute("errMsg", errMsg);
                    // move to confirm page if error
                    return "confirm";
                }
            }

        }

        // move to payment page if success
        return "redirect:/carts";
    }

    @PostMapping("/pay-momo")
    public String payMomo(Model model,
            @RequestParam Map<String, String> params,
            HttpServletRequest request,
            HttpSession session) throws Exception {


        /**
         * Phase 2: Handle Momo Payment
         */
        int ticketId = Integer.parseInt(params.getOrDefault("ticketId", null));
        
        User user = (User) session.getAttribute("currentUser");
        Ticket ticket = ticketRepository.getTicketById(ticketId);

        //parameters
        String endpoint = "https://test-payment.momo.vn/v2/gateway/api/create";
        String partnerCode = "MOMO";
        String accessKey = "F8BBA842ECF85";
        String secretKey = "K951B6PE1waDMi640xX08PD3vg6EkVlz";
//        String partnerCode = "MOMOIOBJ20220825";
//        String accessKey = "INuJ7l7h3DkVrjWk";
//        String secretKey = "G68L1mxpHZFLKu3zFhPWuNzRx1emVCFE";
        String requestId = partnerCode + new Date().getTime();
//        String orderId = requestId;
        String orderId = ticket.getId().toString();
        String orderInfo = "Thanh toán vé xe bằng momo, mã hóa đơn: " + orderId;
        String redirectUrl = "http://localhost:8080/busapp/momo-notify";
        String ipnUrl = "http://localhost:8080/busapp/api/momo-notify";
        String amount = ticket.getPrice().toString();
        String requestType = "captureWallet";
        String extraData = ""; //pass empty value if your merchant does not have stores

        //before sign HMAC SHA256 with format
        //accessKey=$accessKey&amount=$amount&extraData=$extraData&ipnUrl=$ipnUrl&orderId=$orderId&orderInfo=$orderInfo&partnerCode=$partnerCode&redirectUrl=$redirectUrl&requestId=$requestId&requestType=$requestType
        String rawSignature = "accessKey=" + accessKey + "&amount=" + amount + "&extraData=" + extraData + "&ipnUrl=" + ipnUrl + "&orderId=" + orderId + "&orderInfo=" + orderInfo + "&partnerCode=" + partnerCode + "&redirectUrl=" + redirectUrl + "&requestId=" + requestId + "&requestType=" + requestType;
        //puts raw signature
        System.out.println("--------------------RAW SIGNATURE----------------");
        System.out.println(rawSignature);

        //signature
        String signature = utils.toSHA256(secretKey, rawSignature);

        System.out.println("--------------------SIGNATURE----------------");
        System.out.println(signature);

        Map<String, String> requestBody = new HashMap<>();
        {
            requestBody.put("partnerCode", partnerCode);
            requestBody.put("accessKey", accessKey);
            requestBody.put("requestId", requestId);
            requestBody.put("amount", amount);
            requestBody.put("orderId", orderId);
            requestBody.put("orderInfo", orderInfo);
            requestBody.put("redirectUrl", redirectUrl);
            requestBody.put("ipnUrl", ipnUrl);
            requestBody.put("extraData", extraData);
            requestBody.put("requestType", requestType);
            requestBody.put("signature", signature);
        }

        String json = new ObjectMapper().writeValueAsString(requestBody);

        // Create a new RestTemplate instance
        RestTemplate rest = new RestTemplate();
        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.setContentLength(json.length());

        // Request to momo dev endpoint and get response 
        HttpEntity<String> requestEntity = new HttpEntity<String>(json, headers);
        ResponseEntity<String> responseEntity = rest.exchange(endpoint, HttpMethod.POST, requestEntity, String.class);
        System.out.println(responseEntity.getBody());

        Map<String, String> responseMap = new ObjectMapper().readValue(responseEntity.getBody(), Map.class);
        String payUrl = responseMap.get("payUrl");

        // Redirect sang giao diện thanh toán momo
        return "redirect:" + payUrl;
    }

    
    
    
    
    
    
    @RequestMapping(value = "/momo-notify")
    public String momoPostProcess(Model model,
            @RequestParam Map<String, String> params,
            HttpSession session) {

        System.out.println("test pay momo notify");
        System.err.println(params);
        
        /**
         * {"partnerCode":"MOMO","orderId":"MOMO1661521038667","requestId":"MOMO1661521038667","amount":1000,"responseTime":1661521041642,"message":"Successful.","resultCode":0,"payUrl":"https://test-payment.momo.vn/v2/gateway/pay?t=TU9NT3xNT01PMTY2MTUyMTAzODY2Nw==","deeplink":"momo://?action=payWithAppToken&amount=1000&cardId=&cardType=&cashInId=&cashInIdPay=&comment=&createdAt=1661521041641&deeplinkCallback=&description=Thanh+toa%CC%81n+ve%CC%81+xe+b%C4%83%CC%80ng+momo&discountCampaignAmount=0&discountCode=&extra=&extraData=&extras=&gatewayMerchantCode=MOMO&gatewaySessionId=TU9NT3xNT01PMTY2MTUyMTAzODY2Nw==&gatewayVersion=3.0&giftIds=&installmentToken=&isScanQR=false&language=en&merchantcode=MOMO&merchantname=MoMo+Payment&merchantnamelabel=Nh%C3%A0+cung+c%E1%BA%A5p&moneylimitPerTrans=&orderGroupId=&orderId=MOMO1661521038667&orderLabel=M%C3%A3+%C4%91%C6%A1n+h%C3%A0ng&partnerCode=MOMO&partnerName=MoMo+Payment&pin=&prepaidIds=&requestId=MOMO1661521038667&requestType=payment&serviceType=app&signature=9ca451f0fff9b9a4d2d9279033dbe1b8e70e49f3d7c470187be00d1a86036ce9&storeId=MOMO&storeName=MoMo+Payment&subPartnerCode=&type=&urlSubmitToken=https%3A%2F%2Fmomo.vn&v=","qrCodeUrl":"https://test-payment.momo.vn/v2/gateway/app?isScanQr=true&t=TU9NT3xNT01PMTY2MTUyMTAzODY2Nw=="}
         * {partnerCode=MOMO, orderId=MOMO1661521038667, requestId=MOMO1661521038667, amount=1000, orderInfo=Thanh toa?n ve? xe b??ng momo, orderType=momo_wallet, transId=2721386950, resultCode=0, message=Successful., payType=qr, responseTime=1661521058968, extraData=, signature=5eb440b9db26faf6e55013e9dcc94378bc0eedfeae6e253772c60939665ecb09}
         */
        
        // Params
        int resultCode = Integer.parseInt(params.getOrDefault("resultCode", "1"));
        int orderId = Integer.parseInt(params.getOrDefault("orderId", null));
        String requestId = params.getOrDefault("requestId", null);
        String errMsg = "";

        // Pojo
        Ticket ticket = this.ticketRepository.getTicketById(orderId);
        User user = (User) session.getAttribute("currentUser");

        // handle momo payment success 
        if (resultCode == 0 && ticket != null) {
            // Set payment_status sang true
            ticket.setPaymentStatus(true);
            if (this.ticketRepository.updateTicket(ticket) == false) {
                errMsg = "Đã có lỗi xảy ra";
                model.addAttribute("errMsg", errMsg);
                return "redirect:/carts";
            }

            // Create receipt
            Receipt receipt = new Receipt();
            receipt.setAmount(ticket.getPrice());
            receipt.setMomoRequestId(requestId);
            receipt.setPaymentMethod(Receipt.MOMO);
            receipt.setTicketId(ticket);
            receipt.setUserId(user);

            if (this.receiptRepository.addReceipt(receipt) == false) {
                errMsg = "Đã có lỗi xảy ra";
                model.addAttribute("errMsg", errMsg);
                return "redirect:/carts";
            }
        }

        // handle momo payment fail 
        if (resultCode != 0) {
            errMsg = "Đã có lỗi xảy ra trong quá tình thanh toán qua momo";
            model.addAttribute("errMsg", errMsg);
            return "redirect:/carts";
        }

        return "redirect:/carts";
    }

}
