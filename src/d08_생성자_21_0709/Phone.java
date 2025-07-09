package d08_생성자_21_0709;

public class Phone {
    // 클래스 내 멤버
    // 1. 멤버 변수
    String model;
    String color;
    int price;

    // 2, 생성자
    // 1) 기본 생성자 : 클래스 내 생성자가 없으면 자동으로 생성됨(! 클래스 컴파일 될때!)
        // - 클래스 내 하나 이상의 생성자가 있을때는 직접 기본 생성자를 정의해야 함.
    Phone(){
        System.out.println(" --> Phone 기본 생성자 실행");
    }
    // 이름은 같지만 소괄호 안의 ()매개변수 타입/개수/순서 가 다르면 오버로딩 다른 생성자--> 서로 다른 생성자
    // 2) 매개변수가 있는 생성자
        // 함수와 생성자의 차이점
        // 함수와 생성자의 차이점
        // --> 생성자는 매개변수는 있지만 반환값이 없다.
        // 매개변수가 있는 생성자
    Phone( String pModel , String pColor ){
        // 외부로부터 전달받은 인자값이 저장괸 매개변수 값을 멤버 변수에 저장!
        model = pModel;
        color = pColor;
        price = 120000;
    }
    // 3) 생성자의 오버로드
    // ----> 기존 생성자와 매배변수의 타입/순서/개수가 달라야... 이름이 다른거 아님.)
    Phone(String model , String color , int price){
        // 맴버 변수 ㅣ: 객체 내 변수
        // 매개변수 : 메소드/생성자를 사용하는 외부 인수값
        // 멤버변수와 메개변수명이 같을 경우 구분읋 하기 위해
        // this를 사용! this가 붙으면 멤버변수를 가르킴!
        // this --> 현재 메소드/ 생성자를 호출한 객체를 가르킴
        // ★★★★★관례적으로는 초기호 값은 멤버변수와 매개변수명을 동일하게 사용한다!★★★★★★★★★★
        this.model = model;
        this.color = color;
        this.price = price;


    }
    // 3. 메소드
} // class end
