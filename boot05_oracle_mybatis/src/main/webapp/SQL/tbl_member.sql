
create table tbl_member(
userid varchar2(50) primary key --ȸ�� ���̵�
,userpw varchar2(50) not null --ȸ�����
,username varchar2(50) not null --ȸ���̸�
,email varchar2(100) --���ڿ���
,regdate date default sysdate --���Գ�¥
);

select *from tbl_member;


create table tbl_board(
bno number(38) primary key --�Խ��� ��ȣ
,writer varchar2(100) not null --�ۼ���
,title varchar2(200) not null --����
,content varchar2(4000) --����
,viewcnt number(38) default 0 
-- default 0 ��ȸ�� ������
-- insert ���� �ָ� �ش��÷��� ���ڵ带 ���� ������ �⺻��
--0 . �� �����
,regdate date DEFAULT sysdate--��ϳ�¥
);
select * from tbl_board order by bno desc;

--������ ����
create sequence bno_seq
increment by 1 --1�� ���� �ɼ�
start with 1 -- 1���� ����
nocache;
--������ ��ȣ�� �߻�
select bno_seq.nextval from dual;

select *from tbl_user order by uid2  asc;
select *from tbl_message order by mid asc;

