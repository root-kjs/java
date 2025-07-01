package d02_입력함수_24_0630;

import java.util.Scanner;

public class Exam2_입력함수_Scanner_nextLine {
    public static void main(String[] args) {

        // 입력함수 : 콘솔화면에서 키보드로부터 입력받는 방법
        // 1. new Scanner( System.in ); --> 시스템(컴)으로 입력관련 기능(함수)를 제공하는 객체

        // 1) Scanner 객체로부터 .next() 함수 호출
        // new Scanner( System.in ).next();
        // .next();  -->  띄어쓰기 불가능. 문자열 반환

        // 2) 스캐너 객체를 계속 호출하지 않고 변수에 담아서 활용.  타입 변수명 = 자료;
        // 자바는 자료형(타입)을 반드시 명시해야 한다.

        Scanner scan = new Scanner( System.in );
        // Scanner (객체 타입) scan (변수명) = (대임) new Scanner( System.in ) (객체)
        // .next(); --> 입력받은 문자열을 string으로 반환! 띄어쓰기 불가능. 문자열 반환
        // .nextLine();  ->> 띄어쓰기 가능!
        // 엔터 기준으로 입력이 됨.
        System.out.println( " 1. next() 아무거나 입력하세요 (띄어쓰기 앞의 문자열만 출력해줌 문자열 앞의 띄어쓰기는 무시 문자열 다음 띄어쓰기 ):" );
        String str1 = scan.next();
        System.out.println( " 1. next() 입력값 :" + str1 );

        scan.nextLine();

        //scan.nextLine();
        System.out.println( " 2. nextline() 아무거나 입력하세요 (띄어쓰기 문자열 모두 나옴.):" );
        String str2 = scan.nextLine();
        System.out.println( " 2. nextline() 입력값 :" + str2 );

        // 주의점 : nextline();  앞에 다른 .next()가 존재하면 문제 발생.
        // 엔터는 완료! 엔터는 개행. -- > 위에서 엔터 친 것을 적용하여 문제 발생
        // 해결방안 : nextline() 앞에 무의미한 next() 추가??? 뭔말이야

        // scan.nextByte(); // 입력받은 값을 byte로 변환
        System.out.println( " 3. nextByte() 아무거나 입력하세요:" );
        byte byte1 = scan.nextByte( );
        System.out.println( " 3. nextByte() 입력값 :"+ byte1);

        // 8.double
        System.out.println( "8. nextDouble() : " );
        double dv6 = scan.nextDouble();
        System.out.println( "8. nextDouble() : " + dv6 );


        // 9. nextBoolean();
        // 9. nextBoolean();
        System.out.println( "9.nextBoolean() :" );
        boolean b10 = scan.nextBoolean();
        System.out.println( "9.nextBoolean() :" + b10 );

        // nextChar() --> 없음!  scan.next().charAt( 0 );
        // scan.next().charAt( 0 ); 첫번째 글자를 반환하겠다!
        // 입력받은 문자열 중에 첫글자 1개만 반환, 무조건 1, 0번째 인덱스!
        // 키보도로 입력받은 값을 자료타입에 맞는 허용받은 범위내에서 출력해줌.

        System.out.println( "10.scan.next().charAt( 0 ) 아무거나 입력하세요:" );
        char cv1 = scan.next().charAt( 0 );
        System.out.println( "10.scan.next().charAt( 0 )" + cv1 );


    } // main end
} // class end
