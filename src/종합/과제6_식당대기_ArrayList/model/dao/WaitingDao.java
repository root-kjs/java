package 종합.과제6_식당대기_ArrayList.model.dao;
// DB : waitingDto 객체 ---> CRUD 처리
import 종합.과제6_식당대기_ArrayList.model.dto.WaitingDto;
import 종합.과제6_식당대기_ArrayList.view.WaitingView;

import java.util.ArrayList;

public class WaitingDao {

    // 0. WaitingDao 싱글톤 생성
    private WaitingDao(){}
    private static final WaitingDao waitingDao = new WaitingDao();
    public static WaitingDao getInstance(){
        return waitingDao;
    }

    // 1. 멤버변수
        // WaitingDto 클래스타입을 ArrayList로 갖는 객체 생성하기. ---> private DB 만들기 !WaitingDao 와 헷갈리지 말 것!
        private ArrayList<WaitingDto> waitingDB = new ArrayList<>();


    // 2. 생성자


    // 3. 메소드
        // 3-1. 대기 등록  addWaiting
    public boolean addWaiting( String phone, int count){

        boolean result = false; // 리턴 초기값 설정

        WaitingDto waitingDto = new WaitingDto( phone, count ); //  waitingDto 객체 생성 매개변수를 생성자 대입
        waitingDB.add( waitingDto ); // ArrayList에 객체 추가 저장
        result = true; // 리턴값 true 변경
        return result; // 리턴값 반환

    } //addWaiting(); end


    // 3-2. 대기 현황 전체 조회 getWaitingList
    public ArrayList<WaitingDto> getWaitingList(){
        
        return waitingDB; // 전체 게시글 반환
        
    } //getWaitingList(); end.


} //class end
