create table season
(
    id          serial primary key,
    tagline     varchar(128),
    total_votes integer,
    avg_rating  integer,
    name        varchar(128),
    description varchar(128),
    preview_id  integer references media_source (id) on delete set null,
    series_id   integer references title (id) on delete cascade,
    ordinal     integer not null
);