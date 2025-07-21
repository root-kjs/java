package d16_예외처리_39_0721;

import java.io.File;
import java.io.FileInputStream;

public class Exam5_공공데이터 {
    public static void main(String[] args) {
        // 공공데이터포털에서 CSV 파일 다루기 : 인천광역시 부평구_맛있는 집(맛집) 현황
        // https://www.data.go.kr/data/15103411/fileData.do
        // CSV란? 데이터들 간의 속성을 (쉼표)구분하고 행간의 \n 으로 구분한다.

    try {
        // 1. 파일의 존재 여부 확인
        String path = "src/d16_예외처리_39_0721/restaurant.csv"; // 2. 파일명 경로 변수 선언
        File file = new File( path ); // 3. 파일정보 객체 생성
        System.out.println( file.exists()); //  4. 파일 존재 여부 확인

        if ( file.exists() ){ // 5. 파일이 존재하면
            FileInputStream fin = new FileInputStream( path ); // 6. 파일 입력(읽기) 객체 생성
            byte[] inByte = new byte[ (int)file.length() ];  // 7. 해당 파일을 배열 용량만큼 바이트로 선언
            fin.read( inByte ); // 8. 파일 입력(읽기) 객체 바이트를 읽자
            String str1 = new String( inByte , "EUC-KR" ); //  9. 바이트를 스트링으로 변환하고 인코딩을 한국어로 변환
            System.out.println( str1 ); // 10.스트링으로 변환된 파일 출력
            // ★★★★★★ 11. csv 분해하기
            // 열(속성) 구분 ---> ,(쉼표)   /  행 구분 ----> n\
            // 문자열 함수: .split( "구분문자" ); --> 지정한 구분문자 기준으로 쪼개서 배열로 반환하는 함수(라이브러리)
            System.out.println(str1.split("\n") );  // qodufdl todtjdehla. 
            System.out.println(str1.split("\n")[0] );  // 배열 인덱스 --> 첫 행
            System.out.println(str1.split("\n")[1].split(",")[0] );  // 배열 인덱스 --> 두번째 행, 첫번째 열
            String[] 행데이터 = str1.split("\n"); // 행 단위로 쪼개서 배열에[ 저장

            for( int i = 0; i < 행데이터.length; i++  ){
                String row = 행데이터[i]; // 행 단위
               // System.out.println( row );
                // 엑셀 안의 데이터에 쉼표가 있거나 \n이 거나 다르 ㄴ데이터가 들어가져 있는 경우 유효성 검사가 필요하다. 
                String[] 열데이터 = row.split(","); // 열단위
//                System.out.print( "---------"+열데이터[1] );
//                System.out.println( ": "+열데이터[3] );
                System.out.println("-----------------------------------------------");
                System.out.printf("업소명: %s / 주메뉴: %s\n" ,열데이터[1], 열데이터[3] );
                //System.out.println("-----------------------------------------------");
            } // for end


        } // if end


    }catch ( Exception e ){
        System.out.println("예외발생" + e );
    }

        
    }// main end
}// class end
