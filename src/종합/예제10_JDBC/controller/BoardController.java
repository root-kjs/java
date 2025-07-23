package 종합.예제10_JDBC.controller;

import 종합.예제10_JDBC.model.dao.BoardDao;

public class BoardController {
    // 0. 싱글톤 생성
    private BoardController(){}
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance(){ return instance; }

}// class end
