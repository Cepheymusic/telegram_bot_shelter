-- liquibase formatted sql

-- changeset laserova:4
create table reports(
id bigserial primary key,
user_id bigint,
pet_id bigint,
photo_pet bytea,
diet varchar,
habits varchar,
probation_days smallint,
last_report_date timestamp without time zone
);