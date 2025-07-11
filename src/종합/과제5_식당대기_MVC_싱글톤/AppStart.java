package 종합.과제5_식당대기_MVC_싱글톤;

import 종합.과제5_식당대기_MVC_싱글톤.view.WaitingView;

// 프로그램 실행 클래스_250711
public class AppStart {

    public static void main(String[] args) {

        // 뷰(View) 싱글톤 호출
        WaitingView.getInstance().index();

        
    }// main end
} //class end
