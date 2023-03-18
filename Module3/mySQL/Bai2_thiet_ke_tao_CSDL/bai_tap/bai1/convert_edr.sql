create database chuyendoierd;

create table phieuXuat(
	soPX int primary key not null,
    ngayXuat date
);

create table vatTu(
	maVTU int primary key not null,
    tenVTU varchar(50)
);

create table phieuNhap(
	soPN int primary key,
    ngayNhap date
);

create table donDH(
	soDH int primary key not null,
    ngayDH date,
    maNCC int not null,
    foreign key (maNCC) references nhaCC (maNCC)
);

create table nhaCC(
	maNCC int primary key not null,
    tenNCC varchar(50),
    diachi varchar(50)
);

create table sdt(
	sdt varchar(10) primary key not null,
    maNCC int ,
	foreign key (maNCC) references nhaCC (maNCC)
);

create table chi_tiet_phieu_xuat(
	soPX int not null,
    maVTU int not null,
    primary key (soPX, maVTU),
    foreign key (soPX) references phietXuat (soPX),
	foreign key (maVTU) references vatTu (maVTU)
);

create table chi_tiet_phieu_nhap(
	maVTU int not null,
    soPN int not null,
    primary key (maVTU, soPN),
    foreign key (maVTU) references vatTu (maVTU),
	foreign key (soPN) references phieuNhap (soPN)
);

create table chi_tiet_don_dat_hang(
	maVTU int not null,
    soDH int not null,
    primary key (maVTU, soDH),
	foreign key (maVTU) references vatTu (maVTU),
	foreign key (soDH) references donDH (soDH)
);
