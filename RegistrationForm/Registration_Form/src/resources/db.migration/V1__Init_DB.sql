

CREATE SEQUENCE public.note_book_id_seq
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE Note_Books (
    id BIGINT DEFAULT nextval('public.note_book_id_seq'::regclass),
    subscriber_surname VARCHAR(32),
    subscriber_name VARCHAR(32),
    subscriber_patronymic VARCHAR(32),
    subscriber_nickname VARCHAR(20) NOT NULL UNIQUE,
    PRIMARY KEY(id)
);



