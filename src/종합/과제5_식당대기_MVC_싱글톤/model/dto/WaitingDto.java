package 종합.과제5_식당대기_MVC_싱글톤.model.dto;
// 역할 : 데이터모델/객체

public class WaitingDto {
    
    // 1. 멤버 변수 : private
    private String phone;
    private int count;
    
    // 2, 생성자(기본/전체) :public

    public WaitingDto() {
    }

    public WaitingDto(String phone, int count) {
        this.phone = phone;
        this.count = count;
    }

    // 3, 메소드(getter/setter/toString) : public
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
