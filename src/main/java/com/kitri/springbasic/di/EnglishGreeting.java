package com.kitri.springbasic.di;

public class EnglishGreeting implements Greeting {
    @Override
    public String helloFromHotel() {
        return "Hello, may I check your reservation?";
    }

    @Override
    public String helloFromAirline() {
        return "Welcome! Ladies and Gentlemen, this is Delta airline!";
    }
}
