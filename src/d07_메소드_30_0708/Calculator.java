package d07_메소드_30_0708;
// 클래스의 목적은 
// 1. 실행 클래스 : main  함수 갖는 클래스
// 2. 객체설계 클래스 : 객체를 만들기 위한 객체 정의 클래스
public class Calculator {
    // 클래스 멤버( 객체 내 포함 )
    // 1. 멤버 변수 : 객체마다 할당
    // 2, 생성자 
    // 3, 메소드 : 하나의 메소드는 여러 객체들이 공유 JVM
    // 1) 매개변수는 없고 반환값은 있는 메소드
    boolean isPowerOn = false; // 전원 상태 멤버 변수


    double getPI(){
        // 리턴값이 더블이라 double
        // getPI : 메소드명, 카멜표기법, 숫자부터 시작 안됨
        // () 매개변수 자리 : 현재는 없음
        // return 옆에 값을 넣어준면 메소드를 호출했던 곳으로 리턴값을 반환
        return 3.14159;
    }// func end
    // 2) 매개변수 X, 반환값 X (void)
    void powerOn(){
        // 메소드가 실행될때 처리할 코드
        System.out.println( "전원을 킵니다." );
        // ★★★★★멤버 변수 : 해당 메소드를 호출한 객체의 멤버 변수!!★★★★
        isPowerOn  = true;
        // ★★★★★멤버 변수 : 해당 메소드를 호출한 객체의 멤버 변수!!★★★★

    }// func end
    // 3) 매개변수 O, 반환값 X (void)
    void printSum( int x , int y ){
        if (isPowerOn){
            int sum = x + y;
            System.out.println( sum );
        }else {
            System.out.println( "시스템이 꺼져 있습니다. " );
        }
    } // func end

    int add( int x, int y ){
        if (isPowerOn){
            int result = x + y;
            return result;
        }else {
            System.out.println( "전원이 꺼져있습니다." );
            return 0;
        }
    }


} // class end
