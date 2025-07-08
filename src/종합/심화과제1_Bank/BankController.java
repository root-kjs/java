package 종합.심화과제1_Bank;

public class BankController {

    // 00. 모델 Acconunt 클래스의 Acconunt 배열 객체 생성!
    Account[] accounts = new Account[100]; // 테스트 차원으로 2개만 ㅋㅋㅋ

    // 01. 계좌등록 메소드
    boolean accontAdd( String account, int pwd){
        // 타입 리턴값 : 등록 성공/ 실패
        // 타입 매개변수 : 계좌번호 / 비밀번호
        // 매개변수가 있으니 인자값을 대입할 객체가 필요, 등록할 대상인 Acconunt 객체 생성하여 매개변수와 인자값 대입/저장!
        
        Account bankbook = new Account(); //  통장이라고 하자...
        bankbook.account = account;
        bankbook.pwd =pwd;

        // 객체를 생성해서 값 대입/저장했으면 배열에 저장해야 겠지?
        for( int i = 0; i <= accounts.length -1; i++ ){
            //  막 대입은 아니고 빈 배열이 있을 경우에만 해당 객체 저장값 대입
            if( accounts[i] == null ){
                accounts[i] = bankbook;
                return true; // 출력값은 없고 리턴값만 반환해준댜!
            }
        } // for end
        return false;
    } // 계좌등록 메소드 func end
    // 01-1. 계좌조회 메소드(문제에는 없지만 디버깅상 만들어본댜리..
    Account[] accontList(){
        return accounts;
    } // 계좌조회 메소드 end

    // 02. 입금 메소드
    boolean deposit( String account, int pwd, int inMoney ){
        // 타입 리턴값 : 입금 성공 / 실패
        // 타입 매개변수 : 계좌번호 / 비밀번호 / 입금액
        // 매개변수가 있으니 인자값을 대입할 객체가 필요, 등록할 대상인 Acconunt 객체 생성하여 매개변수와 인자값 대입/저장!
//        Account bankbook = new Account();
//        bankbook.account = account;
//        bankbook.pwd =pwd;
//        bankbook.balance += inMoney;
        // 배열에 저장!
        // 저장 하기에 앞서 이미 있는 계좌배열을 조회해서 입력된 인자값(계좌와 비번이) 맞는지 확인 하자!
        // 저장 조건은 계좌번호와 비번이 맞다면 그리고 입금액이 0이 초과일때!
        // 자바에서 문자열 비교는 .equals() 해야지!!!
        for( int i = 0; i <= accounts.length - 1; i++ ){
            if( accounts[i] != null ){ // 계좌 배열에서 null 이 아닌 얘중에서만 돌아야지!
                System.out.println( accounts[i] );
                if( accounts[i].account.equals(account) && accounts[i].pwd == pwd && inMoney > 0) {
                    //bankbook.inMoney = inMoney;
                    accounts[i].balance += inMoney;
                    return true;
                }
            }
        } // for end
        return false;
    } // 입금 메소드 func end


    // 03. 출금 메소드


    // 04. 잔고 메소드
    

}// class end
