CREATE DATABASE QuanLynghiduongFurama;

USE QuanLynghiduongFurama;

CREATE TABLE vi_tri (
ma_vi_tri INT PRIMARY KEY AUTO_INCREMENT,
ten_vi_tri VARCHAR(45)
);

CREATE TABLE trinh_do (
ma_trinh_do INT PRIMARY KEY AUTO_INCREMENT,
ten_trinh_do VARCHAR(45)
);

CREATE TABLE bo_phan (
ma_bo_phan INT PRIMARY KEY AUTO_INCREMENT,
ten_bo_phan VARCHAR(45)
);

CREATE TABLE nhan_vien (
ma_nhan_vien INT PRIMARY KEY AUTO_INCREMENT,
ho_ten VARCHAR(45),
ngay_sinh DATE,
so_cmnd VARCHAR(45),
luong DOUBLE,
so_dien_thoai VARCHAR(45),
email VARCHAR(45),
dia_chi VARCHAR(45),
ma_vi_tri INT,
ma_trinh_do INT,
ma_bo_phan INT,
FOREIGN KEY (ma_vi_tri) REFERENCES vi_tri(ma_vi_tri),
FOREIGN KEY (ma_trinh_do) REFERENCES trinh_do(ma_trinh_do),
FOREIGN KEY (ma_bo_phan) REFERENCES bo_phan(ma_bo_phan)
);

CREATE TABLE loai_khach (
ma_loai_khach INT PRIMARY KEY AUTO_INCREMENT,
ten_loai_khach VARCHAR(45)
);

CREATE TABLE khach_hang (
ma_khach_hang INT PRIMARY KEY AUTO_INCREMENT,
ma_loai_khach INT,
ho_ten VARCHAR(45),
ngay_sinh DATE,
gioi_tinh BIT(1),
so_cmnd VARCHAR(45),
so_dien_thoai VARCHAR(45),
email VARCHAR(45),
dia_chi VARCHAR(45),
FOREIGN KEY (ma_loai_khach) REFERENCES loai_khach(ma_loai_khach)
);

CREATE TABLE kieu_thue (
ma_kieu_thue INT PRIMARY KEY AUTO_INCREMENT,
ten_kieu_thue VARCHAR(45)
);

CREATE TABLE loai_dich_vu (
ma_loai_dich_vu INT PRIMARY KEY AUTO_INCREMENT,
ten_loai_dich_vu VARCHAR(45)
);

CREATE TABLE dich_vu (
ma_dich_vu INT PRIMARY KEY AUTO_INCREMENT,
ten_dich_vu VARCHAR(45),
dien_tich INT,
chi_phi_thue DOUBLE,
so_nguoi_toi_da INT,
ma_kieu_thue INT,
ma_loai_dich_vu INT,
tieu_chuan_phong VARCHAR(45),
mo_ta_tien_nghi_khac VARCHAR(45),
dien_tich_ho_boi DOUBLE,
so_tang INT,
FOREIGN KEY (ma_kieu_thue) REFERENCES kieu_thue(ma_kieu_thue),
FOREIGN KEY (ma_loai_dich_vu) REFERENCES loai_dich_vu(ma_loai_dich_vu)
);

CREATE TABLE dich_vu_di_kem (
ma_dich_vu_di_kem INT PRIMARY KEY AUTO_INCREMENT,
ten_dich_vu_di_kem VARCHAR(45),
gia DOUBLE,
don_vi VARCHAR(10),
trang_thai VARCHAR(45)
);

CREATE TABLE hop_dong (
ma_hop_dong INT PRIMARY KEY AUTO_INCREMENT,
ngay_lam_hop_dong DATETIME,
ngay_ket_thuc DATETIME,
tien_dat_coc DOUBLE,
ma_nhan_vien INT,
ma_khach_hang INT,
ma_dich_vu INT,
FOREIGN KEY (ma_nhan_vien) REFERENCES nhan_vien(ma_nhan_vien),
FOREIGN KEY (ma_khach_hang) REFERENCES khach_hang(ma_khach_hang),
FOREIGN KEY (ma_dich_vu) REFERENCES dich_vu(ma_dich_vu)
);

