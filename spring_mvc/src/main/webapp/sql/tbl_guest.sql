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
 --
 
 
 
create table tbl_reply(
    rno number(38) primary key --��� ��ȣ
    ,bno number(38) default 0 --�Խ��� ��ȣ���� ����Ǵ� ��
    -- tbl_board �� bno �÷� ���ڵ� ��ȣ�� �ܷ�Ű ������������ �߰� ���� ���̺���
    --�Խù� ��ȣ���� ����
    ,replyer varchar2(100) not null --��� �ۼ���
    ,replytext varchar2(4000) not null --��۳���
    ,regdate date --��ϳ�¥
    ,updatedate date --������¥
);
select * from tbl_reply order by rno desc;

alter table tbl_reply add constraint tbl_reply_bno_fk
foreign key(bno) references tbl_board(bno);

--foreign key( ) �ܷ�Ű
--��� ������ ����
create sequence rno_seq
start with 1
increment by 1
nocache;
--dual ���̺��� ������ ��ȣ�� Ȯ��
select rno_seq.nextval from dual;

 
 
 
 