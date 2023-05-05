create database jdbc_database_users;
create table users (
	id int(3) primary key not null auto_increment,
    name varchar(50) not null,
    age int(3) not null,
    gender int(3) not null,
    email varchar(50) not null,
    address varchar(50) not null
);

use jdbc_database_users;

insert into users(name, age, gender, email, address) values ('Gangplank', 35, 0, 'gangplank@gmail.com', 'Runeterra');
insert into users(name, age, gender, email, address) values ('Yasuo', 35, 0, 'yasuo@gmail.com', 'TpHcm');
insert into users(name, age, gender, email, address) values ('Yone', 35, 0, 'yone@gmail.com', 'Da Nang');
insert into users(name, age, gender, email, address) values ('Akali', 35, 0, 'akali@gmail.com', 'Ha Noi');
insert into users(name, age, gender, email, address) values ('Pyke', 35, 0, 'pyke@gmail.com', 'Quang Nam');
insert into users(name, age, gender, email, address) values ('Viego', 35, 0, 'viego@gmail.com', 'Hai Phong');
insert into users(name, age, gender, email, address) values ('Darius', 35, 0, 'darius@gmail.com', 'Yen Bai');

select * from users;