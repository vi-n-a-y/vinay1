
#Spring Boot with JDBC steps (with out using any JPA annotations)

SQL Queries

create table User(
id int primary key auto_increment,
uname varchar(50) unique,
password varchar(30) not null,
fullName varchar(60) not null,
email varchar(60) not null,
phno varchar(20) not null,
address varchar(255) not null);
select * from user;
create table account(
id int primary key auto_increment,
accountNumber varchar(30) unique,
bankName varchar(30) not null,
ifscCode varchar(15) not null,
acctType varchar(20) not null,
currBalance double not null,
userId int not null,
foreign key(userId) references user(id)
);
desc account;
select * from trxn;

select * FROM account;

create table trxn(trnId int auto_increment primary key,
trnDate timestamp default current_timestamp ,
fromAcc varchar(30) not null , 
toAcc varchar(30) not null, 
description varchar(255) ,
amountSend double not null,
balance double not null,
userId int not null,
foreign key(userId) references user(id),
foreign key(fromAcc) references account(accountNumber),
foreign key(toAcc) references account(accountNumber));

desc trxn;
