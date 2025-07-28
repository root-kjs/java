package d21_스레드_44_0728;

import java.time.LocalTime;
import java.util.Scanner;

// 2. 시계 Thread
class 시계스레드 implements Runnable{
    public void run(){
        for (;;){
            System.out.println(LocalTime.now()); // 현재 시간 출력
            try {
                Thread.sleep(1000); // 1초 일시정지
            }catch (Exception e){}
        }
    }
}

// 3. 타이머 스레드
class 타이머스레드 extends Thread{
    boolean state = true; // 무한루프 실행여부
    public void run(){
        int second = 0;
        for (;;){
            if ( state == false ) break;
            second++;
            System.out.println("[타이머] 초 " + second);
            try {
                Thread.sleep(1000); // 현재 스레드를 1초 일시정지
            }catch (Exception e){ }

        }
    }
}

public class Exam2 {
    public static void main(String[] args) {
        // 1. 메인(입력) Thread -->  public static void main(String[] args)

        // 2. 시계
        시계스레드 시계스레드1 = new 시계스레드(); //인터페이스를 구현해준 객체를 구현체
        Thread thread1 = new Thread( 시계스레드1 );
        thread1.start();

        // 3. 타이머  스레드
        타이머스레드 thread2 = null;

        for(;;){
            System.out.println("타이머 1)on 2) off");
            Scanner scan = new Scanner(System.in);
            int ch = scan.nextInt();
            if (ch==1){
                thread2 = new 타이머스레드();
                thread2.start();
            }
            else if (ch==2) {

                thread2.state = false;
            }
        }// for end


    }// main end
}// class end
