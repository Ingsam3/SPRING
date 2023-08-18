
create table tbl_member(
userid varchar2(50) primary key --회원 아이디
,userpw varchar2(50) not null --회원비번
,username varchar2(50) not null --회원이름
,email varchar2(100) --전자우편
,regdate date default sysdate --가입날짜
);

select *from tbl_member;


create table tbl_board(
bno number(38) primary key --게시판 번호
,writer varchar2(100) not null --작성자
,title varchar2(200) not null --제목
,content varchar2(4000) --내용
,viewcnt number(38) default 0 
-- default 0 조회수 제약조
-- insert 건을 주면 해당컬럼에 레코드를 하지 않으면 기본값
--0 . 이 저장됨
,regdate date DEFAULT sysdate--등록날짜
);
select * from tbl_board order by bno desc;

--시퀀스 생성
create sequence bno_seq
increment by 1 --1씩 증가 옵션
start with 1 -- 1부터 시작
nocache;
--시퀀스 번호값 발생
select bno_seq.nextval from dual;

select *from tbl_user order by uid2  asc;
select *from tbl_message order by mid asc;

