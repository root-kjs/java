package 종합.예제8_ArrayList.model.dto;
// 데이터 모델(객체) : 싱글톤 없음 --> 게시물은 여러개 생성되어야 하니 싱글톤으로 안함.
public class BoardDto {

    // 1. 멤버 변수
    private String content; // 내용
    private String writer;  // 작성자

    // 2. 생성자(기본/전체)

    public BoardDto() {
    }

    public BoardDto(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }


    // 3. 메소드(getter/setter/toString)
    public String getContent() {
        return content;
    }

    public String getWriter() {
        return writer;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
    @Override
    public String toString() {
        return "BoardDto{" +
                "content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }

} // class end
