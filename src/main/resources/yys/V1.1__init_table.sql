USE beta_db;

CREATE TABLE person (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  age int(3) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into person (name,age) values('zhangsan',20);
insert into person (name,age) values('lisi',20);
insert into person (name,age) values('wangwu',20);