CREATE TABLE hop_dong_chi_tiet (
ma_hop_dong_chi_tiet INT PRIMARY KEY AUTO_INCREMENT,
ma_hop_dong INT,
ma_dich_vu_di_kem INT,
so_luong INT,
FOREIGN KEY (ma_hop_dong) REFERENCES hop_dong(ma_hop_dong),
FOREIGN KEY (ma_dich_vu_di_kem) REFERENCES dich_vu_di_kem(ma_dich_vu_di_kem)
);

INSERT INTO vi_tri (ma_vi_tri, ten_vi_tri)
VALUE(1, 'Quản Lý'),
	 (2, 'Nhân Viên');
SELECT * FROM vi_tri;
     
INSERT INTO trinh_do (ma_trinh_do, ten_trinh_do)
VALUE(1, 'Trung Cấp'),
     (2, 'Cao Đẳng'),
     (3, 'Đại Học'),
     (4, 'Sau Đại Học');
SELECT * FROM trinh_do;
     
INSERT INTO bo_phan (ma_bo_phan, ten_bo_phan)
VALUE(1, 'Sale-Marketing'),
	 (2, 'Hành chính'),
     (3, 'Phục vụ'),
     (4, 'Quản lý');
SELECT * FROM bo_phan;
     
INSERT INTO nhan_vien
VALUE(1, 'Nguyễn Văn An', '1970-11-07',	'456231786', 10000000, '0901234121', 'annguyen@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng',	1, 3, 1),
     (2, 'Lê Văn Bình', '1997-04-09', '654231234', 7000000, '0934212314', 'binhlv@gmail.com', '22 Yên Bái, Đà Nẵng', 1, 2, 2),
     (3, 'Hồ Thị Yến', '1995-12-12', '999231723', 14000000, '0412352315', 'thiyen@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai', 1, 3, 2),
     (4, 'Võ Công Toản', '1980-04-04', '123231365', 17000000, '0374443232', 'toan0404@gmail.com', '77 Hoàng Diệu, Quảng Trị', 1, 4, 4),
     (5, 'Nguyễn Bỉnh Phát', '1999-12-09', '454363232', 6000000, '0902341231', 'phatphat@gmail.com', '43 Yên Bái, Đà Nẵng', 2, 1, 1),
     (6, 'Khúc Nguyễn An Nghi', '2000-11-08', '964542311', 7000000, '0978653213', 'annghi20@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', 2, 2, 3),
     (7, 'Nguyễn Hữu Hà', '1993-01-01', '534323231', 8000000, '0941234553', 'nhh0101@gmail.com', '4 Nguyễn Chí Thanh, Huế', 2, 3, 2),
     (8, 'Nguyễn Hà Đông', '1989-09-03', '234414123', 9000000, '0642123111', 'donghanguyen@gmail.com', '111 Hùng Vương, Hà Nội', 2, 4, 4),
     (9, 'Tòng Hoang', '1982-09-03', '256781231', 6000000, '0245144444', 'hoangtong@gmail.com', '213 Hàm Nghi, Đà Nẵng', 2, 4, 4),
     (10, 'Nguyễn Công Đạo', '1994-01-08', '755434343', 8000000, '0988767111', 'nguyencongdao12@gmail.com', '6 Hoà Khánh, Đồng Nai', 2, 3, 2);
 SELECT * FROM nhan_vien;
 
INSERT INTO loai_khach (ma_loai_khach, ten_loai_khach)
VALUE(1, 'Diamond'),
     (2, 'Platinium'),
     (3, 'Gold'),
     (4, 'Silver'),
     (5, 'Member');
SELECT * FROM loai_khach;
     
