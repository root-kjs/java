package 종합.과제9_뚝딱마켓_설계.model.dto;
// 중고물품 자바 클래스 객체(데이터)

public class UsedDto {
    // 1. 멤버변수
    private int ugNo;               // 중고물품번호(PK)
    private String ugName;          // 중고물품명
    private int ugPrice;            // 가격(원)
    private String ugSeller;        // 판매자(닉네임)
    private int ugPwd;              // 비밀번호
    private String ugDescription;   // 설명
    private int ugStatus;           // 판매여부
    private String ugCreatedAt;     // 등록일

    // 2. 생성자(기본/전체)
    public UsedDto() {
    }

    public UsedDto(int ugNo, String ugName, int ugPrice, String ugSeller, int ugPwd, String ugDescription, int ugStatus, String ugCreatedAt) {
        this.ugNo = ugNo;
        this.ugName = ugName;
        this.ugPrice = ugPrice;
        this.ugSeller = ugSeller;
        this.ugPwd = ugPwd;
        this.ugDescription = ugDescription;
        this.ugStatus = ugStatus;
        this.ugCreatedAt = ugCreatedAt;
    }
    // 3. 메소드(getter/setter/toString)
    public int getUgNo() {
        return ugNo;
    }

    public String getUgName() {
        return ugName;
    }

    public int getUgPrice() {
        return ugPrice;
    }

    public String getUgSeller() {
        return ugSeller;
    }

    public int getUgPwd() {
        return ugPwd;
    }

    public String getUgDescription() {
        return ugDescription;
    }

    public int getUgStatus() {
        return ugStatus;
    }

    public String getUgCreatedAt() {
        return ugCreatedAt;
    }

    public void setUgNo(int ugNo) {
        this.ugNo = ugNo;
    }

    public void setUgName(String ugName) {
        this.ugName = ugName;
    }

    public void setUgPrice(int ugPrice) {
        this.ugPrice = ugPrice;
    }

    public void setUgSeller(String ugSeller) {
        this.ugSeller = ugSeller;
    }

    public void setUgPwd(int ugPwd) {
        this.ugPwd = ugPwd;
    }

    public void setUgDescription(String ugDescription) {
        this.ugDescription = ugDescription;
    }

    public void setUgStatus(int ugStatus) {
        this.ugStatus = ugStatus;
    }

    public void setUgCreatedAt(String ugCreatedAt) {
        this.ugCreatedAt = ugCreatedAt;
    }

    @Override
    public String toString() {
        return "UsedDto{" +
                "ugNo=" + ugNo +
                ", ugName='" + ugName + '\'' +
                ", ugPrice=" + ugPrice +
                ", ugSeller='" + ugSeller + '\'' +
                ", ugPwd=" + ugPwd +
                ", ugDescription='" + ugDescription + '\'' +
                ", ugStatus=" + ugStatus +
                ", ugCreatedAt='" + ugCreatedAt + '\'' +
                '}';
    }
}// class end
