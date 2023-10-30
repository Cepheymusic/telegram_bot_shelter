-- liquibase formatted sql

-- changeset laserova:3

create table users(
id BIGSERIAL primary key,
chat_id bigint,
name varchar,
surname varchar,
phone varchar(15),
email varchar
);

create table cat_adopter(
id bigserial primary key,
cat_id BIGINT,
address varchar
);

create table dog_adopter(
id bigserial primary key,
dog_id BIGINT,
address varchar
);