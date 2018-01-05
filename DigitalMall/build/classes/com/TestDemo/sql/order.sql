--地址表
create table address(
  id integer primary key,
  receivename varchar2(40),
  fulladdress varchar2(200),
  postalcode varchar2(40),
  phone varchar2(40),
  mobile varchar2(40),
  userid integer references c_user(id)---用户外键 一对多
);
create sequence add_seq start with 1;

--订单表
create table t_order(
  id integer primary key,
  orderid varchar2(40),
  ordertime date,
  totalprice number(10,2),
  userid integer references c_user(id),---用户外键 一对多
  addressid integer references address(id)---地址外键 一对一（不用外键，直接拼接）
);
create sequence order_seq start with 1;

--订单项表
create table orderitem(
  id integer primary key,
  amount integer,
  subtotal number(10,2),
  orderid integer references t_order(id),---订单外键 一对多
  productid integer references goods(id)---商品外键 一对多
);
create sequence orderitem_seq start with 1;
commit;