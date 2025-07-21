package d16_예외처리_39_0721;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Exam4 {
    public static void main(String[] args) {
        /*

         */

        try {
            // 예제1) 키보드로부터 입력받은 값을 텍스트 저장
            Scanner scan = new Scanner(System.in);
            System.out.print("저장할 내용 : ");
            String str1 = scan.next();
            // 저장할 파일 경로
            String path ="src/d16_예외처리_39_0721/test2.txt";
            // 파일에 쓰기 객체 생성, 일반예외 처리
            FileOutputStream fout = new FileOutputStream( path );
            // 입력받은 문자열 바이트 배열로 전환
            // Stream은 바이트로만 읽기, 쓰기가 가능하다.
            byte[] outByte = str1.getBytes();
            //변환된 바이트를 내보내기
            fout.write( outByte );
            
            // 예제2) 파일로부터 텍스트를 호출
            // 파일정보를 알려주는 클래스
            // File 클래스 : 지정한 파일의 정보를 제공하는 객체
            File file = new File( path ); //
            System.out.println( file.isFile() ); // 파일의 경로( 존재 )여부 반환  true/false
            System.out.println( file.getName() ); // 파일의 이름을 반환하는 함수
            System.out.println( file.length() ); // 파일의 용량을(Byte) 반환하는 함수
            System.out.println( file.exists() ); // 파일의 존재여부 반환하는 함수 true/false

                                // file.createNewFile(); // 지정한 경로에 파일 생성 함수
                                // file.delete(); // 파일 삭제
            
            // 2) 파일이 존재할 경우 파일 내용 읽어오기
            if( file.exists() ){
                // 파일 입력 객체
                FileInputStream fin = new FileInputStream( path );
                // 읽어온 바이트를 저장할 바이트 배열 객체 선언
                // long으로 들어올 수 있는데 배열길이는 int만 가능해서 강제 형변환
                byte[] inByte = new byte[ (int)file.length() ]; // )file.length() --> 파일의 용량
                fin.read( inByte );
                String inStr = new String( inByte );
                System.out.println(inStr );
                
            }// if end

        }catch ( Exception e ){
            System.out.println("예외발생" + e );
        }



    }//main end
}//class end
