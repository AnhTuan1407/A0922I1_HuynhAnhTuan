create database products;
use products;
select * from product;
select * from category;

select p.id, p.name, p.price, p.amount, p.color, p.description, c.namecategory from product p JOIN category c ON p.idcategory = c.idcategory;
select p.id, p.name, p.price, p.amount, p.color, p.description, c.namecategory from product p JOIN category c ON p.idcategory = c.idcategory 
where name like "%y%";

DELIMITER $$
CREATE PROCEDURE search(in n varchar(120))
BEGIN
    select p.id, p.name, p.price, p.amount, p.color, p.description, c.namecategory from product p JOIN category c ON p.idcategory = c.idcategory 
	where `name` like "%n%" or p.price like "%n%" or p.amount like "%n%" or p.color like "%n%" or p.`description` like "%n%" or c.namecategory like "%n%"
	order by id;
END$$
DELIMITER ;

call search("n");

	select p.id, p.name, p.price, p.amount, p.color, p.description, c.namecategory from product p JOIN category c ON p.idcategory = c.idcategory 
	where `name` like "%n%"
	order by id;