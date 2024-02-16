create database demo;
use demo;
create table Employee(
empId int auto_increment primary key,
empName varchar(25) not null,
doj varchar(30) ,
basicSlry int);
desc employee;
select * from employee;
