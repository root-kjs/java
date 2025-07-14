package 종합.예제8_ArrayList;

import 종합.예제8_ArrayList.view.BoardView;

public class Appstart {
    public static void main(String[] args) {
        
        // BoardView 싱글톤 호출하여 변수에 저장
        //BoardView bv = BoardView.getInstance();



        BoardView.getInstance().index();


    }//main end
}// class end
