package d15_인터페이스_38_0718;

// 인터페이스란? 상수와 추상메소드를 갖는 타입, 다형성을 위해 사용
// 근본을 바꾸는 게 아닌 형식을 바꾼다.
interface 키보드{
    // 1, 상수 : 초기(처음)값이 필수다.   회색 키워드는 생력 가능!
    public static final String 제조사 = "인텔";
    String 제조일 = "2025-07-18";

    // 2. 추상 메소드 : 공통 성질을 추린 메소드 ---> IoT 시대에서는 다형성이 매우 중요하다!!!!!
    // 구현부를{} 제외한 선언부만 메소드 선언

    public abstract void aKey();
    void bKey();
    
}// interface end


// 구현체란? 추상메소드를 구현한 클래스

class 격투게임 implements 키보드{

    @Override
    public void aKey() {
        System.out.println("공격");
    }

    @Override
    public void bKey() {
        System.out.println("방어");
    }
}

class 축구게임 implements 키보드{

    @Override
    public void aKey() {
        System.out.println("슈팅");
    }

    @Override
    public void bKey() {
        System.out.println("태클");
    }
}

public class Exam1 {

    // 인테페이스는 객체 생성이 안된다. new 안됨!!!
    // 인터페이스도 타입이라 변수 선언은 가능!!!


    public static void main(String[] args) {

        // 인테페이스는 객체 생성이 안된다. new 안됨!!!
        // 인터페이스도 타입이라 변수 선언은 가능!!!
        키보드 myKeyBoard;


        // 변수내 구현체(진짜객체)가 없다.

        myKeyBoard = new 격투게임();
        myKeyBoard.aKey();
        myKeyBoard.bKey();

        myKeyBoard = new 축구게임();
        myKeyBoard.aKey();
        myKeyBoard.bKey();
        
        // 익명 구현체

        키보드 myKeyBoard1 = new 키보드(){

            // 클래스 없이 여기에서 구현(오버라이딩) --> 1회성, 임시용....권장X

            public void aKey() {
                System.out.println("키보드A");
            }

            public void bKey() {
                System.out.println("키보드B");
            }

            
        }; // 세미콜론  꼭 해주기
        
        // 익명체 인터페이스 메소드 구현
        myKeyBoard1.aKey();


    }//main end

}// class end
