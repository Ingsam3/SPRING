select * from bbs order by bbs_no desc;

commit;

alter table bbs MODIFY (bbs_cont varchar2(4000));

drop table bbs;
drop SEQUENCE bbs_no_seq;


--bbs_no_seq ����
create sequence bbs_no_seq
increment by 1 --1�� ���� �ɼ�
start with 1 -- 1���� ����
nocache;


