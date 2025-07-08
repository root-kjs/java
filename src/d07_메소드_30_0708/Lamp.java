package d07_메소드_30_0708;

public class Lamp {
    ////[문제 5] Lamp 클래스를 만드세요. isOn (boolean) 멤버 변수를 가집니다.
    //// 1. turnOn 메소드를 호출하면 isOn이 true가 되고, turnOff 메소드를 호출하면 false가 되도록 두 메소드를 정의하세요.
    ////2. main 함수에서 Lamp 객체를 생성하고, turnOn과 turnOff를 차례로 호출하며 각 단계에서 램프의 상태(isOn 값)를 출력하여 확인하세요.
    boolean isOn;
    void turnOn( ){
        isOn = true;
        System.out.println( isOn );

    }
    void turnOff( ){
        isOn = false;
        System.out.println( isOn );
    }

} // class end
