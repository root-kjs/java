package d11_ArrayList_24_0714;
/*[JAVA] 실습11 : ArrayList 클래스 250714(월)
[ 문제 ] 아래 ArrayList 관련 문제를 해결하시오.
[ 제출방법 ] 코드가 작성된 파일이 위치한 깃허브 상세 주소를 제출하시오.
*/
import d09_접근제한자_32_0710.pk1.A;

import java.util.ArrayList;
import java.util.Scanner;

public class 실습11_ArrayList {

    public static void main(String[] args) {
    //[문제 1] String 타입의 요소를 저장할 수 있는 ArrayList를 nameList 라는 이름으로 생성하세요.
    //1. .add() 메소드를 사용하여 "유재석", "강호동", "신동엽" 세 개의 이름을 리스트에 추가하세요.
    //2. 리스트의 모든 요소를 System.out.println()으로 한 번에 출력하세요.
        ArrayList<String> nameList = new ArrayList<>();

        nameList.add("유재석");
        nameList.add("강호동");
        nameList.add("신동엽");

        System.out.println( nameList );

//[문제 2] 다음과 같이 초기화된 ArrayList가 있습니다.
//1. ArrayList<String> fruits = new ArrayList<>();
//2. fruits.add("사과"); fruits.add("바나나"); fruits.add("딸기");
//3. 일반 for문을 사용하여, 각 인덱스와 해당 인덱스의 요소를 "인덱스 0: 사과" 형식으로 모두 출력하세요.

        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("사과"); fruits.add("바나나"); fruits.add("딸기");
        
        for ( int i =0; i < fruits.size(); i++ ){
            String fruit = fruits.get(i);
            System.out.println("인덱스 "+ i + " : " + fruit);
            
        } // for end

//[문제 3] 문제 3의 fruits 리스트를 사용합니다.
//1. 향상된 for문 을 사용하여 리스트의 모든 요소를 하나씩 출력하세요.


        for ( String fruit : fruits ){
            System.out.println( fruit );
        } //for end


//[문제 4] "A", "B", "C", "D", "E"를 요소로 가지는 ArrayList를 생성하세요.
//1. .remove() 메소드를 사용하여 2번 인덱스의 요소("C")를 삭제하세요.
//2. 삭제 후의 리스트 전체를 출력하여 결과가 올바른지 확인하세요.

        ArrayList<String> abc = new ArrayList<>();
        abc.add( "A" );abc.add( "B" );abc.add( "C" ); abc.add( "D" ); abc.add( "E" );
        abc.remove( 2 );
        System.out.println( abc );

//[문제 5] "자바", "파이썬", "C++"를 요소로 가지는 ArrayList를 생성하세요.
//1. .add(인덱스, 요소) 메소드를 사용하여 1번 인덱스에 "자바스크립트"를 삽입하세요.
//2. 삽입 후의 리스트 전체를 출력하여 순서가 올바르게 변경되었는지 확인하세요.

       ArrayList<String> str2 = new ArrayList<>();
       str2.add("자바"); str2.add("파이썬"); str2.add("C++"); // ArrayList  생성 후 꼭 요소를 삽입할 것!
       str2.add( 1, "자바스크립트" );
       System.out.println( str2 );


//[문제 6] title(문자열)과 author(문자열) 멤버 변수를 가진 Book 클래스를 만드세요.
//1. Book 객체를 저장할 수 있는 ArrayList를 library 라는 이름으로 생성하세요.
//2. new Book(...)을 사용하여 3권의 책 객체를 생성하고 library 리스트에 추가하세요.
//3. 향상된 for문을 사용하여 library에 저장된 모든 책의 제목과 저자를 출력하세요.

        ArrayList<Book> library = new ArrayList<>();

        Book b1 = new Book("책1", "저자1");
        Book b2 = new Book("책2", "저자2");
        Book b3 = new Book("책3", "저자3");

        library.add( b1 ); library.add( b2 ); library.add( b3 );

        for( Book book :library ){
            System.out.println( book.getTitle() +" / "+ book.getAuthor() );

        }

//[문제 7] Scanner를 사용하여 사용자로부터 문자열을 계속해서 입력받습니다.
//1. 입력받은 문자열은 ArrayList에 순서대로 저장합니다.
//2. 만약 사용자가 "종료" 라는 단어를 입력하면, 입력을 멈추고 그때까지 리스트에 저장된 모든 내용을 출력한 뒤 프로그램을 종료하세요.

        Scanner scan = new Scanner(System.in);
        ArrayList<String> arrayList1 = new ArrayList<>(); // 포문 밖에 있어야 누적이 된다네!!
        for(;;){ //Scanner를 사용하여 사용자로부터 문자열을 계속해서 입력받습니다.
            System.out.print( "문자입력 : " );
            String str = scan.next();

            arrayList1.add(str);
            if( str.equals("종료") ){
                System.out.println( arrayList1 );
                break;
            } // if end

        } // 무한루프 end.

//[문제 8] "국어", "수학", "사회", "과학"을 요소로 가지는 ArrayList를 생성하세요.
//1. .set(인덱스, 요소) 메소드를 사용하여 1번 인덱스의 "수학"을 "영어"로 수정하세요.
//2. 수정 후의 리스트 전체를 출력하여 결과가 올바른지 확인하세요.

        ArrayList<String> study = new ArrayList<>();
        study.add( "국어" ); study.add( "수학" ); study.add( "사회" ); study.add( "과학" );
        study.set( 1,"영어" );
        System.out.println( study );


    } // main end
} // class end

class Book{
    //1. 멤버 변수
    private String title; // 멤버 변수는 무조건 priva
    private String author;
    
    // 2. 생성자
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // 3. 메소드(getter/setter)

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
} // class end
