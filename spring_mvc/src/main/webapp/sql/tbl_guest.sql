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

--스프링 AOP와 트랜잭션 실습을 위한 샘플 테이블 생성
create table tbl_user(
    uid2 varchar2(50) primary key --회원 아이디
    ,upw varchar2(50) not null --비번
    ,uname varchar2(100) not null --회원이름
    ,upoint number(38) default 0 
    -- 메세지가 보내지면 포인트 점수 10점 업데이트 => 메시지가 insert면 메시지 하나당 포인트 점수 10점 update는 트랜잭션 적용대상
);

insert into tbl_user (uid2,upw,uname) values('user00',
'56789','홍길동'); 
insert into tbl_user (uid2,upw,uname) values('user01',
'23589','이순신 '); 

select * from tbl_user order by uid2  asc;
commit;

--tbl_message 테이블 생성
create table tbl_message(
    mid number(38) primary key
    ,targetid varchar2(50) not null --외래키 제약조건으로 설
    -- . tbl_user uid2 정 테이블의 컬럼 아이디값을 가져와 저장
    ,sender varchar2(50) not null--보낸사람
    ,message varchar2(1000) not null --보낸 메시지
    ,senddate date --보낸 날짜
);
--외래키 제약조건 추가
alter table tbl_message add constraint fk_usertarget
foreign key(targetid) references tbl_user(uid2);
--mid_no_seq 시퀀스 생성
create sequence mid_no_seq
start with 1
increment by 1
nocache;
select mid_no_seq.nextval from dual;
select * from tbl_message;

 
 
 
 