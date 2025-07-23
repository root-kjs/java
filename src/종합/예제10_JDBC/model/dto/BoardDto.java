package 종합.예제10_JDBC.model.dto;

public class BoardDto {
    // 1, 멤버 변수
    private int bno;
    private String bwriter;
    private String bcontent;

    // 2. 생성자(기본/전체)
    public BoardDto() {}

    public BoardDto(int bno, String bwriter, String bcontent) {
        this.bno = bno;
        this.bwriter = bwriter;
        this.bcontent = bcontent;
    }

    // 3. 메소드(getter/setter/toString)
    public int getBno() {
        return bno;
    }

    public String getBwriter() {
        return bwriter;
    }

    public String getBcontent() {
        return bcontent;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public void setBwriter(String bwriter) {
        this.bwriter = bwriter;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "bno=" + bno +
                ", bwriter='" + bwriter + '\'' +
                ", bcontent='" + bcontent + '\'' +
                '}';
    }
}// class end
