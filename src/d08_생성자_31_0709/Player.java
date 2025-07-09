package d08_생성자_31_0709;

public class Player {

    // 1. 멤버 변수
    String name;
    int power;
    int speed;

    // 2. 생성자(세 멤버 변수를 모두 초기화하는 --> 초기화는 매개변수)
    Player( String name , int power , int speed ){
        this.name = name;
        this.power = power;
        this.speed = speed;
    }




} // class end
