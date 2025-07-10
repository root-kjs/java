package d06_배열클래스_29_0707;

import java.util.Arrays;

public class 실습6_배열 {
    public static void main(String[] args) {
//[문제 1] 정수 5개(10, 20, 30, 40, 50)를 저장할 수 있는 int 타입의 배열 numbers1를 선언과 동시에 초기화하세요.
//배열의 2번 인덱스에 저장된 값을 콘솔에 출력하세요.
    int[] member1 = { 10, 20, 30, 40, 50 };
    // 자바는 배열 초기화시 { } 사용한다. 대괄호 []는 배열 선언 시에만 타입 뒤에 붙음
    // 자바스크립트는  배열을 [] 대괄호로 생성
    System.out.println( member1[1] );

//[문제 2] String 타입의 데이터를 3개 저장할 수 있는 배열 season을 new 키워드를 사용하여 생성하세요.
//각 인덱스에 "봄", "여름", "가을" 값을 순서대로 할당하세요.
//Arrays.toString()을 사용하여 배열의 모든 요소를 한 번에 출력하세요.

        String[] season = new String[3];
        season[0] = "봄";
        season[1] = "여름";
        season[2] = "가을";

        System.out.println( season ); // 배열의 주소값 출력
        System.out.println(Arrays.toString( season ));

//[문제 3] 다음과 같은 과일 배열이 있습니다. for 반복문을 사용하여 배열의 모든 요소를 하나씩 콘솔에 출력하시오.
//선언 코드: String[] fruits = {"사과", "바나나", "포도", "딸기"};

        String[] fruits = {"사과", "바나나", "포도", "딸기"};
        for( int i = 0; i <= fruits.length -1; i++ ){
            System.out.println(  fruits[i] );
        }

        // 향상된 for문 : for( 배열타입 반복할 변수명 : 배열변수명 ){}
        for( String fruit : fruits ){
            System.out.println( "향상된 for문 : " + fruit );
        }

//[문제 4] 다음 학생들의 점수가 담긴 배열이 있습니다. for 반복문을 사용하여 모든 점수의 합계와 평균을 계산하여 콘솔에 출력하시오.
//                요구 조건: 평균은 소수점까지 정확하게 계산되어야 합니다.
//                선언 코드: int[] scores1 = {85, 92, 78, 65, 95};
        int[] scores1 = {85, 92, 78, 65, 95};

        int sum = 0;
        for ( int score : scores1 ){
            sum += score;
        }
        double avrage = (double)sum / scores1.length;
        System.out.println( "합계 : " + sum + " / 평균 : " + avrage );

//[문제 5] 점수 배열에서 100점 만점자가 처음 나타나면, "100점 만점자를 찾았습니다!"라고 출력하고 반복문을 즉시 종료하는 프로그램을 작성하시오.
//선언 코드: int[] scores2 = {77, 82, 100, 54, 96};

        int[] scores2 = {77, 82, 100, 54, 96};

        int perfectScore = 100;
        for ( int score : scores2 ){

            if( score == perfectScore ){
                System.out.println( "100점 만점자를 찾았습니다!" );
                break;
            }
        }
//[문제 6] 다음 배열에서 'A'형 혈액형을 가진 사람이 몇 명인지 for 반복문을 통해 세고, 그 수를 콘솔에 출력하시오.
//선언 코드: String[] bloodTypes = {"A", "B", "O", "AB", "A", "B", "A"};

        String[] bloodTypes = {"A", "B", "O", "AB", "A", "B", "A"};
        int count =0;
        for( String bloodType : bloodTypes ){
            if( bloodType.equals("A") ){ // 자바의 문자열 같은것은 .equals()
                count++; // 계산만 하면 되는게 아니라 출력을 해야지..자바는 ; 세미콜론 반드시 닫을 것!
            }
        }
        System.out.println( count );

//[문제 7] 주어진 숫자 배열에서 가장 큰 값을 찾아 콘솔에 출력하는 프로그램을 작성하시오.
//                선언 코드: int[] numbers2 = {23, 5, 67, 12, 88, 34};

        int[] numbers2 = {23, 5, 67, 12, 88, 34};

        int max = 0;
        for (  int number : numbers2 ){
            if( number > max ){
                max = number;
            }
        }
        System.out.println( max );

//[문제 8] products(상품 목록)와 stock(재고 수량) 배열이 있습니다.
//(*상품명과 재고수량 인덱스가 같다는 가정 )
//Scanner를 이용해 사용자로부터 구매할 상품명과 수량을 입력받아, 재고가 충분하면 "구매 완료!"를 출력하고 재고를 차감하세요.
//재고가 부족하면 "재고가 부족합니다."를, 없는 상품이면 "없는 제품명입니다."를 출력합니다.
//선언 코드:
//String[] products = {"볼펜", "노트", "지우개"};
//int[] stock = {10, 5, 20};
//
//        String[] products = {"볼펜", "노트", "지우개"};
//        int[] stock = {10, 5, 20};
//
//        //Scanner를 이용해 사용자로부터 구매할 상품명과 수량을 입력받아,
//        Scanner scan = new Scanner( System.in );
//
//        // 여러 상태값이 있다면 boolean 이 아니라 int로 해서 해당 체크값에 대한 라벨을 붙여줘도 된다.
//        // int check = 0; // 0 : 없는 제품 , 1: 구매완료 , 2 : 구매불가(*재고부족) 무한 루프 밖에 있으면 안됨.
//
//        for(;;){
//            int check = 0; // 0 : 없는 제품 , 1: 구매완료 , 2 : 구매불가(*재고부족)
//            // 상품을 못 찾은 경우에도 check == 1 또는 2였던 이전 상태가 그대로 남아 있기 때문에
//            // 무한 루프 안에서 계속 누적되기 때문에 상태가 이전 상태에 영향을 받습니다.
//            // check는 매 반복마다 초기화해줘야 합니다
//            System.out.print(  "구매할 상품 : " );
//            String pName = scan.next();
//
//            System.out.print(  "구매수량 : " );
//            int pStock = scan.nextInt();
//
//            for( int i = 0; i <= products.length -1; i++ ){
//                String product = products[i];
//                if( product.equals( pName ) ){
//                    if( stock[i] >= pStock ){  //
//                        stock[i] -= pStock;
//                        check = 1;
//                        System.out.println( product + "/ 재고 : " + stock[i] + " (구매완료)" );
//                        continue;
//                    } else if ( stock[i] < pStock ) {
//                        check = 2;
//                        System.out.println( product  + "/ 재고 : " + stock[i] +" (재고가 부족합니다.)" );
//                        continue;
//                    }
//                }
//            } // for end
//            if ( check == 0 )  {
//                // 이것도 무한루프안에 적어줘야 함...
//                // 무한루프가 언제 끝날지 모르기 때문에 무한루프 안에 적어줘야해...
//                System.out.println( "없는 제품입니다." );
//            }
//            if( pName.equals("x") ){
//                break;
//            }
//        } // 무한 루프 종료

//[문제 9] 주어진 영화 이름과 평점 배열을 이용하여, 각 영화의 평점을 별(★, ☆)로 시각화하여 출력하는 프로그램을 작성하시오.
//(* 영화명과 평점 인덱스가 같다는 가정 )
//요구 조건: 각 영화의 평점(10점 만점)만큼 꽉 찬 별(★)을, 나머지 점수만큼 빈 별(☆)을 출력합니다.
//예시: 평점이 8점이면 ★★★★★★★★☆☆ (총 10개의 별)
//선언 코드:
//String[] movieNames = {"히든페이스", "위키드", "글래디에이터2", "청설"};
//int[] movieRatings = {8, 4, 7, 6};
//출력 예시:
//히든페이스      ★★★★★★★★☆☆
//위키드         ★★★★☆☆☆☆☆☆
//글래디에이터2  ★★★★★★★☆☆☆
//청설          ★★★★★★☆☆☆☆

        String[] movieNames = {"히든페이스", "위키드", "글래디에이터2", "청설"};
        int[] movieRatings = {8, 4, 7, 6};

        //  각 배열을 돌며 영화명과 평점을 출력한다.
        for( int i = 0; i < movieNames.length; i++ ){

            // System.out.printf( "%-10s%d\n", movieNames[i], movieRatings[i] );
            System.out.println( movieNames[i]);


        } // for end

    } //main end
} // class end
