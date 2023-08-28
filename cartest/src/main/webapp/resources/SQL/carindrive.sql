CREATE SEQUENCE m_seq START WITH 1 INCREMENT BY 1 NOCACHE;
CREATE SEQUENCE cars_seq START WITH 1 INCREMENT BY 1 NOCACHE;
CREATE SEQUENCE rentals_seq START WITH 1 INCREMENT BY 1 NOCACHE;

--member 테이블
CREATE TABLE cid_members (
  m_num NUMBER,
  m_id VARCHAR2(30) PRIMARY KEY, --유저 ID
  m_pwd VARCHAR2(30),
  m_name VARCHAR2(30),
  m_phone VARCHAR2(30)
);

-- cars 테이블
CREATE TABLE cid_cars (
  car_id NUMBER PRIMARY KEY,    --차량 고유 코드번호
  car_name varchar2(30),
  car_brand VARCHAR2(30),
  car_year NUMBER,
  car_color VARCHAR2(30),
  car_price NUMBER(10, 2),
  car_availability NUMBER
);

CREATE TABLE cid_rentals (
  rental_id NUMBER PRIMARY KEY, -- 주문번호(렌트번호)
  m_id VARCHAR2(30),
  car_id NUMBER,
  rental_date DATE,
  rental_time NUMBER(4), -- 시간을 4자리 숫자로 저장 (예: 1030)
  return_date DATE,
  return_time NUMBER(4), -- 시간을 4자리 숫자로 저장 (예: 1445)
  rental_cost NUMBER(10, 2),
  
  CONSTRAINT fk_m_id FOREIGN KEY (m_id) REFERENCES cid_members(m_id),
  CONSTRAINT fk_car_id FOREIGN KEY (car_id) REFERENCES cid_cars(car_id)
);


select * from cid_members;
select * from cid_cars;
select * from cid_rentals;
-------------------------------------------------------------------------------------
--삭제관련 명령어

-- members 테이블의 외래 키 제약 조건 해제
ALTER TABLE cid_rentals DROP CONSTRAINT fk_user_id;

-- cars 테이블의 외래 키 제약 조건 해제
ALTER TABLE cid_rentals DROP CONSTRAINT fk_car_id;


DROP TABLE cid_rentals;
DROP TABLE cid_cars;
DROP TABLE cid_members;

DROP SEQUENCE rentals_seq;
DROP SEQUENCE cars_seq;
DROP SEQUENCE m_seq;
--------------------------------------------------------------------------------------


delete from cid_members;

select * from cid_members;

INSERT INTO cid_members (m_num, m_id, m_pwd, m_name, m_phone)
VALUES (m_seq.NEXTVAL, 'zzz', '1234', '홍길동', '010-1111-1111');

delete from cid_members;

INSERT INTO cid_cars (car_id, car_name, car_brand, car_year, car_color, car_price, car_availability)
VALUES (cars_seq.NEXTVAL, '레이', '현대자동차', 2022, '흰색', 5000, 0);

INSERT INTO cid_cars (car_id, car_name, car_brand, car_year, car_color, car_price, car_availability)
VALUES (cars_seq.NEXTVAL, 'sonata', '현대자동차', 2022, '검정색', 7000, 0);

select * from cid_cars;

INSERT INTO cid_rentals (rental_id, m_id, car_id, rental_date, rental_time, return_date, return_time, rental_cost)
VALUES (rentals_seq.NEXTVAL, 'zzz', 1, TO_DATE('2023-07-13', 'YYYY-MM-DD'), 1030, TO_DATE('2023-07-15', 'YYYY-MM-DD'), 1445, 100000);


delete rentals;

SELECT * FROM cid_rentals;

select * from cid_rentals where m_id='zzz';


SELECT
  rental_id,
  m_id,
  car_id,
  TO_CHAR(rental_date, 'YYYY"년" MM"월" DD"일" HH24"시" MI"분"') AS rental_date,
  TO_CHAR(return_date, 'YYYY"년" MM"월" DD"일" HH24"시" MI"분"') AS return_date,
  rental_cost
FROM cid_rentals;



commit;


