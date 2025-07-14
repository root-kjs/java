package 종합.예제8_ArrayList.model.dao;

import 종합.예제8_ArrayList.model.dto.BoardDto;
import 종합.예제8_ArrayList.view.BoardView;

import java.util.ArrayList;

public class BoardDao {

    // BoardDao 싱글톤( boardDao ) 유일 인스턴스 생성
    private BoardDao(){}
    private static final BoardDao boardDao = new BoardDao();
    public static BoardDao getInstance(){
        return boardDao;
    } // 싱글톤 end


    // 1, 멤버 변수
    private ArrayList<BoardDto> boradDB = new ArrayList<>();


    // 3. 메소드 : public 사용 할 것!!!! 안적으면 default 로 처리 됨,
    public boolean addBoard( String content , String writer){
        // 리턴 초기화 기본 false로 하고 DB에 잘 저장됐을때 true를 반환한다.
        boolean result = false;
        // 객체 불러와서 매개변수와 대입
        BoardDto boardDto = new BoardDto( content, writer );

        boradDB.add( boardDto );
        return true;
    } // func end


    public ArrayList<BoardDto> getBoardList(){
        return boradDB;
    }



} // class end
