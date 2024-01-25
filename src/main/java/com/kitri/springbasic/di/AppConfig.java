package com.kitri.springbasic.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Greeting greeting() {
        return new EnglishGreeting();
    }
    @Bean
    public AirlineService airlineService() {
        return new AirlineService(greeting());
    }
    @Bean
    public HotelService hotelService() {
        return new HotelService(greeting());
    }
}
