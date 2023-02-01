use campdb;

Drop table If exists reservation;
Drop table If exists image;
Drop table IF EXISTS review;
Drop table IF EXISTS home;
Drop table IF EXISTS facility;
Drop table IF EXISTS notice;
Drop table IF EXISTS book;
Drop table IF EXISTS user;
Drop table IF EXISTS payment;
Drop table IF EXISTS site;
Drop table IF EXISTS zone;
Drop table IF EXISTS schedule;
Drop table IF EXISTS admin;
Drop table IF EXISTS company;


CREATE TABLE `notice` (
   `notice_code`   INT   NOT NULL auto_increment,
   `admin_code`   INT   NOT NULL,
   `notice_level`   INT   NULL,
   `notice_title`   varchar(100)   NULL,
   `notice_writedate`   DATETIME   NULL   DEFAULT NOW(),
   `notice_content`   varchar(500)   NULL,
    primary key (notice_code)
);

CREATE TABLE `site` (
   `site_code`   INT   NOT NULL auto_increment,
   `zone_code`   INT   NOT NULL,
   `site_name`   VARCHAR(100)   NULL,
   `site_price`   INT   NULL,
   `site_content`   LONGTEXT   NULL,
    primary key (site_code)
);

CREATE TABLE `home` (
   `home_code`   INT   NOT NULL auto_increment,
   `admin_code`   INT   NOT NULL,
   `home_owner`   VARCHAR(20)   NULL,
   `home_content`   LONGTEXT   NOT NULL,
   `home_address`   VARCHAR(100)   NULL,
   `home_longitude`   DOUBLE   NULL,
   `home_latitude`   DOUBLE   NULL,
   `home_https`   VARCHAR(50)   NULL,
   `home_tell`   VARCHAR(20)   NULL,
    primary key (home_code)
);

CREATE TABLE `facility` (
   `facility_code`   INT   NOT NULL auto_increment, 
   `admin_code`   INT   NOT NULL,
   `facility_name`   VARCHAR(100)   NULL,
   `facility_content`   LONGTEXT   NULL,
    primary key (facility_code)
);

CREATE TABLE `book` (
   `book_code`   INT   NOT NULL auto_increment,
   `site_code`   INT   NOT NULL,
   `user_code`   INT   NOT NULL,
   `merchant_uid`   VARCHAR(30)   NOT NULL,
   `book_member`   INT   NOT NULL,
   `book_checkin`   VARCHAR(15)   NOT NULL,
   `book_checkout`   VARCHAR(15)   NOT NULL,
   `book_writedate`   DATETIME   NULL   DEFAULT NOW(),
   `book_price`   INT   NOT NULL,
   `book_car_number`   VARCHAR(8)   NULL,
   `book_state` INT NULL DEFAULT 1,
   `book_detials` VARCHAR(500) NULL,
    primary key (book_code)
);

CREATE TABLE `zone` (
   `zone_code`   INT   NOT NULL auto_increment,
   `admin_code`   INT   NOT NULL,
   `zone_name`   VARCHAR(30)   NOT NULL,
   `zone_content`   LONGTEXT   NULL,
    primary key (zone_code)
);

CREATE TABLE `user` (
   `user_code`   INT   NOT NULL auto_increment,
   `user_id`   VARCHAR(20)   NOT NULL,
   `user_password`   VARCHAR(1000)   NOT NULL,
   `user_name`   VARCHAR(20)   NOT NULL,
   `user_birthday`   VARCHAR(10)   NOT NULL,
   `user_tel`   VARCHAR(20)   NULL,
    primary key (user_code)
);

CREATE TABLE `company` (
   `company_code`   INT   NOT NULL auto_increment,
   `company_name`   VARCHAR(20)   NOT NULL,
    primary key (company_code)
);

CREATE TABLE `admin` (
   `admin_code`   INT   NOT NULL auto_increment,
   `company_code`   INT   NOT NULL,
   `admin_id`   VARCHAR(20)   NOT NULL,
   `admin_password`   VARCHAR(20)   NOT NULL,
    primary key (admin_code)
);

CREATE TABLE `payment` (
   `merchant_uid`   VARCHAR(30)   NOT NULL,
   `pay_method`   VARCHAR(30)   NOT NULL,
   `imp_uid`   VARCHAR(30)   NOT NULL,
    primary key (merchant_uid)
);

