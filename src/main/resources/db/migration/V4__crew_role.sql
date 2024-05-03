create table crew_role
(
    id   serial primary key,
    name varchar(64) unique
);

create unique index idx_crew_role_name on crew_role (lower(name));