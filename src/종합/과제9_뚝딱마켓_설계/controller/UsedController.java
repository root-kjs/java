package 종합.과제9_뚝딱마켓_설계.controller;
// 중고물품 CRUD/검색/상세조회 관련 기능제어

public class UsedController {
    // * 싱글톤 생성
    private UsedController(){}
    private static final UsedController instance = new UsedController();
    public static UsedController getInstance(){ return instance; }
    
}// class end
