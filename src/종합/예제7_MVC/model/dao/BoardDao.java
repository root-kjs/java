package 종합.예제7_MVC.model.dao;

import 종합.예제7_MVC.model.dto.BoardDto;

// 역할 : DB(배열) 역할( CRUD ) --> 실제 데이터가 존재하면 데이터 접근하는 기능
// DB : * 추후 데이터베이스로 SQL 변경할 예정

public class BoardDao {


    private BoardDao(){};

    private static final BoardDao dao = new BoardDao();

    public static BoardDao getInstance(){
        return  dao;
    }

    BoardDto[] boardDB = new BoardDto[100]; //  BoardDto[] 배열선언

    // 1) 등록처리(C) 메소드
    // controller부터 배열에 저장할
    // 매개변수 : BoardDto
    // 반환값 : boolean

    public boolean boardWrite( BoardDto boardDto){
        for ( int i =0; i < boardDB.length; i++ ){
            if ( boardDB[i] == null ){
                boardDB[i] = boardDto;
                return true;
            }
        }
        return false;
    }

    
    // 2) 조회처리 메소드

    public BoardDto[] boardPrint(){

        return boardDB;


    }

    

} // class end
