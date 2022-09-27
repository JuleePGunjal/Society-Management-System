drop database project;
create database project;
use project;
drop table if exists  owner;
drop table if exists societyflat;

drop table if exists visitor;

drop table if exists complaint;
drop table if exists tenant;
drop table if exists maintenance;


drop table if exists noticeboard;

create table owner (id integer primary key auto_increment, 
firstName varchar(50),
lastName varchar(50),
gender varchar(50),
dob date,
mobileNo varchar(50),
email varchar(50),
role varchar(50),
password varchar(600));



create table societyflat(
id integer primary key auto_increment,
ownerId int ,
wing char(1), 
flatType varchar(5),
registerDate date, 
parkingSlot int , 
flatNo int , 
floorNo int,
FOREIGN KEY (ownerId) REFERENCES owner(id)
 );




create table visitor (
id integer primary key auto_increment, 
name varchar(50), 
flatId int, 
contactNo char(10) ,
inTime timestamp default CURRENT_TIMESTAMP, 
FOREIGN KEY (flatId) REFERENCES societyflat(id)
);


drop table if exists vehicle;
create table vehicle (
id integer primary key auto_increment,
flatId int 
,vehicleNo char(20) ,
FOREIGN KEY (flatId) REFERENCES societyflat(id)
);



create table complaint (
id integer primary key auto_increment, 
complaint varchar(600),
ownerId int , 
status varchar(20),
FOREIGN KEY (ownerId) REFERENCES owner(id)
);

create table tenant (
id integer primary key auto_increment, 
firstName varchar(20),
flatId int , 
lastName varchar(20),
contactNo varchar(10),
gender varchar(10),
email varchar(50)
);

drop table if exists maintenance;
create table maintenance (
id integer primary key auto_increment,
month varchar(10), 
flatId int ,
flatMaintenance double(10,2) 
,waterBill double(10,2) ,
parkingBill double(10,2),
others  double(10,2) , 
FOREIGN KEY (flatId) REFERENCES societyflat(id)
);

drop table if exists workstaff;
 create table workstaff (
id integer primary key auto_increment, 
name varchar(30),
 password varchar(600),
monthSalary double(10,2),
address varchar (100),
role varchar(20),
contactNo varchar(10),
email varchar(50)
);


 create table noticeboard (
id integer primary key auto_increment, 
noticeDate timestamp default CURRENT_TIMESTAMP ,
noticemsg varchar(100),
ownerId int,
FOREIGN KEY (ownerId) REFERENCES owner(id));






-- 

insert into owner  (id,firstName,lastName,gender,dob,mobileNo,email,role ,password) values (1,'Julee','Gunjal','Female','1994-06-25','9421291362','julee@gmail.com','secretary','$2a$12$u/8prqWM5C.YL9qdnaHEYOtm5xLlfxC2.57Hgl6UPg1NIyux49RPG');
insert into owner(id,firstName,lastName,gender,dob,mobileNo,email,role ,password) values(2,'Amit', 'Kulkarni','Male', '1900-12-23','9876543210','amit@test.com', 'owner','$2a$10$H9PsSv9rLfYkvU6xZzACcenHp0heUe2J7jzOZTMd5Ov5zbX.YOicS');
insert into owner(id,firstName, lastName, email, role , password) values(3,'Nilesh', 'Ghule', 'nilesh@gmail.com', 'owner','$2a$10$LJeV/Fo8Gw7mTUCP7YiHpeiuKqcgRvUq.H19VDbsB2MSDupE7KXc2');


insert into societyflat(wing,flatType,registerDate,parkingSlot,flatNo,floorNo) values ('A','2Bhk','2021-06-24',101,101,1);
insert into societyflat(wing,flatType,registerDate,parkingSlot,flatNo,floorNo) values ('A','2Bhk','2021-01-24',102,102,1);
insert into societyflat(wing,flatType,registerDate,parkingSlot,flatNo,floorNo) values ('A','2Bhk','2010-12-10',201,201,2);
insert into societyflat(wing,flatType,registerDate,parkingSlot,flatNo,floorNo) values ('A','2Bhk','2015-06-24',202,202,2);
insert into societyflat(wing,flatType,registerDate,parkingSlot,flatNo,floorNo) values ('A','2Bhk','2021-06-24',301,301,3);
insert into societyflat(wing,flatType,registerDate,parkingSlot,flatNo,floorNo) values ('A','2Bhk','2021-01-24',302,302,3);
insert into societyflat(wing,flatType,registerDate,parkingSlot,flatNo,floorNo) values ('B','3Bhk','2021-06-24',101,101,1);
insert into societyflat(wing,flatType,registerDate,parkingSlot,flatNo,floorNo) values ('B','3Bhk','2021-01-24',102,102,1);
insert into societyflat(wing,flatType,registerDate,parkingSlot,flatNo,floorNo) values ('B','3Bhk','2010-12-10',201,201,2);
insert into societyflat(wing,flatType,registerDate,parkingSlot,flatNo,floorNo) values ('B','3Bhk','2015-06-24',202,202,2);
insert into societyflat(wing,flatType,registerDate,parkingSlot,flatNo,floorNo) values ('B','3Bhk','2021-06-24',301,301,3);
insert into societyflat(wing,flatType,registerDate,parkingSlot,flatNo,floorNo) values ('B','3Bhk','2021-01-24',302,302,3);
insert into societyflat(wing,flatType,registerDate,parkingSlot,flatNo,floorNo) values ('C','2Bhk','2021-06-24',101,101,1);
insert into societyflat(wing,flatType,registerDate,parkingSlot,flatNo,floorNo) values ('C','2Bhk','2021-01-24',102,102,1);
insert into societyflat(wing,flatType,registerDate,parkingSlot,flatNo,floorNo) values ('C','2Bhk','2010-12-10',201,201,2);
insert into societyflat(wing,flatType,registerDate,parkingSlot,flatNo,floorNo) values ('C','2Bhk','2015-06-24',202,202,2);
insert into societyflat(wing,flatType,registerDate,parkingSlot,flatNo,floorNo) values ('C','2Bhk','2021-06-24',301,301,3);
insert into societyflat(wing,flatType,registerDate,parkingSlot,flatNo,floorNo) values ('C','2Bhk','2021-01-24',302,302,3);








