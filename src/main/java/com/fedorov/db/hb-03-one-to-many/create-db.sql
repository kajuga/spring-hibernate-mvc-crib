DROP SCHEMA IF EXISTS hb_03_one_to_many;
CREATE SCHEMA hb_03_one_to_many;

DROP TABLE IF EXISTS hb_03_one_to_many.instructor_detail;

CREATE TABLE hb_03_one_to_many.instructor_detail (
        id SERIAL PRIMARY KEY NOT NULL,
        youtube_channel varchar(128) DEFAULT NULL,
        hobby varchar(45) DEFAULT NULL
                                                 );

DROP TABLE IF EXISTS hb_03_one_to_many.instructor;

CREATE TABLE hb_03_one_to_many.instructor (
        id SERIAL PRIMARY KEY NOT NULL,
        first_name varchar(45) DEFAULT NULL,
        last_name varchar(45) DEFAULT NULL,
        email varchar(45) DEFAULT NULL,
        instructor_detail_id int DEFAULT NULL REFERENCES hb_03_one_to_many.instructor_detail(id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
                                          );

DROP TABLE IF EXISTS hb_03_one_to_many.course;

CREATE TABLE hb_03_one_to_many.course (
        id SERIAL PRIMARY KEY NOT NULL,
        title varchar(128) DEFAULT NULL,
        instructor_id int DEFAULT NULL REFERENCES hb_03_one_to_many.instructor(id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
                                       );