select * from bbs order by bbs_no desc;

delete from bbs where bbs_no=3;

commit;

alter table bbs MODIFY (bbs_cont varchar2(4000));

drop table bbs;
drop SEQUENCE bbs_no_seq;


--bbs_no_seq ����
create sequence bbs_no_seq
increment by 1 --1�� ���� �ɼ�
start with 1 -- 1���� ����
nocache;


select *from car_member;

insert into car_member (m_id, m_pwd, m_name, m_email, 
                    m_phone, m_tel, m_birth, m_no, regdate) 
    values ('1','1','1','1','1','1','1',car_seq.nextval, sysdate);

delete from car_member where m_id='1';

