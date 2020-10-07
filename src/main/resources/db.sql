truncate table cars;
truncate table users;


drop table if exists cars;
drop table if exists users;

create table cars
(
    series int          not null,
    name   varchar(128) not null,
    constraint cars_series_uindex
        unique (series)
);

alter table cars
    add primary key (series);

create table users
(
    id        int auto_increment
        primary key,
    name      varchar(255) not null,
    last_name varchar(255) not null,
    email     varchar(255) not null
);

