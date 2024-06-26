create table title_cast
(
    id             serial primary key,
    "order"        integer not null check ( "order" > 0 ),
    character_name varchar(128),
    title_id       int references title (id) on delete cascade,
    person_id      int references person (id) on delete cascade
);