package 종합.예제9_파일CSV.controller;
import 종합.예제9_파일CSV.model.dao.BoardDao;
import 종합.예제9_파일CSV.model.dto.BoardDto;

import java.util.ArrayList;

public class BoardController {
    //0. 싱글톤 생성
    private BoardController(){}
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance(){
        return instance;
    }

    //0. 싱글톤 호출( boardDao )
    private BoardDao boardDao = BoardDao.getInstance();



    // 3. 메소드
    // 3-1. 등록
    public boolean boardWrite( String content , String writer ){
        // 반환값 : boolean
        // 매개변수 :  BoardDto boardDto
        // 매개변수를 받을 BoardDto 객체 생성
        BoardDto boardDto = new BoardDto(content, writer);
        // 유효성 검사 --> 일단 패스
        // Dao에게 저장할 객체를 전달하여 결과 받기
        boolean result = boardDao.boardWrite(boardDto);

        return result;

    }// func end

    // 3-2. 전체 조회
    public ArrayList<BoardDto> boardPrint(){
        // 반환값 : boardDB
        // 매개변수 : 없음
        // dao에게 정보를 요청하여 받는다.
        ArrayList<BoardDto> result = boardDao.boardPrint();
        return result;
    }// func end

}//class end
