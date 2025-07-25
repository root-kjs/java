package 종합.과제9_뚝딱마켓_설계.controller;
// #. 문의댓글 CR관련 기능제어

public class CommentController {
    // * 싱글톤 생성
    private CommentController(){}
    private static final CommentController instance = new CommentController();
    public static CommentController getInstance(){ return instance; }

}// class end
