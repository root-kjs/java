package d09_접근제한자_32_0710;

import d08_생성자_31_0709.Pet;
import d08_생성자_31_0709.실습9_생성자;
import d09_접근제한자_32_0710.pk1.A;

public class Exam2 {

    static class D{

        //final int 최종변수;  --> 에러남, 초긱값이 없으니..
        final int 최종변수 = 10;
        static int 비멤버공유변수; //공유변수, 비멤버변수, 정적변\수 개체 내 포함(소속)되지 않나도 사용가능한 변수 --> 조커인가
        // ....
        // 프로그램이 실행될때 만들어짐, 비멤버 전역변수

        public static final int 상수 = 100; // 상수 선언! 프로그램  내

        void 멤버메소드1(){}
        static void 비멤버메소드1(){}
        void 멤버메소드2(){
            멤버메소드1();
            비멤버메소드1();
        }

    } // class end


    void 멤버메소드(){ // static 아닌 메소드

    }
    static void 비멤버메소드(){// static 메소드
        
    }


    public static void main(String[] args) {
        
 /*
    [ final ]
        1. 수정 불가능한 고정상태를 정의할 때 사용되는 키워드
        2. 사용법
            - final  타입 멤버변수
            - 주의!!! 초기값이 꼭 있어야 한다. 수정 안하니 무조건 반드시 초기값이 있어야 함!!!


    [ static ] *정적인/변화가 없는
        1. 실행중에 변화가 없는 상태를 정의할 때 사용되는 키워드
        2. 프로젝트 컴파일 될 때(프로그램 실행될때) 메모리에 할당되는 키워드!!!
         - 프로그램이 
        
        3. 정적 변수 static 변수
        4. 주의점 : 멤버는 소속이 있어야 함. 
            - 멤버 변수는
            객체 내 변수가 아니라는 말
            - 우선 할당! static
            - 프로그램 내 딱 1개만 존재하는 변수를 선언할 때 사용!
            - 서로다른 객체들이 공유해서 사용한다.. 객체들은 서로 다른 멤버변수를 가졌지만@!

        [ 상수 ] --> 변하지 않는 변수
            1. 사용법 : 자바에서는 public static final 타입 상수명;
            - 프로그램 내 1개만 존재하고 수정 불가능 대문자로만 사용한다!!!@@@@@

        [ static 유무 중요한 이유 ]
        - static 으로 선언된 메소드는 같은 클래스 내 메소드를 호출 할 수 없다.
        - 실체는 메모리 할당!!!
        -
  */


        D d = new D();
        System.out.println( d.최종변수 );
       //d.최종변수 = 15; --> 수정 안됨 에러남
        System.out.println(   D.비멤버공유변수 );
        D.비멤버공유변수 = 20;
        System.out.println(   D.비멤버공유변수 );

        System.out.println( D.상수 );
        System.out.println( A.상수2 );
       System.out.println( 실습9_생성자.상수3 );
        System.out.println( Pet.상수4 ); // 다른 패키지에 있는 아이 가져오려면 임포트ㅎㅎㅎ 좋아좋아!
        
       //멤버메소드(); // 그냥 가져오면 에러남. static이 먼저 할당되고 메모리 할당이 되지 않아서 객체를 생성하여 가져와야 한다.
        // static은 new 연산자랑 상관없이 메모리 우선 할당되어 전역변수라고 생각할 것!!!
       // 비멤버메소드();


        // static 이 아닌



        
    } // main end

    
} // class end
