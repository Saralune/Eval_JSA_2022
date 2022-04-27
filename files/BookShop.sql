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
	user		int(4) PRIMARY KEY AUTO_INCREMENT,
	login			varchar(30)	NOT NULL,
	pwd			varchar(30)	NOT NULL,
	user_name	varchar(30)	NOT NULL,
	first_name	varchar(30)	NOT NULL,
	email 		VARCHAR(50) NOT NULL,
	tel 			VARCHAR(12)	NOT NULL,
	address 		VARCHAR(200) NOT NULL
);

CREATE TABLE admin (
	
);

CREATE TABLE u_order(
	id_order		int(4) PRIMARY KEY AUTO_INCREMENT,
	amount 		FLOAT(10) NOT NULL,
	DATE 			DATE(20) NOT NULL,
	id_user		INT(4)
);

ALTER TABLE u_order ADD FOREIGN KEY (id_user) REFERENCES user(id_user);

CREATE TABLE order_detail(
	id_order 		INT(4) NOT NULL,
	id_user 			INT(4) NOT NULL,
	id_book 			INT(4) NOT NULL,
	book_name		VARCHAR(30) NOT NULL,
	qty				INT(4) NOT NULL,
	date_order		DATE NOT NULL,
	unitary_price 	float(4) NOT NULL,
);

#En console, pour restreindre les droits :

#create user 'sara'@'localhost' identified by '123';
#grant all privileges on bookshop.* to 'sara'@'localhost';
#flush privileges;
#mysql -u sara -p
# show grants for 'sara'@'localhost';

SELECT * FROM user;

INSERT INTO user (login, pwd, user_name, first_name, email, tel, address) 
	VALUES ("annie", "123", "Anne", "Esthésie", "annie@mail.com", "010203040506", "123 rue bidon 31000 Toulouse"); 
INSERT INTO user (login, pwd, user_name, first_name, email, tel, address) 
	VALUES ("ella", "123", "Ella", "Trobu", "ella@mail.com", "010203040506", "236 rue bidon 31000 Toulouse"); 
INSERT INTO user (login, pwd, user_name, first_name, email, tel, address) 
	VALUES ("sara", "123", "Sara", "Fortiche", "sara@mail.com", "010203040506", "102 micile fixe 31000 Toulouse"); 
INSERT INTO user (login, pwd, user_name, first_name, email, tel, address) 
	VALUES ("denis", "123", "Denis", "Gaud", "denis@mail.com", "010203040506", "125 rue des 400 coups 31000 Toulouse"); 

SELECT * FROM category;

INSERT INTO category (cat_name) VALUES ("neuf");
INSERT INTO category (cat_name) VALUES ("occasion");
INSERT INTO category (cat_name) VALUES ("voyage");
INSERT INTO category (cat_name) VALUES ("jeunesse");
INSERT INTO category (cat_name) VALUES ("cuisine");
INSERT INTO category (cat_name) VALUES ("poésie");
INSERT INTO category (cat_name) VALUES ("science-fiction");
INSERT INTO category (cat_name) VALUES ("polar");
INSERT INTO category (cat_name) VALUES ("roman");
INSERT INTO category (cat_name) VALUES ("petit-prix");
INSERT INTO category (cat_name) VALUES ("meilleures ventes");

SELECT * FROM book;

INSERT INTO book (author, book_name, price, id_cat1, id_cat2, id_cat3) 
	VALUES ("Anonyme", "Le livre sans nom", 10.5, 1, 7, 11);
INSERT INTO book (author, book_name, price, id_cat1, id_cat2, id_cat3) 
	VALUES ("J.K. Rowling", "Harry Potter", 20, 1, 4, 9);
INSERT INTO book (author, book_name, price, id_cat1, id_cat2, id_cat3) 
	VALUES ("Guillaume Musso", "La fille de papier", 15.5, 1, 11, 9);
INSERT INTO book (author, book_name, price, id_cat1, id_cat2, id_cat3) 
	VALUES ("Anonyme", "Santa Mondega", 23, 1, 7, 11);
INSERT INTO book (author, book_name, price, id_cat1, id_cat2) 
	VALUES ("Byron Barton", "La voiture", 5.5, 2, 4);