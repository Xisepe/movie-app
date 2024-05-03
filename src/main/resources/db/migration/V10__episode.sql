create table episode
(
    id          serial primary key,
    season_id   integer references season (id) on delete cascade,
    tagline     varchar(128),
    total_votes integer,
    avg_rating  integer,
    name        varchar(128),
    description varchar(128),
    preview_id  int     references media_source (id) on delete set null,
    ordinal     integer not null
);