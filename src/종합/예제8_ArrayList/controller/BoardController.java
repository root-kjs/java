package 종합.예제8_ArrayList.controller;
import 종합.예제8_ArrayList.model.dao.BoardDao;
import 종합.예제8_ArrayList.model.dto.BoardDto;

import java.util.ArrayList;


public class BoardController {

    // BoardController 싱글톤( boardController ) 유일 인스턴스 생성
    private BoardController(){}
    private static final BoardController boardController = new BoardController();
    public static BoardController getInstance(){
        return boardController;
    }


    // 1. dao 싱글톤 가져오기 -->   싱글톤 호출 할때도 private 사용!
    private BoardDao boardDao = BoardDao.getInstance();

    // 3. 메소드 : 등록

    public boolean addBoard( String content, String writer ){

        boolean result = false;
        //  dao 에게 매개변수를 전달하고 결과(리턴) 값을 받는다.
        result = boardDao.addBoard(content, writer);
        return result;


    }//func end

    // 2. 전체 조회

    public ArrayList<BoardDto> getBoardList(){

        return boardDao.getBoardList();

    }





}// class end
