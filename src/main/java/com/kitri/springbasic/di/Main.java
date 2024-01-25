package com.kitri.springbasic.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


public class Main {
    AirlineService airlineService;
    HotelService hotelService;
    public static void main(String[] args) {
        // 스프링 컨테이너 생성 및 설정파일을 통한 빈 객체 초기화
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        AirlineService airlineService =
                context.getBean("airlineService", AirlineService.class);
        HotelService hotelService =
                context.getBean("hotelService", HotelService.class);
        System.out.println(hotelService.welcome());
        System.out.println(airlineService.welcome());
    }
}

