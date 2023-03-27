create database QuanLySinhVien_function;
use QuanLySinhVien_function;
create table Class(
	classId int not null auto_increment primary key,
    className varchar(60) not null,
    startDate datetime not null,
    status bit
);

select * 
from Class;
INSERT INTO Class
VALUES (1, 'A1', '2008-12-20', 1),
(2, 'A2', '2008-12-22', 1),
(3, 'B3', current_date, 0);


create table Student(
	studentId int Not null Primary key auto_increment,
    studentName varchar(30) not null,
    address varchar(50),
    phone varchar(20),
    status bit,
    classId int not null,
    foreign key (classId) references Class(classId)
); 

select * from student;
insert into Student
values (studentId,'Huu Hung', 'Ha Noi', '0912113113', 1, 1),
(studentId,'Le Thi Hoa', 'Hai phong', null, 1, 1),
(studentId,'Manh', 'HCM', '0123123123', 0, 2);
insert into student 
values (studentId, 'oohoo hoo', 'Ha Noi', '082342635', 1, 1);


create table Subject(
	subId int not null primary key auto_increment,
    subName varchar(30) not null,
    credit tinyint not null default 1 check (credit >=1),
    status bit default 1
);

select * from Subject;
insert into Subject
	values (1, 'CF', 3, 1),
		(2, 'C', 6, 1),
        (3, 'HDJ', 5, 1),
        (4, 'RDBMS', 4, 1);

create table mark (
	markId int not null primary key auto_increment,
    subId int not null,
    studentId int not null,
    mark float default 0, check (mark between 0 and 100),
    examTimes tinyint default 1,
    unique key (subId, studentId),
    FOREIGN KEY (SubId) REFERENCES Subject (SubId),
    FOREIGN KEY (StudentId) REFERENCES Student (StudentId)
);

select * from mark;
INSERT INTO Mark (SubId, StudentId, Mark, ExamTimes)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);
       

select * from student;

select * from student where status = 1;

select * from subject where credit < 10;

SELECT S.StudentId, S.StudentName, C.ClassName
FROM Student S join Class C on S.ClassId = C.ClassID
WHERE C.ClassName = 'A1';

SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM Student S join Mark M on S.StudentId = M.StudentId join Subject Sub on M.SubId = Sub.SubId
WHERE Sub.SubName = 'CF';

select * from student 
where studentName like "% h%";

select * from class 
where month(startDate) = 12;

select * from subject 
where credit >  3 and credit < 9;

select s.studentName, sub.subName, m.mark 
from Student s join  Mark m on s.studentId = m.studentId join subject sub on m.subId = sub.subId
order by m.mark, s.studentname;

SET SQL_SAFE_UPDATES = 0;
update student 
inner join class on student.classId = class.classId
set student.classId = 2
where student.studentName like '% Hung';

-- Hien thi subject co credit lon nhat
select * from subject 
where credit=(select max(credit) from subject);


-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select * from subject join mark on subject.subId = mark.subid 
where mark = (select max(mark) from mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select s.studentid, s.studentname, s.address, s.phone, avg(m.mark) from student s
join mark m on s.studentid = m.studentid
group by m.studentid;
