CREATE DATABASE IF NOT EXISTS tbschedule DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
use tbschedule;
drop table if exists t_user;
create table t_user(
 id int not null AUTO_INCREMENT primary key,
 username varchar(200),
 password varchar(100),
 salt char(40),
 version int not null,
 enable int,
 createtime timestamp default current_timestamp not null,
 updatetime timestamp default current_timestamp not null
);
