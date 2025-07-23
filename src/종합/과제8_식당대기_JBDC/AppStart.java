package 종합.과제8_식당대기_JBDC;

import 종합.과제8_식당대기_JBDC.controller.WaitingController;
import 종합.과제8_식당대기_JBDC.model.dao.WaitingDao;
import 종합.과제8_식당대기_JBDC.view.WaitingView;

public class AppStart {
    public static void main(String[] args) {

        // WaitingDao.getInstance().connectDB();
        // WaitingController.getInstance().waitingAdd("010-000", 100); // 대기등록 테스트
        // WaitingController result = WaitingController.getInstance();
        // System.out.println( result.waitingList() ); // 대기조회 테스트
        WaitingView.getInstance().index();

    }// main end
}// class end
