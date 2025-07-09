package d08_생성자_21_0709;

public class UserProfile {
    // 1. 멤버 변수
    String name;
    int age;
    String mbti;

    // 2. 생성자(멤버변수 초기화)
    UserProfile( String name , int age , String mbti ){
        this.name = name;
        this.age = age;
        this.mbti = mbti;
    }

} // class end
