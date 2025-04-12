CREATE SCHEMA dukes;
CREATE SCHEMA beans;

CREATE TABLE dukes.instrument(
    id UUID primary key,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255)

);

CREATE TABLE beans.instrument(
 id UUID primary key,
 name VARCHAR(255) NOT NULL,
 type VARCHAR(255)
);