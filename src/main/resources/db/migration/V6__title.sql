create type mpaa_rating as enum ('G','PG','PG13','R','NC');

create table title
(
    id                  serial primary key ,
    dtype               varchar(31),
    preview_id          int references media_source(id),
    ru_name             varchar(128),
    en_name             varchar(128),
    original_name       varchar(128),
    tagline             varchar(128),
    release_date        date,
    mpaa_rating         mpaa_rating,
    age_constraint      integer,
    duration            integer,
    original_country_id int references countries(id)
);

create table title_genres
(
    genres_id int references genre(id),
    title_id  int references title(id),
    primary key (genres_id, title_id)
);

create table title_media_source
(
    title_id          int references title(id),
    media_source_id int references media_source(id),
    primary key (title_id, media_source_id)
);