package 종합.과제7_식당대기_CSV.model.dao;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import 종합.과제7_식당대기_CSV.model.dto.WaitingDto;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class WaitingDao {
    //0. 싱글톤 생성
    private WaitingDao(){  readCSV();}
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance(){ return instance; }

    //DB ArrayList 생성
    ArrayList<WaitingDto> waitingDB = new ArrayList<>();
    
    // 3. 메소드 
    // 3-1. 등록 함수
    public boolean addBoard( String phone, int count ){
        // 리턴 초기값 설정
        boolean result = false;
        // 매개변수로 받은 인자값을 WaitingDto 객체 대입 생성
        WaitingDto waitingDto = new WaitingDto( phone, count );
        // Dto 객체를 waitingDB  추가
        waitingDB.add(waitingDto);
        return true;
    }
    // 3-2. 전체 조회 함수
    public ArrayList<WaitingDto> getBoardList(){
        return waitingDB;
    }


    // csv 파일경로 및 파일명 변수 저장, 전역변수로 저장하여 공유
    private String path = "src/종합/과제7_식당대기_CSV/waitingDB.csv";

    // 3-3. CSV 연결(불러오기/생성) 함수
    public void loadCSV(){
        // 파일 정보 객체 생성
        File file = new File( path );
        if( file.exists() ){
            writeCSV();
        }else { // csv 파일이 없으면 파일 생성
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }//func end

    // 3-4. CSV 읽기/입력 함수( CSV 파일을 열어서 자바 BoardDto에 대입 : 등록함수,전체조회 함수랑 헷갈리지 말자!!! ㅜㅜ 괜찮아.. 헷갈릴 수 있어...앞으로 헷갈리지 말쟈리. )
    public void readCSV(){
        try {
            // csv 파일을 읽는 파일리더 객체 생성
            FileReader fileReader = new FileReader( path, Charset.forName("EUC-KR"));
            // CSV리더 라이브러리 객체 생성하여 fileReader 담기
            CSVReader csvReader = new CSVReader(fileReader);
            // 자 이제 csv 파일 전체 읽는 메소드 호출하여 리스트 배열에 담자.
            // csvReader는 기본 String 타입. 행을 기준으로 스트링 배열 타입
            List<String[]> inData = csvReader.readAll(); // .readAll() 함수로 모든 CSV 정보를 읽어옴,

            for (String[] row : inData){ // 가져온  CSV 정보 리스트를 행단위로 순회
                String phone = row[0];
                int count = Integer.parseInt(row[1]); // 문자열(String)을 정수(int)로 변환하는 Java의 정적(static) 메서드
                // 자바에 넣을 DTO객체 생성
                WaitingDto waitingDto = new WaitingDto(phone,count );// 이것은 CSV 데이터를 자바 WaitingDto 에다가 넣는거얌.. 그래야 csv 정보를 자바가 읽지...
                // 사용자 입력(등록함수)랑 별개야... 정신차려...이 각박하고 복잡한 세상에서 살아남으려면...ㅜㅜ
                waitingDB.add( waitingDto );
            }// for end

        }catch ( Exception e ){
            System.out.println(e);
        }

    }// func end

    // 3-5. CSV 출력/쓰기( 출력된 자바 ArrayList를 CSV에 저장 : 함수랑 헷갈리지 말자) 함수
    public void writeCSV(){
        try {
            //파일 쓰기모드 객체 생성
            FileWriter fileWriter = new FileWriter(path);
            //CSV 라이터에 대입하여 객체 생성
            CSVWriter csvWriter = new CSVWriter( fileWriter );
            // CSV 빈 리스트 생성하여 자바 DTO 저장
            // 여기서 List는 인터페이스이고, 실제 구현체는 ArrayList<>라고 함..
            List<String[]> outData = new ArrayList<>();
            // 그럼 DB ArrayList 순회하여 outData 에 대입하여 저장// 행 단위로
            for ( WaitingDto waitingDto : waitingDB ){
                // waitingDto 각 속성값을 CSV 행 변수에 저장대입
                String[] row = { waitingDto.getPhone() , String.valueOf(waitingDto.getCount())}; //String.valueOf()으로 int 타입을 String으로 변경함.
                outData.add(row);

            }// for end
            csvWriter.close();
        }catch ( Exception e ){
            System.out.println(e);
        }

    }


}// class end
