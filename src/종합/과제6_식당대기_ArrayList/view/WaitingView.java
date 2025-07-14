package 종합.과제6_식당대기_ArrayList.view;

import 종합.과제6_식당대기_ArrayList.controller.WaitingController;
import 종합.과제6_식당대기_ArrayList.model.dto.WaitingDto;

import java.util.ArrayList;
import java.util.Scanner;

// View ( 사용자 입/출력단)
public class WaitingView {

    // 0. 싱글톤 생성
    // WaitingView 클래스 싱글톤( waitingView ) 유일 인스턴스 생성
        private WaitingView(){} // 비공개 생성자
        private static final WaitingView waitingView = new WaitingView(); // 비공개 우선할당 수정불가 유일 WaitingView 클래스 인스턴스 생성
        public static WaitingView getInstance(){  //  WaitingView 클래스 인스턴스 호출 메소드 getInstance() // 리턴타입 :  WaitingView 클래스
            return waitingView;
        } // 싱글톤 end


    // 1. 멤버변수
    Scanner scan = new Scanner(System.in);
        // WaitingController 싱글톤 호출
        private WaitingController waitingController = WaitingController.getInstance();

    // 2. 생성자



    // 3. 메소드
        // 3.1. 공통 화면 : 화면 출력값이 있기 때문에 리턴타입이 없다.
        public void index(){

            for (;;) { //
                System.out.println("=========== 맛집 대기 시스템 ===========");
                System.out.println(" 1.대기 등록 | 2.대기 현황");
                System.out.println("========================================");
                System.out.print("선택 > ");
                int choose = scan.nextInt();
                if( choose == 1 ){
                    addWaiting();
                }else if ( choose == 2 ){
                    getWaitingList();
                }

            } // 무한루프 end



        } // index() end.

        // 3.2. 입력 화면(대기 등록) : 화면 출력값이 있기 때문에 리턴타입이 없다.
        // controller 리턴값  : boolean
        public void addWaiting(){

            System.out.print("전화번호 : ");
            String phone = scan.next();
            System.out.print("인원수 : ");
            int count = scan.nextInt();
            System.out.println("[안내] 대기 등록이 완료되었습니다.");
            boolean result = waitingController.addWaiting( phone,count );
            if( result == true ){
                System.out.println( "글쓰기 성공" );
            }else {
                System.out.println( "글쓰기 실패" );
            }


        } // addWaiting() end.


        // 3.2 출력화면(대기 전체조회)
        // controller 리턴값 --> ArrayList<WaitingDto>
        public void getWaitingList(){

            ArrayList<WaitingDto> result = waitingController.getWaitingList();

            for( int i = 0; i < result.size(); i++) {
                WaitingDto waiting = result.get(i);
                System.out.println("============= 대기 현황 =============");
                System.out.printf("연락처: %s - 인원 : %d 명\n", waiting.getPhone(), waiting.getCount());
                System.out.println("------------------------------------");
            }


        }// getWaitingList() end.


} // class end
