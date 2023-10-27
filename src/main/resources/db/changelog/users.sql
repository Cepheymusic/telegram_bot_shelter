-- liquibase formatted sql

-- changeset laserova:3
--create table contact(
--name varchar(30),
--surname varchar(30),
--phone varchar(10),
--email varchar
--);

create table users(
id serial primary key,
chatId bigint
);

create table cat_adopter(
catId int,
address varchar
);

create table dog_adopter(
dogId int,
address varchar
);