INSERT INTO khach_hang
VALUE(1, 5, 'Nguyễn Thị Hào', '1970-11-07', 0, '643431213', '0945423362', 'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng'),
     (2, 3, 'Phạm Xuân Diệu', '1992-08-08', 1, '865342123', '0954333333', 'xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị'),
     (3, 1, 'Trương Đình Nghệ', '1990-02-27', 1, '488645199', '0373213122', 'nghenhan2702@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh'),
     (4, 1, 'Dương Văn Quan', '1981-07-08', 1, '543432111', '0490039241', 'duongquan@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng'),
     (5, 4, 'Hoàng Trần Nhi Nhi', '1995-12-09', 0, '795453345', '0312345678', 'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai'),
     (6, 4, 'Tôn Nữ Mộc Châu', '2005-12-06', 0, '732434215', '0988888844', 'tonnuchau@gmail.com', '37 Yên Thế, Đà Nẵng'),
     (7, 1, 'Nguyễn Mỹ Kim', '1984-04-08', 0, '856453123', '0912345698', 'kimcuong84@gmail.com', 'K123/45 Lê Lợi, Hồ Chí Minh'),
     (8, 3, 'Nguyễn Thị Hào', '1999-04-08', 0, '965656433', '0763212345', 'haohao99@gmail.com', '55 Nguyễn Văn Linh, Kon Tum'),
     (9, 1, 'Trần Đại Danh', '1994-07-01', 1, '432341235', '0643343433', 'danhhai99@gmail.com', '24 Lý Thường Kiệt, Quảng Ngãi'),
     (10, 2, 'Nguyễn Tâm Đắc', '1989-07-01', 1, '344343432', '0987654321', 'dactam@gmail.com', '22 Ngô Quyền, Đà Nẵng');
SELECT * FROM khach_hang;
     
INSERT INTO kieu_thue (ma_kieu_thue, ten_kieu_thue)
VALUE(1, 'year'),
     (2, 'month'),
     (3, 'day'),
     (4, 'hour');
SELECT * FROM kieu_thue;
     
INSERT INTO loai_dich_vu (ma_loai_dich_vu, ten_loai_dich_vu)
VALUE(1, 'Villa'),
     (2, 'House'),
     (3, 'Room');
SELECT * FROM loai_dich_vu;
    
INSERT INTO dich_vu
VALUE(1, 'Villa Beach Front', 25000, 10000000, 10, 3, 1, 'vip', 'Có hồ bơi', 500, 4),
     (2, 'House Princess 01', 14000, 5000000, 7, 2, 2, 'vip', 'Có thêm bếp nướng', null, 3),
     (3, 'Room Twin 01', 5000, 1000000, 2, 4, 3, 'normal', 'Có tivi', null, null),
     (4, 'Villa No Beach Front', 22000, 9000000, 8, 3, 1, 'normal', 'Có hồ bơi', 300, 3),
     (5, 'House Princess 02', 10000, 4000000, 5, 3, 2, 'normal', 'Có thêm bếp nướng', null, 2),
     (6, 'Room Twin 02', 3000, 900000, 2, 4, 3, 'normal', 'Có tivi', null, null);
SELECT * FROM dich_vu;

