create database final_test;
use final_test;

select * from sach;
select * from hocsinh;
select * from themuonsach;

select t.mamuonsach, s.tensach, s.tacgia, h.hoten, h.lop, t.ngaymuon, t.ngaytra, t.trangthai from themuonsach t join sach s on t.masach = s.masach join hocsinh h on t.mahocsinh = h.mahocsinh;

select s.masach, s.tensach, s.tacgia, s.soluong, s.mota from sach s



