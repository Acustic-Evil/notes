CREATE SEQUENCE IF NOT EXISTS notes_id_seq;
CREATE TABLE IF NOT EXISTS notes (
    id BIGSERIAL PRIMARY KEY,
    title varchar(255),
    text text
);