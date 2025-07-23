drop database if exists  mydb0723;
create database mydb0723;
use mydb0723;

create table user(
	uno int auto_increment, -- 속성명, 타입, 자동번호check
    uname varchar(30) not null, -- 가변성 문자열 , 빈칸 불가능(필수 입력)
    uage int default 10, -- insert 생략시 초기값
    constraint primary key(uno) -- 위에서 선언란 회원번호 속성을 기본키(PK) 설정 
);

select * from user;

-- insert into user( uname, uage ) values ( "유재석", 40 );
-- 고정된 값: 상수

# JDBC  매개변수 사용 --> ?
insert into user( uname, uage ) values ( ? , ? );
