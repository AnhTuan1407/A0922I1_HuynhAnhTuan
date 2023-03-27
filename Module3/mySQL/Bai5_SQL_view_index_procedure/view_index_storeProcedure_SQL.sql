create database product;
use product;
create table product (
	ID  int not null,
	product_code varchar(50),
	product_name varchar(50),
    product_price int not null ,
    product_amount varchar(50),
	product_description varchar(50),
    product_status  bit
);
INSERT INTO product
VALUES (1, 'MG01','May Giat', 300,2,'GOOD',0),
       (2, 'TL02', 'Tu Lanh', 450,5,'GOOD',1),
       (3, 'DH03', 'Dieu Hoa', 6000,1,'NORMAL',1),
       (4, 'QA04', 'Quat', 50,10,'SIMPLE',0),
       (5, 'BD05', 'Bep Dien',565,4,'OLD',1);
       
select * from product;

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
CREATE UNIQUE INDEX product_code
ON product (product_code);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
CREATE INDEX composite ON product(product_name, product_price);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
EXPLAIN SELECT * FROM product WHERE product_name = 'Dieu Hoa'; 

