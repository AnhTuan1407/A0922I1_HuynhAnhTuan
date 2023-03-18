create database QuanLySinhVien;
create table Class(
	classId int not null auto_increment primary key,
    className varchar(60) not null,
    startDate datetime not null,
    status bit
);

create table Student(
	studentId int Not null Primary key auto_increment,
    studentName varchar(30) not null,
    address varchar(50),
    phone varchar(20),
    status bit,
    classId int not null,
    foreign key (classId) references Class(classId)
); 

create table Subject(
	subId int not null primary key auto_increment,
    subName varchar(30) not null,
    credit tinyint not null default 1 check (credit >=1),
    status bit default 1
);

create table mark (
	markId int not null primary key auto_increment,
    subId int not null,
    studentId int not null,
    mark float default 0, check (mark between 0 and 100),
    mark float default 0, check (mark between 0 and 100),
    examTimes tinyint default 1,
    UNIQUE (subId, studentId),
    FOREIGN KEY (SubId) REFERENCES Subject (SubId),
    FOREIGN KEY (StudentId) REFERENCES Student (StudentId)
);