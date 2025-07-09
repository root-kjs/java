package d08_생성자_21_0709;

public class Rectangle {
    // 1. 멤버 변수
    int width;
    int height;

    // 2. 생성자(매개변수)
    Rectangle( int width , int height ){
        this.width = width;
        this.height = height;
    }

    // 3. 메소드 : 생성자에 매개변수 있으니 매배변수는 생략
    double getArea( ){
        return  width * height;
    }

}// class end
