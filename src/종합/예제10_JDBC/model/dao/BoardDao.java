package 종합.예제10_JDBC.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BoardDao {
    // 0. 싱글톤 생성
    private BoardDao(){ connectDB(); }
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance(){ return instance; }

    // 1, DB연동 정보
    private String db_url ="jbdc:mysql://localhost:3306/exam10";
    private String db_user ="root";
    private String db_password ="1234";
    private Connection conn; // Connection -> DB연동 결과를 조작하는 인터페이스, import 주의( java.sql )

    // 2. DB연동 메소드
    public void connectDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MYSQL 드라이버/클래스 불러오기
            conn = DriverManager.getConnection( db_url, db_user, db_password );
        }catch ( ClassNotFoundException e){
            System.out.println( "[경고] MYSQL 드라이버(라이브러리) 연동 실패!" + e );
        }catch ( SQLException e ){
            System.out.println( "[경고] DB서버 연동 실패!" + e );
        }
    }//func end

}// class end
