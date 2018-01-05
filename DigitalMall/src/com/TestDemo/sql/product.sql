--商品表
create table goods(
  --序号，主键
  id integer primary key,
  --名字
  name varchar2(100),
  --图片路径
  imagepath varchar2(128),
  --子分类
  category varchar2(100) ,
  --品牌
  cid REFERENCES category(id),
  --价格
  price number(10,2),
  --优惠价
	myprice number(10,2),
  --数量
  amount integer,
  --发布日期
  publishtime date,
  --描述
  descp varchar2(1000),
  --处理器
  professor varchar2(30),
  --内存
  memory varchar2(30),
  --硬盘
  disk varchar2(30),
  --显卡
  Graphics varchar2(30),
  --显示屏
  monitor varchar2(30),
  --编辑推荐
  editorrecommendstatus varchar2(100)
);
commit;

create sequence goods_seq start with 1;

insert into goods values(
goods_seq.nextval,
'联想E470c','lenovo_01.jpg','ThinkPad E470c',9,
3999.00,3499.00,100,to_date('2017-09-11','yyyy-mm-dd'),
'14英寸笔记本电脑（i5-6200U 8G 500G Win10）黑色',
'酷睿双核I5-6200U','8GB','500GB','集成显卡','14英寸','yes');

insert into goods values(
goods_seq.nextval,
'宏碁TMTX50-G2-50D4','Acer_01.jpg','TMTX50-G2-50D4(NX.VERCN.004)',10,
4399.00,4199.00,100,to_date('2017-08-11','yyyy-mm-dd'),
'墨舞 TMTX50 15.6英寸笔记本（i5-7200U 8G DDR4 256GB SSD 940MX 2G DDR5显存 全高清）黑色',
'英特尔酷睿I5-7200U','8GB','500GB','独立显卡','15.6英寸','yes');

insert into goods values(
goods_seq.nextval,
'苹果 Apple Macbook Air','Apple_01.jpg','Apple Macbook Air',11,
5988.00,5799.00,195,to_date('2016-05-01','yyyy-mm-dd'),
'苹果（Apple） Apple Macbook Air笔记本电脑13.3英寸 13.3英寸 双核i5/8GB内存/128闪存',
'Intel i5低功耗版','8GB内存','128闪存','集成显卡','13.3英寸超高清屏（2K/3k/4K)','yes');

commit;

select * from goods;