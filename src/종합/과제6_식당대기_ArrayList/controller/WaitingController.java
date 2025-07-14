package 종합.과제6_식당대기_ArrayList.controller;

import 종합.과제6_식당대기_ArrayList.model.dao.WaitingDao;
import 종합.과제6_식당대기_ArrayList.model.dto.WaitingDto;

import java.util.ArrayList;

public class WaitingController {

    // 0. 본인 싱글톤 생성
    private WaitingController(){}
    private static final WaitingController waitingController = new WaitingController();
    public static WaitingController getInstance(){
        return waitingController;
    }

    // 1. 멤버변수
        // Dao 싱글톤 호출 --> private
        private WaitingDao waitingDao = WaitingDao.getInstance();

    // 2. 생성자

    // 3. 메소드
    // 3-1. 대기 등록  addWaiting
    public boolean addWaiting( String phone, int count){

        boolean result = false; // 리턴 초기값 설정
        result = waitingDao.addWaiting(phone , count); // dao 에게 addWaiting() 매개변수를 전달하고 결과(리턴) 값을 저장한다.
        return result;


    } //addWaiting(); end


    // 3-2. 대기 현황 전체 조회 getWaitingList
    public ArrayList<WaitingDto> getWaitingList(){

        return waitingDao.getWaitingList(); // 전체 게시글 반환

    } //getWaitingList(); end.






} // class end
