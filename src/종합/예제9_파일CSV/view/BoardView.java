package 종합.예제9_파일CSV.view;
import 종합.예제9_파일CSV.controller.BoardController;
import 종합.예제9_파일CSV.model.dto.BoardDto;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardView {
    //0. 싱글톤 생성
    private BoardView(){}
    private static final BoardView instance = new BoardView();
    public static BoardView getInstance(){
        return instance;
    }

    //0. 싱글톤 호출( BoardController )
    private BoardController boardController = BoardController.getInstance();

    // 입력함수 객체 생성
    private Scanner scan = new Scanner(System.in);

    // 3. 메소드
    //  ------------------------ 3-1. 공통화면 
    public void index(){
        for(;;) {
            System.out.println("=====================");
            System.out.println("1.등록 2. 전체조회");
            System.out.println("=====================");
            System.out.print(" 선택 > ");
            int choose = scan.nextInt();
            if (choose == 1) {
                boardWrite();
            } else if (choose == 2) {
                boardPrint();
            }
        }// for end
    }// func end

    //  ------------------------ 3-2. 등록
    public void boardWrite(){
        System.out.print("내용 : ");
        String content = scan.next();
        System.out.print("작성자 : ");
        String writer = scan.next();
        boolean result = boardController.boardWrite(content, writer);
        if(result){
            System.out.println("글 등록 성공");
        }else {
            System.out.println("글 등록 실패");
        }
    }// func end


    //  ------------------------ 3-3. 전체조회
    public void boardPrint(){
        ArrayList<BoardDto> result = boardController.boardPrint();

        for ( BoardDto boardDto :  result ){
            System.out.println("---------- 목록 ----------");
            System.out.print( "작성자 : " + boardDto.getWriter() );
            System.out.print( "내용 : " + boardDto.getContent() );
            System.out.println("-------------------------");
        }// for end

    }// func end

}//class end
