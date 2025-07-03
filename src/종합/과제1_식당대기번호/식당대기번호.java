package 종합.과제1_식당대기번호;

import java.util.Scanner;

//[JAVA] 종합과제1 : 식당 대기번호 프로그램 (변수 활용) 250703(목)
//[ 목표 ] Scanner, for(;;), if 문과 변수를 활용하여, 최대 3팀의 대기 명단을 관리할 수 있는 간단한 식당 대기번호 발행 프로그램을 구현합니다.
public class 식당대기번호 {
    public static void main(String[] args) {


        // 0. 대기 명단 저장 공간 만들기 --> 메모리 설계(전역/지역변수)
        String phone1 = null; int count1 = 0;
        String phone2 = null; int count2 = 0;
        String phone3 = null; int count3 = 0;

        //1. 반복 화면 출력 영역 출력
        for(;;){
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("1.대기 등록 | 2.대기 현황");
            System.out.println("========================================");
            System.out.print("선택 > ");
            Scanner scan = new Scanner( System.in );
            int select = scan.nextInt();

            //2. 사용자 기능 선택에 따른 다른 화면 출력
            if( select == 1 ){ // 1.대기 등록 입력시
                System.out.print("전화번호 : "); String phone = scan.next();
                System.out.print("인원수 : ");   int count = scan.nextInt();
                //3. 조건에 맞는 화면 기능 분할 ---> 상세 기능 구현
                if( phone1 == null ){
                    phone1 = phone;
                    count1 = count;
                    System.out.println("[안내] 대기 등록이 완료되었습니다.");
                }else if( phone2 == null ){
                    phone2 = phone;
                    count2 = count;
                    System.out.println("[안내] 대기 등록이 완료되었습니다.");
                }else if( phone3 == null ){
                    phone3 = phone;
                    count3 = count;
                    System.out.println("[안내] 대기 등록이 완료되었습니다.");
                }else{
                    System.out.println("[경고] 더 이상 대기 등록을 할 수 없습니다.");
                }
            }else if( select == 2 ){  // 2.대기 현황 입력시
                //3. 조건에 맞는 화면 기능 분할 ---> 상세 기능 구현
                if( phone1 != null ){
                    System.out.printf("1. 연락처 : %s - 인원 : %d명\n", phone1, count1);
                    System.out.println("-------------------------------");
                }
                if( phone2 != null ){
                    System.out.printf("1. 연락처 : %s - 인원 : %d명\n", phone2, count2);
                    System.out.println("-------------------------------");
                }
                if( phone3 != null ){
                    System.out.printf("1. 연락처 : %s - 인원 : %d명\n", phone3, count3);
                    System.out.println("-------------------------------");
                }
            } // if end  1.대기 등록 | 2.대기 현황 선택시

        } // 무한반복 for end
    } // main end
} // class end
