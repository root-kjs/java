package 종합.과제5_식당대기_MVC_싱글톤.controller;

import 종합.과제5_식당대기_MVC_싱글톤.model.dao.WaitingDao;

public class WaitingController {

    // 0. 싱글톤 생성 WaitingController
    private WaitingController(){}
    private static final WaitingController waitingController = new WaitingController();
    public static WaitingController getInstance(){
        return waitingController;
    }
    // 1. 멤버 변수



    // 2, 생성자
    // 3. 메소드
} // main end
