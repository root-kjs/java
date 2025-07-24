-- [SQL] 실습5 : JOIN 실습 문제_250723(목)
-- [ 문제 ] 아래 SQL JOIN 관련 문제를 해결하시오.
-- [ 제출방법 ] 각 문제의 요구사항에 맞는 SQL 코드를 작성하여 제출하시오.
-- [사전 준비] 실습용 데이터베이스 및 테이블, 데이터 생성
-- 아래 SQL 코드를 전체 복사하여 MySQL Workbench에서 실행(Ctrl+Shift+Enter)한 후 문제를 풀어주세요.
-- ==================== 실습 환경 구축 ====================
DROP DATABASE IF EXISTS exam5;
CREATE DATABASE exam5;
USE exam5;
-- 1. 카테고리 테이블
CREATE TABLE pcategory(
    카테고리번호_pk INT UNSIGNED AUTO_INCREMENT,
    카테고리명 VARCHAR(10) NOT NULL,
    PRIMARY KEY(카테고리번호_pk)
);
-- 2. 제품 테이블
CREATE TABLE product(
    제품번호_pk INT UNSIGNED AUTO_INCREMENT,
    제품명 VARCHAR(100) NOT NULL,
    제품가격 INT UNSIGNED NOT NULL,
    카테고리번호_fk INT UNSIGNED,
    PRIMARY KEY(제품번호_pk),
    FOREIGN KEY(카테고리번호_fk) REFERENCES pcategory(카테고리번호_pk)
);
-- 3. 재고 테이블
CREATE TABLE stock(
    재고번호_pk INT UNSIGNED AUTO_INCREMENT,
    재고수량 INT,
    재고등록날짜 DATETIME DEFAULT NOW(),
    제품번호_fk INT UNSIGNED,
    PRIMARY KEY(재고번호_pk),
    FOREIGN KEY(제품번호_fk) REFERENCES product(제품번호_pk)
);

-- 샘플 데이터 삽입
INSERT INTO pcategory(카테고리명) VALUES('노트북'), ('스마트폰'), ('의류'), ('도서');
INSERT INTO product(제품명, 제품가격, 카테고리번호_fk) VALUES
('그램 15인치', 1500000, 1), ('맥북 프로 16인치', 3000000, 1),
('갤럭시 S23', 1200000, 2), ('아이폰 14 Pro', 1550000, 2),
('반팔 티셔츠', 30000, 3), ('청바지', 80000, 3),
('혼공 SQL', 22000, 4);
INSERT INTO stock(재고수량, 제품번호_fk) VALUES (10, 1), (5, 2), (20, 3), (15, 4), (100, 5), (50, 6),(5, 1), (2, 3);

-- ========================================================
-- [문제 1] 모든 제품의 제품명과 해당 제품의 카테고리명을 함께 조회하세요. (조회결과: 7개 레코드)
select * from pcategory;
select * from product;
select * from product p inner join pcategory pc on p.카테고리번호_fk = pc.카테고리번호_pk; -- 이것은 공통 교집합. 모든 제품이 나오지 않음. 카테고리= 제품 1대일 매칭!
select 카테고리명, 제품명 from product p inner join pcategory pc on p.카테고리번호_fk = pc.카테고리번호_pk; 
select 카테고리명, 제품명 from product p inner join pcategory pc on p.카테고리번호_fk = pc.카테고리번호_pk; 

-- [문제 2] '노트북' 카테고리에 속하는 모든 제품의 제품명과 제품가격을 조회하세요. (조회결과: 2개 레코드)
select 카테고리명, 제품명 from product p 
	inner join pcategory pc 
    on p.카테고리번호_fk = pc.카테고리번호_pk 
    where 카테고리명 = '노트북'; 

-- [문제 3] 모든 제품의 제품명과 등록된 재고수량을 함께 조회하세요. (조회결과: 8개 레코드)
select * from product; -- 제품번호_pk
select * from stock; -- 제품번호_fk
select 제품번호_pk, 제품명, 재고수량 from product p inner join stock s on p.제품번호_pk = s.제품번호_fk;

-- [문제 4] '그램 15인치' 제품의 모든 재고등록날짜와 재고수량을 조회하세요. (조회결과: 2개 레코드)
select 제품명, 재고등록날짜, 재고수량 from product p inner join stock s on p.제품번호_pk = s.제품번호_fk where 제품명 = '그램 15인치';

