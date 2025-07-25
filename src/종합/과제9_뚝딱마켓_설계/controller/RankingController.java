package 종합.과제9_뚝딱마켓_설계.controller;
// 최다 중고물품 등록판매자 Top10 조회 기능 제어

public class RankingController {
    // * 싱글톤 생성
    private RankingController(){}
    private static final RankingController instance = new RankingController();
    public static RankingController getInstance(){ return instance; }

}// class end
