CREATE SEQUENCE IF NOT EXISTS notes_seq;
CREATE TABLE IF NOT EXISTS notes (
    id SERIAL PRIMARY KEY,
    title varchar(255),
    text text
);