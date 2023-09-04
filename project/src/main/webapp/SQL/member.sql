SELECT * FROM member;

create table member( --회원 관리 테이블
  mem_id varchar2(50) primary key --회원 아이디
  ,mem_pwd varchar2(200) not null --비밀번호
  ,mem_name varchar2(50) not null --회원이름
  , mem_zip varchar2(10) not null --우편번호
  , mem_zip2 varchar2(10) not null -- 우편번호
  , mem_addr varchar2(200) not null --주소
  , mem_addr2 varchar2(100) not null -- 나머지 주소
  , mem_phone01 varchar2(10) --첫번째 자리 폰번호
  , mem_phone02 varchar2(10) --두번째 자리 폰번호
  , mem_phone03 varchar2(10) --세번째 자리 폰번호
  , mail_id varchar2(100) -- 메일 아이디
  , mail_domain varchar2(100) --메일 도메인
  , mem_date date --가입날짜
  , mem_state number(38) --가입회원 1, 탈퇴회원 2
  , mem_delcont varchar2(4000) -- 탈퇴사유
  , mem_deldate date -- 탈퇴날짜
  );
  
SELECT * FROM member;

 	update member set mem_pwd='wwwww', mem_name='rewwwww',
   	 mem_zip='', mem_zip2='',
   	 mem_addr='', mem_addr2='',
   	 mem_phone01='',mem_phone02='',mem_phone03='',
   	 mail_id='',mail_domain=''
   	 where mem_id='wwwww';

alter table member MODIFY (mem_delcont varchar2(4000));
  
SELECT * FROM zipcode;

insert into zipcode (no,zipcode,sido,gugun,gil,bunji)values(
1,'123-789','서울시','종로구','돈화문로','26 단성사 빌딩');

commit;





insert into member(mem_id,mem_pwd,mem_name,mem_zip,mem_zip2,mem_addr,
mem_addr2,mem_phone01,mem_phone02,mem_phone03,mail_id,
mail_domain,mem_date, mem_state)
values('bbbbb','77777','hong','123','567','서울시 종로구 돈화문로','00빌딩 00호','010','1111','2222'
,'aaaaa','naver.com',sysdate,'1');
  