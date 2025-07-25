package d20_43_0725;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class BookDto {

}

class BoardDto{

    @Override
    public String toString() {
        return "BoardDto{}";
    }
}

//

public class Exam1 {
    public static void main(String[] args) {

        // Object는 최상위 클래스로 모든 객체의 조상, 모든 타입을 상속, 다형성으로 다양한 타입 변환 가능하다.
        // 형제간의 타입 변환은 안됨.
        // 모든 자료를 대입(저장) 받을 수 있는 최상위 타입
        // 1. Object 주요 메소드
            // 1) .toString()    : 자료(객체)의 주소값(위치) 반환 함수
            // 2) .equals()      : 자료(객체) 자체를 비교하여 비교결과를 반환  vs == --> 자료(객체)의 주소 비교
            // 3) .hashCode()    : 자료(객체) 자체를 정수로 반환하는 함수  -> 객체를 식별하는 정수값, 객체를 빠르게 찾기 위해

        // 2. Class : 클래스의 정보를 담는 클래스
            // 특징 : 리플렉션 --> 실행 도중에 동적으로 객체의 구조(멤버변수, 생성자, 메소드) 를 분석하고 조작하는
            // -----> 실행 중 객체 할당,
            // 1) Class.forNsame()       -->  실행 중 클래스 로드 함수
            // 2) .getFields()           -->  지정한 인스턴스의 모든 멤버변수를 반환
            //    .getConstructors()     -->  지정한 인스턴스의 모든 생성자를 반환
            //    .getMethods()          -->  지정한 인스턴스의 모든 메소드를 반환

        /*
           3. Wrapper 클래스 : 8가지 기본 타입을 참조타입으로 사용하기 위해 사용
           - 특징 : 기본 타입은 메소드(기능)이 없어서, 해당 클래스를 사용하면 다양한 기능을 제공받는다.

           Integer
           Short
           Boolean
           Double
           Float
           Byte
           Long
           
           - 주요메소드
           parse(분석하다/변환하다)
           .parseXXXX("문자열"); ---> 문자열을 XXX 기본 타입으로 변환

           반대로 기본 타입을 문자열로 변환할 경우

           String.valueOf("100"); --> 자료를 문자열로 변환 (아주 중요!!!!)


           4. LocalDate 클래스 : 현재 시스템의 날짜/시간 반환한 클래스
            특징 : 날짜/ 시간 정의 및 형식을 변경하거나 세부 날짜 계산도 가능!
            주요 메소드 : now()

            1) LocalDateTime.now() // 현재 날짜와 시간 생성
            2) LocalDateTime.of() // 지정한 날짜/시간 객체 생성( 년, 월, 일, 시, 분, 초 )
            3) .getYear()  .getMonthValue() .getDayOfMonth()
            4) .plusDays()
               .getMinus()
            5) DateTimeFormatter
              DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd hh mm ss"); // 월은 대문자 MM
             String today = localDateTime.format( formatter );
             System.out.println( today );



         */

        Object o1 = 3;    // Object 클래스에 기본 타입 대입 가능.
        Object o2 = 3.14; // 실수를 Object로 분류할 수 있다.
        Object o3 = true; // 논리값을 Object로 분류할 수 있다.
        Object o4 = "유재석"; // 문자열을 Object로 분류할 수 있다.
        Object o5 = new Object(); // 논리값을 Object로 분류할 수 있다.
        Object o6 = new int[]{ 1, 2, 3 }; // 배열도 Object로 분류할 수 있다.

        // toString() --> 인스턴스/자료주소/메모리 위치(16진수 표현) 반환
        // d20_43_0725.BookDto@7cca494b
        Object o7 = new BookDto();
        System.out.println(o7.toString());  // 주소값

        //  toString() 오버라이딩 하여 문자열을 리턴값을 주면 BoardDto{}; 출력!
        Object o8 = new BoardDto();
        System.out.println(o8.toString());  // 주소값을 해당 문자열로 반환


        Object o9 = new BookDto();

        System.out.println( "A -->" + o9 ); // Ad20_43_0725.BookDto@3b9a45b3
        Object o10 = new BookDto();
        System.out.println( "B -->" + o10 ); // Bd20_43_0725.BookDto@568db2f2

        //   ==   --->  변수가 갖는 값/주소값(위치) 비교, 객체가 위치한 곳!
        // .equals ---> 주소안의 값(객체)을 비교
        System.out.println( o9 == o10 );     // false
        System.out.println( o9.equals(o10) ); // false
        Object o11= o9;
        System.out.println( o9 == o11 );     // true

        String str1 = new String("유재석");
        String str2 = new String("유재석");

        System.out.println( str1 == str2 );
        System.out.println( str1.equals(str2) );

        // 객체의 주소값을 정수로 반환
        //  .hashCode() :
        System.out.println( str1.hashCode()  ); // 객체 자체를 정수화  50621969
        System.out.println( str2.hashCode()  ); // 객체 자체를 정수화  50621969

        System.out.println( o9.hashCode()  );
        System.out.println( o10.hashCode()  );
        System.out.println( o11.hashCode()  );


        String str = new String();
        Class c = str.getClass();
        System.out.println(  c ); // class java.lang.String
        
        
        // Class.forName() --> 지정한 클래스 경로에서 클래스를 로드/ 불러오기 위한 메소드
        // Class --> 일반예외가 항상 발생되기 때문에 try -- catch

        int value = 3;
        Integer value1 = 3;
        Class c2 = value1.getClass(); // 클래스의 정보를 알려주는 메소드
        //value.getClass();
        //Integer 

        // 리플렉션은 프로그램 실행 중에 객체의 구조 (필드, 메소드, 생성자 등)를 분석하고 조작할 수 있는 기능입니다. 
        // 이를 통해 컴파일 시점에 알 수 없는 클래스나 객체에 대한 정보를 런타임에 동적으로 접근하고 조작할 수 있습니다. 
        // JDBC 드라이버도 new 로 객체 생성 안하고 리플렉션으로 자동 객체 생성!
        
        try {
            Class.forName("java.lang.String");
        }catch (ClassNotFoundException e ){
            System.out.println( e );
        }

        Field[] fields = c.getFields(); // 클래스 타입의 멤버 변수명 반환
        System.out.println( "왜? 왜??? " + fields  );

        for( int i = 0; i < fields.length; i++){
            System.out.println(fields[i] );
        }

        // 클래스의 생성자 정보 반환
        Constructor[] constructors = c.getConstructors();
        for( int i = 0; i < constructors.length; i++){
            System.out.println( "머냐고 " + constructors[i] );
        }
        // 스트링 타입의 모든 함수를 보여줌
        Method[] methods = c.getMethods();
        for( int i = 0; i < methods.length; i++){
            System.out.println( "????  " + methods[i] );
        }
        // 타입은 자료를 구분/분류하는 형식
        int value11 = 100;     // 자료는 100, 타입은 int
        Integer value22 = 100; // 자료는 100, 타입은 Integer

        // 1. 언박싱과 오토박싱   Integer  <--> int 왔다 갔다 할 수 있음
        Integer value33 = value11; // 오토박싱 : int --> Integer
        int value44 = value22;  // 언박싱 Integer --> int 가능!


        // ★★★★★★ 문자열을 기본 타입으로 변환 ★★★★★★★★★
        // http 웹은 문자열로 통신하기 때문에 문자열을 다양한 기본 타입으로 변경하는 것이 아주 중요하다!!!!
        // ★★★★★★   CSV도 아주 중요!!!!!!!! csv 다 문자열!
        
        
        Integer.parseInt("100"); // 문자열 100을 숫자 100으로 바꾸기
        // 자바는 다양한 언어와 통신을 하기 때문에 서로 다른 언어와의 형변환이 아주 중요!!!!
        // 문자열을 기본차입으로 형변환!
        double val2 = Double.parseDouble("3.14");
        float val3 = Float.parseFloat("3.14");
        byte val4 = Byte.parseByte("100");
        short val5 = Short.parseShort("100");
        long val6 = Long.parseLong("100");
        boolean val7 = Boolean.parseBoolean( "true" );


        // 기본타입 ===> 문자열 변환

        String s1 = 100+""; // 값과 문자열을 더하기 연산하면 문자열이 됨. 띄어쓰기 하지 마요
        String s2 = String.valueOf( 100 ); // 숫자가 문자열로 타입 변롼됨


        // 4. 현재 날짜와 시간 생성
        //now() --> static 함수
        LocalDate localDate = LocalDate.now();
        System.out.println( localDate ); // 2025-07-25

        LocalTime localTime = LocalTime.now();
        System.out.println( localTime ); // 11:36:59.643710900

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println( localDateTime ); // 2025-07-25T11:37:35.585379300



        // 2. 지정한 날짜/시간 객체 생성( 년, 월, 일, 시, 분, 초 )
        LocalDateTime d1 = LocalDateTime.of(2025, 07, 25, 11, 35, 10);
        System.out.println(d1); // 2025-07-25T11:35:10

        // 날짜/시간 형식 변경
        // 날자 시간 객체 .format( 형식 객체 ); // 지정한 형식으로 변환한 날짜 데이터 변환

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd hh mm ss"); // 월은 대문자 MM

        String today = localDateTime.format( formatter );
        System.out.println( today );

        // DB 를 사용한다면 나자 형식은 SQL 에서 하는 것을 추천!
        int year = localDateTime.getYear();
        int month = localDateTime.getMonthValue();
        int day = localDateTime.getDayOfMonth();
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        int seconds = localDateTime.getSecond();

        // 날짜 계산!
        LocalDateTime plusDateTime = localDateTime.plusDays( 10 );
        System.out.println( plusDateTime );
        LocalDateTime minusDateTime = localDateTime.minusDays(10 );
        System.out.println( minusDateTime );



    }// main end
}// class end
