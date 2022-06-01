CREATE TABLE IF NOT EXISTS students (
                                        id SERIAL,
                                        name varchar(250) NOT NULL,
                                        surname varchar(250) NOT NULL
);
INSERT INTO students (name, surname) VALUES ('Jim', 'Tlolo');
INSERT INTO students (name, surname) VALUES ('Jim2', 'Tlolo2');