package d17_OpenCSV_40_0722;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exam2 {
    public static void main(String[] args) {
    /*
        [ JDBC ] : JAVA DATABACE CONNECT 자바 데이터베이스 연동
        1. 준비 
            1) JDBC MYSQL 라이브러리 다운로드 : https://dev.mysql.com/downloads/connector/j/
            2) mysql-connector-j-9.3.0.jar
        2. 연동코드
        3. ★ 핵심 JDBC
            인터페이스를 사용하는 이유 : 각기 다른 데이터베이스 회사의 클래스(구현체)를 조작하기 위해
            다형성의 특징 : 소스코드 다 바뀌는데 클래스 메소드만 변경 아주 죠음!
            1) Connection : 데이터베이스를 연동하는 인터페이스
                (1) DB서버와 연동 한수 
                    DriverManager.getConnection(  서버주소, 계정, 비번  );
                (2) 연동된 DB에 SQL 기재 함수 , 기재된 PreparedStatement 타입 반환
                    PreparedStatement ps = conn.preparedStatment( sql문법 );
                
            2) PreparedStatement : sql 조작하는 인터페이스 
                (1) 기재된 sqL 실행 함수 
                    ps.excuteQuery(); SELECT 문법 실행 결과를 ResultSet 타입 반환
                    ps.excuteUpdate();  INSERT, UPDATE, DELETE 문법 실행결과 int 타입 반환
                
            
            3) ResultSet : sql 실행결과를 조각하는 인터페이스
                (1) SQL 결과 조작 함수
                    rs.next();  --> 조회된 레코드 중에서 다음 레코드 이동 함수
                    rs.getXXX( 속성명 ); --> 현재 레코드에서 지정한 속성명의 값 반환 함수
                          XXX --> 자바 타입 --> getInt(), getString(),
                    
     */
        // 1) 자바와 데이터베이스 연동 : mysql 회사에서 지원하는 연동 Driver 클래스 로드 : DB 회사별로 다름.
        // ★ 무조건 필수 일반 예외처리 해야 함.
        try {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            System.out.println("JDBC 드라이버 가져오기 성공!");
            // DB 연동 후 연동(connect)결과를 갖는 인터페이스, Connection , import java.sql
                // .prepareStatement( sql ) --> 연동된 DB에 SQL 기재 준비, PreparedStatement 타입 반환

            // 연동 함수 : .getConnection( 서버주소 , 계정명, 비밀번호 );
            String db_url = "jdbc:mysql://localhost:3306/mydb0722";      // 데이터베이스 서버주소
            String db_user = "root";     // 데이터베이스 계정명
            String db_password = "1234"; // 데이터베이스 비밀번호

            // Connection : 인터페이스 --> 각기 다른 회사가 다른 설정을 사용해야 하므로 인터페이스로 정의
            // 구현체 : DriverManager
            Connection conn = DriverManager.getConnection(db_url , db_user, db_password );
            System.out.println("JDBC 드라이버 연동 성공!");

            // 자바에서 insert 문법 사용하기 ------------------------------------------------ //
            String sql = "insert into test(content) values('안녕하세요!')";
            // 6) 지정한 SQL을 연동된 인터페이스에 대입 : .prepareStatement( sql );
            PreparedStatement ps = conn.prepareStatement( sql ); //
            // 7) 기재된 SQL 실행 : PreparedStatement --> 인터페이스가 다 나눠있음.
            ps.execute(); // 기재된 SQL 실행! --:> 자바에서 실행하고 SQL 워크벤치 테이블에서 확인!




            
        }catch ( ClassNotFoundException e){
            System.out.println("JDBC 드라이버 가져오기 실패!" + e );
        } catch (SQLException e) {
            System.out.println("JDBC 드라이버 연동 실패!" + e );
        }


    }// main end
}// class end
