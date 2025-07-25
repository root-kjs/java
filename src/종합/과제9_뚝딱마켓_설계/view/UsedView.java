package 종합.과제9_뚝딱마켓_설계.view;
// 중고물품 CRUD view 화면구현

public class UsedView {
    // * 싱글톤 생성
    private UsedView(){}
    private static final UsedView instance = new UsedView();
    public static UsedView getInstance(){ return instance; }

}// class end
