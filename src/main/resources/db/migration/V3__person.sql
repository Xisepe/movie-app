create table person
(
    id             serial primary key,
    preview_id     integer references media_source (id) on delete set null,
    citizenship_id integer references country (id) on delete set null,
    place_of_birth varchar(255),
    date_of_death  date,
    date_of_birth  date,
    name           varchar(255)
);

create index idx_person_date_of_birth on person (date_of_birth);

create index idx_person_name on person (lower(name));
