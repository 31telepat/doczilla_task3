CREATE TABLE IF NOT EXISTS students (
    id SERIAL,
    name varchar(250) NOT NULL,
    surname varchar(250) NOT NULL,
    patronymic varchar(250) NOT NULL,
    dateOfBorn DATE,
    nameOfGroup varchar(250) NOT NULL
);
