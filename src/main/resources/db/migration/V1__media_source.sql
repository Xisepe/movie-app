drop table if exists media_source;

create type media_type as enum ('VIDEO', 'PHOTO');

create table media_source
(
    id         serial primary key,
    url        varchar(255),
    media_type media_type
);