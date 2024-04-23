create table season
(
    tagline     varchar(128),
    total_votes integer,
    avg_rating  integer,
    name        varchar(128),
    description varchar(128),
    preview_id  int references media_source (id),
    series_id   int references title (id),
    ordinal     int,
    primary key (series_id, ordinal)
);

create table season_episode
(
    season_ordinal     int,
    season_series_id   int,
    episodes_ordinal   int,
    episodes_series_id int,
    primary key (season_ordinal, season_series_id, episodes_ordinal, episodes_series_id),
    foreign key (season_ordinal, season_series_id) references season(ordinal, season_series_id)
);

alter table season_episodes
    add constraint fk_seaepi_on_episode foreign key (episodes_series_id, episodes_ordinal) references episode (series_id, ordinal);

alter table season_episodes
    add constraint fk_seaepi_on_season foreign key (season_series_id, season_ordinal) references season (series_id, ordinal);