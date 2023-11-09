-- liquibase formatted sql

-- changeset laserova:3
create table cat(
id bigserial primary key,
--id_cat_adopter bigint,
name varchar(15),
age integer,
breed varchar(20),
health_restrictions boolean default false,
id_cat_adopter bigint references cat_adopter(id)
--constraint "fk_cat_adopter" foreign key (id_cat_adopter) references cat_adopter(id)
);

create table dog(
id bigserial primary key,
--id_dog_adopter bigint,
name varchar(15),
age integer,
breed varchar(20),
health_restrictions boolean default false,
id_dog_adopter bigint references dog_adopter(id)
--constraint "fk_dog_adopter" foreign key (id_dog_adopter) references dog_adopter(id)
);