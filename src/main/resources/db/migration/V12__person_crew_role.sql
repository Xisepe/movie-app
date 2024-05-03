create table person_crew_role
(
    person_id    int references person (id),
    crew_role_id int references crew_role (id),
    primary key (person_id, crew_role_id)
);