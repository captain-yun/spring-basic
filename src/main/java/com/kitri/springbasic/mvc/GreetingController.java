package com.kitri.springbasic.mvc;

import com.kitri.springbasic.di.AirlineService;
import com.kitri.springbasic.di.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Controller
public class GreetingController {
    @Autowired
    AirlineService airlineService;
    @Autowired
    HotelService hotelService;

    public GreetingController(AirlineService airlineService, HotelService hotelService) {
        this.airlineService = airlineService;
        this.hotelService = hotelService;
    }

    @GetMapping("/greeting")
    public String hello(Model model) {
        String welcomeMessage = airlineService.welcome();
        model.addAttribute("welcomeMessage", welcomeMessage);
        return "greeting";
    }
    @GetMapping("/greetingFromAirline")
    public String helloFromAirline(Model model) {
        String welcomeMessage = airlineService.welcome();
        model.addAttribute("welcomeMessage", welcomeMessage);
        return "greeting";
    }
    @GetMapping("/greetingFromHotel")
    public String helloFromHotel(Model model) {
        String welcomeMessage = hotelService.welcome();
        model.addAttribute("welcomeMessage", welcomeMessage);
        return "greeting";
    }
}
