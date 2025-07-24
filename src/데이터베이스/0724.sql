drop database if exists mydb0724;
create database mydb0724;
use mydb0724;
create table t1(
	num_pk int,
    constraint primary key(num_pk) -- 식별키, 중복이 없고 공백도 없고 null 없고 고유한 값 userID는 pk로 거의 사용하지 않음.
);

create table t2(
	no_pk int,
    constraint primary key(no_pk),
    num_pk int, -- 참조된 속성도 다시 정의해줘야 한다. 중복값 방지와 무결성 유지를 위해 참조키 활용!
    constraint foreign key(num_pk) 
				references t1(num_pk) 
                # 참조 옵션 : [on] [update/delete] [cascade/ set null / restrict(기본값/생략)]
                # on delete cascade -- 참조중인 pk 레코드가 삭제되면 같이 fk레코드도 같이 삭제된다. 
                # on update cascade -- 참조중인 pk 레코드 값의 변경되면 fk 값도 같이 변경된다.
                # on delete set null -- 참조중인 pk 레코드가 삭제되면 fk 값은 null 로 변경된다. 
                # on update set null -- 참조중인 pk 레코드의 pk값이 변경되면 fk 값은 null로 변경된다.
                # on delete restrict -- (기본값/생략) pk가 참조중인 pk 레코드는 삭제 불가능( 기본 설정되어 있음 )
                # on update restrict -- (기본값/생략) pk가 참조중인 pk 레코드는 수정 불가능( 기본 설정되어 있음 )
                
    -- fk 설정!참조키, 중복 가능, null  가능, 댓글이 위치한 게시물번호, 게시물 작성자 번호, 주문한 제품번호
); -- 우리집 주소 : pk, 쇼핑뫃 배송지  fk -----> pk를 다양한 상황에서 활용하는 것이 fk!!!!!

# 왜? pk 와 fk 참조(관계)형 테이블 ==> 관계형 데이터베이스 RDBS
# 서로 다른 테이블 합치기(집합) ==> JOIN ==> 참조 관계만 join이 가능!
# 샘플 데이터

insert into t1 values(10),(20),(30),(40),(50); -- 행단위로 소괄호 속성값 작성!
insert into t2 values(1, 10),(2,20),(3,10),(4,10), (5,20); -- 행단위로 소괄호 속성값 작성!

select * from t1;
select * from t2;
# 2개 이상의 테이블을 조회하기 ==> 
-- (1) cross join ==> 데카르트 곱으로 5*5  모든 경우의 수가 나옴. 잟 안씀
select * from t1, t2;
select count(*) from t1, t2; -- 25row

-- (2) 교집합 : 두 테이블간의 공통된 값( pk <=> fk )을 기준으로 레코드 조회
# 2.1) where -->   잘 안씀! 일반적으로 where 조건절과 구분이 어렵기 때문에 실무에서 사용 잘 안함.
select * from t1, t2 where t1.num_pk = t2.num_pk; -- 관계된 테이블간의 공통된 pk = fk(pk)

# 2.2) ★☆★☆★☆★☆ inner join절 ★☆★☆★☆★☆ ==> 가장 많이 사용함! 조금 길지만 해당 속성명이 보이니 직관적이긴 한 것 같음!
select * from t1 inner join t2 on t1.num_pk = t2.num_pk; -- 일반적으로 pk와 fk 이름 동일하게 사용. 구분하기 위해 fk 하지만 나중에 헷갈리니 미리 같은 이름으로 사용하자!
-- where : 일반조건 / having : 그룹 조건 / on : 집합 조건

# 2.3) inner 생략 가능!
select * from t1 join t2 on t1.num_pk = t2.num_pk;
select * from t1 as t11 join t2 as t22 on t11.num_pk = t22.num_pk;
select * from t1 t11 join t2 t22 on t11.num_pk = t22.num_pk;
-- on 절에는 별칭 사용 안됨
select t1.num_pk 식별키, t2.num_pk 참조키 from t1 join t2 on t1.num_pk = t2.num_pk; -- on 절에는 별칭 사용 안됨

-- ★☆ 아래 키워드 전제 조건은 pk속성명과 fk속성명이 잃치한 경우에만 가능!
# 2.4) natural join
select * from t1 natural join t2;
# 2.5) t1 join t2 using( num_pk );
select * from t1 join t2 using( num_pk );

# (3) outer join
# 3.1) 왼쪽 레코드는 다나오고 오른쪽 테이블 교집합 표현! 교집합이 안된 부분은 오른쪽 속성값 null로 나옴!
select * from t1 left outer join t2 on t1.num_pk = t2.num_pk;

# 3.2) 오른쪽 테이블 기준으로 다 나오고 왼쪽은 교집합 된 속성들이 나옴.
select * from t1 right outer join t2 on t1.num_pk = t2.num_pk;

# 3.3) outer 생략 가능!
select * from t1 left join t2 on t1.num_pk = t2.num_pk;

# (4) 합집합 union
-- mysql : union / oracle : full outer join 
# 4.1) union : 2개 이상의 select를 하나로 합치기, left 와 right를 따로 작성 후  union 으로 묶어줌! 별로인데....
select * from t1 left join t2 on t1.num_pk = t2.num_pk union
select * from t1 right join t2 on t1.num_pk = t2.num_pk;

# (5) ★☆★☆★☆★☆ 차집함 : 공통 (pk = fk) 제외한 나머지 도 많이 사용됨!!!   ★☆★☆★☆★☆ 
# 5.1)
select * from t1 left join t2 on t1.num_pk = t2.num_pk
			where t2.num_pk is null ; -- 먼저 left 조인을 구하고, fk인 값이 null 인 것만 조회

# 5.2) 오른쪽 테이블의 차집함 : 오른쪽 테이블 기준으로 공통 (pk= fk) 레코드 제외 왼쪽 나머지 레코드만 나오게....
select * from t1 right join t2 on t1.num_pk = t2.num_pk where t1.num_pk is null;

/*
 - 교집합 : 두 테이블 간의 pk와 fk 값이 동일한 레모드를 하나의 테이블로 조회
	1. where
    2. inner join on 
    3. join on 
    4. natural join 
    5. join using
    
 - 차집합 : 두 테이블 간의 테이블A 의 (pk와 fk 값이 동일한) 레코드를 제외한 테이블B 의 레코드 조회
	1. select * from 테이블A 
				left outer join 테이블B   
				on 테이블A.pk = 테이블B.fk 
				where 테이블B.fk is null; 
 - 합집합 : 두 테이블 간의 모든 레코드를 하나의 레코드로 조회
 
*/

 


 

























