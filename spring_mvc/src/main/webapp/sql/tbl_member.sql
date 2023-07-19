
create table tbl_member(
userid varchar2(50) primary key --회원 아이디
,userpw varchar2(50) not null --회원비번
,username varchar2(50) not null --회원이름
,email varchar2(100) --전자우편
,regdate date default sysdate --가입날짜
);

select *from tbl_member;