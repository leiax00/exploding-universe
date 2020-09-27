create schema if not exists universe collate utf8mb4_unicode_ci;

create table if not exists universe.u_user
(
    id          int auto_increment primary key,
    username    varchar(255) null,
    password    varchar(255) null,
    phone_num   varchar(32)  null,
    role_id     int          not null,
    status      int          not null,
    description varchar(255) null,
    constraint `UK_USERNAME` unique (username)
) ENGINE = InnoDB;

create table if not exists universe.u_role
(
    id          int auto_increment primary key,
    name        varchar(64)  not null,
    authority   text,
    description varchar(255) null,
    constraint `UK_USERNAME` unique (name)
) ENGINE = InnoDB;
