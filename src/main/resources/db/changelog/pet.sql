-- liquibase formatted sql

-- changeset laserova:2
create table cat(
id serial primary key,
name varchar(15),
photo bytea,
age integer,
breed varchar(20),
healthRestrictions boolean,
diet varchar,
habits text,
status integer
);

create table dog(
id serial primary key,
name varchar(15),
photo bytea,
age integer,
breed varchar(20),
healthRestrictions boolean,
diet varchar,
habits text,
status integer
);