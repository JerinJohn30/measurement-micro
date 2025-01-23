create database measurementdb;
use measurementdb;

create table measurement_details(
	measurement_id int primary key auto_increment,
    customer_id int,
    neck_size float,
    chest_size float,
    shoulder_length float,
    sleeve_length float,
    jacket_length float,
    waist_size float,
    hip_size float,
    pant_length float);
