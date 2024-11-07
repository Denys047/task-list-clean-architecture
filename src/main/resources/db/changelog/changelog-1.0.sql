--liquibase formatted sql

--changeset denys:1
CREATE TABLE users
(
    id       uuid PRIMARY KEY,
    name     VARCHAR(256),
    username VARCHAR(256)  NOT NULL UNIQUE,
    password VARCHAR(1024) NOT NULL,
    role     VARCHAR(64)   NOT NULL
);

--changeset denys:2
CREATE TABLE tasks
(
    id          uuid PRIMARY KEY,
    title       VARCHAR(256) NOT NULL,
    description TEXT         NOT NULL,
    status      VARCHAR(64)  NOT NULL,
    date_start  DATE         NOT NULL,
    date_end    DATE         NOT NULL,
    user_id     uuid REFERENCES users (id)
);

