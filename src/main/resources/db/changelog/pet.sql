-- liquibase formatted sql

-- changeset laserova:2
create table cat(
id bigserial primary key,
name varchar(15),
--photo bytea,
age integer,
breed varchar(20),
health_restrictions boolean,
status varchar(30)
);

create table dog(
id bigserial primary key,
name varchar(15),
--photo bytea,
age integer,
breed varchar(20),
health_restrictions boolean,
status varchar(30)
);