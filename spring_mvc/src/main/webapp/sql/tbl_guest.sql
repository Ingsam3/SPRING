 create table tbl_guest(
    gno int PRIMARY key
    ,gname  varchar (20)   not null 
    ,gtitle varchar2 (200) not null 
    ,gcont  varchar2 (4000) not null 
    ,ghit  int DEFAULT 0     
    ,gdate date DEFAULT sysdate 
 );
  create sequence  gno_seq2
  start with 1 -- 1���� ����
  increment by 1 -- 1 �� ����
  nocache;     
	
 select gno_seq2.nextval as "gno_seq2 ������ ��ȣ��" from dual; 