package d02_입력함수_24_0630;

public class Exam1_강제타입변환 {
    public static void main(String[] args) {

        // 변수의 타입변환 --> 캐스팅
        // 한 타입의 객체 참조를 다른 타입의 객체 참조로 변환하는 과정을 말합니다.
        // 특히 객체지향 프로그래밍에서 상속 관계에 있는 클래스들 사이에서 이루어지는 캐스팅은 중요한 개념
        // 1. 자동 타입 변환  --> 묵시적
            // byte --> short/char --> int ---> long ---> float --> double

        byte byteValue = 10;
        short shortValue = byteValue;  // byte ---> short 변환 가능! 작은 것에서 큰 것으로,
        // 데이터 손실이 거의 없다! 플롯은 손실이 생길 수 있음
        int intValue = shortValue;
        long longValue = intValue;
        float floatValue = longValue;
        double doubleValue = floatValue; // 10  나옴
        // 자료는 그대로 이지만 자료형은 다름!( 타입은 값의 분류/종류 ) --> 타입과 자료는 성격이 다르다.
        // java는 다형성 : 하나의 자료가 여러개의 타입을 가질 수 있다!!! 엄청 중요! 상속!!!!!!!!!!
        // 하나의 자료가 다양한 형식, 종류, 타입을 가질 수 있다! 자료는 그대로 지만 형식은 바뀔 수 있다!!!! 중요!!!!
        // 변수 타입이 바뀔 수 있다!!! 상속! 인터페이스 개념!!!!


        // 2, 강제 타입 변환 --> 명시적
            // double --> float --> long --> int -->
            // 메모리 크기가 큰 것에서 작은 것으로 변환 가능!
            // 데이터의 손실이 크다.
            // (변환할 타입명)변수명

        double dvalue = 3.14;
        // float fvalue = dvalue; 형변환 안됨! // 명시적 강제 타입변환 가능!!!
        float fvalue = (float) dvalue;

        long lvalue = (long)fvalue; // 데이터 손실 발생! --> long은 정수라 실수단위 데이터가 없어짐! 3.14 --> 3
        int ivalue = (int)lvalue;
        short svalue = (short) ivalue;
        byte bvalue = (byte)svalue; //   자료형 변수 = (타입)변수명; --> 강제 형변환! 문법!

        System.out.println( bvalue );

        // 3, 연산 타입변환
        byte b1 = 10;
        byte b2 = 20;
        short s1 = 30;
        int i1 = 50;
        long l1 = 100;
        float f1 =3;  // 정수로 표현 가능 하지만 출력은 3.0
        double d1 = 5;

        // int 이하의 타입 연산결과는 int 이다.
        // int가 가장 큰 타입이니까 연산결과는 int 자동 타입 변환!
        System.out.println( i1 + s1 );

        // int + long ==> long으 로 연산결과가 나옴 -->
        // 두개의 항 중에 더 튼 항으로 자동 타입 변환되어 long 이 나옴!
        System.out.println( l1 + i1 );




    } // main end
} // class end
