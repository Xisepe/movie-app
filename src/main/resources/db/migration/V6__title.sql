create type mpaa_rating as enum ('G','PG','PG13','R','NC');

create table title
(
    id                  serial primary key,
    dtype               varchar(31),
    preview_id          int references media_source (id) on delete set null,
    ru_name             varchar(128),
    en_name             varchar(128),
    original_name       varchar(128),
    tagline             varchar(128),
    release_date        date,
    mpaa_rating         mpaa_rating,
    age_constraint      integer,
    duration            integer,
    original_country_id int references country (id) on delete set null,
    total_season        int default 0 check ( total_season >= 0 )
);

create index idx_title_ru_name on title (ru_name);
create index idx_title_en_name on title (en_name);
create index idx_title_original_name on title (original_name);
create index idx_title_release_date on title (release_date);

create table title_genres
(
    genres_id int references genre (id) on delete cascade,
    title_id  int references title (id) on delete cascade,
    primary key (genres_id, title_id)
);

create table title_media_source
(
    title_id        int references title (id) on delete cascade,
    media_source_id int references media_source (id) on delete cascade,
    primary key (title_id, media_source_id)
);