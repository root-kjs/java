package d02_입력함수_24_0630;

public class Exam3_연산자_equals {
    public static void main(String[] args) {

        // ★★ 끝나는 주석처리는 반그시 할 것! 기본적인 자세와 태도는 지킬 것! ★★★
        // 배움의 기본 자세를 지키자!
        // ★★★ 선생님께서 계속 강조하는 부분은 반드시 습관화 할 것! ★★★
/*
         [ 연산자 ]
         1. 산술 연산자 :  + , - , * , / , % (나머지)
         2. 연결 연산자 : 피연산자(자료)중에 문자열이 포함되면 연결처리
            --> "문자열" + 10, "문자열" + 변수명
         3. 비교 연산자 : 자바는 === "없다" --> 타입을 언제나 강력히 선언하기때문에 없음.
            --> 두 항을 비교한 결과를 boolean(논리값)으로 반환
            --> > 초과, < 미만, == 같다, != 같지 않다, >= 크거나 같다, <= 작거나 같다.
         4. 논리 연산자 --> && , ||   ,  ! --> 부정(반대로)
         5. 증감 연산자 : 
             ++변수명 --> 선위 증가 , 변수명++ --> 후위 증가
             --변수명 --> 선위 감소 , 변수명-- --> 후위 감소
         6. (복합)대입연산자
            =     --->  오른쪽 값을 왼쪽에 대입.
            +=    ----> 오른쪽 값을 왼쪽값에 대한 후 대입
            -=, %= , *= ---> 오른쪽 항의 값을 왼쪽 항에 연산 한 후 왼쪽에 대입
         7. 삼항 연산자
         조건 1 ? 참: 거짓
         조건 1 ? 참: 조건2 ? 참: 거짓

         
*/


        int x = 10;
        int y = -5;



        // 1) 연결 연산자 : 두항을 연결한 하나의 문자열을 반환.
        System.out.println( x + "개" ); // 10개 자바스크립트, 파이썬 공통!
        // 2) 산술 연산자 : 두 항을 연산한 하나의 숫자 결과를 반환.
        System.out.println( x + y );
        System.out.println( x - y );
        System.out.println( y - x );
        System.out.println( -y - x );
        System.out.println( -y / x ); // int 자료 타입이니까 소수점은 나오지 않음
        System.out.println( y / x );
        System.out.println( 10.0 / 3 ); // 자동 큰 타입으로 타입변환되어 double로 나옴
        System.out.println( 20.0 / x );
        System.out.println( 20.010 / x ); // 소수점 길게 나옴
        System.out.println( 20.0000000 / x ); // 0만 많으면 2.0 으로 나옴
        System.out.println( 20.1 / x ); // 소수점 아래 0 아닌 숫자 나오면 소수점 길게 나옴
        System.out.println( x > y );
        System.out.println( x == y );
        System.out.println( x != y );
        System.out.println( x <= y );
        System.out.println( x < y );
        System.out.println( -y % x ); // 나머지 :  5
        System.out.println( (y % -x) ); // 나머지 : -5
        System.out.println( y % x );  // 나머지 :  -5
        System.out.println( x  < 20 && x > 5 );
        System.out.println( !(x  < 20 && x > 5 ) );
        System.out.println( x == 0 && y == 0 );
//        System.out.println( x++ ); // 출력 후 1 증가 :  출력 값 10
//        System.out.println( ++x ); // 1 증가 후 :  출력 값 12
        System.out.println( ++x ); // 1 증가 후 :  출력 값 11
        System.out.println( x++ ); // 출력 후 1 증가 :  출력 값 11
        System.out.println( x++ ); // 출력 후 1 증가 :  출력 값 12
        System.out.println( ++x );  // 1 증가 후 :  출력 값 14

        int z = 10;
        int t = 20;
        System.out.println( z += t );  // 30

        System.out.println(  x >= 60 ? "합격" : "불합격"  );
        // 삼항 연산자 : 조건1 ? 참 : 거짓  , 조건2 > 참 : 조건3 ? 참 : 거짓
        // 삼항 연산자에서 2개의 조건을 비교할때 첫번째 조건에서 거짓은 제외
        System.out.println(  x >= 60 ? "합격" :  x >= 1000 ? "잘했어요~!" : "공부하세요!"  );
        
        // 8. 문자열 비교는 "문자열".equals("10");
        System.out.println( "김진숙".equals("김진숟") );
        System.out.println( "김진숙".equals("김진숙") );
        // 아래도 되지만, 문자열 비교는 "문자열".equals("10"); 할 것 ! 자바 스크립트와 다름!
        System.out.println( "김진숙" == "김진숙" ); 
        

        







    } // main end
} // class end