INSERT INTO dich_vu_di_kem
VALUE(1, 'Karaoke', 10000, 'giờ', 'tiện nghi, hiện tại'),
     (2, 'Thuê xe máy', 10000, 'chiếc', 'hỏng 1 xe'),
     (3, 'Thuê xe đạp', 20000, 'chiếc', 'tốt'),
     (4, 'Buffet buổi sáng', 15000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
     (5, 'Buffet buổi trưa', 90000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
     (6, 'Buffet buổi tối', 16000, 'suất', 'đầy đủ đồ ăn, tráng miệng');
SELECT * FROM dich_vu_di_kem;
     
INSERT INTO hop_dong
VALUE(1, '2020-12-08', '2020-12-08', 0, 3, 1, 3),
     (2, '2020-07-14', '2020-07-21', 200000, 7, 3, 1),
     (3, '2021-03-15', '2021-03-17', 50000, 3, 4, 2),
     (4, '2021-01-14', '2021-01-18', 100000, 7, 5, 5),
     (5, '2021-07-14', '2021-07-15', 0, 7, 2, 6),
     (6, '2021-06-01', '2021-06-03', 0, 7, 7, 6),
     (7, '2021-09-02', '2021-09-05', 100000, 7, 4, 4),
     (8, '2021-06-17', '2021-06-18', 150000, 3, 4, 1),
     (9, '2020-11-19', '2020-11-19', 0, 3, 4, 3),
     (10, '2021-04-12', '2021-04-14', 0, 10, 3, 5),
     (11, '2021-04-25', '2021-04-25', 0, 2, 2, 1),
     (12, '2021-05-25', '2021-05-27', 0, 7, 10, 1);
SELECT * FROM hop_dong;
     
INSERT INTO hop_dong_chi_tiet
VALUE(1,  2, 4, 5),
     (2, 2, 5, 8),
     (3, 2, 6, 15),
     (4, 3, 1, 1),
     (5, 3, 2, 11),
     (6, 1, 3, 1),
     (7, 1, 2, 2),
     (8, 12, 2, 2);
SELECT * FROM hop_dong_chi_tiet;

-- 2. Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là
-- một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
SELECT * FROM nhan_vien
WHERE ho_ten like '% % H%' OR ho_ten like '% % T%' OR ho_ten like '% % K%';

-- 3. Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và
-- có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
SELECT * FROM khach_hang
WHERE dia_chi like '% Đà Nẵng' OR dia_chi like '% Quảng Trị' AND ((now() - year(ngay_sinh)) > 18 AND (now() - year(ngay_sinh)) < 50);

-- 4. Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu
-- lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của
-- khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là
-- “Diamond”.
SELECT k.ma_khach_hang, k.ho_ten, l.ten_loai_khach, COUNT(h.ma_khach_hang) AS so_lan_dat_phong
FROM khach_hang k JOIN loai_khach l ON k.ma_loai_khach = l.ma_loai_khach JOIN hop_dong h ON k.ma_khach_hang = h.ma_khach_hang
WHERE l.ten_loai_khach = 'Diamond'
GROUP BY h.ma_khach_hang
ORDER BY so_lan_dat_phong;

-- 6. Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue,
-- ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng
-- thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
SELECT d.ma_dich_vu, d.ten_dich_vu, d.dien_tich, d.chi_phi_thue, l.ten_loai_dich_vu
FROM dich_vu d JOIN loai_dich_vu l ON d.ma_loai_dich_vu = l.ma_loai_dich_vu JOIN hop_dong h ON d.ma_dich_vu = h.ma_dich_vu
WHERE year(h.ngay_ket_thuc) = 2020 OR (year(h.ngay_lam_hop_dong) = 2021 AND month(h.ngay_lam_hop_dong) > 3)
GROUP BY h.ma_dich_vu

-- 7. Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich,
-- so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các loại
-- dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng
-- chưa từng được khách hàng đặt phòng trong năm 2021.
SELECT d.ma_dich_vu, d.ten_dich_vu, d.dien_tich, d.so_nguoi_toi_da, d.chi_phi_thue, l.ten_loai_dich_vu
FROM dich_vu d JOIN loai_dich_vu l ON d.ma_loai_dich_vu = l.ma_loai_dich_vu JOIN hop_dong h ON d.ma_dich_vu = h.ma_dich_vu
WHERE year(h.ngay_ket_thuc) = 2020 AND year(h.ngay_lam_hop_dong) = 2020 
GROUP BY h.ma_dich_vu

-- 8. Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu
-- ho_ten không trùng nhau.
-- Cach 1
SELECT DISTINCT ho_ten FROM khach_hang
-- Cach 2

-- Cach 3

-- 9. Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi
-- tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt
-- phòng.
SELECT month(h.ngay_lam_hop_dong), COUNT(k.ma_khach_hang) AS so_luong_khach
FROM hop_dong h JOIN khach_hang k ON h.ma_khach_hang = k.ma_khach_hang
WHERE year(h.ngay_lam_hop_dong) = 2021
GROUP BY month(h.ngay_lam_hop_dong)
ORDER BY month(h.ngay_lam_hop_dong)

-- 10. Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu
-- dịch vụ đi kèm. Kết quả hiển thị bao gồm ma_hop_dong,
-- ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc,
-- so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở
-- dich_vu_di_kem).
SELECT hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc, SUM(hdct.so_luong) AS so_luong_dich_vu_di_kem
FROM hop_dong hd LEFT JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
GROUP BY hd.ma_hop_dong
ORDER BY hd.ma_hop_dong


-- 11. Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách
-- hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc
-- “Quảng Ngãi”.
SELECT dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem 
FROM dich_vu_di_kem dvdk JOIN hop_dong_chi_tiet hdct ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem JOIN hop_dong hd ON hdct.ma_hop_dong = hd.ma_hop_dong 
JOIN khach_hang k ON hd.ma_khach_hang = k.ma_khach_hang JOIN loai_khach l ON k.ma_loai_khach = l.ma_loai_khach 
WHERE l.ten_loai_khach = 'Diamond' AND (k.dia_chi like '% Vinh' OR  k.dia_chi like '% Quảng Ngãi')

-- 12. Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách
-- hàng), so_dien_thoai (khách hàng), ten_dich_vu,
-- so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở
-- dich_vu_di_kem), tien_dat_coc của tất cả các dịch vụ đã từng được
-- khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được
-- khách hàng đặt vào 6 tháng đầu năm 2021.
SELECT hd.ma_hop_dong , nv.ho_ten, kh.ho_ten, kh.so_dien_thoai, dv.ten_dich_vu, SUM(ifnull(hdct.so_luong, 0)) AS so_luong_dich_vu_di_kem, hd.tien_dat_coc
FROM hop_dong hd
LEFT JOIN nhan_vien nv ON hd.ma_nhan_vien = nv.ma_nhan_vien
LEFT JOIN khach_hang kh ON hd.ma_khach_hang = kh.ma_khach_hang
LEFT JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
LEFT JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong 
GROUP BY nv.ho_ten
HAVING hd.ma_hop_dong IN (SELECT hd1.ma_hop_dong FROM hop_dong hd1 WHERE MONTH(hd1.ngay_lam_hop_dong) IN (12, 11, 10) AND YEAR(hd1.ngay_ket_thuc) = 2020)

