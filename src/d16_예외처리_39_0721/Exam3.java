package d16_예외처리_39_0721;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exam3 {
    public static void main(String[] args) {
    /*
    [ 파일 입출력 클래스 ]
        1. 쓰기/출력/내보내기( 자바 ---> 외부 )
            FileOutputStream

        2. 읽기/입력/가져오기( 외부 ---> 자바 )
            FileInputStream
     */
    // 1. 쓰기/출력/내보내기( 자바 ---> 외부 ) : FileOutputStream

        // 패키지 > 오른쪽 > 경로/참조복사 > 컨텐츠 루트로부터의 경로(상대경로)
        // 무조건 일반예외가 무조건 발생되기 때문에 일반 예외처리를 해줘야 함.
        //  생성할 파일명도 적어줘야 함.
        String path = "./src/d16_예외처리_39_0721/test.txt";

        try{
            FileOutputStream fout = new FileOutputStream( path );
            //
            // 문자열을 바이트 배열 변환 함수 : 여기도 예외발생됨.
            fout.write("자바에서 작성한 텍스트입니다. ".getBytes()); //FileOutputStream write rksmd Bytes 지원
        }catch ( FileNotFoundException e){
            System.out.println(" 파일 또는 경로가 존재하지 않습니다. " + e );
        }catch ( IOException e1 ){
            System.out.println("입출력 도중에 오류가 발생됐습니다" + e1);
        }


        try{
            FileInputStream finput = new FileInputStream(path);
            //
            byte[] bytes = new byte[42];
            finput.read(bytes);
            System.out.println( new String( bytes )  );

        }catch ( FileNotFoundException e){
            System.out.println(" 파일 또는 경로가 존재하지 않습니다. " + e );
        }catch ( IOException e1 ){
            System.out.println("파일을 읽어오는데 문제 발생" + e1);
        }
        



    }//main end
}//class end
