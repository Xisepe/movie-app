create table title_crew
(
    id        serial primary key,
    "order"   integer not null check ( "order" > 0 ),
    title_id  int references title (id) on delete cascade,
    person_id int references person (id) on delete cascade
);

create table title_crew_role
(
    title_crew_id int references title_crew (id) on delete cascade,
    crew_role_id  int references crew_role (id) on delete cascade,
    primary key (title_crew_id, crew_role_id)
);
