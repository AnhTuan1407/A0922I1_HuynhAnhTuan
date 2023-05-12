create database products;
use products;
select * from product;
select * from category;

select p.id, p.name, p.price, p.amount, p.color, p.description, c.namecategory from product p JOIN category c ON p.idcategory = c.idcategory;