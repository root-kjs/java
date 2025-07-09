package 종합.예제5_게시판5_생성자;
// Model : 모델을 만드는 거임!
// 클래스는 모델을 만드는 거고, 실체는 (메모리 --> new 객체 생성)해서 만드는 것!
public class Board {
    //1. 멤버 변수
    String content;
    String writer;

    //2. 생성자 ---> 객체 멤버 변수 초기화
    Board(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }

} // class end
