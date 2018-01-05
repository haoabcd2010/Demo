--用户表
create table c_user(
id integer primary key,
name varchar2(40),
email varchar2(40),
password varchar2(40)
);
commit;

create sequence user_seq start with 1;

select * from c_user;