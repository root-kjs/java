package 종합.과제9_뚝딱마켓_설계.model.dao;
// #. 중고물품 DB 연동

public class UsedDao {
    // * 싱글톤 생성
    private UsedDao(){ connectDB.connect(); }
    private static final UsedDao instance = new UsedDao();
    public static UsedDao getInstance(){ return instance; }

    // * 싱글톤 호출
    public ConnectDB connectDB = ConnectDB.getInstance();

    // ============================== 단위 기능 ================================== //

    // (1) 중고물품 등록

    // (2) 중고물품 목록조회

    // (3) 중고물품 삭제

    // (4) 중고물품 수정

    // (5) 중고물품 검색조회

    // (6) 중고물품 상세조회

}// class end