select hd.ma_hop_dong,nv.ho_ten as ten_nhan_vien ,kh.ho_ten,kh.so_dien_thoai,dv.ten_dich_vu, sum(hdct.so_luong) as so_luong_dich_vu_di_kem,
	sum(tien_dat_coc) as tong_tien_dat_coc from nhan_vien nv
join hop_dong hd using (ma_nhan_vien)
join khach_hang kh using (ma_khach_hang)
join dich_vu dv using (ma_dich_vu)
join hop_dong_chi_tiet  hdct using (ma_hop_dong)
where (ngay_lam_hop_dong between '2020-10-01' and '2020-12-31')
and (ngay_lam_hop_dong not between '2021-01-01' and '2021-06-30')
group by hd.ma_hop_dong;

-- 13. Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các
-- Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử
-- dụng nhiều như nhau).
SELECT dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, SUM(hdct.so_luong) AS so_lan_su_dung
FROM  dich_vu_di_kem dvdk JOIN hop_dong_chi_tiet hdct ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
GROUP BY hdct.ma_dich_vu_di_kem
ORDER BY so_lan_su_dung DESC
LIMIT 2;

-- 14. Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một
-- lần duy nhất. Thông tin hiển thị bao gồm ma_hop_dong,
-- ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính
-- dựa trên việc count các ma_dich_vu_di_kem)
SELECT h.ma_hop_dong, dv.ten_dich_vu, l.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, COUNT(hdct.so_luong) AS so_lan_su_dung 
FROM hop_dong h 
JOIN dich_vu dv ON h.ma_dich_vu = dv.ma_dich_vu  
JOIN loai_dich_vu l ON dv.ma_loai_dich_vu = l.ma_loai_dich_vu
JOIN hop_dong_chi_tiet hdct ON hdct.ma_hop_dong = h.ma_hop_dong 
JOIN dich_vu_di_kem dvdk ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
GROUP BY dvdk.ten_dich_vu_di_kem
HAVING so_lan_su_dung = 1
ORDER BY h.ma_hop_dong ;
SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));

