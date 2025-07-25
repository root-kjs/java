package 종합.과제9_뚝딱마켓_설계.model.dto;
// 문의댓글 자바 클래스 객체(데이터)

public class CommentDto {
    // 1. 멤버변수
    private int cNo;             // 문의댓글번호(PK)
    private int ugNo;            // 중고물품번호(FK)
    private String cWriter;      // 작성자(닉네임)
    private String cInquiry;     // 문의내용
    private int cPwd;            // 비밀번호
    private String cCreatedAt;   // 작성일

    // 2. 생성자(기본/전체)
    public CommentDto() {
    }

    public CommentDto(int cNo, int ugNo, String cWriter, String cInquiry, int cPwd, String cCreatedAt) {
        this.cNo = cNo;
        this.ugNo = ugNo;
        this.cWriter = cWriter;
        this.cInquiry = cInquiry;
        this.cPwd = cPwd;
        this.cCreatedAt = cCreatedAt;
    }

    // 3. 메소드(getter/setter/toString)
    public int getcNo() {
        return cNo;
    }

    public int getUgNo() {
        return ugNo;
    }

    public String getcWriter() {
        return cWriter;
    }

    public String getcInquiry() {
        return cInquiry;
    }

    public int getcPwd() {
        return cPwd;
    }

    public String getcCreatedAt() {
        return cCreatedAt;
    }

    public void setcNo(int cNo) {
        this.cNo = cNo;
    }

    public void setUgNo(int ugNo) {
        this.ugNo = ugNo;
    }

    public void setcWriter(String cWriter) {
        this.cWriter = cWriter;
    }

    public void setcInquiry(String cInquiry) {
        this.cInquiry = cInquiry;
    }

    public void setcPwd(int cPwd) {
        this.cPwd = cPwd;
    }

    public void setcCreatedAt(String cCreatedAt) {
        this.cCreatedAt = cCreatedAt;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "cNo=" + cNo +
                ", ugNo=" + ugNo +
                ", cWriter='" + cWriter + '\'' +
                ", cInquiry='" + cInquiry + '\'' +
                ", cPwd=" + cPwd +
                ", cCreatedAt='" + cCreatedAt + '\'' +
                '}';
    }
}// class end
