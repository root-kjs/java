package d18_JDBC_41_0723;

public class AppStart {
    public static void main(String[] args) {

        UserDao userDao = UserDao.getInstance();

        userDao.userInsert2( "강호동",30 );
        userDao.userInsert2( "신동엽",60 );
        userDao.userSelect( );

    }//main endq
}// class end
