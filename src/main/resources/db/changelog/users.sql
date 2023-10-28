-- liquibase formatted sql

-- changeset laserova:3

create table users(
id serial primary key,
chatId real
);

create table cat_adopter(
id serial primary key,
catId int,
address varchar
);

create table dog_adopter(
id serial primary key,
dogId int,
address varchar
);