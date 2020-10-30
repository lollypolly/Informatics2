create table service_user (
    id serial primary key,
    first_name varchar(20),
    last_name varchar(20),
    email varchar(20),
    hash_password varchar(100)
);
