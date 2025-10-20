/** 데이터베이스 생성 */
create database shoppy;

/** 데이터베이스 열기 */
use shoppy;
select database();


/** 테이블 목록 확인 */

/** member 테이블 생성 */
create table member(
	id  varchar(50) primary key,
    pwd varchar(50) not null,
    name varchar(20) not null,
    phone char(13),
    email varchar(50) not null,
    mdate date
);
-- pwd 사이즈 변경 
alter table member modify column pwd varchar(100) not null; 
show tables;
desc member;
select * from member;
SET SQL_SAFE_UPDATES = 0;
delete from member where mdate = "2025-10-17";
select count(id) from member where id = "test";
select pwd from member where id="hong";







/************************************************
상품 테이블 : product
************************************************/

create table product (
	pid int auto_increment primary key,
    name varchar(200) not null,
    price long,
    info varchar(200),
    rate double,
    image varchar(100),
    imgList json
);
desc product;
select * from productl
-- "pid" : "1",
--         "image" : "1.webp",
--         "name" : "후드티",
--         "price": 15000,
--         "info" : "분홍색 후드티",
--         "rate": "4.2",
--         "imgList" : [
--             "/images/1.webp",
--             "/images/1.webp",
--             "/images/1.webp"
--         ],













