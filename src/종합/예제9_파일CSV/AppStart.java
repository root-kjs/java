package 종합.예제9_파일CSV;
import 종합.예제9_파일CSV.controller.BoardController;
import 종합.예제9_파일CSV.model.dto.BoardDto;
import 종합.예제9_파일CSV.view.BoardView;

import java.util.ArrayList;

public class AppStart {
    public static void main(String[] args) {


        // View 작업 전에 Controller / Dao 테스트
        // BoardController 실글톤 호출
        BoardController bc = BoardController.getInstance();
            // 1. 등록 테스트
            boolean result1 = bc.boardWrite("안녕", "유재석");
            System.out.println("result1 = " + result1);

            // 2. 전체조회 테스트
            ArrayList<BoardDto> result2 = bc.boardPrint();
            System.out.println("result2 = " + result2);



        // BoardView.getInstance().index(); // view 싱글톤 호출
        
         

    }//main end
}// class end

