SELECT * FROM member;

create table member( --ȸ�� ���� ���̺�
  mem_id varchar2(50) primary key --ȸ�� ���̵�
  ,mem_pwd varchar2(200) not null --��й�ȣ
  ,mem_name varchar2(50) not null --ȸ���̸�
  , mem_zip varchar2(10) not null --�����ȣ
  , mem_zip2 varchar2(10) not null -- �����ȣ
  , mem_addr varchar2(200) not null --�ּ�
  , mem_addr2 varchar2(100) not null -- ������ �ּ�
  , mem_phone01 varchar2(10) --ù��° �ڸ� ����ȣ
  , mem_phone02 varchar2(10) --�ι�° �ڸ� ����ȣ
  , mem_phone03 varchar2(10) --����° �ڸ� ����ȣ
  , mail_id varchar2(100) -- ���� ���̵�
  , mail_domain varchar2(100) --���� ������
  , mem_date date --���Գ�¥
  , mem_state number(38) --����ȸ�� 1, Ż��ȸ�� 2
  , mem_delcont varchar2(4000) -- Ż�����
  , mem_deldate date -- Ż��¥
  );
  
SELECT * FROM member;

alter table member MODIFY (mem_delcont varchar2(4000));
  
SELECT * FROM zipcode;
  