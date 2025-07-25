package 종합.과제9_뚝딱마켓_설계.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    // * 싱글톤 생성
    private ConnectDB(){ }
    private static final ConnectDB instance = new ConnectDB();
    public static ConnectDB getInstance(){ return instance; }

    // * DB 연동(MySQL) 멤버변수
    private String db_url = "jdbc:mysql://localhost:3306/used";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn; // DB 연동결과 조작 인터페이스(java.sql)

    // * DB 연동(MySQL) 함수
    void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection( db_url, db_user, db_password );
            System.out.println("[안내] DB 연동 성공!" );
        }catch ( ClassNotFoundException e ){ System.out.println( "[경고] 드라이버 연동 실패!" + e );
        }catch ( SQLException e ){ System.out.println("[경고] DB 연동 실패!" + e ); }

    }// func end

}// class end
