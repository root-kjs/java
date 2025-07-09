package d08_생성자_21_0709;

public class BankAccount {
    // 1. 멤버 변수
    String accountNumber;
    String ownerName;
    int balance;

    // 2. 멤버 변수를 모두 초기화하는 생성자
    BankAccount( String accountNumber , String ownerName , int balance){
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    // 3-1. 입금 메소드
    // 매개변수 : 입금액 
    // 리턴값 : 잔액
    // 입금액 출금액 등 성격이 비슷한 데이터는 같은 변수명을 사용해도 된다.
    int deposit( int deposit ){
        if( deposit > 0 ){
            balance += deposit;
        }
        return balance;
    }

    // 3-2. 출금 메소드
    // 매개변수 : 출금액
    // 리턴값 : 잔액
    int withdraw( int withdraw ){
        if( withdraw > 0 ){
            balance -= withdraw;
        }
        return balance;
    }

} // class end
