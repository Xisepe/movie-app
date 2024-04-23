create table title_cast
(
    "order"        integer,
    character_name varchar(128),
    title_id       int references title(id),
    person_id      int references person(id),
    primary key (title_id, person_id)
);