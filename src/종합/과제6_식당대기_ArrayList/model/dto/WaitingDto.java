package 종합.과제6_식당대기_ArrayList.model.dto;
// Model : 데이터 모델/객체
public class WaitingDto {

    // 1. 멤버변수 : private 비공개 설정
    private String phone;
    private int count;

    // 2. 생성자(기본/전체)
    public WaitingDto() {
    }

    public WaitingDto(String phone, int count) {
        this.phone = phone;
        this.count = count;
    }

    // 3. 메소드(getter/setter/toString)

    public String getPhone() {
        return phone;
    }

    public int getCount() {
        return count;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "WaitingDto{" +
                "phone='" + phone + '\'' +
                ", count=" + count +
                '}';
    }

} // class end
