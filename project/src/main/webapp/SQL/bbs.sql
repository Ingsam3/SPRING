select * from bbs order by bbs_no desc;

delete from bbs where bbs_no=3;

commit;

alter table bbs MODIFY (bbs_cont varchar2(4000));

drop table bbs;
drop SEQUENCE bbs_no_seq;


--bbs_no_seq 积己
create sequence bbs_no_seq
increment by 1 --1究 刘啊 可记
start with 1 -- 1何磐 矫累
nocache;


select *from car_member;
select *from C_member;

delete from c_member where m_id ='test2';

insert into C_member(m_id, m_pwd, m_name, m_email, m_phone, m_tel, m_birth, m_no, regdate) 
values('test','test','test','test','test','test','test',carmem_seq.nextval,sysdate);



delete from car_member where m_id='car_member';

insert into car_member (m_id, m_pwd, m_name, m_email, 
                    m_phone, m_tel, m_birth, m_no, regdate) 
    values ('1','1','1','1','1','1','1',car_seq.nextval, sysdate);

delete from car_member where m_id='1';

select * from carmem_seq;

CREATE SEQUENCE carmem_seq START WITH 1 INCREMENT BY 1;

insert into car_member(m_id, m_pwd, m_name, m_email, m_phone, m_tel, m_birth, m_no, regdate) 
values('test','test','test','test','test','test','test',carmem_seq.nextval,sysdate); 


SELECT *
  FROM all_sequences
 WHERE sequence_name = 'carmem_seq';


