create database final_test_2;
use final_test_2;

select * from benhan;
select * from benhnhan;

select ba.maBenhAn, ba.maBenhNhan, bn.tenBenhNhan, ba.ngayNhapVien, ba.ngayRaVien, ba.lyDo from benhan ba join benhnhan bn on ba.maBenhNhan = bn.maBenhNhan;

UPDATE benhan join benhnhan on benhan.maBenhNhan = benhnhan.maBenhNhan set tenBenhNhan = 'Nguyen Van ACC', ngayNhapVien = '07-08-2016', ngayRaVien = '08-08-2019', lyDo = 'Ung thu gan cc' WHERE maBenhAn = 'BA-001'