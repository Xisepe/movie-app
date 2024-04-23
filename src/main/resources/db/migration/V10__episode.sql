create table episode
(
    id          serial primary key,
    season_id   integer references season (id),
    tagline     varchar(128),
    total_votes integer,
    avg_rating  integer,
    name        varchar(128),
    description varchar(128),
    preview_id  int references media_source (id),
    ordinal     integer not null
);