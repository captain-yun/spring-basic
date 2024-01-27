package com.kitri.springbasic.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;


public class Main {

    AirlineService airlineService;
    HotelService hotelService;
    public static void main(String[] args) {
        // 스프링 컨테이너 생성 및 설정파일을 통한 빈 객체 초기화
        // (1) 자바 클래스를 통한 설정
//        AnnotationConfigApplicationContext context
//                = new AnnotationConfigApplicationContext(AppConfig.class);
//        AirlineService airlineService =
//                context.getBean("airlineService", AirlineService.class);
//        HotelService hotelService =
//                context.getBean("hotelService", HotelService.class);
        
        // (2) XML을 통한 설정
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/application.xml");
        AirlineService airlineService =
                context.getBean("airlineService", AirlineService.class);
        HotelService hotelService =
                context.getBean("hotelService", HotelService.class);

        System.out.println(airlineService.welcome());
        System.out.println(hotelService.welcome());
    }
}

