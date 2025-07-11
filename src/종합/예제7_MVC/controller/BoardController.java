package 종합.예제7_MVC.controller;

import 종합.예제7_MVC.model.dao.BoardDao;
import 종합.예제7_MVC.model.dto.BoardDto;

public class BoardController {

    // BoardController 싱글톤 만들기 ::: 3단계
    private BoardController(){}
    private static final BoardController control = new BoardController();
    public static BoardController getInstance(){
        return control;
    }

    //  view 에게 젅달받은 입력값을 boardDao 보내기 위해 미리만든 BoardController 객체(싱글톤) 호출하여 변수에 저장
    private BoardDao boardDao = BoardDao.getInstance();

    // 1) 등록 처리 메소드

    public boolean boardWrite( String content, String writer ){

        // ★★★★ 게시물(데이터 모델)이 싱글톤이면 1개만 저장되니까, DTO(데이터 모델)만 싱글톤으로 처리하지 않는다.

        BoardDto boardDto = new BoardDto( content , writer );

        boolean result =  boardDao.boardWrite( boardDto );
                
        return result;


    }


    // 2, 조회 처리 메소드

    public BoardDto[] boardPrint(){


        BoardDto[] result = boardDao.boardPrint();

        return result;


    }





} // class end
