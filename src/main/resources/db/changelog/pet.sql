-- liquibase formatted sql

-- changeset laserova:3
create table cat(
id bigserial primary key,
--id_cat_adopter bigint,
name varchar(15),
age integer,
breed varchar(20),
health_restrictions boolean,
status varchar(30),
id_cat_adopter bigserial references cat_adopter(id_cat_adopter)
--constraint "fk_cat_adopter" foreign key (id_cat_adopter) references cat_adopter(id)
);

create table dog(
id bigserial primary key,
--id_dog_adopter bigint,
name varchar(15),
age integer,
breed varchar(20),
health_restrictions boolean,
status varchar(30),
id_dog_adopter bigserial references dog_adopter(id_dog_adopter)
--constraint "fk_dog_adopter" foreign key (id_dog_adopter) references dog_adopter(id)
);