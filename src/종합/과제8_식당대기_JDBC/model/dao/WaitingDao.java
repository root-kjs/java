package 종합.과제8_식당대기_JDBC.model.dao;

import 종합.과제8_식당대기_JDBC.model.dto.WaitingDto;

import java.sql.*;
import java.util.ArrayList;

public class WaitingDao {
    // * 싱글톤 생성
    private WaitingDao(){ connectDB(); }
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance(){ return instance; }
    
    // * DB연동 상수
    private String db_url = "jdbc:mysql://localhost:3306/waitingDB";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn; // DB 연동결과를 조작하는 인터페이스(java.sql)
    
    // * DB 연동 메소드
    public void connectDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버
            conn = DriverManager.getConnection( db_url, db_user, db_password );
            System.out.println( "DB서버 연동성공!");
        } catch ( ClassNotFoundException e ){
            System.out.println( "[경고] DB드라이버 연동실패!" + e );
        } catch ( SQLException e ){
            System.out.println( "[경고] DB서버 연동실패!" + e );
        }// catch end
    }// func end

    // ---------------------------- WaitingDao 단위기능 ---------------------------- //
    // (1) 대기등록
    public boolean waitingAdd( WaitingDto waitingDto ){
        boolean result = false;
        try {
            // 1.SQL 작성
            String sql = "insert into waiting( wphone, wcount ) values( ?,? )";
            // 2.SQL 기재
            PreparedStatement ps = conn.prepareStatement( sql );
            // 3.SQL 매개변수 대입
            ps.setString(1, waitingDto.getWphone() );
            ps.setInt(2, waitingDto.getWcount() );
            // 4.SQL 실행
            int count = ps.executeUpdate(); // 등록/수정/삭제 쿼리는 등록 횟수로 실행 결과값 판단.
            // 5.SQL 실행결과에 따른 로직/리턴/반환
            if( count >= 1 ) return true;
            else return false;
        }catch ( Exception e ){System.out.println( e ); }
        return false;
    }// func end


    // (2) 대기현황
    public ArrayList<WaitingDto> waitingList(  ){
        // 대기현황용 DB --> 자바 리스트 객체 생성
        ArrayList<WaitingDto> waitingList = new ArrayList<WaitingDto>();
        try {
            // 1. SQL 작성
            String sql = "select * from waiting order by wno desc";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement( sql );
            // 3. SQL 매개변수 대입 --> 조회는 매개변수 없어서 생략
            // 4. SQL 실행 --> 조회는 테이블을 가져오므로 ResultSet executeQuery();  사용!
            ResultSet rs = ps.executeQuery(); // DB연동 SQL 실행결과를 ResultSet(표) 담았다!
            // 5. SQL 실행결과 로직/리턴/확인
            // ---> 조회 테이블은 while문으로 순차적으로 SQL 각 속성값을 가져온 다음, 자바 WaitingDto 객체에 각각 대입
            while ( rs.next() ){
                int wno = rs.getInt("wno");
                String wphone = rs.getString("wphone");
                int wcount = rs.getInt("wcount");
                WaitingDto waitingDto = new WaitingDto( wno, wphone, wcount ); // Dto 객체에 SQL 속성값 대입
                waitingList.add( waitingDto ); // Dto 객체를 자바 리스트 객체에 추가!
            } //while end
        }catch ( Exception e ){ System.out.println("[예외발생]" + e ); }
        return waitingList; // 값이 있든 없든 waitingList 일괄 반환!
    }// func end


    // (3) 특정 대기취소(삭제)
    public boolean waitingCancle( int wno ){
        boolean result = false;
        try {
            // 1. SQL 작성
            String sql = "delete from waiting where wno = ?";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입, 1번은 sql 의 ? ,자리번호, wno은 전달받은 매개변수 대입!
            ps.setInt(1, wno);
            // 4. SQL 실행
            int count = ps.executeUpdate();
            // 5. SQL 실행결과 로직/리턴/확인!
            if( count == 1 ) return true;
            else return false;
        }catch ( Exception e ){ System.out.println("[예외발생]" + e ); }
        return false;
    }// func end


    // (4) 특정 대기수정
    // controller에서 dto객체를 생성하니 dto객체로 매개면수 받겠다, 그리고 매개변수가 2개 이상이면, 가급적 최종 객체로 받는다.
    public boolean waitingEdit( WaitingDto waitingDto ){

        try {
            // 1. SQL 작성
            String sql = "update waiting set wcount = ? where wno = ?"; // 수정은 from 없음. set =
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement( sql );
            // 3. SQL 매개변수 대입
            ps.setInt(1, waitingDto.getWcount()); // 매개변수로 받은값을 수정
            ps.setInt(2, waitingDto.getWno());
            // 4. SQL 실행
            int count = ps.executeUpdate();
            // 5. SQL 실행결과 로직/리턴/확인
            if( count == 1 )  return true;
            else return false;
        }catch ( Exception e ){ System.out.println("[예외발생]" + e ); }
        return false;
    }// func end

}// class end
