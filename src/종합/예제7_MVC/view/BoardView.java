package 종합.예제7_MVC.view;

import 종합.예제7_MVC.controller.BoardController;
import 종합.예제7_MVC.model.dto.BoardDto;
import java.util.Scanner;

public class BoardView {

    // BoardView 싱글톤 만들기 ::: 3단계
    private BoardView(){ } // 1) private 생성자명(){};
    private static final BoardView view = new BoardView(); // 2)
    public static BoardView getInstance(){ //
        return view;
    }

    private Scanner scan = new Scanner(System.in);// 이 클래스에서만 사용하는 입력함수 객체 변수 생성
   
    private BoardController bc = BoardController.getInstance(); // 미리만든 BoardController 객체(싱글톤) 호출하여 변수에 저장

    // 2)
    public void index(){  // 같은 패키지가 아니면 public
        for( ; ; ) {// (1) 무한루프 : 프로그램 계속적으로 실행하기 위해서
            System.out.println("========== My Community ==========");// (2) 출력
            System.out.println("  1.게시물쓰기 | 2.게시물출력");
            System.out.println("==================================");
            System.out.print("선택 > ");
            Scanner scan = new Scanner(System.in); // (3) 입력
            int choose = scan.nextInt();
            if( choose == 1 ) { boardWrite(); }
            else if( choose == 2 ) { boardPrint(); }
            
        } // 무한루프 end
    } //func end

    // 3) 등록 view
    public void boardWrite(){
        System.out.print("내용 : ");
        String content = scan.next();
        System.out.print("작성자 : ");
        String writer = scan.next();
       
        boolean result = bc.boardWrite(content,writer);
        if( result ){
            System.out.println("글쓰기 성공");
        } else {
            System.out.println("글쓰기 실패");
        }


    } // func end

    // 4) 조회 view
    public void boardPrint(){

        BoardDto[] result = bc.boardPrint();
        // BoardDto[] result = BoardController.boardPrint();

        for( int i = 0; i < result.length; i++){
            if( result[i] != null ) {
                System.out.println("-------- 게시물 목록 --------");
                System.out.println("작성자 : " + result[i].getWriter() );
                System.out.println("내용 : " + result[i].getContents()  );
                System.out.println("-----------------------------");
            }
        }

    } //func end


} // class end
