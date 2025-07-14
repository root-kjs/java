package d11_ArrayList_24_0714;

import java.util.ArrayList;

public class Exam1 {


    public static void main(String[] args) {
        /*
        [ 배열 ] : 고정길이, 메소드(기능) 없다.
        [ ArrayList ] :  자바 회사에서 제공하는 클래스(라이브러리), 다양한 메소드(기능) 제공
        1. 정의 : 컬랙션 프레임워크 중 리스트 자료형 클래스
        2. 목적 : 가변길이의 배열 지원함!
        3. 사용법
            1) 선언방법
               ArrayList< 항목타입 > 변수명 = new ArrayList<>();
               * < 제네릭 타입 > : 리스트에 저장할 항목/요소들의 타입
            2) 요소 추가 --> 변수명.add();
                변수명.add( "요소값" ); //  마지막 인덱스에 요소값 추가!
                변수명.add( 인덱스, "요소값" ); // 인덱스 중간에 요소값 추가 가능!
                인덱스란?? 저장번호 순서
            3) 요소 전체 출력/반환
                변수명 --> 전체 문자열 배열 출력
                변수명.size(); --> 전체 배열 길이 반환
                변수명.get( 인덱스 ); --> 해당 
            4) 요소 수정 ==> .set();
                변수명.set( 인덱스번호, "수정할 값" );
            5) 요소 삭제
                변수명.remove( 1 ); --> 해당 인덱스의 요소값 삭제
        4. 리스트와 반목문의 관계
        for( int i = 0; i < 리스트변수명.size(); i++ ){
            항목타입 변수명 = 리스트변수명.get(i);
        }
        for( 항목타입 반복되는변수명 : 리스트변수명  ){}
            반복되는 변수명
        */

        // 1) ArrayList 객체 생성하기
        ArrayList< String > 리스트객체 = new ArrayList<>(); // 자동완성해서 import 할 것!

        // 변수명
        System.out.println( 리스트객체 );
        System.out.println("리스트객체 = " + 리스트객체); // soutv
        
        // 2) .add(); 요소 추가하기
        리스트객체.add( "유재석" );
        

        리스트객체.add( "강호동" );
        리스트객체.add( "신동엽" ); // 마지막 배열 요소에 추가!!!
        System.out.println( 리스트객체 );
        
        // ! 중간에 요소 추가
        리스트객체.add(1, "박명수");  // 인덱스 순서에 요소 추가 가능!
        System.out.println( 리스트객체 );
        
        // .set(); 요소 수정하기
        리스트객체.set( 1, "김진숙" );
        System.out.println( 리스트객체 );  // .set( 인덱스번호, "수정할 요소값" ); 해당 인덱스 요소값 수정!!!

        // .size(); 리스트의 크기(길이) ==> length 확인하기
        System.out.println(  리스트객체.size() );

        // .get(); 리스트 객체 인덱스 요소값 반환
        System.out.println( 리스트객체.get(1) );  // 1번 인덱스의 요소값 반환
        
        
        // .remove();
        리스트객체.remove( 1 ); // 1번 인덱스 요소값 삭제
        System.out.println( 리스트객체 );

        // 리스트객체오 반복문의 관계
            // 일반 반복문
            for ( int i = 0; i < 리스트객체.size(); i++ ){
                String str = 리스트객체.get(i); // [i] 대신에 .get(i) 로 ArrayList 리스트객체 요소값을 순회하여 가져옴!!!!
                System.out.println( str );
            }

            // 향상된 for문 --> for( 항목타입 반복되는 벼누명 : 리스트명 )
            for (  String str : 리스트객체 ){
                System.out.println( str );
            }

            // Sting이 아닌 내가 만든 클래스 타입일 경우의 ArrayList

            // 3개의 멤버 객체 생성
            Member m1 = new Member("김진화", 20);
            Member m2 = new Member("김진숙", 10);
            Member m3 = new Member("김해수", 10);

            // < Member >타입 클래스를 저장할 ArrayList 객체 생성
            ArrayList< Member > memberList = new ArrayList<>();

            // 생성한 ArrayList에 객체들 저장
            memberList.add( m1 );
            memberList.add( m2 );
            memberList.add( m3 );
            
            // ArrayList리스트내 요소 하나씩 순회
            for( int i = 0; i < memberList.size(); i++ ){
                Member member = memberList.get(i);
                System.out.println( member.name );
                System.out.println( member.age );

            }


            //
            //ArrayList< Member > memberList = new ArrayList<>();





    } // main end



}// class end

class Member{
    // 1. 멤버 변수
    String name; // 이름
    int age;     // 나이

    // 2. 생성자
    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }
} //class end