-- [문제 5] 모든 제품의 제품명, 카테고리명, 재고수량을 한 번에 조회하세요. (3개 테이블 조인) (조회결과: 8개 레코드) inner는 교집합만 구한다. 
select * from pcategory;-- 카테고리번호_pk
select * from product; -- 카테고리번호_fk
select * from stock; -- 제품번호_fk
select * from product p inner join pcategory pc on p.카테고리번호_fk = pc.카테고리번호_pk  inner join stock s  on p.제품번호_pk = s.제품번호_fk ;
select 제품번호_pk, 제품명, 카테고리명, 재고수량 from product p inner join pcategory pc on p.카테고리번호_fk = pc.카테고리번호_pk  inner join stock s on p.제품번호_pk = s.제품번호_fk ;
select 제품번호_pk, 제품명, 카테고리명, 재고수량 from stock s inner join product p on s.제품번호_fk = p.제품번호_pk inner join pcategory pc  on p.카테고리번호_fk = pc.카테고리번호_pk ;
select * from pcategory pc 
	inner join product p on pc.카테고리번호_pk = p.카테고리번호_fk
    inner join stock s on p.제품번호_pk = s.제품번호_fk;

select * from pcategory pc 
	inner join product p on pc.카테고리번호_pk = p.카테고리번호_fk
    left join stock s on p.제품번호_pk = s.제품번호_fk;
    
-- 재고 수량 null인 것도 포함해서 조회하려면, inner join 보다는 (left/right) outer join 을 사용햐얄 듯...
select 제품명, 카테고리명, 재고수량 from pcategory pc 
	inner join product p on pc.카테고리번호_pk = p.카테고리번호_fk
    left outer join stock s on p.제품번호_pk = s.제품번호_fk;
    
-- [문제 6] 모든 카테고리의 카테고리명과 해당 카테고리에 속한 제품명을 조회하세요. 만약 카테고리에 속한 제품이 없더라도 카테고리명은 모두 표시되도록 하세요. (조회결과: 7개 레코드)
select * from pcategory;-- 카테고리번호_pk
select * from product; -- 카테고리번호_fk
select * from stock; -- 제품번호_fk
select * from pcategory pc left outer join product p on pc.카테고리번호_pk = p.카테고리번호_fk; 
select 카테고리명, 제품명 from pcategory pc left outer join product p on pc.카테고리번호_pk = p.카테고리번호_fk; 

-- [문제 7] 재고가 한 번도 등록되지 않은 제품의 제품명을 조회하세요. (조회결과: 1개 레코드)
select * from product p left outer join stock s on p.제품번호_pk = s.제품번호_fk;
select 제품명, 재고수량 from product p left outer join stock s on p.제품번호_pk = s.제품번호_fk where s.재고수량 is null;

-- [문제 8] 각 카테고리별로 총 재고 수량의 합계를 카테고리명과 함께 조회하세요. (조회결과: 3개 레코드)
select 카테고리명, sum( 재고수량 ) from pcategory pc 
	join product p on pc.카테고리번호_pk = p.카테고리번호_fk
    left join stock s on p.제품번호_pk = s.제품번호_fk
    group by 카테고리명;

-- [문제 9] 각 제품별로 총 재고 수량을 조회하고, 총 재고 수량이 많은 순서대로 정렬하여 제품명과 총재고수량을 표시하세요. (조회결과: 6개 레코드)
select 제품명, sum(재고수량) top from pcategory pc 
	join product p on pc.카테고리번호_pk = p.카테고리번호_fk
    left join stock s on p.제품번호_pk = s.제품번호_fk
    group by 제품명 order by top desc;  -- 7개 : 개인적으로 재고수량이 없는(null) 도 나오는게... 물론 다양한 상황이 있겠지만...해당 상품 비노출이거나..

-- 테이블 간의 연관관계를 파악 할 
-- 테이블 간의 공통점/교집합 속성명 여부를 먼저 확인할 것! 만약 2개로는 안되는 경우 다른 연관된 테이블과도 확인하여 연결(join)할 것!
select 제품명, sum(재고수량) top from pcategory pc -- 두 테이블간의 필드명이 똑같은 경우에는 테이블 경로 표시..  --> p.속성명 pc. 속성명
	join product p on pc.카테고리번호_pk = p.카테고리번호_fk
    join stock s on p.제품번호_pk = s.제품번호_fk
    group by 제품명 order by top desc; -- 6개  