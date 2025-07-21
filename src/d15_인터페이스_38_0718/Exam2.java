package d15_인터페이스_38_0718;

// * extends 하나의 클래스 vs implement 여러개의 인터페이스 대입 가능!

interface Buy { 
    void buy(); // 추상 메소드
    
    
    
}
interface Sell { void sell(); }

class Customer extends Object implements Buy , Sell{
    // extends : 클래스 1 개당 상속은 1개만 가능! 다형성 표시 제약!

    // implements : 클래스 1개당 여러개의 인터페이스 가능!!!  포괄적인 다형성 지원


    @Override
    public void buy() {
        System.out.println("구매");
    }

    @Override
    public void sell() {
        System.out.println("판매");
    }
}




public class Exam2 {

    public static void main(String[] args) {



        Buy buy = new Customer();
        buy.buy();
        // buy.sell(); // 안됨, 형제 관계




    }// main end
}//class end
