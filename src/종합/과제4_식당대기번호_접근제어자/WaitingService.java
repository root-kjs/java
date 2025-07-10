package 종합.과제4_식당대기번호_접근제어자;

import java.util.Scanner;

public class WaitingService {

    public static void main(String[] args) {

        
        for(;;){ // 1. 반복되는 끊임없는 입출력을 위한 무한루프 발동! 나가는 출구 없어요...;;
            
            // 2. 반복 출력화면 구현 
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("1.대기 등록 | 2.대기 현황");
            System.out.println("========================================");
            System.out.print("선택 > ");
            
            // 3. 사용자 메뉴 선택 입력값을 받아보자.. 외워질때가 된 것 같지만 멈칫멈칫하다...
            Scanner scan = new Scanner(System.in); // 입력함수 어서오고...
            int select = scan.nextInt(); // 메뉴 선택값은 숫자 정수로 받는다..내 맴...
            
            if( select == 1 ){ // 1.대기 등록 선택 : 사용자 입력값 숫자에 따른 메뉴 기능을 분기처리한댜!

                System.out.print( "전화번호 : " );
                String phone = scan.next(); // 1.1. 입력받은 전번 내마음에가 아닌 phone 변수에 잠시 즈장...

                System.out.print( "인원수 : " );
                int count = scan.nextInt();
                // 자 이제 입력값을 Waiting[]에 저장해보쥬앙!! 배열 저장 전에 Waiting 클래스 객체 저장이 먼저다!
                // 그런데 Waiting 멤버변수 보안 비공개  ㅜㅜ.. 하지만 setter 메소드가 있지롱!
                // 1.2. Waiting 일단 먼저 객체 생성! 매개변수 생성자를 활용하쟈!
                // Waiting waiting = new Waiting( phone, count ); // 과제3번 클래스 가져와서 한참 헤맸다..ㅜㅜ //
                // System.out.println( waiting );
                // 1.3 생성한 객체값을 세터 메소드 함수를 이용해 저장..
                // 아맞다...기능정의는 Controller 가져와서 해야지 여기서 하면 안돼...다시!!!
                // boolean 반환값이 있으니 변수에 담는다. 
                boolean result = WaitingController.addWaiting( phone, count );
                
                if( result ){
                    System.out.println( "[안내] 대기 등록 완료.\n" );
                } else {
                    System.out.println( "[안내] 대기 등록 실패.\n" );
                }

                
            } else if ( select == 2) { // 2.대기 현황 선택!

                // getWaitingList() 호출
                Waiting[] waitings = WaitingController.getWaitingList();
                ///Waiting waiting = new Waiting(); // null 이 나오네...

                for( int i = 0; i < waitings.length; i++ ) {

                    if( waitings[i] != null ) {
                        System.out.println("--------- 대기 현황 ---------");
                        System.out.printf("연락처 : %s - 인원 : %d \n",waitings[i].getPhone() ,waitings[i].getCount() );

                    }

                }

            } // if end

        } // 무한루프 안녕...잘가...고생했어...

    }// main end
} //class end
