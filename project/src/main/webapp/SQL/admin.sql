create table admin(
  admin_no number(38)
  ,admin_id varchar2(50) primary key --������ ���̵�
  ,admin_pwd varchar2(200) not null --������ ���
  ,admin_name varchar2(50) not null --������ �̸�
  ,admin_date date --��ϳ�¥
  );
 
 select * from admin;