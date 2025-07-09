package d08_생성자_31_0709;

public class Goods {
    // 1. 멤버 변수
    String name;
    int price;

    // 2-1. 기본 생성자
    Goods(){
        this.name = "미정";
        this.price = 0;
    }

    // 2-2. 매개변수가 있는 생성자: name과 price를 매개변수로 받아 초기화
    Goods( String name , int price){
        this.name = name;
        this.price = price;
    }




} // class end
