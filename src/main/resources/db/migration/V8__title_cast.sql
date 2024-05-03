create table title_cast
(
    id             serial primary key,
    "order"        integer,
    character_name varchar(128),
    title_id       int references title (id) on delete cascade,
    person_id      int references person (id) on delete cascade
);