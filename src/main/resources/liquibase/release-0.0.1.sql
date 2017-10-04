--liquibase formatted sql

--changeset Jack:InitialSchemaCreation(dbms:postgresql failOnError:true splitStatements:false)

CREATE TABLE users (
  "id"                BIGSERIAL PRIMARY KEY,
  username            VARCHAR(30) UNIQUE,
  "password"          TEXT,
  enabled             BOOLEAN,
  creation_time       DATE,
  modification_time   DATE
);

INSERT INTO users ("id", username, "password", enabled, creation_time, modification_time)
VALUES (0, 'starter', 'starter', true, '01-OCT-17', null);
--rollback SELECT 1;