create table episode
(
    tagline     varchar(128),
    total_votes integer,
    avg_rating  integer,
    name        varchar(128),
    description varchar(128),
    preview_id  int references media_source (id),
    series_id   int references title (id),
    ordinal     integer not null,
    primary key (series_id, ordinal)
);