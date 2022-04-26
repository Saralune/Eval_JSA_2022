DROP DATABASE if EXISTS BookShop;
CREATE DATABASE BookShop;
USE bookshop;

CREATE TABLE book (
	id_book		int(4) PRIMARY KEY AUTO_INCREMENT,
	author		varchar(30)	NOT NULL,
	book_name	varchar(30)	NOT NULL,
	price			float(8)	NOT NULL DEFAULT 0,
	id_cat1 		INT(4),
	id_cat2		INT(4),
	id_cat3 		INT(4)
);

CREATE TABLE category(
	id_cat 		INT(4) PRIMARY KEY AUTO_INCREMENT,
	cat_name		VARCHAR(30) NOT NULL
);

CREATE TABLE user (
	id_user		int(4) PRIMARY KEY AUTO_INCREMENT,
	login			varchar(30)	NOT NULL,
	pwd			varchar(30)	NOT NULL
);

CREATE TABLE customer (
	cust_name				varchar(30)	NOT NULL,
	first_name		varchar(30)	NOT NULL,
	email 			VARCHAR(50) NOT NULL,
	tel 				VARCHAR(12)	NOT NULL,
	address 			VARCHAR(200) NOT NULL
);

CREATE TABLE admin (
	name				varchar(30)	NOT NULl
);

CREATE TABLE cust_ORDER(
	id_order		int(4) PRIMARY KEY AUTO_INCREMENT,
	amount 		FLOAT(10) NOT NULL,
	DATE 			DATE(20) NOT NULL,
	idUser		INT(4)
);

ALTER TABLE cust_order ADD FOREIGN KEY (id_user) REFERENCES user(id_user);

CREATE TABLE order_detail(
	id_order 		INT(4) NOT NULL,
	id_user 			INT(4) NOT NULL,
	id_book 			INT(4) NOT NULL,
	book_name		VARCHAR(30) NOT NULL,
	qty				INT(4) NOT NULL,
	date_order		DATE NOT NULL,
	unitary_price 	float(4) NOT NULL,
	amount			FLOAT(4) NOT NULL,
);

