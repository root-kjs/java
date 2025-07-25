package 종합.과제9_뚝딱마켓_설계.model.dao;
// # 중고물품 문의댓글 DB연동

public class CommentDao {
    // * 싱글톤 생성
    private CommentDao(){ connectDB.connect(); }
    private static final CommentDao instance = new CommentDao();
    public static CommentDao getInstance(){ return instance; }

    // * 싱글톤 호출
    public ConnectDB connectDB = ConnectDB.getInstance();

    // ============================== 단위 기능 ================================== //

    // (1) 중고물품 문의댓글 작성(익명)

    // (2) 중고물품 상세조회 > 중고물품 문의댓글 목록조회


}// class end
