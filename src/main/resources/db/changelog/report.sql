-- liquibase formatted sql

-- changeset laserova:4
create table reports(
id bigserial primary key,
--id_users bigint,
photo bytea,
diet varchar,
health varchar,
habits varchar,
report_date date,
last_report_date date,
resolution varchar(30) default 'probation',
sent_message boolean default false,
id_users bigserial references users(id)
--constraint "fk_users_reports" foreign key (id_users) references users(id)
);
--`status` ENUM('new', 'progress', 'done', 'fauled') NOT NULL,