
create table tbl_member(
userid varchar2(50) primary key --ȸ�� ���̵�
,userpw varchar2(50) not null --ȸ�����
,username varchar2(50) not null --ȸ���̸�
,email varchar2(100) --���ڿ���
,regdate date default sysdate --���Գ�¥
);

select *from tbl_member;