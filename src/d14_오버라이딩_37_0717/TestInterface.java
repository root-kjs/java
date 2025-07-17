package d14_오버라이딩_37_0717;

public interface TestInterface {
    // 상수는 무조건 초기값 주기
    // 인터페이스는 무조건 상수로 처리된다.
    public static final int value2 = 10;
    int value1 = 1; // 상수 키워드  public static final 생략 가능!

    // [7] 추상메소드 : 선언부만 선언하고 실행문{}없는 메소드
    // public abstract 반환타입 메소드();
    // 실행문{}은 각 클래스가 구현(오버라이딩) 한다.
    public abstract void method2();
    boolean method3( int a  ); // abstract 생략 가능!
    
    // 1. 멤버변수
    //int value1; // 불가능

    // 2, 생성자
    // TestInterface(){} // 불가능

    // 3. 메소드
    // void method(){} // 불가능

} // interface end
