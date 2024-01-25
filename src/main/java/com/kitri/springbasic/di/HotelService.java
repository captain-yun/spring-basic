package com.kitri.springbasic.di;

import org.springframework.beans.factory.annotation.Autowired;

public class HotelService {

    Greeting greeting;

    public HotelService(Greeting greeting) {
        this.greeting = greeting;
    }

    String welcome() {
        return greeting.helloFromHotel();
    }
}