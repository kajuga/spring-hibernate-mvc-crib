    DROP SCHEMA IF EXISTS hb_04_one_to_many_uni;
    CREATE SCHEMA hb_04_one_to_many_uni;

    DROP TABLE IF EXISTS hb_04_one_to_many_uni.instructor_detail;
    CREATE TABLE hb_04_one_to_many_uni.instructor_detail (
        id SERIAL PRIMARY KEY NOT NULL,
        youtube_channel varchar(128) DEFAULT NULL,
        hobby varchar(45) DEFAULT NULL
                                                     );


    DROP TABLE IF EXISTS hb_04_one_to_many_uni.instructor;
    CREATE TABLE hb_04_one_to_many_uni.instructor (
        id SERIAL PRIMARY KEY NOT NULL,
        first_name varchar(45) DEFAULT NULL,
        last_name varchar(45) DEFAULT NULL,
        email varchar(45) DEFAULT NULL,
        instructor_detail_id int DEFAULT NULL REFERENCES hb_04_one_to_many_uni.instructor_detail(id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
                                                );


    DROP TABLE IF EXISTS hb_04_one_to_many_uni.course;
    CREATE TABLE hb_04_one_to_many_uni.course (
        id SERIAL PRIMARY KEY NOT NULL,
        title varchar(128) DEFAULT NULL,
        instructor_id int DEFAULT NULL REFERENCES hb_04_one_to_many_uni.instructor (id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
                                                );


    DROP TABLE IF EXISTS hb_04_one_to_many_uni.review;
    CREATE TABLE hb_04_one_to_many_uni.review (
        id SERIAL PRIMARY KEY NOT NULL,
        comment varchar(256) DEFAULT NULL,
        course_id int DEFAULT NULL references hb_04_one_to_many_uni.course(id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
                                              );
