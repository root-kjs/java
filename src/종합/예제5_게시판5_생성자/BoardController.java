package 종합.예제5_게시판5_생성자;
//Controller : 기능의 제어와 로직을 담당
public class BoardController{
    Board[] boards = new Board[100];

    // 기능을 나누는 이유는 추후 개발규모가 커질 경우 업무 역할을 분담하기 위해!
    // 각각의 기능을 나눠서 문제 발생시 책임 규모가 작아짐.
    // 복잡한 기능을 로직/코드를 나눠서 유지보수 관리를 용이하게 하기 위함임!!!
    // ============================================================
    // 1. 등록 이벤트(함수/메소드)
    // 입력값을 받아(인자값) 객체를 생성하여 배열에 저장
    // 매개변수 : 내용, 작성자
    // 반환값 : 성공/실패
    boolean doPost( String content , String writer ){
        boolean check = false;
        // 1. 생성자를 이용한 객체 만등기
        Board board = new Board( content, writer );
        // 2. 배열내 빈공간을 찾아서 생성된 객체 대입
        // 향상된 포문에서는 인덱스 위치를 알 수가 없기 때문에 해당 배열의 인덱스의 객체로 저장 되는 게 아니다.
        // 그래서 향상된 포문을 이용해 객체를 배열로 저장 할 수 없다.
        // 인덱스가 필요하다. 배열에서 객체를 해당 위치에 저장 하기 위해서는
//        for( Board board1 : boards ){
//            if( board1 == null ){
//                board1 = board;
//                return true;
//            }
//        } // for end
        for(int i = 0; i <= boards.length - 1; i++){
            System.out.println( boards.length );
            if( boards[i] == null ){
                boards[i] = board;
                return true;
            }
        }
        return false;
    } // func end
    
    // 2. 출력(조회) 이벤트
    // 현재 저장된 모든 객체들을 가지고 있는 배열 호출
    // 매개변수 : X
    // 반환값 : 보드 배열
    // 자바 변수명 앞에는 타입 또는 클래스!!!!!
    
    Board[] doGet(){
        return boards;
    }

} // class end
