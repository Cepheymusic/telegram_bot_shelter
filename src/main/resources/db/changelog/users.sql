-- liquibase formatted sql

-- changeset laserova:3

create table users(
id serial primary key,
chat_id bigint
);

create table cat_adopter(
id serial primary key,
cat_id int,
address varchar
);

create table dog_adopter(
id serial primary key,
dog_id int,
address varchar
);