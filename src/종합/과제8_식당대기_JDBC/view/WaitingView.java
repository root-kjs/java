package 종합.과제8_식당대기_JDBC.view;

import 종합.과제8_식당대기_JDBC.controller.WaitingController;
import 종합.과제8_식당대기_JDBC.model.dto.WaitingDto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WaitingView {
    // 0. 싱글톤 생성
    private WaitingView(){}
    private static final WaitingView instance = new WaitingView();
    public static WaitingView getInstance(){ return instance; }

    // 0. 싱글톤 호출( controller )
    private WaitingController wc = WaitingController.getInstance();

    Scanner scan = new Scanner(System.in);

    // 0. 공통화면
    public void index(){
        try {
            for(;;){
                System.out.println("=========== 맛집 대기 시스템 =============");
                System.out.println("1.대기등록  2.대기현황  3.특정 대기취소  4.특정 대기수정");
                System.out.println("========================================");
                System.out.print("메뉴 선택 > ");
                int choose = scan.nextInt();
                if( choose == 1 ) waitingAdd();
                else if( choose == 2 ) waitingList();
                else if( choose == 3 ) waitingCancle();
                else if( choose == 4 ) waitingEdit();
                else System.out.println("[경고] 올바른 메뉴번호 숫자를 입력하세요!");
            }// for end
        }catch ( InputMismatchException e ){
            System.out.println("[경고] 입력 타입 불일치! <메뉴: 숫자다시입력>");
            scan = new Scanner( System.in );
        }catch ( Exception e ){
            System.out.println("[오류] 관리자 문의(000-0000)" + e );
        }// catch end
    }// func end

    // ---------------------------- WaitingView 단위기능 ---------------------------- //

    // (1) 대기등록
    public void waitingAdd(){
        System.out.println("---- 대기등록 ----");
        System.out.print("연락처: ");
        String wphone = scan.next();
        System.out.print("인원수: ");
        int wcount = scan.nextInt();
        
        // 사용자에게 입력된 값을 매개변수로 Controller에게 전달하고, 리턴값을 받아 실행성공여부 출력!
        boolean result = wc.waitingAdd( wphone,wcount );
        if( result ) System.out.println( "대기등록 성공!");
        else System.out.println( "대기등록 실패");
    }// func end


    // (2) 대기현황
    public void waitingList(){
        System.out.println("---- 대기현황 ----");
        // controller에게 받은 리턴값을 ArrayList<WaitingDto> 배열순회하여 속성값 출력!
        ArrayList<WaitingDto> result = wc.waitingList();
        System.out.println("대기번호\t 연락처\t 대기인원 ");
        if( result != null ) {
            for (WaitingDto dto : result) {
                System.out.printf("%d\t %s\t %d \n ", dto.getWno(), dto.getWphone(), dto.getWcount());
            }// for end
        }else{ System.out.println(" 대기자가 없습니다. "); }
    }// func end


    // (3) 특정 대기취소(삭제)
    // (3) 특정 대기취소(삭제)
    public void waitingCancle(){
        System.out.println("---- 특정 대기취소 ----");
        System.out.print("대기번호 입력: ");
        int wcount = scan.nextInt();
        // 사용자에게 입력받은 대기번호(매개변수)를 Controller에게 전달하고, 반환받은 리턴값으로 화면 출력!
        boolean result = wc.waitingCancle( wcount );
        try {
            if( result ) System.out.println(" 대기취소 성공!");
            else System.out.println(" 대기취소 실패! ");
        }catch ( InputMismatchException e ){
            System.out.println("[경고] 대기번호(숫자)를 입력하세요." + e );
        }// catch end
    }// func end


    // (4) 특정 대기수정
    public void waitingEdit(){
        System.out.println("---- 특정 대기수정 ----");
        System.out.print(" 수정할 대기번호 입력: ");
        int wno = scan.nextInt();
        System.out.print(" 대기인원 수정: ");
        int wcount = scan.nextInt();

        // 사용자에게 입력받은 매개변수를 Controller에게 전달하고, 반환받은 리턴값으로 화면 출력!
        boolean result = wc.waitingEdit( wno, wcount );
        try {
            if( result ) System.out.println(" 대기수정 성공!");
            else System.out.println(" 대기수정 실패! ");
        }catch ( InputMismatchException e ){
            System.out.println("[경고] 대기번호,인원을 숫자로 입력하세요." + e );
        }// catch end
    }// func end

}// class end
