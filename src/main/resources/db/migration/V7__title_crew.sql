create table title_crew
(
    id        serial primary key,
    "order"   integer,
    title_id  int references title (id),
    person_id int references person (id)
);

create table title_crew_role
(
    title_crew_id int references title_crew (id),
    crew_role_id  int references crew_role (id),
    primary key (title_crew_id, crew_role_id)
);
