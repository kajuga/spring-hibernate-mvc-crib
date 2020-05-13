DROP SCHEMA IF EXISTS hb_eager_vs_lazy_demo;
CREATE SCHEMA hb_eager_vs_lazy_demo;

DROP TABLE IF EXISTS hb_eager_vs_lazy_demo.instructor_detail;

CREATE TABLE hb_eager_vs_lazy_demo.instructor_detail (
        id SERIAL PRIMARY KEY NOT NULL,
        youtube_channel varchar(128) DEFAULT NULL,
        hobby varchar(45) DEFAULT NULL
                                                 );

DROP TABLE IF EXISTS hb_eager_vs_lazy_demo.instructor;

CREATE TABLE hb_eager_vs_lazy_demo.instructor (
        id SERIAL PRIMARY KEY NOT NULL,
        first_name varchar(45) DEFAULT NULL,
        last_name varchar(45) DEFAULT NULL,
        email varchar(45) DEFAULT NULL,
        instructor_detail_id int DEFAULT NULL REFERENCES hb_eager_vs_lazy_demo.instructor_detail(id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
                                          );

DROP TABLE IF EXISTS hb_eager_vs_lazy_demo.course;

CREATE TABLE hb_eager_vs_lazy_demo.course (
        id SERIAL PRIMARY KEY NOT NULL,
        title varchar(128) DEFAULT NULL,
        instructor_id int DEFAULT NULL REFERENCES hb_eager_vs_lazy_demo.instructor(id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
                                       );