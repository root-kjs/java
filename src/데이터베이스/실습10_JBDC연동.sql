drop database if exists exam10;
create database exam10;
use exam10;
create table board(
	bno int auto_increment,
    bcontent longtext not null,
    bwriter varchar(30),
    constraint primary key(bno)
);