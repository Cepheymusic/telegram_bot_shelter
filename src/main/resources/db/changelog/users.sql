-- liquibase formatted sql

-- changeset laserova:2

create table users(
id bigserial primary key,
chat_id bigint,
name varchar(30),
surname varchar(30),
phone varchar(15),
email varchar
);

create table cat_adopter(
id_cat_adopter bigserial primary key,
address varchar,
date_start_probation date,
constraint "fk_users_catadopter" unique foreign key (id_users) references users(id)
);

create table dog_adopter(
id_dog_adopter bigserial primary key,
address varchar,
date_start_probation date,
constraint "fk_users_dogadopter" unique foreign key (id_users) references users(id)
);
