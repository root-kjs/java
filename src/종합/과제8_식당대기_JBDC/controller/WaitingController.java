package 종합.과제8_식당대기_JBDC.controller;

import 종합.과제8_식당대기_JBDC.model.dao.WaitingDao;
import 종합.과제8_식당대기_JBDC.model.dto.WaitingDto;
import java.util.ArrayList;

public class WaitingController {
    // 0. 싱글톤 생성
    private WaitingController(){}
    private static final WaitingController instance = new WaitingController();
    public static WaitingController getInstance(){ return instance; }

    // 0. 싱글톤 호출( Dao )
    private WaitingDao wd = WaitingDao.getInstance();

    // ---------------------------- WaitingController 단위 기능 ---------------------------- //
    // (1) 대기등록
    public boolean waitingAdd( String wphone, int wcount ){
        // View로부터 매개변수 받은것을 Dao에게 전달 후, Dao의 리턴값을 다시 view에게 전달!
        WaitingDto waitingDto = new WaitingDto(0, wphone, wcount);
        boolean result = wd.waitingAdd( waitingDto );
        return result;
    }// func end


    // (2) 대기현황
    public ArrayList<WaitingDto> waitingList(){
        ArrayList<WaitingDto> result = wd.waitingList();
        return result;
    }// func end


    // (3) 특정 대기취소(삭제)
    public boolean waitingCancle( int wno ){
        // view 매개변수를 dao에게 전달하고, 리턴값을 받아 view에게 전달
        boolean result = wd.waitingCancle( wno );
        return result;
    }// func end


    // (4) 특정 대기수정
    public boolean waitingEdit( int wno, int wcount ){
        // dto 객체 만들어 view로 부터 매개변수 대입생성 후 controller에게 전달하고, 해당 반환값을 다시 view에게 전달
        WaitingDto waitingDto = new WaitingDto( wno,"-", wcount);
        boolean result = wd.waitingEdit( waitingDto );
        return result;
    }// func end

}// class end
