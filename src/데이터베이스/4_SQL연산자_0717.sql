# SQL 연산자_250717(목)
-- 카톡방에 예제코드를 복/붙 해서 전체실행(CTRL+SHIFT+ENTER)
drop database if exists mydb0717;
create database mydb0717;
use mydb0717;

# 1. 회원테이블
create table member(            # 아이돌 그룹
   mid char(8) not null ,         # 식별키       최대 8자리
    mname varchar(10) not null ,   # 그룹명      최대 10자리
    mnumber int not null ,         # 인원수      정수 +-21억정도
    maddr char(2) not null ,       # 지역      최대 2자리
    mphone1 char(3) ,            # 지역번호   최대 2자리
    mphone2 char(8) ,            # 전화번호    최대 8자리
    mheight smallint ,            # 평균키       정수 +-3만정도
   mdebut date ,               # 데뷔일       yyyy-mm-dd
    constraint primary key ( mid )            # 제약조건
);
# 2. 구매테이블
create table buy(
   bnum int auto_increment ,          # 구매번호   정수    자동번호 부여
    mid char(8),                  # 구매자      FK
    bpname char(6) not null ,         # 제품명      최대 6자리
    bgname char(4) ,                # 분류명       최대   4자리
    bprice int not null ,            # 가격       정수
    bamount smallint not null ,         # 구매수량   정수
    constraint primary key(bnum) ,               # 제약조건
    constraint foreign key ( mid ) references member(mid) # 제약조건
);

# 샘플데이터
INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');
INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);

# 테이블 샘플 확인
select * from member;
select * from buy;

# [1] as 별칭 , 조회결과의 속성명 변경(원본 테이블과는 상관없음/수정 안됨.)
select mid from member;
select mid as 회원아이디 from member;
select mid as 회원아이디, mname 회원명 from member; -- 변수명에는 띄어쓰기 없음. as 는 생략 가능!
select mid 회원아이디 from member as m;
select mid 회원아이디 from member m;

# [2] distinct , 속성값이 중복인 레코드 제거
select maddr as 주소 from member;
select distinct maddr as 주소 from member;

# [3] 산술연산자 : + - * / div(몫) mod(나머지)
select mnumber as 인원수 , mnumber + 3 as 더하기, mnumber - 3 as 빼기 , 
mnumber * 3  as 곱하기, mnumber / 3 as 나누기 , 
mnumber div 3 as 몫 , mnumber mod 3 as 나머지 from member; -- 나머지는 정수로 나오네..

# [4] 비교연산자 : > < >= <= , = (같다), != 같지 않다. 
select * from member where mname = '블랙핑크';
select * from member where mnumber = 4;
select * from member where mname != '블랙핑크';
select * from member where mheight <= 160;

select * from member where mheight >= 160 and mheight <= 165;
select * from member where mheight between 165 and 170;

select * from member where maddr = '경기' or maddr = '전남'; -- 조건1 or  조건2
select * from member where maddr in( '경기','전남', '경남'); -- 조건1 or  조건2
select * from member where maddr in( '경기','전남', '경남'); -- where 속성명 in(속성값, 속성값);
select * from member where maddr in( '경기','전남', '경남'); -- where 속성명 in(속성값, 속성값);

# 논리 연산자 : not 부정, and 이면서, 
select * from member where not mname = '블랙핑크';
# 기타 연산자 : between 시작값 and 끝값; or, 속성명 in(값1, 값2);

# null 연산자
select * from member where mphone ='';     --  속성값이 비어있는 표현, ''빈 칸 대신에 null 사용한다.
select * from member where mphone = null;  -- (X) 속성값이 null 이면 불가능!!!!
select * from member where mphone is null; -- is null : 속성값이 null 이면
select * from member where mphone is not null; -- is not null : 속성값이 null 이 아니면...alter

#  문자패턴 연산자 : 속성명 like ' 문자패턴' , % --> 문자 대응(글자 수 갯수 상과없음) , _(언더바) ---> 글자수 제한이 있음.
select * from member where mname like '에이%'; -- 속성의 값이 '에이'로 시작하는 --> 검색 만들때 많이 사용!!!!! 예시) 에이X, 에이XX, 에이XXX 등등..
select * from member where mname like '%핑크'; -- 속성의 값이 '핑크' 로 끝나는
select * from member where mname like '%이%'; -- 속성의 값에 '이'가 포함된!!!
select * from member where mname like '에이_'; -- 속성의 값이 '에이'로 시작하는 세글자(_수만큼)
select * from member where mname like '_이_'; -- 속성의 값에 두번째 글자가 '이'인 세글자

select * from member where maddr like "경%";


# [5] 정렬 order by 속성명 asc/desc , 정렬
select * from member order by mdebut asc; -- asc(오릌차순/기본값), desc(내림차순)
select * from member order by mdebut;  -- asc(오릌차순/기본값)
-- 오름차순 : 1 2 3 ㄱㄴㄷ abc 날짜 옛날것이 위에 있음(25-05-01 25-07-10)
-- 내림차순 : 3 2 1 ㄷㄴㄱ cba 날짜 최근이 큰 숫자!!!( 25-07-17 25-07-16)
# 주의할 점 : 2개 이상의 정렬은 ,(쉼표)로 구분하되 , 1차 정렬에서 붕복값이 있을 경우, 중복값끼리 2차 정렬
select * from member order by maddr desc , mdebut asc; -- 1차 주소 내림차순, 1차 정렬결과의 중복값중에서 2차 정렬 반영!

# [6] limit 레코드수 , 조회결과 제한 *페이징 처리
select * from member limit 4;    -- 조회결과에서 상위 2개만 조회 제한
select * from member limit 0, 4; -- 조회결과에서 상위ㅜ 2개만 조회
select * from member limit 1, 2; -- 조회결과에서 상위ㅜ 2개만 조회
select * from member order by mheight desc limit 3; -- 등수 뽑을 때도 많이 사용












