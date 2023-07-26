 create table tbl_guest(
    gno int PRIMARY key
    ,gname  varchar (20)   not null 
    ,gtitle varchar2 (200) not null 
    ,gcont  varchar2 (4000) not null 
    ,ghit  int DEFAULT 0     
    ,gdate date DEFAULT sysdate 
 );
  create sequence  gno_seq2
  start with 1 -- 1부터 시작
  increment by 1 -- 1 씩 증가
  nocache;     
	
 select gno_seq2.nextval as "gno_seq2 시퀀스 번호값" from dual; 
 --
 
 
 
create table tbl_reply(
    rno number(38) primary key --댓글 번호
    ,bno number(38) default 0 --게시판 번호값이 저장되는 컬
    -- tbl_board 의 bno 컬럼 레코드 번호값 외래키 제약조건으로 추가 설정 테이블의
    --게시물 번호값만 저장
    ,replyer varchar2(100) not null --댓글 작성자
    ,replytext varchar2(4000) not null --댓글내용
    ,regdate date --등록날짜
    ,updatedate date --수정날짜
);
select * from tbl_reply order by rno desc;

alter table tbl_reply add constraint tbl_reply_bno_fk
foreign key(bno) references tbl_board(bno);

--foreign key( ) 외래키
--댓글 시퀀스 생성
create sequence rno_seq
start with 1
increment by 1
nocache;
--dual 테이블에서 시퀀스 번호값 확인
select rno_seq.nextval from dual;

 
 
 
 