-- 15. Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten,
-- ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi mới chỉ lập được
-- tối đa 3 hợp đồng từ năm 2020 đến 2021.
SELECT nv.ma_nhan_vien, nv.ho_ten, td.ten_trinh_do, bp.ten_bo_phan, nv.so_dien_thoai, nv.dia_chi
FROM nhan_vien nv 
JOIN trinh_do td ON nv.ma_trinh_do = td.ma_trinh_do 
JOIN bo_phan bp ON bp.ma_bo_phan = nv.ma_bo_phan 
JOIN hop_dong hd ON hd.ma_nhan_vien = nv.ma_nhan_vien
WHERE year(hd.ngay_lam_hop_dong) in (2020, 2021)
GROUP BY nv.ho_ten
HAVING COUNT(hd.ma_nhan_vien)  <= 3;

-- 16. Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019
-- đến năm 2021.
SELECT nv.ho_ten
FROM nhan_vien nv 
WHERE nv.ma_nhan_vien NOT IN (SELECT nv.ma_nhan_vien FROM nhan_vien nv 
JOIN hop_dong hd ON hd.ma_nhan_vien = nv.ma_nhan_vien
GROUP BY nv.ho_ten)
GROUP BY nv.ho_ten;

-- 17. Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum
-- lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với
-- Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
create view nb as
select khach_hang.ma_khach_hang,loai_khach.ten_loai_khach,sum((ifnull(chi_phi_thue,0)+ifnull(so_luong,0)*ifnull(gia,0))) as tong_tien
from khach_hang
join loai_khach using(ma_loai_khach)
join hop_dong using(ma_khach_hang)
join hop_dong_chi_tiet using(ma_hop_dong)
join dich_vu using(ma_dich_vu)
join dich_vu_di_kem using(ma_dich_vu_di_kem)
where year(hop_dong.ngay_lam_hop_dong)=2021
group by khach_hang.ma_khach_hang;
update khach_hang
set ma_loai_khach  = ( select ma_loai_khach from loai_khach where ten_loai_khach like "Diamond")
where ma_khach_hang in (select ma_khach_hang from nb where nb.tong_tien>10000000);

-- 18. Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc
-- giữa các bảng).
SELECT kh.ma_khach_hang, kh.ho_ten
FROM khach_hang kh JOIN hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang
WHERE (hd.ngay_lam_hop_dong between '2020-01-01' and '2020-12-31');

-- 19. Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong
-- năm 2020 lên gấp đôi.
SELECT dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, dvdk.gia
FROM dich_vu_di_kem dvdk JOIN hop_dong_chi_tiet hdct ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem 
JOIN hop_dong hd ON hd.ma_hop_dong = hdct.ma_hop_dong
WHERE YEAR(hd.ngay_lam_hop_dong) = 2020 
GROUP BY dvdk.ma_dich_vu_di_kem
HAVING SUM(hdct.so_luong) > 10;


-- 20. Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ
-- thống, thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang),
-- ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
select ma_khach_hang,ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi from khach_hang
union all
select ma_nhan_vien,ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi from nhan_vien;