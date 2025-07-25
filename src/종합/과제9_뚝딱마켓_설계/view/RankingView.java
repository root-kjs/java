package 종합.과제9_뚝딱마켓_설계.view;
// 최다 중고품등록 판매자 Top10 집계조회 view 화면구현

public class RankingView {
    // * 싱글톤 생성
    private RankingView(){}
    private static final RankingView instance = new RankingView();
    public static RankingView getInstance(){ return instance; }

}// class end
