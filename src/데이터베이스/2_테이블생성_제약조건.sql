-- 250715(화) day2
-- 데이터베이스는 여러개의 테이블(표)를 저장 할 수 있다.
-- DB(데이터베이스) 생성
create database mydb0715;
-- 활성화
use mydb0715;
-- 테이블 생성( 필드 생성 ); 
create table test1( 필드명 int );
-- 현재 활성화된 데이터베이스의 테이블 목록 조회
show tables;
-- 2개 이상의 속성을 정의할 때 , (쉼표)로 구분한다.
create table test2(  필드명1 int, 필드명2 double ); 
-- 현재 활성화된 데이터베이스 내 테이블 삭제
drop table test1;
-- 만약에 테이블이 존재하면 삭제(안전한 삭제)
drop table if exists test1;
 -- drop table if exists test3;
-- MYSQL 데이터 타입
create table test3( # 테이블 정의 시작
정수필드1 tinyint , 정수필드2 smallint , 정수필드3 mediumint , 
정수필드4 int , 	정수필드5 bigint , 정수필드6 int unsigned , 
실수필드1 float , 실수필드2 double , 실수필드3 decimal, 
날짜필드1 date , 날짜필드2 time , 날짜시간3 datetime , 
문자필드1 char(3) , 문자필드2 varchar(3) , 문자필드3 text , 문자필드4 longtext , 
논리필드1 bool
);
 show tables;
 -- 테이블 조회
 select * from test3;
 
 # 예제1) 방문록 기록하는 테이블 설계
 create table board(
	content longtext , # 게시물의 내용(대용량) private String content
    writer varchar(30) # 게시물 작성자 private String writer
 );
 select * from board;
 
 # 예제2) 대기번호 발급 테이블 생성(속성)
 create table waiting(
	phone char(13),  # 휴대폰 번호(문자열 첫글자가 0이예용...), 고정길이 13자, private String phone
    count tinyint    # 인원수 최대 100 정도 private byte count
 );
 select * from waiting;
 
 # 제약조건을 이용한 테이블 설계
 -- 목적 : 테이블 간의 문제와 결함이 되는 사전 입력방지/해결
 
 create table test4(
	#필드명 타입 제약조건
    필드명1 tinyint not null , -- 지정한 속성에는 null을 대입할 수 없게 제약조건을 설정
    필드명2 smallint unique , -- 해당 속성에는 중복값을 저장할 수 없게 설정
    필드명3 int default 10 , -- 지정한 속성의 값이 생략될 때, 자동으로 10 기본값으로 설정됨
    필드명4 bigint auto_increment , -- 지정한 속서의 값이 생랴될때 자동으로 순서번호 설정됨 1,2,3,4,5
    -- *** auto_increment pk랑 같이 사용해야 에러가 안난다. 
    constraint primary key( 필드명4 ) -- "필드명4" 속성을 PK 필드로 설정
 );
 
 select * from test4; # 테이블 조회
 
 -- foreign key
 create table test5(
	필드명1 bigint , -- 필드 속성 지정
    constraint foreign key( 필드명1 ) references test4( 필드명4 ) 
    -- test5의 "필드명1"을 FK 필드로 설정하고 test4테이블 "필드명4" 속성의 PK를 참조한다. 
 );
 
 # 예제3) 회원제 게시판 DB 설계하시오.
drop database if exists boardService0715; -- 새로 만들 데이터베이스가 있다면 삭제
create database boardService0715;
use boardService0715;
create table member( #. [1] 회원 테이블
	mno int auto_increment , 			-- 회원번호 : 정수 , 자동번호, PK 사용할 예정
    mid varchar(30) not null unique , 	-- 회원 아이디 : 문자열 최대 30, 공백X, 중복 X
    mpwd varchar(30) not null , 		-- 회원 비번 : 문자열 최대 30, 공백X,
    mname varchar(10) not null , 		-- 회원 닉넴 : 문자열 최대 10, 공백X,
    constraint primary key( mno ) 		-- 미리 만들어진 "회원번호" 속성을 *PK 필드로 설정 
);

create table board(
	bno int auto_increment , 			-- 게시물 번호 : 정수, 자동번호 , *PK로 사용할 예정
    btitle varchar(100) not null , 
    bcontent longtext , 				-- 게시물 내용 : 4GB 대용량(사진/긴글)
    bdate datetime default now() ,		-- 게시물 작성일시 : 날짜시간, 기본값, now() : 현재 날짜시간 반환함수
    bview int default 1 , 				-- 게시물 조회수 : 정수 , 기본값 , 0
    constraint primary key( bno ) , 	-- 위에서 선언된 "게시물 번호"를 PK필드로 지정
    mno int , 							-- 게시물 작성자 : FK 키로 사용할 예정,
    constraint foreign key(mno) references member( mno ) 
);
show tables;
select * from board; 
--  여러 테이블 간의 관계 확인( 다이어그램 )

 
 
 
 
 
 
 
 
 
 
 









