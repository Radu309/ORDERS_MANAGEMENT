DROP DATABASE IF EXISTS virtualShop;
CREATE DATABASE IF NOT EXISTS virtualShop;
use virtualShop;
DROP TABLE if EXISTS clients;
DROP TABLE if EXISTS products;
DROP TABLE if EXISTS orders;

CREATE TABLE clients(
	primaryKey int primary key auto_increment,
	ID int,
    nameClient varchar(30),
    email varchar(30),
    age int
);

CREATE TABLE products(
	primaryKey int  primary key auto_increment,
	ID int ,
    nameProduct varchar(30),
    numberProducts int,
    price float
);

CREATE TABLE orders(
	orderId int primary key,
	clientID int,
    productID int,
    numberOfProducts int
);
insert into clients(ID, nameClient, email, age) values(1,"Ana-Maria","anaMaria@yahoo.com",12);
insert into clients(ID, nameClient, email, age) values(2,"Roxana Elena","roxanaElena@yahoo.com",15);
insert into clients(ID, nameClient, email, age) values(3,"Ionescu Ion","ionescuIon@yahoo.com",20);
insert into clients(ID, nameClient, email, age) values(4,"Rusinaru Florinel","rusinaruFlorinel.com",21);
insert into clients(ID, nameClient, email, age) values(5,"Theodora Naomi","theodoraNaomi.com",20);

insert into products(ID, nameProduct, numberProducts, price) values(1,"Periuta de dinti",25,10);
insert into products(ID, nameProduct, numberProducts, price) values(2,"Saltea",10,100);
insert into products(ID, nameProduct, numberProducts, price) values(3,"Mouse",10,300);
insert into products(ID, nameProduct, numberProducts, price) values(4,"Boxe",5,500);
insert into products(ID, nameProduct, numberProducts, price) values(5,"Casti",10,400);

insert into orders values(1,2,3,4);

delimiter //
create procedure newClient(IDVal int, nameClientVal varchar(30), emailVal varchar(30), ageVal float)
begin 
	INSERT INTO clients(ID, nameClient, email, age) VALUES
	(IDVal, nameClientVal, emailVal, ageVal);
end; //
##call newClient(4,"Roberta Mihaela", "robertaMihaela@yahoo.com",19);

delimiter //
create procedure newProduct(IDVal int, nameProductVal varchar(30), numberProductVal int, priceVal float)
begin 
	INSERT INTO products(ID, nameProduct, numberProduct, price) VALUES
	(IDVal, nameProductVal, numberProductVal, priceVal);
end; //

#delete from clients where clients.ID = 1;
#update clients set ID=ID-1  where clients.ID>1;
select * from clients;
select * from products;
select * from orders;