CREATE TABLE `review` (
   `review_code`   INT   NOT NULL auto_increment,
   `book_code`   INT   NOT NULL,
   `review_content`   LONGTEXT   NULL,
   `review_score`   INT   NULL,
   `review_image`   VARCHAR(50)   NULL,
    primary key (review_code)
);

CREATE TABLE `schedule` (
   `schedule_code`   INT   NOT NULL auto_increment,
   `admin_code`   INT   NOT NULL,
   `schedule_date`   DATE   NOT NULL,
   `schedule_name`   VARCHAR(20)   NOT NULL,
    primary key (schedule_code)
);

CREATE TABLE `image` (
   `image_code`   INT   NOT NULL auto_increment,
   `company_code`   INT   NOT NULL,
   `zone_code`   INT   NULL,
   `site_code`   INT   NULL,
   `home_code`   INT   NULL,
   `facility_code`   INT   NULL,
   `image_file`   VARCHAR(50)   NOT NULL,
    primary key (image_code)
);

CREATE TABLE `reservation` (
   `reservation_code`   INT   NOT NULL auto_increment,
   `book_code`   INT   NOT NULL,
   `reservation_date`   DATE   NOT NULL,
    primary key (reservation_code)
);

ALTER TABLE `notice` ADD CONSTRAINT `FK_admin_TO_notice_1` FOREIGN KEY (
   `admin_code`
)
REFERENCES `admin` (
   `admin_code`
);

ALTER TABLE `site` ADD CONSTRAINT `FK_zone_TO_site_1` FOREIGN KEY (
   `zone_code`
)
REFERENCES `zone` (
   `zone_code`
);

ALTER TABLE `home` ADD CONSTRAINT `FK_admin_TO_home_1` FOREIGN KEY (
   `admin_code`
)
REFERENCES `admin` (
   `admin_code`
);

ALTER TABLE `facility` ADD CONSTRAINT `FK_admin_TO_facility_1` FOREIGN KEY (
   `admin_code`
)
REFERENCES `admin` (
   `admin_code`
);

ALTER TABLE `book` ADD CONSTRAINT `FK_site_TO_book_1` FOREIGN KEY (
   `site_code`
)
REFERENCES `site` (
   `site_code`
);

ALTER TABLE `book` ADD CONSTRAINT `FK_user_TO_book_1` FOREIGN KEY (
   `user_code`
)
REFERENCES `user` (
   `user_code`
);

ALTER TABLE `book` ADD CONSTRAINT `FK_payment_TO_book_1` FOREIGN KEY (
   `merchant_uid`
)
REFERENCES `payment` (
   `merchant_uid`
);

ALTER TABLE `zone` ADD CONSTRAINT `FK_admin_TO_zone_1` FOREIGN KEY (
   `admin_code`
)
REFERENCES `admin` (
   `admin_code`
);

ALTER TABLE `admin` ADD CONSTRAINT `FK_company_TO_admin_1` FOREIGN KEY (
   `company_code`
)
REFERENCES `company` (
   `company_code`
);

ALTER TABLE `review` ADD CONSTRAINT `FK_book_TO_review_1` FOREIGN KEY (
   `book_code`
)
REFERENCES `book` (
   `book_code`
);

ALTER TABLE `schedule` ADD CONSTRAINT `FK_admin_TO_schedule_1` FOREIGN KEY (
   `admin_code`
)
REFERENCES `admin` (
   `admin_code`
);

ALTER TABLE `image` ADD CONSTRAINT `FK_company_TO_image_1` FOREIGN KEY (
   `company_code`
)
REFERENCES `company` (
   `company_code`
);

ALTER TABLE `image` ADD CONSTRAINT `FK_zone_TO_image_1` FOREIGN KEY (
   `zone_code`
)
REFERENCES `zone` (
   `zone_code`
);

ALTER TABLE `image` ADD CONSTRAINT `FK_site_TO_image_1` FOREIGN KEY (
   `site_code`
)
REFERENCES `site` (
   `site_code`
);

ALTER TABLE `image` ADD CONSTRAINT `FK_home_TO_image_1` FOREIGN KEY (
   `home_code`
)
REFERENCES `home` (
   `home_code`
);

ALTER TABLE `image` ADD CONSTRAINT `FK_facility_TO_image_1` FOREIGN KEY (
   `facility_code`
)
REFERENCES `facility` (
   `facility_code`
);

ALTER TABLE `reservation` ADD CONSTRAINT `FK_book_TO_reservation_1` FOREIGN KEY (
   `book_code`
)
REFERENCES `book` (
   `book_code`
);