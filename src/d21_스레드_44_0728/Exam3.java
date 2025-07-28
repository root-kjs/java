package d21_스레드_44_0728;
// 1. 유저 1 --> 스레드 1
class User1 extends Thread{
    public Calculator calculator;
    public void run(){
        calculator.setMemory(100);
    }
}// class end
// 2. 유저 2 --> 스레드 2
class User2 extends Thread{
    public Calculator calculator;
    public void run(){
        calculator.setMemory(200);
    }
}// class end

// 3. 계산기
// synchronized 동기화
// 여러 thread 가 동시에 1개의 스레드를 사용하면 멤버변수 충돌이 생길 수 있다(일수도 있고 아닐 수도 있다)
// 메소드에 락을 걸어서 Methode를 점령한다.
// 동기화 --> 하나의 스레드를 처리 : 처리 순서가 보장(순차처리), 주문 순서대로 손님에게 준다.이어 달리기, 서로간의 영향을 끼치는 경우에는 동
// 비동기화(기본값) --> 여러개의 스레드를 동시에 처리 : 처리 순서가 보장이 안됨. // 음식이 완성된 순서대로 손님에게 준다. 다같이 따로 달리기
// 사용법 : 메소드 선언부에 반환타입 앞에 sychronized

class Calculator{
    public int memory;
    public synchronized  void  setMemory( int memory ){ // synchronized 동기화
        this.memory = memory;
        try{ Thread.sleep(2000); }
        catch (Exception e){}
        System.out.println( this.memory );
    }
}


public class Exam3 {
    public static void main(String[] args) {
    /*
        [ 동기화, 비동기화]

     */
        Calculator calculator = new Calculator();
        //
        User1 user1 = new User1();
        user1.calculator = calculator;

        User2 user2 = new User2();
        user2.calculator = calculator;

        user1.start();
        user2.start();

    }// main end
}// class end
