package d10_디자인패턴_33_0711;

// 1. 싱글톤 : 딱 하나만 인스턴스 사용 : 디자인 패턴!!!!
// 사용처 :

class Controller{
    // 1.  기본 생성자 : private으로 생성자 제한을 둔다. 외부 사용 제한
    private Controller(){

    }
    //2. private statio final 이용한 정적(우선 할당) 상수 인스턴스를 하나 만든다.
    private static final Controller controller = new Controller();

    //3, getter 메소드( 싱글톤 반환)
    public static Controller getInstance(){
        return controller; // 싱글톤 인스턴스 반환
    }
}

public class Exam1 {
    public static void main(String[] args) {

        // 1. 싱글톤 불러오기
         Controller.getInstance();

    } //main end
}//class end
