-- liquibase formatted sql

-- changeset laserova:2
create table cat(
id bigserial primary key,
name varchar(15),
file_path varchar,
file_size bigint,
media_type varchar(30),
data bytea,
age integer,
breed varchar(20),
health_restrictions boolean,
status varchar(30)
);

create table dog(
id bigserial primary key,
name varchar(15),
file_path varchar,
file_size bigint,
media_type varchar(30),
data bytea,
age integer,
breed varchar(20),
health_restrictions boolean,
status varchar(30)
);