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

--������ AOP�� Ʈ����� �ǽ��� ���� ���� ���̺� ����
create table tbl_user(
    uid2 varchar2(50) primary key --ȸ�� ���̵�
    ,upw varchar2(50) not null --���
    ,uname varchar2(100) not null --ȸ���̸�
    ,upoint number(38) default 0 
    -- �޼����� �������� ����Ʈ ���� 10�� ������Ʈ => �޽����� insert�� �޽��� �ϳ��� ����Ʈ ���� 10�� update�� Ʈ����� ������
);

insert into tbl_user (uid2,upw,uname) values('user00',
'56789','ȫ�浿'); 
insert into tbl_user (uid2,upw,uname) values('user01',
'23589','�̼��� '); 

select * from tbl_user order by uid2  asc;
commit;

--tbl_message ���̺� ����
create table tbl_message(
    mid number(38) primary key
    ,targetid varchar2(50) not null --�ܷ�Ű ������������ ��
    -- . tbl_user uid2 �� ���̺��� �÷� ���̵��� ������ ����
    ,sender varchar2(50) not null--�������
    ,message varchar2(1000) not null --���� �޽���
    ,senddate date --���� ��¥
);
--�ܷ�Ű �������� �߰�
alter table tbl_message add constraint fk_usertarget
foreign key(targetid) references tbl_user(uid2);
--mid_no_seq ������ ����
create sequence mid_no_seq
start with 1
increment by 1
nocache;
select mid_no_seq.nextval from dual;
select * from tbl_message;

 
 
 
 