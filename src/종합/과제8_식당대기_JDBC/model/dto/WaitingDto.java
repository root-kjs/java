package 종합.과제8_식당대기_JDBC.model.dto;

public class WaitingDto {
    // 1. 멤버 변수
    private int wno;
    private String wphone;
    private int wcount;

    // 2. 생성자(기본/전체)
    public WaitingDto() {
    }
    public WaitingDto(int wno, String wphone, int wcount) {
        this.wno = wno;
        this.wphone = wphone;
        this.wcount = wcount;
    }

    // 3. 메소드(getter/setter/toString)
    public int getWno() {
        return wno;
    }

    public String getWphone() {
        return wphone;
    }

    public int getWcount() {
        return wcount;
    }

    public void setWno(int wno) {
        this.wno = wno;
    }

    public void setWphone(String wphone) {
        this.wphone = wphone;
    }

    public void setWcount(int wcount) {
        this.wcount = wcount;
    }

    @Override
    public String toString() {
        return "WaitingDto{" +
                "wno=" + wno +
                ", wphone='" + wphone + '\'' +
                ", wcount='" + wcount + '\'' +
                '}';
    }
}// class end
