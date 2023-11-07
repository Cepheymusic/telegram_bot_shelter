-- liquibase formatted sql

-- changeset laserova:5

create table volunteer(
id serial primary key,
chat_id bigint,
name varchar(30),
phone varchar(15),
email varchar
);