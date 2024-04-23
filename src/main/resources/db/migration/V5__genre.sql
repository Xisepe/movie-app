create table genre
(
    id   serial primary key ,
    name varchar(64)
);

create index idx_genre_name on genre (name);