-- liquibase formatted sql

-- changeset laserova:4
create table reports(
id serial primary key,
user_id bigint,
pet_id integer,
photo bytea,
diet varchar,
habits varchar,
probationDays smallint,
lastReportDate timestamp without timezone,
missedOneDay boolean default false,
missedTwoDay boolean default false
);