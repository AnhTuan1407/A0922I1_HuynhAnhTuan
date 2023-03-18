create database QuanLyDiemThi;

select * from HocSinh;
create table HocSinh(
	MaHS varchar(20) primary key,
    TenHS varchar(50),
    NgaySinh datetime,
    Lop varchar(20),
    GT varchar(20)
);

select * from MonHoc;
create table MonHoc(
	MaMH varchar(20) primary key,
    TenMH varchar(50)
);


select * from BangDiem;
create table BangDiem(
	MaHS varchar(20),
    MaMH varchar(20),
	foreign key (MaHS) references HocSinh(MaHS),
    foreign key (MaMH) references MonHoc(MaMH),
    DiemThi float,
    NgayKT datetime
);

select * from GiaoVien;
create table GiaoVien(
	MaGV varchar(20) primary key,
    TenGV varchar(50),
    SDT varchar(10)
);

ALTER TABLE MonHoc ADD MaGV VARCHAR(20);
ALTER TABLE MonHoc ADD CONSTRAINT FK_MaGV FOREIGN KEY (MaGV) REFERENCES GiaoVien(MaGV);