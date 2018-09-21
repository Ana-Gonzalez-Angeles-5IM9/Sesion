
create database Lab3;
use Lab3;

create table usuarios(
    usu nvarchar(10),
    contra nvarchar(11)
);

insert into usuarios values
	('2017094951','1234');
    
insert into usuarios values
	('2017090462','4321');
    
select * from usuarios;	