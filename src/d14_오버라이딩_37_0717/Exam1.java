package d14_오버라이딩_37_0717;


class  상위클래스{
    // 1. 멤버 변수
    int value1 = 10;
    int value2 = 20;

    // 2. 생성자
    public 상위클래스() {
        System.out.println("1. 상위 클래스 인스턴스 생성");
    }

    //3. 메소드
    void showValue1(){
        System.out.println(">> 1. 상위 클래스 메소드 실행 ------------ 1");
    }
} // class end

class 하위클래스 extends 상위클래스{
    // 1. 멤버 변수
    int value3 = 30; 
    int value2 = 40;
    
    //2. 생성자
    하위클래스(){
        System.out.println("2. 하위클래스 인스턴스 생성");
    }
    
    // 3. 메소드
    void showValue2(){
        System.out.println( ">> 2. 하위 클래스 메소드 실행 ------------ 2" );
    }
    void showValue1(){
        System.out.println( ">> 3. 하위 클래스 메소드2 실행 ----------- 3" );
    }
    
}// class end

public class Exam1 {

    public static void main(String[] args) {

         // 1. 상위 클래스 인스턴스 생성
         상위클래스 obj1 = new 상위클래스();
         obj1.showValue1();
         // obj1.showValue2(); 에러남!!!

        // 1. 상위 클래스 인스턴스 생성
        하위클래스 obj2 = new 하위클래스();
        obj2.showValue1(); // 하위 클래스는 상위클래스 메소드 사용가능!!!
        obj2.showValue2();


        System.out.println( obj2.value1 );
        System.out.println( obj2.value2 ); // 동일한 멤버변수 일때는 현재타입의 값이 우선!
        System.out.println( obj2.value3 );

        상위클래스 obj3 = obj2; // 하위 클래스가 상위클래스로 자동 타입변환 할 경우
        // 멤버 변수는 객체마다 다르게 할당되어 재정의/ 오버라이딩을 할 필요가 없음!

        System.out.println( obj3.value2 ); // 상위 클래스 타입의 멤버변수 값을 가져온다!

        // 메소드명이 동일할때는 어떻게 구분?
        // 오버라이딩(자식 타입이 우선!!!!!!!!!) : 부모가 물려준 메소드를 재정의한다!
        // 메소드는 공유하기 때문에 다른 기능을 추가하고 싶을때는 추가 정의 가능하다!
        obj3.showValue1(); // 태생이 하위클래스라 하위클래스 메소드가 실행된다.
        obj2.showValue1();
        obj2.showValue2();
        obj1.showValue1();

        상위클래스 obj4 = obj2;
        obj4.showValue1();
        //obj4.showValue2(); // 타입이 변경이 되어도 메소드는 최초 타입의 메소드가 실행된다.(단 메소드명이 같아야 함!!!!!)
        System.out.println( obj4.value2 ); // 타입이 변경되면 멤버변수는 변경된 타입의 멤버변수값을 따라간다.





    }// main end
}// class end
