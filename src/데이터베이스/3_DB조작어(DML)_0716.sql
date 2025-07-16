-- 2025-07-16(수) DML(정의어)
drop database if exists mydb0716;
create database mydb0716;
use mydb0716;
create table test(
	mno int auto_increment , -- 속성명 타입 제약조건(2개 이상 넣어도 된다)
    mname varchar(30) not null unique ,
    mcount int default 2 , 
    constraint primary key(mno)  -- 마지막 쉼표 생략
);
# 데이터베이스 조작어
# [1] insert : 레코드 삽입!
# 레코드란? 테이블 내 행(가로)단위의 데이터들 : 1행 == 1줄 == 1레코드
# !주의 : 테이블 내 데이터 삽입시 레코드(1행/줄) 단위로 데이터가 삽입됨. 
-- insert into 테이블명( 속성명1, 속성명2 ) values( 값1 , 값2 );
-- 1) 입력되는 속성명(필드명)과 속성값을 매칭시킬것!!!!
insert into test( mno , mname , mcount ) values( 1 , "유재석" , 33 );
insert into test( mcount , mno , mname ) values( 40 , 2 , "강호동" );

-- 2) auto increment 제약조건의 속성은 생략시 자동번호(1씩 증가된) 자동번호 할당! --> 레코드(1행) 단위로 데이터 추가되니까!
-- PK에서 많이 사용
insert into test( mcount , mname ) values( 50 , "신동엽" );
-- 3) default 제약조건의 속성은 값 생력시 정의된 기본값이 들어감 : 가입일 등
insert into test( mname ) values( "서장훈" );
-- 4) not null 제약조건의 속성은 반드시 꼭!! 속성값을 넣어야 한다! 안그러면 에러
# insert into test( mno , mcount ) values( 5, 40 );
-- 5) unique 제약조건의 속성은 붕복값이 있을 경우 오류발생!!!!
insert into test( mname ) values( "유재석" );
-- 6) 모든 속성값을 작성할 경우 속성명 생략가능하다. 단, 순서대로 작성해야 함!
insert into test values( 5, "하하", 20 );

-- 7) 하나의 insert에서 여러개 레코드 삽입할 경우
insert into test values( 30, "하하1", 20 ), ( 10, "하하2", 20 ), ( 100, "하하3", 20 );
insert into test values( "하하4"); -- 속성명을 빼면 안된다. 빼는 경우에는 전체 속성값을 다 넣는 경우만!!!
insert into test( mname ) values( "하하5");
insert into test( mno, mname ) values( 0, "하하6"); -- 0은 안되나보다!
insert into test( mno, mname ) values( 3, "하하7");
select * from test; -- 확인차 테이블 조회

# [2] select --> 레코드 조회
-- !주의 : 조회결과는 기존 테이블과는 상관이 없고 조회결과로 맘대로 연산도 가능, 추가도 가능.
-- select만 result table 이 존재함. --> 조회결과는 무조건 표형식으로 나옴!
-- 1) select * from 테이블명; --> 해당 테이블의 전체 레코드 조회!

select * from test; -- 전체 속성 테이블 조회
-- 2) 선택 속성만 조회
select mname, mcount from test; -- mname 속성만 조회 영어순처럼 거꾸로 읽자
-- 3) select 속성명 from 테이블명 where 조건절; : 조건절은 연산자가 많이 활용됨!
-- !주의 : 아래 속성값은 완전 똑같아야 조회됨!
select * from test where mname = "하하"; # = (대입이 아닌 같다라는 뜻!)
select * from test where mno = 3; -- 회원번호(mno) 속성값이 3인 레코드를 조회! 

# [3] update : 레코드 수정
-- mysql workbench에서는 수정/삭제 safe mode 이므로 불가능!
-- safeMode 해제 : set SQL_SAFE_UPDATES = 0;
set SQL_SAFE_UPDATES = 0; -- 끄기 0, 켜기 1 
-- 1) 전체 레코드의 속성값을 수정할 경우
-- update 테이블명 set 속성명 = 새로운 값;
-- update 테이블명 set 속성명 = 새로운 값 where 조건절;
-- update 테이블명 set 속성명1 = 속성값1 , 속성명2 = 속성값2; 
update test set mcount = 100; -- 전체 속성값 수정
update test set mcount = 44 where mname = "유재석";

# [4] delete : 레코드 삭제
-- delete from 테이블명 where 조건절;

delete from test where mno = 102; -- 조건절에 맞는 레코드만 삭제
delete from test; -- 전체 테이블 삭제
select * from test; -- 전체 속성 테이블 조회























