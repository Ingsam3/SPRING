--¸â¹ö Å×ÀÌºí
create table C_member(
    m_no NUMBER(38) ,
    m_id VARCHAR2(50) primary key,
    m_pwd  VARCHAR2(50) not null,
    m_name  VARCHAR2(50) not null,
    m_email  VARCHAR2(100) not null,
    m_phone  VARCHAR2(100) not null,
    m_tel  VARCHAR2(100) not null,
    m_birth  VARCHAR2(100) not null,
    regdate date default sysdate 
);

select * from C_member;
--¸â¹ö ½ÃÄö½º
CREATE SEQUENCE carmem_seq START WITH 1 INCREMENT BY 1;

commit;