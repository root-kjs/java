package d01_0627; // 현재 .java 파일이 위치한 폴더명

public class Example3 { // class start : 모든 자바코드는 클래스안에 작성한다.
    public static void main(String[] args) {
        /*
        [ 출력함수 ]
        System : 시스템 관련 기능 제공하는 클래스
        out :  출력 관련 객체를 반환하는 변수
        1) System.out.print();
        2) System.out.println();  : 출력 후 줄바꿈 함수
        3) System.out.printf(); : f(format) 형식에 맞게 출력 함순
           printf(); 형식 --> %s : 문자열     / %c : char   / %d : 정수    / %f : 실수
           자릿수 있음(자릿수 맞춤) :
           %자릿수d : 자릿수 만큼 자리수 차지, 비어 있으면 공백, 기본 오른쪽 자리 정렬
           %자릿수-d : 자릿수만큼 차지\하고 왼쪽 정렬
           %자릿수0d : ...

           
         */
        System.out.println( "자바안녕" ); // 줄바꿈 처리하여 출력!
        System.out.println( "자바안녕2" );

        System.out.print( "자바안녕3" ); // 그냥 자료 출력
        System.out.print( "자바안녕4" );

        System.out.printf( "%s" , "자바안녕5" );
        
        String name = "유재석"; // String(문자열타입) name(변수명) = (대입) "유재석"(자료) ; (명령마침) 무조건 넣어야 함
        int age = 40;  // 정수

        System.out.printf( "저는 %s 이고 나이는 %d 입니다 ", name , age);
        
        // prinf("형식 자리 %s, %d, %c, %f" , 값1(변수), 값2(변수) );
        // vs + 연결 연산자 사용!
        System.out.println(  "저는" + name + "이고 나이는 " + age + " 입니다. "  );
        System.out.printf( " 저는 %s이고 나이는 %2d 입니다. \n" , name, 555555555 ); // %6d : 6은 숫자가 아닌 6자리수 안에 정수를 표시! 숫자가 넘치면 그냥 다 표시 자료형 크기 만큼!
        System.out.printf( " 저는 %s이고 나이는 %-6d 입니다. \n" , name, age );  // %-6d : 6자리수 안에 정수를 표혐학고 왼쪽 정렬!
        System.out.printf( " 저는 %s이고 나이는 %03d 입니다. \n" , name, 555555555 );  // %06d : 6자리 수안에 정수를 표현하고 빈칸은 0으로 채움!
        System.out.printf( " 저는 %s이고 나이는 %5.2f 입니다. \n" , name, 1.554466 ); // %5.2f : 5자리수 칸안에 소수점 자리는 2개 나오게
        
        // 이스케이프 문자: 제어문자 -> 특수기호에 기능이 표현된 문자 , 제어문자
        System.out.println( "안녕1\n안녕2" ); // \n 줄바꿈 처리
        System.out.println( "안녕1\t안녕2" ); // \t 들여쓰기 처리
        System.out.println( "안녕1\'안녕2\'" ); // \' 작은 따옴표 출력!
        System.out.println( "안녕1     \"안녕2\"" ); // \" 큰 따옴표 출력!
        System.out.println( "    안녕1     \\안녕2\\\\\\" ); // \\ 백슬러시 출력!



    } // main end
} // class end

