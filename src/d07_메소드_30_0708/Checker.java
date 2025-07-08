package d07_메소드_30_0708;

public class Checker {
    //[문제 4] Checker 클래스를 만드세요.
//1. 정수 하나를 매개변수로 받아, 그 수가 짝수이면 true, 홀수이면 false를 반환하는 isEven 메소드를 정의하세요.
//2. main 함수에서 isEven 메소드를 호출하고, 반환된 값에 따라 "짝수입니다." 또는 "홀수입니다."를 출력하세요.
    boolean isEven( int x ){
        if( x % 2 == 0 ){
//            boolean result = true;
//            return result;
            return true; // 메소드의 타입과 반환값의 타입이 매칭이 되어야 한다.
        } else {
//            boolean result = false;
//            return result;
            return true;
        }

    } //func end
} // class end
