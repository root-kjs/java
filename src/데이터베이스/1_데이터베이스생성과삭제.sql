# 한 줄 주석
-- 한 줄 주석
/*
여러 줄 주석
*/
-- [2] SQL 명령어 작성 방법
-- 1. SQL 문법끝에 반드시 ;(세미클론) 으로 마친다.
show databases;
-- [3] SQL 실행방법
-- 1. 단위실행 : ctrl+enter,  상단 번개(1) 아이콘
-- 2. 전체실행 : 현재 파일 낸 모든 명령 싷행 ctrl+shift+enter
-- [4]실행결과 : result grid, output 창 확인하여 명령문 결과 확인한다.
-- [5] 데이터베이스 주요 명령어
-- 1. 데이터베이스가 저장된 로컬경로 확인 방법
show variables like 'datadir'; # 마지막 세미콜론 잊지말기

-- C:\ProgramData\MySQL\MySQL Server 8.0\Data  --? 
-- 2. 데이터 베이스 생성하기
-- create database(폴더) mydb0714;
-- 실행 후 output 확인 해서 폴더가 생성됐는지 확인요망!!!!

create database mydb0714; 

-- 3. 삭제 : drop database 폴더명;
drop database mydb0714;

-- 4. DB 서버내 데이터베이스가 존재하면 삭제하기
-- why? 안전하게 삭제하는 방법/ 여러번 실행해도 오류가 발생하지 않아서
drop database if exists mydb0714;

-- 5. DB 서버 내 데이터베이스 목록보기alter
show databases;

-- DB 서버 내 데이터베이스 활성화(사용)하기
 use mydb0714;

-- UI에서 데이터베이스 확인 : 워크벤치 새로고침
# 예제1 : 데이터베이스 기본 셋팅/준비
 drop database if exists test0714;  # 'test0714'이름의 데이터베이스가 있다면 삭제하기
 create database test0714;  # 'test0714'이름의 데이터베이스 생성하기
 show databases;
 use test0714; # 왼쪽 활성화(진한글씨) 
 
 -- 현재 파일을 저장하는 방법 : ctrl + s
 
 
 






