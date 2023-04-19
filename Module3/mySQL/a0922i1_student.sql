create database a0922i1_student;
create table students (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
 );
 use a0922i1_student;
insert into students(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into students(name, email, country) values('Kante','kante@che.uk','Runeterra');
insert into students(name, email, country) values('Akali','akali@che.uk','Runeterra');
insert into students(name, email, country) values('Yone','yone@che.uk','Runeterra');
insert into students(name, email, country) values('Yasuo','yasuo@che.uk','Runeterra');
insert into students(name, email, country) values('Ryze','ryze@che.uk','Runeterra');

ALTER USER 'root'@'localhost' IDENTIFIED BY '12345678';
FLUSH PRIVILEGES;

select * from students;

select id,name,email,country from users where id = 2
