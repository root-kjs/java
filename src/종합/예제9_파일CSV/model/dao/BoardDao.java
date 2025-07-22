package 종합.예제9_파일CSV.model.dao;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import 종합.예제9_파일CSV.model.dto.BoardDto;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
    //0. 싱글톤 생성 : 지정한 클래스 내 유일한 객체생성
    private BoardDao(){
        // 싱글톤 생성시 csv로드(오픈)
        openCSV();
    }
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance(){
        return instance;
    }

    // DB 대신할 ArrayList<> 선언
    // ArrayList는 기본적으로 어떤 타입이든 넣을 수 있지만, 제네릭을 지정하면 특정 타입만 넣도록 제한함.
    ArrayList<BoardDto> boardDB = new ArrayList<>();

    // 3. 메소드
    // 3-1. 등록(글쓰기) 함수
    public boolean boardWrite( BoardDto boardDto ){
        // 반환값 : boolean
        // 매개변수 :  BoardDto boardDto

        boardDB.add( boardDto ); // 리스트(boardDB)에 DTO 저장
        // csv 재저장
        saveCSV();
        return true;
    }// func end
    
    // 3-2. 전체 조회
    public ArrayList<BoardDto> boardPrint( ){
        // 반환값 : boardDB
        // 매개변수 : 없음

        return boardDB;
    }// func end

    
    //  3-3. CSV 파일연동 ------------------------------
    
    private String path = "src/종합/예제9_파일CSV/data.csv"; // csv 파일 경로 설정
    public void openCSV(){
        File file = new File( path ); // 파일 객체 생성
        if ( file.exists() ){
            loadCSV();
        }else { // 파일 없으면 파일 생성

            try {
                file.createNewFile(); // 파일 생성
            } catch (IOException e) {
                System.out.println( e );
            }
        }
    }// func end

    // 3-4. CSV 입력함수(호출/읽기) ------------------------------
    public void loadCSV(){
        try {
            FileReader fileReader = new FileReader( path );
            CSVReader csvReader = new CSVReader(fileReader);
            List<String[]> inData = csvReader.readAll(); // .readAll() 함수로 바이트가 아닌 String으로 바로 읽어온다
            for (String[] row : inData) {
                String content = row[0];
                String writer = row[1];
                BoardDto boardDto = new BoardDto(content, writer);
                boardDB.add(boardDto);
            }// for end

            // csvReader를 안전하게 닫기 --> 메모리 누수를 방지.
            // 파일 객체는 자동 초기화보다 직접 초기화가 안전하다. 용량이 크기 때문에 직접 닫는게 안전!
            csvReader.close();
        }catch (Exception e){
            System.out.println( e );
        }

    }// func end



    //  3-5. CSV 출력함수(저장/쓰기모드) ------------------------------
    public void saveCSV(){
        try {
            // 1. FileWriter(쓰기모드) 객체 생성
            FileWriter fileWriter = new FileWriter( path );
            CSVWriter csvWriter = new CSVWriter( fileWriter );
            //  List 인터페이스 , ArrayList 구현체
            List<String[]> outData = new ArrayList<>();

            for ( BoardDto boardDto : boardDB ){
                String[] row = { boardDto.getContent(), boardDto.getWriter() };
                outData.add(row);

            }// for end
            csvWriter.writeAll( outData );
            csvWriter.close();

        }catch (Exception e){
            System.out.println(e);
        }
    }// func end
    
}//class end
