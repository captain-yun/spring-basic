package com.kitri.springbasic.di;

import org.springframework.beans.factory.annotation.Autowired;

public class AirlineService {

    Greeting greeting;

    public AirlineService(Greeting greeting) {
        this.greeting = greeting;
    }

    public String welcome() {
        return greeting.helloFromAirline();
    }
}
