create table title_crew
(
    "order"   integer,
    title_id  int references title (id),
    person_id int references person (id),
    primary key (title_id, person_id)
);

create table title_crew_role
(
    title_id     int references title(id),
    person_id    int references person(id),
    crew_role_id int references crew_role(id),
    primary key (title_id, person_id, crew_role_id)
);
