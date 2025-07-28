package d21_스레드_44_0728;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam4 {
    public static void main(String[] args) {
    /*
         [ 스레드풀 ]
         1. 미리 일정 갯수의 스레드를 생성하고 필요에 따라 재사용하는 방식
         2, 목적: 작업이 들어올 때마다 새로운 스레드가 아닌 기존 스레드 이용
         3. 효과 : 스레드 재사용, 자원 효율성, 과부하 방지 등
         4. 구조 : 작업의 요청을 '큐'
            * '큐' 선입선출 : 자료의 데이터들을 요청 순서대로 처리 방법 --> 먼저 들어온게 먼저 처리된다.
            * '스택' : 먼저 들어온게 나중에 처리된다. 
         5. 생활예시 : 콜센터, 대기중인 콜센터 직원이 업무 처리
            - 직원1( 스레드 ) / 직원2( 스레드 ) / 직원3( 스레드 )
         6. 사용처 : 1) 톰캣[ 자바 웹클래스 ]
                    2) JDBC
                    3) 업로드/다운로드
                    4) 채팅(다중접속)
         7. 사용법
    */
        // ExecutorService executorService = Executors.newFixedThreadPool( 스레드풀 저장할 스레드 수  );
        ExecutorService executorService = Executors.newFixedThreadPool( 3 );

        // 반복문을 이용하여 각각 3개 스레드를 생성하여 스레드풀에 넣어주기
        for( int i = 1; i <=3; i++ ){
            String name ="Thread" + i;
            Runnable runnable = new Runnable(){ // 인터페이스에 new를 사용하며 익명구현체
                public void run(){
                    try {
                        Thread.sleep( 2000 );

                    }catch ( Exception e){}
                    System.out.println("Task Tread : " + name );
                }
            }; //  익명 구현체 end; 세미클론 붙인다.
            executorService.submit( runnable );
        }// for end
        // Task Tread : Thread2 --> 스레드의 순서와 배정은 개발자가 지정하는 게 아니라 시스템이 결정한다.
        // Task Tread : Thread1 --> 스레드의 작업순서는 보장 받을 수 없다. 운영체제가 알아서 운영체제 맘대로 ...
        // Task Tread : Thread3
        executorService.shutdown(); // 스레드풀(스레드풀 저장된 모든 스레드풀) 종료 

    }// main end
}// class end
