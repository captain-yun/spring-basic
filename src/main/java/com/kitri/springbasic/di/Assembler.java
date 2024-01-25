package com.kitri.springbasic.di;

public class Assembler {

    private Greeting greeting;
    private AirlineService airlineService;
    private HotelService hotelService;

    public Assembler() {
        greeting = new EnglishGreeting();
        airlineService= new AirlineService(greeting);
        hotelService= new HotelService(greeting);
    }

    public Greeting getGreeting(){
        return greeting;
    }
    public AirlineService getAirlineService(){
        return airlineService;
    }
    public HotelService getHotelService(){
        return hotelService;
    }
}
