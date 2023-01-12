USE CAMPDB;

-- 테이블 삭제 순서

DROP TABLE NOTICE;

DROP TABLE FACILITY;

DROP TABLE HOME;

DROP TABLE REVIEW;

DROP TABLE BOOK;

DROP TABLE PAYMENT;

DROP TABLE SITE;

DROP TABLE ZONE;

DROP TABLE COMPANY;

DROP TABLE ADMIN;

DROP TABLE USER;

CREATE TABLE `notice` (
	`notice_code`	INT	NOT NULL auto_increment,
	`company_code`	INT	NOT NULL,
	`notice_level`	INT	NULL,
	`notice_title`	varchar(100)	NULL,
	`notice_writer`	varchar(50)	NULL,
	`notice_writedate`	date	NULL,
	`notice_content`	varchar(500)	NULL,
    PRIMARY KEY(notice_code)
);

CREATE TABLE `site` (
	`site_code`	INT	NOT NULL auto_increment,
	`zone_code`	INT	NOT NULL,
	`site_name`	VARCHAR(100)	NULL,
	`site_price`	INT	NULL,
	`site_content`	LONGTEXT	NULL,
	`site_img1`	VARCHAR(50)	NULL,
	`site_img2`	VARCHAR(50)	NULL,
	`site_img3`	VARCHAR(50)	NULL,
	`site_img4`	VARCHAR(50)	NULL,
	`site_img5`	VARCHAR(50)	NULL,
    PRIMARY KEY(site_code)
);

CREATE TABLE `review` (
	`review_code`	INT	NOT NULL auto_increment,
	`user_code`	INT	NOT NULL,
	`company_code`	INT	NOT NULL,
	`review_content`	LONGTEXT	NULL,
	`review_score`	INT	NULL,
	`review_img1`	VARCHAR(50)	NULL,
    PRIMARY KEY(review_code)
);

CREATE TABLE `home` (
	`home_code`	INT	NOT NULL auto_increment,
	`company_code`	INT	NOT NULL,
	`home_content`	LONGTEXT	NOT NULL,
	`home_img1`	VARCHAR(30)	NULL,
	`home_img2`	VARCHAR(30)	NULL,
	`home_img3`	VARCHAR(30)	NULL,
	`home_address`	VARCHAR(255)	NULL,
	`home_coordinate`	VARCHAR(255)	NULL,
	`https`	VARCHAR(50)	NULL,
	`company_phone_number`	VARCHAR(20)	NULL,
    PRIMARY KEY(home_code)
);

CREATE TABLE `facility` (
	`facility_code`	INT	NOT NULL auto_increment,
	`company_code`	INT	NOT NULL,
	`facility_name`	VARCHAR(100)	NULL,
	`facility_content`	LONGTEXT	NULL,
	`facility_img1`	VARCHAR(50)	NULL,
	`facility_img2`	VARCHAR(50)	NULL,
	`facility_img3`	VARCHAR(50)	NULL,
    PRIMARY KEY(facility_code)
);

CREATE TABLE `book` (
	`book_code`	INT	NOT NULL auto_increment,
	`site_code`	INT	NOT NULL,
	`user_code`	INT	NOT NULL,
	`payment_code`	INT	NOT NULL	COMMENT '타입수정될수도있음',
	`book_member`	INT	NOT NULL,
	`book_date`	DATE	NOT NULL,
	`book_price`	INT	NOT NULL,
	`book_review`	INT	NOT NULL	COMMENT '0:작성X, 1:작성O',
	`book_car_number`	VARCHAR(8)	NULL,
    PRIMARY KEY(book_code)
);

CREATE TABLE `zone` (
	`zone_code`	INT	NOT NULL auto_increment,
	`company_code`	INT	NOT NULL,
	`zone_name`	VARCHAR(30)	NOT NULL,
	`zone_content`	LONGTEXT	NULL,
	`zone_img1`	VARCHAR(50)	NULL,
    PRIMARY KEY(zone_code)
);

CREATE TABLE `user` (
	`user_code`	INT	NOT NULL auto_increment,
	`user_id`	VARCHAR(20)	NOT NULL,
	`user_password`	VARCHAR(20)	NOT NULL,
	`user_name`	VARCHAR(20)	NOT NULL,
	`user_birthday`	INT	NOT NULL,
	`user_phone_number`	VARCHAR(20)	NOT NULL,
    PRIMARY KEY(user_code)
);

CREATE TABLE `company` (
	`company_code`	INT	NOT NULL auto_increment,
	`admin_code`	INT	NOT NULL,
	`company_name`	VARCHAR(20)	NOT NULL,
    PRIMARY KEY(company_code)
);

CREATE TABLE `admin` (
	`admin_code`	INT	NOT NULL auto_increment,
	`admin_id`	VARCHAR(20)	NOT NULL,
	`admin_pwd`	VARCHAR(20)	NOT NULL,
	`admin_name`	VARCHAR(50)	NOT NULL,
    PRIMARY KEY(admin_code)
);

CREATE TABLE `payment` (
	`payment_code`	INT	NOT NULL auto_increment,
	`payment_type`	varchar(30)	NOT NULL,
	`payment_detail`	INT	NOT NULL	COMMENT '결제 완료/환불 신청/환불 완료',
    PRIMARY KEY(payment_code)
);

ALTER TABLE `notice` ADD CONSTRAINT `FK_company_TO_notice_1` FOREIGN KEY (
	`company_code`
)
REFERENCES `company` (
	`company_code`
);

ALTER TABLE `site` ADD CONSTRAINT `FK_zone_TO_site_1` FOREIGN KEY (
	`zone_code`
)
REFERENCES `zone` (
	`zone_code`
);

ALTER TABLE `review` ADD CONSTRAINT `FK_user_TO_review_1` FOREIGN KEY (
	`user_code`
)
REFERENCES `user` (
	`user_code`
);

ALTER TABLE `review` ADD CONSTRAINT `FK_company_TO_review_1` FOREIGN KEY (
	`company_code`
)
REFERENCES `company` (
	`company_code`
);

ALTER TABLE `home` ADD CONSTRAINT `FK_company_TO_home_1` FOREIGN KEY (
	`company_code`
)
REFERENCES `company` (
	`company_code`
);

ALTER TABLE `facility` ADD CONSTRAINT `FK_company_TO_facility_1` FOREIGN KEY (
	`company_code`
)
REFERENCES `company` (
	`company_code`
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
	`payment_code`
)
REFERENCES `payment` (
	`payment_code`
);

ALTER TABLE `zone` ADD CONSTRAINT `FK_company_TO_zone_1` FOREIGN KEY (
	`company_code`
)
REFERENCES `company` (
	`company_code`
);

ALTER TABLE `company` ADD CONSTRAINT `FK_admin_TO_company_1` FOREIGN KEY (
	`admin_code`
)
REFERENCES `admin` (
	`admin_code`
);