package 종합.예제8_ArrayList.view;

import 종합.예제8_ArrayList.controller.BoardController;
import 종합.예제8_ArrayList.model.dto.BoardDto;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardView {

    // BoardView 싱글톤( boardView ) 유일 인스턴스 생성
    private BoardView(){}
    private static final BoardView boardView = new BoardView();
    public static BoardView getInstance(){
        return boardView;
    } // 싱글톤 end

    // 0. BoardController 싱글톤 가져오기
    private BoardController bc = BoardController.getInstance();

    // 1. 멤버 변수
    Scanner scan = new Scanner(System.in);

    // 3. 메소드
    // 3-0 공통 화면
    public void index(){

        for(;;) {
            System.out.println("====== My Community ======");
            System.out.println(" 1. 글쓰기 2. 전체 글 조회");
            System.out.println("=========================");
            System.out.print(" 선택 > ");
            int choose = scan.nextInt();

            if (choose == 1) {
                addBoard(); // 등록
            } else {
                getBoardList(); // 조회

            }

        } // 무한루프 end

    } // func end

    // 3-1. 게시물 등록(입/출력)
    public void addBoard(){
        System.out.print("내용 : "); String content = scan.next();
        System.out.print("작성자 : "); String writer = scan.next();

        boolean result = bc.addBoard( content, writer );
        if(result == true){
            System.out.println("글쓰기 성공");
        }else {
            System.out.println("글쓰기 실패");
        }


    }
    // 3-2. 게시물 전체조회
    public void getBoardList(){
        System.out.println("--------- 목록 ---------");
        ArrayList<BoardDto> boardDB =  bc.getBoardList();

        for( BoardDto board : boardDB ){

            System.out.print("작성자 : " + board.getWriter());
            System.out.println("내용 : " + board.getContent());
            System.out.println("----------------------");
        }

//        for( int i = 0; i < boardDB.size(); i++ ){
//            BoardDto board = boardDB.get(i);
//            System.out.print("작성자 : " + board.getWriter());
//            System.out.println("내용 : " + board.getContent());
//            System.out.println("----------------------");
//        }


    } // func end


} // class end
