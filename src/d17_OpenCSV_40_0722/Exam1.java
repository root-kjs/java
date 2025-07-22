package d17_OpenCSV_40_0722;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.List;

public class Exam1 {
    public static void main(String[] args) {

    /* 각종 자바 관련 라이브러리 공유 :   https://mvnrepository.com
    
     */
    // OpenCSV 라이브러리 사용하기 : 셀 안에 ,(쉼표)가 있는 경우 알아서 제외해줌""(큰 따옴표 안의 ,(쉼표)는 .split() 하면 안됨. 해당 유효성 검사를 OpenCSV 라이브러리가 처리 해줌)
        // AI 사용하면 버전 조심할 것!
        // 처음 시작할 경우에는 왠만하면 최신 버전 사용...나중에 시간이 지나니까...ㅠ
        // new CSVReader( new FileReader( 파일경로 ) ) --> CSV 읽어오는
        // .readAll() --> 데이터를 List<String[]> 타입으로 반환하는 함수
        

        
    try { // 예외처리 필수
        // 1. 파일 경로 지정
        String path = "src/d17_OpenCSV_40_0722/restaurant.csv";

        // 2, 파일 읽기모드 객체 생성(자바) , 예외처리, 한글 인코딩
        FileReader fileReader = new FileReader( path , Charset.forName("EUC-KR"));

        // 3. CSVReader 클래스 이용한 file 읽어오기
        // CSVWriter : CSV 출력하는 클래스(외부 라이브러리)
        CSVReader csvReader = new CSVReader( fileReader );

        // 4. .readAll() : List<String[]>  --> ArrayList 구현체
        // List<> --> 인터페이스
        List<String[]> inData = csvReader.readAll();
        System.out.println( inData );

        //5. 반복문 순회

        for( int i = 0; i  < inData.size(); i++){
            String[] row = inData.get(i);
            System.out.printf("업소명: %s | 메뉴: %s \n",row[1], row[3] );
        }


    } catch ( Exception e ){
        System.out.println("예외발생 " + e);
    }
    


        

    }//main end
}// class end
