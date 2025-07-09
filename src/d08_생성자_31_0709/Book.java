package d08_생성자_31_0709;

public class Book {
    // 1. 멤버 변수 정의
    String title;
    String author;
    int price;

    // 2.1 기본 생성자 생성 --> 안하면 그냥 new 하면 에러남.
    Book(){}

    // 2. 생성자(매개변수) 정의
    Book(String title , String author , int price){
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
}// class end
