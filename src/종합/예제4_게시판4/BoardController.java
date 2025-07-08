package 종합.예제4_게시판4;
// Controller(C)
public class BoardController{
//BoardController 클래스 (제어/로직 담당)
//- 게시물 데이터를 직접 관리하고 처리하는 클래스입니다.
//- Board 객체를 100개 저장할 수 있는 배열(Board[] boards = new Board[100];)을 멤버 변수로 가집니다.
    // 멤버 변수
    Board[] boards = new Board[1];
    // 기존에 선언한 Board의 배열이니까 Board  클래스 선언  가능
    // Board > Board[]

//     로직과 제어를 담당
//     등록 메소드
// 리턴값이 불리언이라 boolean 메소드 선언!
    boolean doPost(String content, String writer){
        // 객체를 생성하여 멤버 변수에 매개변수 인자값을 대입
        // 멤버 변수 선언과는 별개로 해당 클래스의 객체를 선언하여  매개변수 값을 객체의 멤버변수에 대입해줘야 함.
        // 게시판 클래스 객체를 생성해줘야 멤버 변수에 매개변수를 대입해 줄 수 가 있지!
        Board board = new Board(); // 객체 생성
        board.content = content; // 매개변수로 받은 값을 멤버변수에 대입 저장
        board.writer = writer;
        // 그다음에
        for( int i = 0; i <= boards.length -1; i++ ){
            if( boards[i] == null ){
                boards[i] = board; // 빈배열을 찾아 해당 객체 대입
                return true; // 저장 성공시 true
            } // for문 안에 else 하면 안돼!
        } // for end
        return false;
    } // 등록 멤소드 func end
    
    // 02. 조회 메소드 
    // ★★ 리턴값 : 보드 배열 --> 리턴값에 따라 메소드의 타입이 결정된다.
    Board[] doGet(){
        return boards; // 객체를 반환 !!!! 중요!!!!
    }
    
} // class end
