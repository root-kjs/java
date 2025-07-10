package d09_접근제한자_32_0710.pk1;

public class A { //private
    public int 공개변수 = 1;
    private int 비공개변수 = 2;
    //(default) int 일반변수 = 3; // 아무것도 없으면
    int 일반변수 = 3;


    public static final int 상수2 = 200;

    public void 메소드(){
        A a = new A();
        System.out.println( a.공개변수 );
        System.out.println( a.비공개변수 );
        System.out.println( a.일반변수 );

    }

}
