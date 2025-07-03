package d04_if_for문_26_0702;

import java.util.Scanner;

public class Exam1_반복문_for {
    public static void main(String[] args) {
        // 반복문 : 조건 충족(true) 했을때 반복코드 실행
        // 주요 키워드
        // break  --> 조건에 맞는 얘가 나오면 가장 가까운 포문 종료! if문에서 조건에 맞는 얘가 나오면 가장 가까운 반복문으로 가서 포문 탈출(종료)
        // continue --> 조건에 맞는 얘는 결과, 해당 조건의 다음 가장 가까운 포문의 증감식으로 이동.  생략 if문에서 조건에 맞는 얘가 나오면 점프(생랼)하고 가장 가까운 반복문으로 가서 포문 실행
        // if의 조건이 5이면 5의결과는 건너띄고 6으로 갑. 포문의 증감식으로 감.
        // 무한루프
        // 1) for( ; ; ){}
        // 2) while( true ){}

        // for( ;; ){
        while (true){
            System.out.println(  "무한입력[ 종료가 안되요...(*종료조건 : x 입력)]" );
            String input = new Scanner( System.in ).next(); // 키보드 무한 콘솔 입력
            //  무한루프의 종료조건을 만들자!
            if( input.equals("x") ){ // 만약 입력값이 x 이면 무한루프 포문 종료! // 자바의 문자열 같은 비교는 .equals()
                break;
            }
        } //  for end  // while end

    } // main end
} // class end
