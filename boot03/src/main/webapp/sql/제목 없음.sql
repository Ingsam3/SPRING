select *from tbl_members;


select *from tbl_members order by uid2 asc;

select *from tbl_profile order by fno asc;

select *from tbl_useraddr2 order by userno asc;

insert into tbl_useraddr2 (userno,address,username,regdate) values(
 	bno_seq2.nextval, '1', '1','1111-11-11');
    
    ALTER TABLE tbl_useraddr2 DROP COLUMN redgdate;
    ALTER TABLE tbl_useraddr2 ADD redgdate VARCHAR(40);
    
    
----------------------------  
--test_board 테이블 생성
create table test_board(
board_no  number(38) primary key 
,board_title  varchar2(200) not null 
,board_cont  varchar2(4000) not null 
);

-- test_seq 시퀀스 생성
create sequence test_seq
increment by 1 --1씩 증가 옵션
start with 1 -- 1부터 시작
nocache;

--시퀀스 번호값 발생
select bno_seq.nextval from dual;    
select *from test_board ;

select *from test_board;

insert into test_board (board_no, board_title, board_cont)
values(test_seq.nextval,'1','1');

--------

select * from car_member;

    
    
