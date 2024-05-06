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
    ordinal     integer not null check ( ordinal > 0 )
);

create function inc_total_season() returns trigger as
$$
begin
    update title
    set total_season = total_season + 1
    where title.id = new.id;
end;
$$
language plpgsql;