DROP SCHEMA IF EXISTS student_demo;
-- DROP DATABASE IF EXISTS hb_student_tracker;
-- CREATE DATABASE hb_student_tracker;
CREATE SCHEMA student_demo;


DROP TABLE IF EXISTS student_demo.student;
CREATE TABLE student_demo.student (
                         id SERIAL PRIMARY KEY not null ,
                         first_name VARCHAR(45) DEFAULT NULL,
                         last_name VARCHAR(45) DEFAULT NULL,
                         email VARCHAR(45) DEFAULT NULL
);


-- truncate hb_student_tracker.public.student;