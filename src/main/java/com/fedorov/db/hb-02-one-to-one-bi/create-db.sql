DROP SCHEMA IF EXISTS hb_02_one_to_one_bi;
CREATE SCHEMA hb_02_one_to_one_bi;

-- SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS hb_02_one_to_one_bi.instructor_detail;

CREATE TABLE hb_02_one_to_one_bi.instructor_detail (
            id SERIAL PRIMARY KEY NOT NULL,
            youtube_channel varchar(128) DEFAULT NULL,
            hobby varchar(45) DEFAULT NULL
                                                   );

DROP TABLE IF EXISTS hb_02_one_to_one_bi.instructor02;

CREATE TABLE hb_02_one_to_one_bi.instructor02 (
            id SERIAL NOT NULL,
            first_name varchar(45) DEFAULT NULL,
            last_name varchar(45) DEFAULT NULL,
            email varchar(45) DEFAULT NULL,
            instructor_detail_id int DEFAULT NULL references hb_02_one_to_one_bi.instructor_detail(id) ON DELETE CASCADE
                                            );

