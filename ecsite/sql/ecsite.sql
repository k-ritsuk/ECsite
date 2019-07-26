set names utf8;
set foreign_key_checks = 0;
drop database if exists ecsite;/*esciteがデータベース名になる*/
								/*もし「ecsite」というデータベースがあったら、削除する。*/

create datebase if not exists ecsite;/*「ecsite」データベースを作成*/
use ecsite;/*作成した「ecsite」データベースを利用*/


/*ログインに必要な情報を入力*/
drop table if exists login_user_transaction;

create table login_user_transaction(

id int not null primary key auto_increment,

login_id varchar(16) unique,/*ログインに必要なID*/
login_pass varchar(16),		/*ログインに必要なpassword*/
user_name varchar(50),		/*名前*/

insert_date datetime;
/*新しく作るから必要*/
updated_date datetime
/*insert文を実行するためUpdate*/

);


drop table if exists item_info_transaction;

create table item_info_transaction(

id int not null primary key auto_increment,

item_name varchar(30),	/*商品の名前*/
item_price int,			/*商品の値段*/
item_stock int,				/*商品の在庫*/

insert_date datetime;
/*新しく作るから必要*/
updated_date datetime
/*insert文を実行するためupdate*/

);


drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(

	id int not null primary key auto_increment,

item_transaction_id int,
total_price int,
total_count int,
user_master_id varher(16),
pay varchar(30),
insert_date datetime;
delete_date datetime
);


INSERT INTO item_info_transaction(item_name,item_price,item_stock) VALUES("ノートBook",100,50);
INSERT INTO login_user_transaction(login_id,login_pass,user_name) VALUES("internous","internous01","test");





)
