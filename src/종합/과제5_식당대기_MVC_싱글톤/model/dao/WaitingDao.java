package 종합.과제5_식당대기_MVC_싱글톤.model.dao;

// 역할 : DTO 배열 및 CRUD 처리 ( * DB역할 )

import 종합.과제5_식당대기_MVC_싱글톤.model.dto.WaitingDto;

public class WaitingDao {

    // 0. WaitingDao 싱글톤 객체 생성
    private WaitingDao(){} // 외부 클래스 객체 생성 금지
    private static final WaitingDao waitingDao = new WaitingDao(); // 비공개(바로접근불가) 유일한 전역(우선할당) 수정불가 공유 인스턴스 1개 미리 생성해서 변수 저장.
    public static WaitingDao getInstance(){ // getInstance() 메소드를 통한 waitingDao 인스턴스 호출!
        return  waitingDao;
    }

    // 1. 멤버 변수(DB 역할)
    WaitingDto[] waitingDtos = new WaitingDto[100];

    // 2. 생성자 : 위에 WaitingDao 싱글톤 생성함,

    // 3. 메소드 : WaitingDto 객체 싱글톤 호출 후 WaitingDao[] 배열 저장과 WaitingDao[] 배열 전체 조회



    
    
} // class end

