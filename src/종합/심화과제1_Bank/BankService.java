package 종합.심화과제1_Bank;

import 종합.예제4_게시판4.BoardController;

import java.util.Scanner;

//[JAVA] 심화과제1 : BankService 아래 실행예시를 참고하여 코드를 구현하시오.
//[ 클래스 개수 ] : 3개 (Account, BankController, BankService)
//[ 규칙 ] BankController 에서는 입력과 출력을 하지 않습니다.
//[ 계좌 최대 개수 ] : 100개
public class BankService {
    public static void main(String[] args) {
        // 1. 모델을 반영한 컨트롤러 객체 전역변수로 생성해서 관련 기능 메소드들 가져올거얌!
        BankController bc = new BankController();
        // 2. 반복 출력화면을 구현
        for(;;){
            System.out.println("============== KB Bank  ==============");
            System.out.println("  1.계좌등록 | 2.입금 | 3.출금 | 4.잔고  ");
            System.out.println("======================================");
            System.out.print("선택 > ");
            // 3. 사용자가 메뉴번호를 선택 입력 받을 수 있는 입력함수 객체 생성
            Scanner scan = new Scanner(System.in);
            // 4. 사용자 메뉴 선택값을 담을 변수 생성--> 자바에서 변수는 무조건 타입 먼저 ㅎㅎ
            int select = scan.nextInt();
            // 5. 사용자 메뉴 선택값 변수에 담았으니 값에 따른 세부 기능 구현 분기처리!
            if( select == 1 ){ // 1.계좌등록
                // 6. 일단 선택 했을때 보이는 화면 구현하고 사용자 입력값을 받는다.
                System.out.println( "--- 계좌 등록 ---" );
                System.out.print( "계좌번호 : " );
                String account = scan.next();
                System.out.print( "비밀번호 : " );
                int pwd = scan.nextInt();
                // 7-1. 사용자 입력값(인자값)을 받았으면 계좌 등록 함수를 호출!
                // 7-2. 컨트롤러 객체로 해당 함수 가져와서 변수에 담음. 리턴값 타입으로 변수 선언!
                // 7.3. 사용자의 입력값을 메소드에 인자값으로 넣어주세용! 당연히 타입 체크할 것!
                boolean resultAdd =  bc.accontAdd( account, pwd);
                // 7.4. 리텁값을 변수로 담았으니 해당 결과에 대한 계좌개설 성공여부를 따져보쟈!
                if( resultAdd == true ){
                    System.out.println("[안내] 계좌 등록이 완료되었습니다.");
                    // 8.1. 확인차 등록한 계좌 모두 출력해볼거얌!
                    // 8.2. 그럴려면 계좌 조회 함수 호출! 하려면 객체가 필요해...
                    // 8.3. 메소드의 리턴값의 타입을 변수 타입으로 지정하는것을 잊으면 안돼!!!!
                    Account[] accounts = bc.accontList();
                    // 8.4. 배열은 그대로 호출하면 주소값이 나오니..객체를 가져오기 위해 포문을 돌리고 해당 멤버 변수로 조각내서 가져온다.
                    // 8.5. 입/출력은 조건이 있다. 데이터 멤버변수의 값이 null일 경우를 체크하자!
                    // 8.6. 등록시에는 null 값 체크 했으니..제외/ 널이 아닐 경우 출력!
                    for( int i = 0; i <= accounts.length - 1; i++){
                        if( accounts[i] != null ){
                            System.out.print(  "계좌번호 : "+  accounts[i].account );
                            System.out.print(  " / 비밀번호 : "+  accounts[i].pwd );
                            System.out.println(  "\n--------------------" );
                        }
                    } // 계좌조회 for end
                }else{
                    System.out.println("[경고] 신규 계좌 등록 공간이 없습니다.");
                } // resultAdd 리턴값에 따른 등록 여부 if end

            } else if ( select == 2 ) { // 2.입금
                // 9. 입금메뉴 선택 했을때 보이는 화면 구현하고 사용자 입력값을 받는다.
                System.out.println( "--- 입금 ---" );
                System.out.print( "계좌번호 : " );
                String account = scan.next();
                System.out.print( "비밀번호 : " );
                int pwd = scan.nextInt();
                System.out.print( "입금액 : " );
                int inMoney = scan.nextInt();
                // 9.1 입금메소드 호출! 변수에 담자!
                boolean resultDeposit = bc.deposit( account, pwd, inMoney );
                // 9.2 리턴값에 따른 결과값을 출력하자!
                 if( resultDeposit == true ){
                     System.out.println( "[안내] 입금이 완료되었습니다." );
                 } else {
                     System.out.println("[경고] 입금 실패!");
                 }
                

            } else if ( select == 3 ) { // 3.출금

            } else if ( select == 4 ) { // 4.잔고

            } //  else if ( select == 4) end
            
        } //무한 루프 end
    }//main end
}// class end







