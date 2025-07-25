package 종합.과제9_뚝딱마켓_설계.model.dao;
// # 중고물품 DB 中 최다중고품 등록판매자 Top10 집계 가공데이터 연동

public class RankingDao {
    // * 싱글톤 생성
    private RankingDao(){ connectDB.connect(); }
    private static final RankingDao instance = new RankingDao();
    public static RankingDao getInstance(){ return instance; }

    // * 싱글톤 호출
    public ConnectDB connectDB = ConnectDB.getInstance();


    // ============================== 단위 기능 ================================== //

    // (1) 중고물품 등록랭킹 조회(Top10)

}// class end
