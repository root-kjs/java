package d16_예외처리_39_0721;

import java.io.*;
import java.util.Scanner;

//[JAVA] 실습15 : 파일 처리 (개정판) 250721(월)
//[ 문제 ] 아래 파일 처리 관련 문제를 해결하시오.
//[ 제출방법 ] 코드가 작성된 파일이 위치한 깃허브 상세 주소를 제출하시오.
public class 실습15_예외처리 {
    public static void main(String[] args) {
//[문제 1] 파일에 일기 쓰기
//1. FileOutputStream을 사용하여 src 폴더 내에 src/diary.txt 파일을 생성하세요.
//2. "오늘 날씨는 맑았다. 자바 공부는 재미있다." 라는 문자열을 바이트로 변환하여 파일에 쓰세요.
//3. try-catch를 사용하여 예외 처리하세요.

    try {
        // 1, 파일명 및 경로 변수 선언
        String path = "src/d16_예외처리_39_0721/diary.txt";
        FileOutputStream fout = new FileOutputStream(path); // 일반예외는 빨간줄 나오닌 반드시 예외처리 필수!

        //  .getBytes()로 변환해서 write 파일로 내보내기
        fout.write("오늘 날씨는 맑았다. 자바 공부는 재미있다.".getBytes());
    } catch ( FileNotFoundException e){
        System.out.println("[예외발생]파일 또는 경로가 존재하지 않습니다." + e);
    } catch ( IOException e1 ){
        System.out.println("[예외발생]입출력 도중에 오류가 발생됐습니다" + e1);
    } // FileOutputStream --> 이 아이는 기본 일반 예외처리 2개 셋트!

//[문제 2] 파일에 작성된 일기 읽기
//1. FileInputStream을 사용하여 문제 1에서 생성한 src/diary.txt 파일을 읽어오세요.
//2. 읽어온 바이트 데이터를 String으로 변환하여 콘솔에 출력하세요.

    try {
        String path = "src/d16_예외처리_39_0721/diary.txt";
        FileInputStream fin = new FileInputStream(path);

       // byte[] inByte = new byte[(int)path.length()]; // 파일의 타입을  바이트 배열 int 로 강제 형변환한 다음에 해당 용량만큼을 바이트 배열의 객체로 선언 // 파일 정보 객체가 아니라 인코딩이 깨지는 거 가틈..
        // 입력한 바이트수 계산해서 배열 크기 지정한다. 노가다네...ㅡㅡ
        // 한글 3 바이트 // 아스키 1byte
        // 17*3 = 51 + 7 = 58
        byte[] inByte = new byte[ 58 ];
        // read 하기전에 해당 파일을 바이트 배열로 변경해야 FileInputStream 객체가 읽기 가능
        fin.read(inByte); // FileInputStream -->  이 아이는 기본 일반예외처리 필수 2개
        System.out.println(  fin.read(inByte) ); // 바이트 수가 나올테니...String으로 변환
        String str = new String( inByte, "UTF-8"  );
        System.out.println( str );

    }catch ( FileNotFoundException e ){
        System.out.println("[예외발생]파일 또는 경로가 존재하지 않습니다." + e);
    }catch ( IOException e1 ){
        System.out.println("[예외발생]입출력 도중에 오류가 발생됐습니다" + e1);
    }

//[문제 3] File 클래스로 파일 정보 확인하기
//1. File 객체를 src/diary.txt 경로로 생성하세요.
//2. .exists(), .getPath(), .getName(), .length() 메소드를 각각 사용하여 해당 파일의 존재 여부, 경로, 이름, 크기(바이트)를 출력하세요.

    try {
        String path = "src/d16_예외처리_39_0721/diary.txt";
        File file = new File( path );
        System.out.println( file.exists() ); // 파일 존재 유무 확인 true/false
        System.out.println( file.getPath() ); // 파일 경로 출력
        System.out.println( file.getName() ); // 파일명 확인
        System.out.println( file.length() ); // 파일용량(byte) 확인
    }catch (Exception e){
        System.out.println("예외발생" + e );
    }


//[문제 4] 방문 로그 누적 기록하기_250722(화)선생님 내용 확인 후 수정_문제가 요구한 것을 상세히 확인 할 것! --> 틀림
        // 기존 파일 읽은 다음에 기록--> 그래야 누적이 됨
//1. FileOutputStream을 사용하여 src/visit_log.txt 파일을 여세요.
//2. Scanner로 방문자 이름을 입력받아, "OOO님이 방문했습니다.\n" 형식의 문자열을 visit_log.txt 파일의 기존 내용 뒤에 추가하세요.
//3. 프로그램을 여러 번 실행하여 방문 기록이 계속 누적되는지 확인하세요.
        Scanner scan = new Scanner(System.in);
        try {

            System.out.print("방문자 이름 입력 : ");
            String str = scan.next();


            String strLog = str + "님이 방문했습니다.\n";

            // 입력받은 String을 파일에 저장할 수 있는 바이트로 변환
            // 입력받은 문자열을 바이트 변환 , 왜?  FileOutputStream은 바이트 만 쓰기/읽기 가능하다.

            String path = "src/d16_예외처리_39_0721/visit_log.txt";
            File file = new File(path);
            byte[] outBytes = strLog.getBytes();
            if( file.exists() ) {

                // 방안 2. 파일을 내보낼때 계속 붙여쓰기 가능
                FileOutputStream fout = new FileOutputStream(path , true );
                //FileOutputStream 객체를 바이트로 변환한 outBytes을 .write() 파일로 내보낸다.,
                fout.write(outBytes);
            }// if end
        }catch ( Exception e ){
            System.out.println("예외발생" + e );
        }

//[문제 5] 연락처를 CSV 형식으로 파일에 저장하기
//1. Scanner를 사용하여 사용자로부터 이름, 전화번호, 사는 도시를 순서대로 입력받으세요.
//2. 입력받은 데이터들을 쉼표(,)로 연결하여 하나의 String으로 만드세요. (예: "유재석,010-1234-5678,서울")
//3. 해당 문자열을 contacts.csv 파일에 저장하세요. (줄바꿈 문자 \n 포함)

//        파일을 생성하자. FileOutputStream
        //"스트림"은 일반적으로 데이터, 특히 오디오나 비디오와 같은 미디어를 네트워크를 통해 실시간으로 전송하는 기술을 의미합니다. 줄여서 "스밍"이라고도 합니다. 또한, 데이터의 흐름이나 연속적인 데이터 열을 의미하기도 하며, 프로그래밍에서는 데이터 처리 과정에서 연속적인 데이터 흐름을 다루는 개념으로 사용됩니다. 
        // FileOutputStream  이 아이는 기본적으로 일반예외처리 필수 
        // 통합 예외 슈퍼 예외처리 클래스로 사용하자...귀찮아...
        
        try {
            // 아래 내용 어차피 파일이 없음며
            System.out.print("이름 : ");
            String name = scan.next();
            System.out.print("전화번호 : ");
            String phone = scan.next();
            System.out.print("사는 도시 : ");
            String city = scan.next();
            String profile = new String( name + "," + phone + "," + city +"\n" );
            System.out.println( profile );

            String path = "src/d16_예외처리_39_0721/contacts.csv";
            File file = new File( path );  // 파일 정보 객체 선언


                // FileOutputStream 객체 생성
                FileOutputStream fout = new FileOutputStream( path );

                // 스트링을 파일 변환할 수 있는 바이트 배열 객체 변환, 파일 용량만큼 배열 int 강제 형변환,
                // 아하 아래 소스는 그냥 문자열을 바이트로 변환한거고...스트링을 바이트로 변환한게 없었댜리... 내용이 안나온 이유 : 입력받은 문자열을 .getBytes() 변환
               // byte[] outByte = new byte[ (int)profile.length() ];
               // fout.write( outByte );
                fout.write(  profile.getBytes() );

                //System.out.println( file.exists() ); //  이건 파일 정보 객체이지 파일이 생성된것은 아니니 false

        }catch ( Exception e ){
            System.out.println("예외발생" + e );
        }


//[문제 6] 영화 감상평을 파일에 저장하기
//1. Scanner를 사용하여 사용자로부터 좋아하는 영화 제목과 감상평을 한 줄로 입력받으세요.
//2. 입력받은 내용을 src 폴더 내의 src/movie_review.txt 파일에 저장하세요.


            try {
                System.out.print("영화 제목 : ");
                String movie = scan.next();
                System.out.print("감상평 : ");
                String review = scan.next();

                String rowMovie = new String( movie + " "+ review );
                // 문자열을 바이트로 변환

                // 파일 스트림 객체 생성
                String path = "src/d16_예외처리_39_0721/movie_review.txt";
                FileOutputStream fout = new FileOutputStream( path );
                fout.write( rowMovie.getBytes());




            }catch ( Exception e ){
                System.out.println("예외발생" + e );
            }

//[문제 7] 저장된 감상평 파일 읽기
//1. 문제 3에서 생성된 src/movie_review.txt 파일의 내용을 읽어오세요.
//2. File 클래스의 .length()를 사용하여 파일 크기만큼 바이트 배열을 선언하고, 파일 전체를 한 번에 읽어오세요.
//3. 읽어온 내용을 콘솔에 출력하세요.
//    [ 스트림 ] 컴퓨터내 데이터/자료 가 다니는 통로
//    * 데이터 가 다니는 통로인 스트림은 *바이트 단위* 이동
//    * 영문/특수문자 1글자당 : 1바이트 , 한글 1글자당: 3바이트

        try {
            String path = "src/d16_예외처리_39_0721/movie_review.txt";
            File file = new File( path );

            System.out.println( file.exists() );
            // 파일이 있다면  파일 용량만큼 해당 문자열 바이트 배열로 변환

            if( file.exists() ){
                byte[] inByte = new byte[ (int)file.length() ];
                // 파일 읽기 스트림 객체 생성 하기 전 파일정보 객체 먼저 만들어서 쉽게 가공하자..
                FileInputStream fin = new FileInputStream( path );
                fin.read( inByte ); // 이것은 스트림 바이트이니 읽으려면 문자열로 다시 변환해줘야 함.
                String mStr = new String( inByte );
                //  파일 내 문자열 콘솔 출력 고고..
                System.out.println( mStr );

            }

        }catch ( Exception e ){
            System.out.println("예외발생" + e );
        }


//[문제 8] 공공데이터 CSV 파일 읽고 분석하기
//1. **공공데이터포털(data.go.kr)**에서 '부평구_인구현황'을 검색하여 CSV 파일을 다운로드하고, src 폴더에 bupyeong_population.csv 라는 이름으로 저장하세요.
//2. FileInputStream을 사용하여 해당 파일을 읽어오세요. (주의: 한글 깨짐 방지를 위해 new String(bytes, "EUC-KR") 사용)
//3. 읽어온 전체 내용을 줄바꿈(\n) 기준으로 분리하여 String 배열에 저장하세요.
//4. for문을 사용하여 배열의 각 줄(각 동의 인구 정보)을 순회하며, '행정기관'과 '총인구수'만 추출하여 "동별: [ 동별 ], 총 인구: [ 인구수(계)   ]명" 형식으로 출력하세요.

        try {
            String path = "src/d16_예외처리_39_0721/bupyeong_population.csv";
            File file = new File(path );
            if( file.exists() ) {// 파일이 있다면 코드 실행..
                // FileInputStream  객체  생성
                FileInputStream fin = new FileInputStream(path);
                // 파일 용량만큼 스트림을 위한 바이트 배열로 변환하기 전에 파일 정보 객체 생성
                byte[] inbyte = new byte[(int) file.length()];
                // 자 읽기는 바이트만 가능하다고 스트림.
                fin.read( inbyte );
                // 바이트를 문자열로 변환할때 인코딩을 맞춰준다.
                String str = new String( inbyte, "EUC-KR" );
                System.out.println( str ); // csv 파일 콘솔 출력 확인
                // 읽어온 전체 내용을 줄바꿈(\n) 기준으로 분리하여 String 배열에 저장하세요.

                // String str --> String 배열로 먼저 바꿔줘야 한다.
                // csv  .split() 쪼개기 :  행은 \n, 열은 ,(쉼표)
                String[] strRow =  str.split("\n");
                //System.out.println( strRow );
                // strRow 포문 돌려서 열 속석 추출
                for( int i = 0; i < strRow.length; i++){
                    String row = strRow[i]; //  행 나누기
                    String[] colm = row.split(","); // 행데이터 배열 만들기
                    // 자 이제 출력 고고
                    System.out.printf( "동별: %s / 총인구수: %s 명\n ", colm[0], colm[1] );
                }
            }
        }catch ( Exception e ){
            System.out.println("예외발생" + e );
        }


    }// main end
}// class end