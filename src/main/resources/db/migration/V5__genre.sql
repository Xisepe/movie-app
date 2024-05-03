create table genre
(
    id   serial primary key,
    name varchar(64) unique
);

create unique index idx_genre_name on genre (lower(name));