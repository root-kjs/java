package 종합.예제7_MVC.model.dto;

// 데이터 모델이면서 이/동/ 객체

public class BoardDto {

    // 1, 멤버 변수 : 기본 private
    private String contents;
    private String writer;

    // 2, 생성자
    public BoardDto() {
    }

    public BoardDto(String contents, String writer) {
        this.contents = contents;
        this.writer = writer;
    }

    // 3, 메소드( getter / setter / .toString() )
    public String getContents() {
        return contents;
    }

    public String getWriter() {
        return writer;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "contents='" + contents + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }


}// class end.
