package d04_if_for문_26_0702;

import java.util.Scanner;

//JAVA] 실습4 : 제어문 - 문제를 보고 설계를 하는 습관을 들이자! 250702(수)
//[ 문제 ] 아래 제어문 관련 문제
//[ 제출방법 ] 코드가 작성된 파일이 위치한 깃허브 상세 주소를 제출하시오.
public class 실습4_조건문_if {
    public static void main(String[] args) {
        //[문제 1] Scanner를 이용해 두 개의 점수(int)를 입력받아 총점을 계산하세요. 총점이 90점 이상이면 '성공'을, 그렇지 않으면 '실패'를 출력하는 프로그램을 작성하시오.
        //입력 예시:
        //첫 번째 점수: 40
        //두 번째 점수: 55
        //출력 예시:
        //성공   // 프롬프트 명령어
        // 전역변수 Scanner 객체 변수 선언
        Scanner scan = new Scanner( System.in );  // 입력함수 객체 생성하여 변수에 저장
//        System.out.print( "첫 번째 점수 : " );    // 사용자에게 입력 안내
//        int score1 = scan.nextInt();            // 사용자에게 입력받은 값을 자료 타입에 맞는 함수와 변수에 저장
//        System.out.print( "두 번째 점수 : " );   // 문제가 요구하는 추가 입력값 안내 및 입력갑 변수 저장
//        int score2 = scan.nextInt();
//
//        if( score1 + score2 >= 90 ){              // 조건에 맞는 문제 값 출력, 연산이 길어지면 해당 내용 변수로 활용!
//            System.out.println( "성공" );  
//        } else{
//            System.out.println( "실패" );
//        }

        //[문제 2] Scanner를 이용해 서로 다른 두 개의 정수를 입력받아, 더 큰 수를 출력하는 프로그램을 작성하시오.
        //입력 예시:
        //첫 번째 정수: 10
        //두 번째 정수: 25
        //출력 예시:
        //더 큰 수: 25

//        System.out.print( "첫 번째 정수 : " );
//        int decimal1 = scan.nextInt();
//        System.out.print( "두 번째 정수 : " );
//        int decimal2 = scan.nextInt();
//        if( decimal1 > decimal2 ){
//            System.out.println( decimal1 );
//        } else {
//            System.out.println( decimal2 );
//        }

        //[문제 3] Scanner를 이용해 아이디와 비밀번호를 String으로 입력받습니다. 아이디가 'admin'이고 비밀번호가 '1234'와 모두 일치하면 '로그인 성공'을, 하나라도 다르다면 '로그인 실패'를 출력하는 프로그램을 작성하시오.
        //요구 조건: 문자열 비교는 .equals() 메소드를 사용하세요.
        //입력 예시:
        //아이디: admin
        //비밀번호: 1234
        //출력 예시:
        //로그인 성공

//        System.out.print( "아이디 : " );
//        String id = scan.nextLine();
//        System.out.print( "비밀번호 : " );
//        String pw = scan.nextLine();
//
//        boolean idB = id.equals("admin");
//        boolean pwB = pw.equals("1234");
//        System.out.println( idB && pwB  );
//        if( idB && pwB ){
//            System.out.println( "로그인 성공" );
//        }else {
//            System.out.println( "로그인 실패" );
//        }

        //[문제 4] Scanner를 이용해 비밀번호를 문자열로 입력받아, 길이에 따라 보안 등급을 출력하는 프로그램을 작성하시오.
        //요구 조건: 비밀번호의 길이는 .length() 메소드로 구할 수 있습니다.
        //8자 미만: '보안 등급: 약함 (8자 이상으로 설정해주세요.)'
        //8자 이상 12자 미만: '보안 등급: 보통'
        //12자 이상: '보안 등급: 강함'
        //입력 예시:
        //비밀번호를 입력하세요: mypassword123
        //출력 예시:
        //보안 등급: 강함
        //.length() --> 자바 문자열의 길이 --> "문자열".length() --> 문자열의 길이( 문자 갯수 반환 함수 )
//        System.out.print( "비밀번호 : " );
//        String pwd = scan.nextLine();
//        if( pwd.length() >= 12 ){
//            System.out.println( "보안 등급: 강함" );
//        }else if( pwd.length() >= 8 ){
//            System.out.println( "보안 등급: 보통" );
//        }else {
//            System.out.println( "보안 등급: 약함 (8자 이상으로 설정해주세요.)" );
//        }

        //[문제 5] Scanner를 이용해 주민등록번호 13자리(-포함)를 문자열로 입력받습니다.
        // 성별을 나타내는 8번째 숫자가 '1' 또는 '3'이면 '남자'를, '2' 또는 '4'이면 '여자'를 출력하는 프로그램을 작성하시오.
        //요구 조건: 8번째 문자는 .charAt(7)으로 가져올 수 있습니다.
        //입력 예시:
        //주민등록번호(-포함) 13자리를 입력하세요: 950101-2******
        //출력 예시:
        //여자   // 주민번호 , 전화번호 , 우편번호는 그냥 문자열이라고 생각하고 접근할 것!

//        System.out.print( "주민등록번호(-포함) 13자리를 입력하세요 : ");
//        String regId = scan.nextLine();  // 문자열 1개를 처리 할 때는 자료 타입 char -> chaeAt()을 가져와서 황용하자!!!!
//        char gender = regId.charAt( 7 ); // 자바에서 char는 문자이고 표형은 "" 큰따옴표가 아니라 작은 따옴표로 표시한다. 문자열과 다르다. 1개 문자 자료타입!
//        // 문자(char) == '1'  vs   문자열(String) "문자열".equals("문자열");  // 비교는 이렇게 다르게 표시
//        // 자바는 자료타입 검사가 엄격하다!
//        System.out.println( gender );
//        if( gender == '1' || gender == '3' ){
//            System.out.println( "남자" );
//        } else if ( gender == '2' || gender == '4' ) {
//            System.out.println( "여자" );
//        } else {
//            System.out.println( "주민번호를 바르게 입력하세요." );
//        }

        //[문제 6] Scanner를 이용해 게임 점수를 정수로 입력받아, 아래 기준에 따라 지급될 상품을 출력하는 프로그램을 작성하시오.
        //900점 이상: 'A급 경품'
        //700점 이상 900점 미만: 'B급 경품'
        //500점 이상 700점 미만: 'C급 경품'
        //500점 미만: '참가상'
        //입력 예시:
        //점수를 입력하세요: 750
        //출력 예시:
        //B급 경품

//        System.out.print( "점수를 입력하세요: ");
//        int gameScore = scan.nextInt();  // 자바 문자열은 ""
//        if( gameScore >= 900 ){
//            System.out.println( "A급 경품" );
//        } else if ( gameScore >= 700  ) {
//            System.out.println( "B급 경품" );
//        } else if ( gameScore >= 500  ) {
//            System.out.println( "C급 경품" );
//        } else {
//            System.out.println( "참가상" );
//        }

        //[문제 7] Scanner를 이용해 사용자 역할(role)을 문자열로 입력받습니다. 역할에 따라 다른 접근 권한 메시지를 출력하는 프로그램을 작성하시오.
        //admin: '모든 기능에 접근할 수 있습니다.'
        //editor: '콘텐츠 수정 및 생성 기능에 접근할 수 있습니다.'
        //viewer: '콘텐츠 조회만 가능합니다.'
        //그 외 역할: '정의되지 않은 역할입니다.'
        //입력 예시:
        //역할을 입력하세요: editor
        //출력 예시:
        //콘텐츠 수정 및 생성 기능에 접근할 수 있습니다.

//        System.out.print( "역할을 입력하세요 : ");
//        String role = scan.nextLine();
//        if( role.equals("admin") ){
//            System.out.println( "모든 기능에 접근할 수 있습니다." );
//        } else if ( role.equals("editor") ) {
//            System.out.println( "콘텐츠 수정 및 생성 기능에 접근할 수 있습니다." );
//        } else if ( role.equals("viewer") ) {
//            System.out.println( "콘텐츠 조회만 가능합니다." );
//        } else {
//            System.out.println( "정의되지 않은 역할입니다." );
//        }

        //[문제 8] Scanner를 이용해 사용자의 나이를 정수로 입력받아, 아래 기준에 따라 입장료를 출력하는 프로그램을 작성하시오.
        //8세 미만: '무료'
        //8세 이상 19세 이하: '5,000원'
        //20세 이상 65세 미만: '10,000원'
        //65세 이상: '3,000원'
        //입력 예시:
        //나이를 입력하세요: 22
        //출력 예시:
        //10,000원
//        System.out.print( "나이를 입력하세요: ");
//        int userAge = scan.nextInt();
//        if( userAge >= 65 ){
//            System.out.println( "3,000원" );
//        } else if ( userAge >= 20 ){
//            System.out.println( "10,000원" );
//        } else if ( userAge >= 8 ){
//            System.out.println( "10,000원" );
//        } else {
//            System.out.println( "무료" );
//        }

        //[문제 9] Scanner를 이용해 하나의 점수를 입력받아 다음 조건에 따라 등급을 출력하는 프로그램을 작성하시오.
        //90점 이상: 'A등급'
        //80점 이상 90점 미만: 'B등급'
        //70점 이상 80점 미만: 'C등급'
        //70점 미만: '재시험'
        //입력 예시:
        //점수를 입력하세요: 85
        //출력 예시:
        //B등급
//        System.out.print( "점수를 입력하세요 : ");
//        int rank = scan.nextInt();
//        if( rank >= 90){
//            System.out.println( "A등급");
//        } else if ( rank >= 80 ) {
//            System.out.println( "B등급");
//        } else if ( rank >= 70 ) {
//            System.out.println( "C등급");
//        } else{
//            System.out.println( "재시험");
//        }

        //[문제 10] Scanner를 이용해 총 구매 금액을 입력받습니다. 구매 금액에 따라 할인율을 적용하여 최종 결제 금액을 출력하는 프로그램을 작성하시오.
        //50,000원 이상: 10% 할인
        //30,000원 이상 50,000원 미만: 5% 할인
        //10,000원 이상 30,000원 미만: 1% 할인
        //10,000원 미만: 할인 없음
        //입력 예시:
        //총 구매 금액: 60000
        //출력 예시:
        //최종 결제 금액: 54000원

//        System.out.print( "총 구매금액 : ");
//        int amount = scan.nextInt();
//
//        int dcRate = 0;
//        if( amount >= 50000 ){
//            dcRate = 10;
//        } else if( amount >= 30000 ){
//            dcRate = 5;
//        } else if( amount >= 10000 ){
//            dcRate = 1;
//        }
//
//        int finalPayment =  amount - ( (amount * dcRate) / 100 ); // 구매금액에 따른 할인률 계산식
//        System.out.printf( "최종결제금액 : %d원" , finalPayment ); // 최종결제 금액

        //[문제 11] 1부터 12 사이의 월(Month)을 숫자로 입력받아, 해당하는 계절을 출력하는 프로그램을 작성하시오. 만약 1~12 이외의 숫자를 입력하면 '잘못된 월입니다.'를 출력하세요.
        //봄: 3, 4, 5월
        //여름: 6, 7, 8월
        //가을: 9, 10, 11월
        //겨울: 12, 1, 2월
        //입력 예시:
        //월(1~12)을 입력하세요: 9
        //출력 예시:
        //가을
//        System.out.print( "월(1~12)을 입력하세요 : " );
//        int month = scan.nextInt();
//        if(  month <= 5 ){
//            System.out.println( "봄" );
//        } else if( month <= 8 ){
//            System.out.println( "여름" );
//        } else if( month <= 11 ){
//            System.out.println( "가을" );
//        } else if(  month == 1 ||  month == 2 ||  month == 12  ){
//            System.out.println( "겨울" );
//        } else {
//            System.out.println( "잘못된 월입니다." );
//        }

        //[문제 12] Scanner를 이용해 서로 다른 세 개의 정수를 입력받아, 가장 큰 수를 출력하는 프로그램을 작성하시오.
        //입력 예시:
        //첫 번째 정수: 45
        //두 번째 정수: 12
        //세 번째 정수: 78
        //출력 예시:
        //가장 큰 수: 78
//        System.out.print( "첫 번째 정수 : ");
//        int num1 = scan.nextInt();
//        System.out.print( "두 번째 정수 : ");
//        int num2 = scan.nextInt();
//        System.out.print( "세 번째 정수 : ");
//        int num3 = scan.nextInt();
//
//        if( num1 > num2 ){
//            if( num1 > num3 ){
//                System.out.println( num1 );
//            }else{
//                System.out.println( num3 );
//            }
//        } else if ( num2 > num3 ){
//            System.out.println( num2 );
//        } else {
//            System.out.println( num3 );
//        }
//
//        int max = num1;  // 3개 이상의 비교나 최고/최저의 등급을 나누는 값이 요구된다면, 임시 대입할 수 있는 변수를 만들어서 활용 할 것!
//        if( num2 > max ){ max = num2; }
//        if( num3 > max ){ max = num3; }
//        System.out.println( max );
//
//        if( num2 > max ){
//            max = num2;
//            if( num3 > max ){
//                max = num3;
//            }
//        }
//        System.out.println( max );

        //[문제 13] Scanner를 이용해 연도(year)를 입력받아 해당 연도가 윤년인지 평년인지 판별하는 프로그램을 작성하시오.
        //윤년 조건:
        //연도가 4의 배수이면서, 100의 배수는 아닐 때
        //또는 연도가 400의 배수일 때
        //입력 예시:
        //연도를 입력하세요: 2024
        //출력 예시:
        //2024년은 윤년입니다.

//        System.out.print( "연도를 입력하세요 : " );
//        int year = scan.nextInt();
//
//        // 윤년 판별 여부 계산식( true / false )
//        boolean leapYear = (( year % 4 == 0 ) && ( year % 100 != 0 )) || ( year % 400 == 0 );
//
//        if( leapYear ){
//            System.out.printf( "%d년은 윤년입니다.", year );
//        } else{
//            System.out.printf( "%d년은 평년입니다.", year );
//        }

        //[문제 14] Scanner를 이용해 서로 다른 세 개의 정수를 입력받아, 오름차순(작은 수부터 큰 수 순서)으로 정렬하여 출력하는 프로그램을 작성하시오.
        //입력 예시:
        //첫 번째 정수: 17
        //두 번째 정수: 4
        //세 번째 정수: 8
        //출력 예시:
        //4, 8, 17

//        System.out.print( "첫 번째 정수 : ");
//        int numA = scan.nextInt();
//        System.out.print( "두 번째 정수 : ");
//        int numB = scan.nextInt();
//        System.out.print( "세 번째 정수 : ");
//        int numC = scan.nextInt();
//
//        // 제어문은 if 조건을 파악하는 게 중요하다!!!!
//        // 스왑 : 정렬을 변경 할때는 스왑 값을 바꾸는 위치를 바꾸는 Swap
//        // 변수들간의 값 교체(Swap) , 변수는 값을 담는 공간!
//        // 정렬은 모든 값을 빠짐 없이 서로 비교하고 꾸준히 비교당한 얘는 제외한다.
//        // 비교할 모든 조건을 파악 한다. 조건에 따른 모든 경우의 수를 대입하여 순서를 정한다.
//        // 정렬은 조건에 맞게 서로의 자리를 바꾸는 과정
//        // [ numA , numB , numC ]
//        // 내림차순 정렬(큰수에서 작은수로) : 3 > 2 > 1
//        // 오름차순 정렬(작은 수부터 큰 수로) : 1 > 2 > 3
//        // 그래서 서로의 값을 바꾼다. 서로의 값을 대입하면 변수의 값이 사라지니 임시 변수를 만들어 서로의 위치를 교체!
//        // 우선 조건을 가장 큰 수를 찾는 것으로 시작~ 큰값을 찾는것이랑은 다르다. 서로의 값을 비교하기에 큰값, 중간값, 작은 값 다 찾아야 하는것임.
//        // 노가다넹.... 갑자기 같은것으로 응용한 처리절차 포문이 생각이 안난다...ㅜㅜ 흑흑
//        // 조건 : 1) a > b, 2) a > c, 3) b > c
//        // 아래는 오름차순 정렬(우선 헷갈리니..)
//        if( numA > numB ){ // 조건1 : a > b
//            int temp = numA;
//            numA = numB;
//            numB = temp;
//        }
//        // System.out.println( numA , numC , numC );
//        // ----> 안됨. 문자열을 포함시켜서 여러 변수들을 문자열 형태로 가져오는 방법을 사용 할 것@@@
//        // 이 구문은 두 개의 값을 println()에 넣었기 때문에 발생한 오류입니다.
//        // Java의 System.out.println() 메서드는 한 개의 인자만 받습니다. println(int, int)처럼 두 개의 정수를 직접 받을 수 없습니다.
//
//        if( numA > numC ){ // 조건1 : a > c
//            int temp = numA;
//            numA = numC;
//            numC = temp;
//        }
//
//        if( numB > numC ){ // 조건1 : b > c
//            int temp = numB;
//            numB = numC;
//            numC = temp;
//        }
//
//        System.out.printf( "내림차순 : %d, %d , %d", numA , numB, numC );

        //[문제 15] 가위바위보 게임
        //지시: 두 명의 플레이어가 참여하는 가위바위보 게임을 만드시오.
        //입력: 플레이어 1과 플레이어 2는 각각 0(가위), 1(바위), 2(보) 중 하나의 숫자를 Scanner로 입력합니다.
        //출력:
        //플레이어 1이 이기면 '플레이어1 승리'를 출력합니다.
        //플레이어 2가 이기면 '플레이어2 승리'를 출력합니다.
        //두 플레이어가 같은 것을 내면 '무승부'를 출력합니다.
        //입력 예시:
        //플레이어1 (0:가위, 1:바위, 2:보): 1
        //플레이어2 (0:가위, 1:바위, 2:보): 0
        //출력 예시:
        //플레이어1 승리

        // 문제풀이
        // 1. 화면 출력 및 사용자 입력값 받음
        // 입력: 플레이어 1과 플레이어 2는 각각 0(가위), 1(바위), 2(보) 중 하나의 숫자를 Scanner로 입력합니다.
      System.out.println( "\n플레이어 1(0(가위), 1(바위), 2(보) 중 하나의 숫자 입력) " );
//        //2. 입력함수 객체 생성
//        //Scanner scan = new Scanner( System.in ); // 이미 위에서 선언해서 에러나와 주석처리
        int p1 = scan.nextInt(); // 플레이어1이 낸 숫자
        System.out.println( "플레이어 2(0(가위), 1(바위), 2(보) 중 하나의 숫자 입력) " );
        int p2 = scan.nextInt(); // 플레이어2가 낸 숫자
        
        // 자 이제 승부를 가려보자!
        // 승부를 가릴렬면 비교를 해야하니 if문..
        // 승리 조건 다져보쟈리 ~ 
        // 무승부 : p1 == p2 / 한쪽이 이기면 나머지는 지는거니 이기는 조건만~ㅎㅎ
        // 이기는 조건(p1) 0(가위), 1(바위), 2(보) 3가지가 있어용
        // p1 == 0 && p2 == 2,  p1 == 1 && p2 == 0,  p1 == 2 && p2 == 1
        // 그럼 조건문 작성 고고고
        // 머든지 먹고 들어가는 짧은거 먼저 끝내버리장!
        if( p1 == p2 ){
            System.out.println( "무승부" );
        } else if( p1 ==  ( p2 + 1 ) % 3   ){
            System.out.println( "플레이어1 승리" );
//        } else if( p1 == 0 && p2 == 2 ||  p1 == 1 && p2 == 0 ||  p1 == 2 && p2 == 1 ){
//            System.out.println( "플레이어1 승리" );
       } else {
            System.out.println( "플레이어2 승리" );
        }


    } // main end
} // class end
