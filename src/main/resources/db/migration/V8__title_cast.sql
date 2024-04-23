create table title_cast
(
    id             serial primary key,
    "order"        integer,
    character_name varchar(128),
    title_id       int references title (id),
    person_id      int references person (id)
);