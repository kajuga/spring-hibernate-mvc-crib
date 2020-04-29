CREATE DATABASE hb_student_tracker;


DROP TABLE IF EXISTS student;
CREATE TABLE student (
                         id SERIAL PRIMARY KEY not null ,
                         first_name VARCHAR(45) DEFAULT NULL,
                         last_name VARCHAR(45) DEFAULT NULL,
                         email VARCHAR(45) DEFAULT NULL
);


truncate hb_student_tracker.public.student;