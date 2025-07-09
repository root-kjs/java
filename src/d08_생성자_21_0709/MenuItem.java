package d08_생성자_21_0709;

public class MenuItem {
    // 1. 멤버 변수
    String name;
    int price;
    boolean isSignature;

    // 2. 생성자(세 멤버 변수를 모두 초기화)
    MenuItem( String name , int price , boolean isSignature){
        this.name = name;
        this.price = price;
        this.isSignature = isSignature;

    }


} // class end
