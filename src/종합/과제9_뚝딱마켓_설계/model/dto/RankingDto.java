package 종합.과제9_뚝딱마켓_설계.model.dto;
// 중고물품 최다등록 판매자 Top10 자바 클래스 객체(데이터)

public class RankingDto {
    // 1. 멤버변수
    private int ugRanking;      // 최다 중고물품 등록 판매자 순위
    private String ugSeller;    // 최다 중고물품 등록 판매자명(닉네임)
    private int ugTotal;        // 판매자별 고물품  등록수 합계


    // 2. 생성자(기본/전체)
    public RankingDto() {
    }

    public RankingDto(int ugRanking, String ugSeller, int ugTotal) {
        this.ugRanking = ugRanking;
        this.ugSeller = ugSeller;
        this.ugTotal = ugTotal;
    }

    // 3. 메소드(getter/setter/toString)
    public int getUgRanking() {
        return ugRanking;
    }

    public String getUgSeller() {
        return ugSeller;
    }

    public int getUgTotal() {
        return ugTotal;
    }

    public void setUgRanking(int ugRanking) {
        this.ugRanking = ugRanking;
    }

    public void setUgSeller(String ugSeller) {
        this.ugSeller = ugSeller;
    }

    public void setUgTotal(int ugTotal) {
        this.ugTotal = ugTotal;
    }

    @Override
    public String toString() {
        return "RankingDto{" +
                "ugRanking=" + ugRanking +
                ", ugSeller='" + ugSeller + '\'' +
                ", ugTotal=" + ugTotal +
                '}';
    }

}// class end
