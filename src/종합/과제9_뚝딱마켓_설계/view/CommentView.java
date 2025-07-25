package 종합.과제9_뚝딱마켓_설계.view;
// 문의댓글 View(프론트단) 화면구현

public class CommentView {
    // * 싱글톤 생성
    private CommentView(){}
    private static final CommentView instance = new CommentView();
    public static CommentView getInstance(){ return instance; }
    
}// class end
