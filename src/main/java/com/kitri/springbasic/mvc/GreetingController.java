package com.kitri.springbasic;

import com.kitri.springbasic.di.AirlineService;
import com.kitri.springbasic.di.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/greeting")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(airlineService.welcome());
    }
}
