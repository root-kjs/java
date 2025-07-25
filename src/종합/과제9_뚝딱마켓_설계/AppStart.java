package 종합.과제9_뚝딱마켓_설계;

import 종합.과제9_뚝딱마켓_설계.model.dao.UsedDao;
import 종합.과제9_뚝딱마켓_설계.view.IndexView;

public class AppStart {
    public static void main(String[] args) {

        /* Dao Test */
        // UsedDao.getInstance();// DB 연동 확인

        /* Controller Test */

        IndexView.getInstance().index();// 공통 메인 화면

    }// main end
}// class end

