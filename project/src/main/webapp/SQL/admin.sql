create table admin(
  admin_no number(38)
  ,admin_id varchar2(50) primary key --������ ���̵�
  ,admin_pwd varchar2(200) not null --������ ���
  ,admin_name varchar2(50) not null --������ �̸�
  ,admin_date date --��ϳ�¥
  );
 
 delete from admin;
 select * from admin order by admin_id asc;
 
 commit;
 
 insert into admin(admin_id,admin_date,admin_name,admin_no,admin_pwd)
 		values('admin1',sysdate, 'admin1',1,'admin1');
        
        
        