package d03_연산자_25_0701;

public class Exam1_if제어문 {
    public static void main(String[] args) {
        
        // if 제어문
        // 1. 조건에 따른 결과를 제어
        // if()  참일때 코드;  // {} 참인것 1개일때면 중괄호 없어도 된다.그냥 중괄호 사용한다.
        // 참일때 명령어가 2개 이상일 때는 중괄호 사용! 머여.....ㅡㅡ;;;
        // 그냥 중괄호 쓸래.........

        // 아래는 여러 조건들 중에서 하나의 결과가 나온다.
        int 지갑돈 =1750;
        if( 지갑돈 >= 3000 ){
            System.out.println( "택시를 탄다" );
        }else if(  지갑돈 >= 1700 ){
            System.out.println( "버스를 탄다" );
        }else {
            System.out.println( "걸어간다." );
        }

        int age = 25;
        char gender = 'w'; // 여자
        if( age >= 19 ){
            System.out.print( "성인" );
            if( gender == 'w' ){
                System.out.print( "여자" );
            }else{
                System.out.print( "남자" );
            }
        }else{
            System.out.print( "미성년자" );
        }
        
    } // main end
} // class end
