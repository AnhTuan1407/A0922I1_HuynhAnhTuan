create database QuanLyBanHang_them_du_lieu;
use QuanLyBanHang_them_du_lieu;
create table Custommer(
	cID int primary key not null,
    cName varchar(50),
    cAge int
);

select * from Custommer;
insert into Custommer
values (1, 'Minh Quan', 10),
	(2, 'Ngoc Oanh', 20),
    (3, 'Hong Ha', 50);

create table Oder(
	oID int primary key not null,
    cID int not null,
    foreign key (cID) references Custommer (cID),
    oDate date,
    oTotalPrice double
);

select * from Oder;
insert into oder
values (1, 1, '2006-3-21', null),
	(2, 2, '2006-3-23', null),
    (3, 1, '2006-3-16', null);

create table OderDetail(
	oID int not null,
    pID int not null,
    odQTY double,
    primary key (oID, pID),
    foreign key (oID) references Oder (oID),
    foreign key (pID) references Product (pID)
);

select * from OderDetail;
insert into OderDetail
values (1, 1, 3),
	(1, 3, 7),
    (1, 4, 2),
    (2, 1, 1),
    (3, 1, 8),
    (2, 5, 4),
    (2, 3, 3);

create table Product(
	pID int not null primary key,
    pName varchar(50),
    pPrice double
);

select * from Product;
insert into Product
values (1, 'May Giat', 3),
	(2, 'Tu Lanh', 5),
    (3, 'Dieu Hoa', 7),
    (4, 'Quat', 1),
    (5, 'Bep Dien', 2);
    
select oId, oDate, oTotalPrice from Oder;

select * 
from Custommer c join Oder o on c.cID = o.cID join OderDetail od on o.oId = od.oId join Product p on od.pId =p.pId;  

select * from custommer c
left join oder o on c.cId=o.cId
where o.cId is null;
