package 종합.예제10_JDBC.view;

import 종합.예제10_JDBC.controller.BoardController;

public class BoardView {
    // 0. 싱글톤 생성
    private BoardView(){}
    private static final BoardView instance = new BoardView();
    public static BoardView getInstance(){ return instance; }

}//class end
