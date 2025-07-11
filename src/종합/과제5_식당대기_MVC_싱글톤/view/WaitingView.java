package 종합.과제5_식당대기_MVC_싱글톤.view;

import 종합.과제4_식당대기번호_접근제어자.Waiting;

import java.util.Scanner;

// View : 서비스 화면 입출력 담당 역할

public class WaitingView {

//### 01. 멤버 변수
    // 1. 공통 초기화면 구현 : 실행은 AppStart에서 담당하니 메소드로 정의하여 AppStart 호출할 것!
    // 2, 메모리 절약, 전역 상태 관리, 리소스 공유, 중복 인스턴스 생성 방지, 단일 접근 지점 설정 등을 위해 유일한 객체 싱글톤으로 구현
            // 싱글톤 : 객체의 인스턴스를 한개만 생성되게 하는 패턴
            // 로그 관리자, 환경 설정 관리자
            // 싱글톤 패턴은 전역 상태를 가지므로, 테스트 및 디버깅이 어려움. 또한, 멀티스레드 환경에서 동기화 문제가 발생할 수 있으므로 주의
    
    // 3, WaitingView 싱글톤 객체 생성 ( 3단계 )
        //--> 1)생성자(private)  2) 싱글톤 객체 생성(private static final 타입 ) 3) 메소드(public static 타입 getInstance())

//### 02. 생성자

        // 1단계) 비공개 생성자 선언 : 외부 클래스 선언 안되요.
        private WaitingView(){}
        // 2단계) 비공개 우선할당(공유/정적변수) 상수 타입(클래스) 싱글톤(객체 유일 인스턴스) 생성하여 변수 저장. 인스턴스 하나만 사용할 거얌
        private static final WaitingView waitingView = new WaitingView();
        // 3단계) 공개 우선할당(공유/정적변수) 타입(클래스) getInstance() : 싱글톤 호출 메소드 정의
        public static WaitingView getInstance(){ // getInstance() --> 메소드는 싱글톤에서 유일하게 외부에서 객체를 얻는 메소드.
            return  waitingView;  // 반환값 : 타입(클래스)의 인스턴스
        }

//### 03. 메소드
      
    // 4.초기 공통화면 출력  index() : 프로그램(서비스 페이지 = index) 공통화면 출력 메소드
        // public : 모든 클래스에서 접근 가능한 메소드
        // 매개변수 : 없음
        // 반환값 : 없음
    public void index(){

        for(;;) { //
            System.out.println("===== 맛집 대기 시스템 =====");
            System.out.println("1.대기 등록 | 2.대기 현황");
            System.out.println("===========================");
            System.out.print("선택 > ");

        }// 무한루프 end
    } // index() end

    // 분기로 나누어지는 화면은 별도의 메소드(로직)으로 처리하여 공통 화면으로 호출.
    // 5. 식당대기 등록(사용자단 입/출력)
    public void waitingPost(){

        System.out.println( "===== 맛집 대기 시스템 =====" );
        System.out.println( "1.대기 등록 | 2.대기 현황" );
        System.out.println( "===========================" );
        System.out.print( "선택 > " );

//        Scanner scan
//
//        전화번호 : 010-1234-5678
//        인원수 : 2
//                [안내] 대기 등록이 완료되었습니다.





    } // index() end

} //class end
