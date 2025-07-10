package d09_접근제한자_32_0710;

public class BankAccount {

    // 1. 멤버변수
    private String accountNumber;

    // 2. 생성자

    BankAccount(String accountNumber){
        this.accountNumber = accountNumber;
    }

    // 3. 메소드
        // 3.1. Getter
        public String getAccountNumber( ){

            return accountNumber;

        }// func end


}// class end

