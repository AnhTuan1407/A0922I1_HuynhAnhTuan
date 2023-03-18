create database QuanLyBanHang;
create table Custommer(
	cID int primary key not null,
    cName varchar(50),
    cAge int
);

create table Oder(
	oID int primary key not null,
    cID int not null,
    foreign key (cID) references Custommer (cID),
    oDate date,
    oTotalPrice double
);

create table OderDetail(
	oID int not null,
    pID int not null,
    odQTY double,
    primary key (oID, pID),
    foreign key (oID) references Oder (oID),
    foreign key (pID) references Product (pID)
);

create table Product(
	pID int not null primary key,
    pName varchar(50),
    pPrice double
);
