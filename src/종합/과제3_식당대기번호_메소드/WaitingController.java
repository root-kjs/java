package 종합.과제3_식당대기번호_메소드;

public class WaitingController {

    Waiting[] waitings = new Waiting[1];

    // 01. 대기 등록 메소드
    // 반환값 : 저장 성공 시 true, 실패(공간 없음) 시 false를 반환(return)합니다.
    boolean addWaiting(String phone, int count){

        // Waiting  클래스 객체 생성해서 매개변수의 값을 멤버 변수에 대입

        Waiting waiting = new Waiting();
        waiting.phone = phone;
        waiting.count = count;

        //  빈배열 순회하여 빈배열 있다면 멤버 변수에 매개변수값 대입
        for( int i = 0; i <= waitings.length - 1; i++ ){
            // 게시팜 배열 내 빈공간이 있다면 객체를 해당 빈 배열 인덱스에 대입  저장
            if( waitings[i] == null ){
               waitings[i] = waiting;
                return true;
            }
        } // for end
        return false;
    } // func end

    // 02. 대기 현황 조회 기능 메소드
    Waiting[] getWaitingList(){
      return waitings;
    } // func end


} // class end
