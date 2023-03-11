create database class;

create table class(
	id int,
    name_class varchar(255) 
);

select * from class;
insert into class(id, name_class)
values (1, 'A0922I1');
insert into class(id, name_class)
value (2, 'A0123I1');

create table teacher(
	id int,
    nameteacher varchar(255),
    age int,
    country varchar(255)
);

select * from teacher;
insert into teacher (id, nameteacher, age, country)
value (1, 'Tuan', 20, 'Viet Nam');

drop table class;
drop table teacher;

