-- liquibase formatted sql

-- changeset laserova:3

create table users(
id BIGSERIAL primary key,
chat_id bigint,
name varchar(30),
surname varchar(30),
phone varchar(15),
email varchar
);

create table cat_adopter(
--id_adopter bigserial primary key,
id bigint,
chat_id bigint,
name varchar(30),
surname varchar(30),
phone varchar(15),
email varchar,
cat_id bigint,
dog_id bigint,
address varchar
);

create table dog_adopter(
--id_adopter bigserial primary key,
id bigint,
chat_id bigint,
name varchar(30),
surname varchar(30),
phone varchar(15),
email varchar,
dog_id bigint,
cat_id bigint,
address varchar
);