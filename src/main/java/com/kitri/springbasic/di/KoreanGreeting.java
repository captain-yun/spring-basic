package com.kitri.springbasic.di;

public class KoreanGreeting implements Greeting {
    @Override
    public String helloFromHotel() {
        return "환영합니다 고객님! 예약자분 성함을 알려주시겠습니까?";
    }

    @Override
    public String helloFromAirline() {
        return "환영합니다 탑승객 여러분 여기는 코리안 에어라인입니다!";
    }
}