DROP SCHEMA IF EXISTS hb_01_one_to_one_uni;
DROP DATABASE IF EXISTS hb_instructor_tracker;

CREATE DATABASE hb_instructor_tracker;


CREATE SCHEMA hb_01_one_to_one_uni;


-- SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS hb_01_one_to_one_uni.instructor_detail;

CREATE TABLE hb_01_one_to_one_uni.instructor_detail (
                        id SERIAL PRIMARY KEY NOT NULL, youtube_channel varchar(128) DEFAULT NULL, hobby varchar(45) DEFAULT NULL);

DROP TABLE IF EXISTS instructor;

CREATE TABLE hb_01_one_to_one_uni.instructor
                        (id SERIAL PRIMARY KEY NOT NULL, first_name varchar(45) DEFAULT NULL, last_name varchar(45) DEFAULT NULL,
                        email varchar(45) DEFAULT NULL, instructor_detail_id INTEGER NOT NULL REFERENCES hb_01_one_to_one_uni.instructor_detail(id) ON DELETE NO ACTION ON UPDATE NO ACTION);


