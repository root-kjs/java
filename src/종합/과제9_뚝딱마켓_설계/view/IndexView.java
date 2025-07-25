package 종합.과제9_뚝딱마켓_설계.view;
// [공통] 메인 통합 View(프론트단) 화면구현

import java.util.InputMismatchException;
import java.util.Scanner;

public class IndexView {
    // * 싱글톤 생성
    private IndexView(){}
    private static final IndexView instance = new IndexView();
    public static IndexView getInstance(){ return instance; }

    // * 전역변수
    private Scanner scan = new Scanner(System.in);

    // * 공통 메인화면(통합)
    public void index(){
        try {
            for(;;){
                userMennu(); // 사용자 공통 메뉴
                int choose = scan.nextInt();
                if( choose == 1 ) usedSearch();
                else if( choose == 2 ) usedPrint();
                else if( choose == 3 ) usedDetail();
                else if( choose == 4 ) usedRanking();
                else if( choose == 5 ) usedAdd();
                else if( choose == 6 ) usedUpdate();
                else if( choose == 7 ) usedDelete();
                else if( choose == 8 ) commentAdd();
                else System.out.println("[경고] 올바른 메뉴 번호를 입력하세요.");
            }// for end
        }catch ( InputMismatchException e ){ System.out.println( "[경고] 입력 타입 오류! 올바른 숫자를 입력하세요." ); }
         catch ( Exception e ){ System.out.println( "[오류] 관리자 문의(000-0000)" ); } // catch end
    }// func end


    // ============================== 단위 기능 ================================== //

    // * 사용자 공통 메뉴
    public void userMennu(){
        System.out.println("\n=========== 뚝딱마켓(중고물품 거래 플랫폼) ==============");
        System.out.println("1. 중고검색  2. 전체목록  3. 상세조회  4. 등록랭킹(Top10)  ");
        System.out.println("5. 중고등록  6. 물품수정  7. 물품삭제  8. 중고물품 문의  ");
        System.out.println("=======================================================\n");
        System.out.print("▶ 메뉴선택 > ");
    }

    // (1) 중고물품 등록
    public void usedAdd(){
        System.out.println("\n(5) 중고물품 등록\n");
        System.out.print("ㆍ판매자 닉네임(필수입력):");
        String ugSeller = scan.next();
        System.out.print("ㆍ판매할 물품명(필수입력):");

    }

    // (2) 중고물품 목록조회
    public void usedPrint(){
        System.out.println("\n(2) 중고물품 전체목록\n");
    }

    // (3) 중고물품 삭제
    public void usedDelete(){
        System.out.println("\n(7) 중고물품 삭제\n");
    }

    // (4) 중고물품 수정
    public void usedUpdate(){
        System.out.println("\n(6) 중고물품 수정\n");
    }

    // (5) 중고물품 검색조회
    public void usedSearch(){
        System.out.println("\n(1) 중고물품 검색\n");
        System.out.print("- 검색어(입력) > ");
        String searchKeyword = scan.next();
    }

    // (6) 중고물품 등록랭킹 조회(Top10)
    public void usedRanking(){
        System.out.println("\n(4) 중고물품 등록랭킹(Top10)\n");
    }

    // (7) 중고물품 문의댓글 작성(익명)
    public void commentAdd(){
        System.out.println("\n(8) 문의등록\n");
    }

    // (6) 중고물품 상세조회
    public void usedDetail(){
        System.out.println("\n(3) 중고물품 상세조회\n");
    }

    // (9) 중고물품 상세조회 > 중고물품 문의댓글 목록조회
    public void commentList(){
        System.out.println("\n● 문의내역\n");
    }


}// class end
