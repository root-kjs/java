package d17_OpenCSV_40_0722;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

// Data Access Object : 데이터(DB/파일) 접근 객체
public class Dao {
    // 0. 싱글톤 생성
    private Dao(){
        connectDB(); // Dao 객체가 생성될 때 동시에 DB연동 함수 실행!
    }
    private static final Dao instance = new Dao();
    public static Dao getInstance(){ return instance; }

    // 1. DB 연동에 필요한 정보
    private String db_url = "jdbc:mysql://localhost:3306/mydb0722";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn; //DB 연동 결과를 갖는 인터페이스

    // 3. 메소드
    // 3-1. DB 연동하기
    public void connectDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // mysql 드라이버/클래스 로드 함수
            conn = DriverManager.getConnection( db_url , db_user , db_password );
            System.out.println(" DB 연동 성공!");
        }catch ( ClassNotFoundException e ){
            System.out.println("[경고] mysql 드라이버 연동 실패");
        }catch ( SQLException e ){
            System.out.println("[경고] DB 연동 실패");
        }
        
    }// func end




}// class end
