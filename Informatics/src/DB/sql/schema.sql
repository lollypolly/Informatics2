-- CRUD
-- Create
-- Read
-- Update
-- Delete
create table driver
(
    id         serial primary key,
    first_name varchar(20),
    last_name  varchar(20),
    age        integer
);

create table car
(
    id        serial primary key,
    model     varchar(20),
    color     varchar(20),
    driver_id integer,
    foreign key (driver_id) references driver (id)
);

insert into driver(first_name, last_name, age)
values ('Марсель', 'Сидиков', 26);
insert into driver(first_name, last_name, age)
values ('Тимур', 'Камалеев', 19);
insert into driver(first_name, last_name, age)
values ('Альберт', 'Ханнанов', 19);

insert into car(model, color, driver_id)
values ('Nissan GTR', 'Grey', 2);
insert into car (model, color, driver_id)
values ('ГАЗ69', 'КАМУФЛЯЖ', 3),
       ('Волга', 'Бежевый', 3),
       ('Bugatti Chiron', 'Black', null);


select *
from driver;

select first_name, last_name
from driver;

select *
from driver
order by age desc;

select *
from driver
order by age, id desc;

select *
from driver
where age > 20
   or last_name like '%ев';

update driver
set age = 27
where id = 1;

select first_name, last_name
from driver d
where d.id in (select driver_id from car);

select *
from driver d
         left join car c on d.id = c.driver_id;

select *
from driver d
         right join car c on d.id = c.driver_id;

select *
from driver d
         inner join car c on d.id = c.driver_id;

select *
from driver d full join car c on d.id = c.driver_id;
