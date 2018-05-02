
CREATE TABLE easybuy_comment(
	ec_id int auto_increment NOT NULL,
	ec_content varchar(200) NOT NULL,
	ec_create_time datetime NOT NULL,
	ec_reply varchar(200) NULL,
	ec_reply_time datetime NULL,
	ec_nice_name varchar(10) NULL,
	primary key(ec_id))default charset=utf8

CREATE TABLE easybuy_news(
	en_id int auto_increment NOT NULL,
	en_title varchar(40) NOT NULL,
	en_content varchar(1000) NOT NULL,
	en_create_time datetime NOT NULL,
 primary key(en_id))default charset=utf8

CREATE TABLE easybuy_order(
	eo_id int auto_increment NOT NULL,
	eo_user_id varchar(10) NOT NULL,
	eo_user_name varchar(20) NOT NULL,
	eo_user_address varchar(20) NOT NULL,
	eo_create_time datetime NOT NULL,
	eo_cost float NOT NULL,
	eo_status int NOT NULL,
 primary key(eo_id))default charset=utf8

CREATE TABLE easybuy_order_detail(
	eod_id int auto_increment NOT NULL,
	eo_id int NOT NULL,
	ep_id int NOT NULL,
	eod_quantity int NOT NULL,
	eod_cost float NOT NULL,
  primary key(eod_id))default charset=utf8


CREATE TABLE easybuy_product(
	ep_id int auto_increment NOT NULL,
	ep_name varchar(20) NULL,
	ep_description varchar(100) NOT NULL,
	rp_price float NULL,
	ep_stock int NULL,
	epc_id int NULL,
	epc_child_id int NULL,
	ep_file_name varchar(200) NOT NULL,
  primary key(ep_id))default charset=utf8
CREATE TABLE easybuy_product_cate;ry(
	epc_id int auto_increment NOT NULL,
	epc_name varchar(20) NOT NULL,
	epc_parent_id int NOT NULL,
   primary key(epc_id))default charset=utf8

CREATE TABLE easybuy_user(
	eu_user_id varchar(10) NOT NULL,
	eu_user_name varchar(20) NOT NULL,
	eu_password varchar(20) NOT NULL,
	eu_sex varchar(1) NOT NULL,
	eu_birthday date NULL,
	eu_identity_code varchar(18) NULL,
	eu_email varchar(80) NULL,
	eu_mobile varchar(11) NOT NULL,
	eu_address varchar(200) NOT NULL,
	eu_login real NULL,
	eu_status int NOT NULL,
 primary key(epc_id))default charset=utf8
