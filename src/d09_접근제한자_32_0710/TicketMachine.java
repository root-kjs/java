package d09_접근제한자_32_0710;

public class TicketMachine {

    // 1. 멤버변수
    static int totalTickets = 0; // 정적변수

    // 3. 메소드
    void issueTicket(){ // 인스턴스 메소드
        totalTickets++;
        System.out.println( "티켓 1장을 발권했습니다" );

    }//func end

    // 스태틱(공유.정적) 메소드
    static void printTotalTickets(){

        System.out.println( totalTickets );

    }//func end

} // class end
