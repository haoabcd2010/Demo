--类别表（一个表）
create table category(
  id integer primary key,
  name varchar2(40),
  parentid integer,
  amount integer
);
commit;

create sequence cat_seq start with 1;

insert into category values(cat_seq.nextval,'平板电脑',null,100);
insert into category values(cat_seq.nextval,'笔记本',null,100);
insert into category values(cat_seq.nextval,'台式机',null,100);
insert into category values(cat_seq.nextval,'手机',null,100);

insert into category values(cat_seq.nextval,'联想',1,20);
insert into category values(cat_seq.nextval,'宏碁',1,25);
insert into category values(cat_seq.nextval,'苹果',1,16);
insert into category values(cat_seq.nextval,'华硕',1,30);

insert into category values(cat_seq.nextval,'联想',2,28);
insert into category values(cat_seq.nextval,'宏碁',2,25);
insert into category values(cat_seq.nextval,'苹果',2,35);
insert into category values(cat_seq.nextval,'华硕',2,18);

insert into category values(cat_seq.nextval,'联想',3,48);
insert into category values(cat_seq.nextval,'宏碁',3,22);
insert into category values(cat_seq.nextval,'苹果',3,15);
insert into category values(cat_seq.nextval,'华硕',3,54);

insert into category values(cat_seq.nextval,'苹果',4,85);
insert into category values(cat_seq.nextval,'小米',4,35);
insert into category values(cat_seq.nextval,'华为',4,5);
insert into category values(cat_seq.nextval,'三星',4,54);
commit;

select * from category;