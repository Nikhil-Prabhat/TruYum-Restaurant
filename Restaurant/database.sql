SET SQL_SAFE_UPDATES = 0;
create database restaurant;
use restaurant;

create table admin_login
(email  varchar(30),
password varchar(30));

insert into admin_login values("nik@gmail.com","honey");
insert into admin_login values("pra@gmail.com","Sejal");

select * from admin_login;

create table menu(
id int not null auto_increment primary key,
pic varchar(200),
name varchar(20),
price float,
active boolean,
dateOfLaunch date,
category varchar(20),
freeDelivery boolean
);

insert into menu(pic,name,price,active,dateOfLaunch,category,freeDelivery) values("https://images.unsplash.com/photo-1528735602780-2552fd46c7af?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60","Sandwich",99.00,true,"2017/03/15","Main Course",true);
insert into menu(pic,name,price,active,dateOfLaunch,category,freeDelivery) values("https://images.unsplash.com/photo-1512152272829-e3139592d56f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60","Burgar",129.00,true,"2017/12/23","Main Course",false);
insert into menu(pic,name,price,active,dateOfLaunch,category,freeDelivery) values("https://images.unsplash.com/photo-1534308983496-4fabb1a015ee?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60","Pizza",149.00,true,"2017/08/21","Main Course",false);
insert into menu(pic,name,price,active,dateOfLaunch,category,freeDelivery) values("https://images.unsplash.com/photo-1491449347753-6b0223fb6931?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60","French fries",57.00,false,"2017/07/02","Starters",true);
insert into menu(pic,name,price,active,dateOfLaunch,category,freeDelivery) values("https://images.unsplash.com/photo-1564355808539-22fda35bed7e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60","Chocolate Brownie",32.00,true,"2022/11/02","Desserts",true);

select * from menu;

drop table menu;
select * from menu;

create table customer_login
(
name varchar(20),
password varchar(20)
);

insert into customer_login values("nik","seju");
insert into customer_login values("pra","seju");

select * from customer_login;

create table cart
(userid varchar(20),
id long);

select * from cart;
delete from cart;