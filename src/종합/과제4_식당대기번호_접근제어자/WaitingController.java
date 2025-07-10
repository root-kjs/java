package 종합.과제4_식당대기번호_접근제어자;


// Controller
//2. WaitingController.java 클래스 설계 (Controller - static 활용)
//        · 대기 명단 배열을 private static final Waiting[] waitings = new Waiting[100]; 으로 선언합니다.
//        · 대기 등록 기능 메소드 addWaiting(String phone, int count)를 public static 으로 정의합니다.
//            - 매개변수로 받은 값들을 Waiting 클래스의 생성자에 전달하여 객체를 생성합니다.
//            - static으로 선언된 waitings 배열의 빈 공간을 찾아 생성된 객체를 저장하고, 성공 여부를 boolean으로 반환합니다.
//        · 대기 현황 조회 기능 메소드 getWaitingList()를 public static 으로 정의합니다.
//            - static으로 선언된 waitings 배열 전체를 반환합니다.

public class WaitingController {

    // 1. 멤버변수 : Waiting 클래스를 배열로 갖는 아이를 컨트롤 할 거얌
    private static final Waiting[] waitings = new Waiting[100]; // 비공개 우선할당 상수(수정불가) 웨이팅 배열 100개 선언!

    // 2. 생성자 : 기본은 하자
    public WaitingController() {
    }

    // 3, 메소드 : Controller 이니까 메소드가 많겠지?
    // 3.1. 대기 등록 기능 메소드 addWaiting(String phone, int count)를 public static 으로 정의합니다.
    // - static으로 선언된 waitings 배열의 빈 공간을 찾아 생성된 객체를 저장하고, 성공 여부를 boolean으로 반환합니다.
    public static boolean addWaiting(String phone, int count){ // 공개 우선할당 반환값 없는 매개변수 메소드

        Waiting waiting = new Waiting( phone, count ); // 값을 저장/대입해야 하니 Wating 클래스를 가져와서 객체 생성하여,

        for( int i =0; i < waitings.length; i++ ){ // Wating[]에 저장하자.  자바 배열은 길이 정해져서 널 체크하고 해당 입력값 넣자.

            if( waitings[i] == null ){
               waitings[i] = waiting;
               return true;
            }
        } // for end
        return false;
    } //func end

    // 3.2. 대기 현황 조회 기능 메소드 getWaitingList()를 public static 으로 정의합니다.
    //  - static으로 선언된 waitings 배열 전체를 반환합니다.
    public static Waiting[] getWaitingList( ){
        return waitings;
    }//func end


}// class end
