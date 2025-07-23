package d18_JDBC_41_0723;


import java.sql.*;

//JDBC 연동
public class UserDao {

    private UserDao(){
        connectDB();// 싱글톤 생성시
    }
    private static final UserDao instance = new UserDao();
    public static UserDao getInstance(){
        return instance;
    }

    // 싱글톤 : 프로그램 내 유일(싱글) 객체(톤)
    // ---> 주로 MVC패턴에서 싱글톤 사용하는 레이어(계층): view/controller/dao
    // ---> 기능을 처리하는 역할이라 거의 멤버변수가 없고 기능 관련이 많다, 메소드위주 기능은 재사용(공유) 가능하니 1개만 가지고 있어도 된다.
    // ---> 스프링 프레임워크에서는 싱글톤 위주로 개발이 진행된다. 무조건! 디자인 패턴을 강제 주입!
    // ---> DTO(데이터 이동 객체) : 멤버 변수 위주 에서는 싱글톤 사용하지 않음 --> 데이터는 1개만 존재하는 게 아니라 여러개 존재하고 여러개 데이터를 이동해야 하니까.
    // 관례적인 MVC 패턴에서의 용어 DAO : Data(주로 DB) Access Object
    
    // ★☆★☆ 데이터베이스 연동 코드(함수)

    // 1) MYSQL 드라이버/클래스 불러오기
    private String db_url ="jdbc:mysql://localhost:3306/mydb0723"; // 연동할 DB서버의 주소 jdbc:mysql://ip번호:port번호/DB명, 3306 --> mysql 사용관련 port
    private String db_user ="root";                                // DB서버의 계정명
    private String db_password ="1234";                            // DB서버의 비밀번호
    private Connection conn;  // DB연동 결과를 조작하는 인터페이스(java.sql)

    public void connectDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // 일반예외 발생
            conn = DriverManager.getConnection( db_url, db_user, db_password ); // Connection 자체가 정적 클래스라
            System.out.println(" MYSQL 서버 연동 성공!" );
        }catch ( ClassNotFoundException e ){
            System.out.println("[경고] MYSQL 라이브러리 로드 실패" + e ); // 라이브러리 연동 및 오타 문제
        }catch ( SQLException e ){
            System.out.println("[경고] MYSQL 서버 연동 실패" + e ); // 외부통신 할때는 DB 문제일 수도 있어서 일반 예외처리 대비, 대부분의 사유는 오타나 진짜 DB가 없는 경우임.
        }
    }// func end

    public boolean userInsert(){
        try{
            // 1.SQL 작성 : mysql 워크벤치 키고 작업 할 것(기본 SQL 문법)
            String sql = "insert into user( uname, uage ) values ( '유재석', 40 );";
            // 2.SQL 기재 : PreparedStatement --> SQL 문을 실행하기 위한 인터페이스
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3 SQL 실행 --> 보통 처리결과를 count(int)로 많이 사용한다.
            int count = ps.executeUpdate();

            // 4.SQL 결과에 따른 확인로직/리턴
            System.out.println( count );
            if( count >= 1  ) return true;
            else return false; // 실패

        }catch (Exception e){
            System.out.println(e);
        }
        return false; // func end
    }// func end

// 2) 
    public boolean userInsert2( String uname , int uage ){
        try {
            // 1. SQL 작성
            String sql = "insert into user(uname , uage) values(?,?)";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입하기 ( set : 저장 / get : 호출 )
                //  ps.setXXX (?번호 , 값 )==> XXXX -> 타입 / ? 에 값 대입
            ps.setString( 1, uname ); // SQL 1번째 물음표에 String 타입으로 대입!
            ps.setInt(2, uage );// SQL 2번째 물음표에 int 타입으로 대입!
            // 4. SQL 실행
            int count = ps.executeUpdate();
            // 5.SQL 결과에 따른 확인로직/리턴
            if( count >= 1 ) return true;
            else return false; // 결과가 1 미만이면 실패!

        }catch ( Exception e ){
            System.out.println( "예외 발생" + e );
        }
        return false; // 예외(catch) 발생되면 실패!
    }// func end
    
// 3) 
    public void userSelect(){
        try {
            // 1. SQL 작성
            String sql = "select * from user;";

            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);

            // 3. SQL 매개변수 대입

            // 4. SQL 실행
            // insert/update/delete --> 레코드 처리개수(int) -->


            // 레코드 조회(테이블)
            ResultSet rs = ps.executeQuery(); // 테이블 조회결과 조작 인터페이스, import주의(java.sql)!!!
            
            /* 5,  확인용
            int 행번호 = 0;
            while( rs.next() ){ // 조회결과를 하나씩 행(레코드)단위로 이동 조회하는 함수, 다음 레코드가 존재 하지 않을 때까지 반복!
                System.out.println( ++행번호 ) ;
                System.out.println( rs.getInt("uno"));
                System.out.println( rs.getString("uname"));
                System.out.println( rs.getInt("uage"));
            }*/

            while( rs.next() ){ // 조회결과를 하나씩 행(레코드)단위로 이동 조회하는 함수, 다음 레코드가 존재 하지 않을 때까지 반복!
                //
                System.out.printf( "번호: %d, 이름: %s, 나이: %d \n",
                        rs.getInt(1), // 첫번째 열(속성/칼럼)의 값 반환
                        rs.getString(2),
                        rs.getInt(3) );
                // DB의 행/열 값을 자바의 리스트(객체)로 전달해야 함.

                // 자바 : DB 레코드(행) 1개 --> DTO(객체) 1개. 여러개 행 ==> 리스트, 배열

            }
            
        }catch ( Exception e ){
            System.out.println("예외발생" + e );
        }
        
        
        
        
    }    
    
    

}// class end
