create table person_crew_role
(
    person_id    int references person (id) on delete cascade,
    crew_role_id int references crew_role (id) on delete cascade,
    primary key (person_id, crew_role_id)
);