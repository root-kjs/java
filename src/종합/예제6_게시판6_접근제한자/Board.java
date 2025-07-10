package 종합.예제6_게시판6_접근제한자;
// Model : 게시물 모델을 만드는 거임!
// DTO, VO
// 클래스는 모델을 만드는 거고, 실체는 (메모리 --> new 객체 생성)해서 만드는 것!
// 모델에 getter/setter 작성

public class Board {
    // 1. 멤버 변수 : private --> 데이터모델에서는 무조건 private!!!
    // * 모델링에 들어간 속성
    // private : 현재 클래스에서만 접근 키워드
    // static : 객체 없이 접근 가능한 키워드
    // final : 수정 불가능 키워드
    private String content;
    private String writer;

    // 2. 생성자 ---> 객체생성시 멤버 변수 초기화
    // 주로(관례적으로) 기본 생성자 1개와 전체 매개변수를 갖는 생성자 1개를 깔고 들어감...
    // 추후 상황에 따라 추가 생성
    // 단축키 :  alt + insert
    //  *관례적* 기본생성자1개 와 전체매개변수갖는생성자1개 한다. (2개) * 상황에 따라 추가
    // 자동 : 해당 클래스에서 오른쪽클릭 -> [생성] -> [생성자] -> 모든 멤버변수 복수선택(ctrl)후 -> [확인]
    // 1) 기본생성자
    public Board(){}
    // 2) 전체매개변수를 갖는 생성자
    public Board(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }

    // 3. 메소드
    // private으로 선언된 멤버변수를 외부, 다른 클래스부터 접근할 수 있도록 getter/setter 지원
    //  toString() 모든 멤버변수값을 문자열로 정보를 보여준다
    // 자동 : 해당 클래스에서 오른쪽클릭 -> [생성] -> [getter 및 setter] -> 모든 멤버변수 복수선택(ctrl)후 -> [확인]
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    // 2) 개발자가 작업하면서 객체의 주소값이 아닌 객체내 멤버변수 값을 문자열로 반환 , toString() 지원한다.
    // 자동 : 해당 클래스에서 오른쪽클릭 -> [생성 -> [toString] -> 모든 멤버변수 복수선택(ctrl)후 -> [확인]
    @Override
    public String toString() {
        return "Board{" +
                "content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
} // class end
