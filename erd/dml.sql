use campdb;

-- 유저
INSERT INTO user VALUES(0, 'user01', '1234', '김씨', 000101, '010-1234-5678');
INSERT INTO user VALUES(0, 'user02', '1234', '이씨', 010101, '010-1584-5678');
INSERT INTO user VALUES(0, 'user03', '1234', '박씨', 020202, '010-5238-4828');

-- 상호
INSERT INTO company(company_name) VALUES('NoopCamping');
INSERT INTO company(company_name) VALUES('GosuCamping');

-- 관리자
insert into `admin`(company_code, admin_id, admin_password) values(1,'admin01','111111');
insert into `admin`(company_code, admin_id, admin_password) values(1,'admin02','111111');
insert into `admin`(company_code, admin_id, admin_password) values(2,'admin03','222222');

-- 공지
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(1, 1, '공지사항1', "공지사항 1입니다.");
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(1, NULL, '공지사항2', "공지사항 1입니다.");
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(1, NULL, '공지사항2', "공지사항 1입니다.");

-- 시설
INSERT INTO facility(admin_code, facility_name, facility_content) VALUES(1, "시설1", "시설1입니다.");
INSERT INTO facility(admin_code, facility_name, facility_content) VALUES(1, "시설2", "시설2입니다.");
INSERT INTO facility(admin_code, facility_name, facility_content) VALUES(1, "시설3", "시설3입니다.");
INSERT INTO facility(admin_code, facility_name, facility_content) VALUES(1, "시설4", "시설4입니다.");

-- 홈페이지
INSERT INTO home(admin_code, home_content, home_longitude, home_latitude)VALUES(1,'안녕하세요.', 37.5039781087508, 127.04273317956381);
INSERT INTO home(admin_code, home_content, home_longitude, home_latitude)VALUES(3,'안녕하세요2', 37.56517320755754, 126.97909982283633);

-- 구역
INSERT INTO zone(admin_code, zone_name, zone_content) VALUES(1,'구역A', 'A존입니다.');
INSERT INTO zone(admin_code, zone_name, zone_content) VALUES(1,'구역B', 'B존입니다.');
INSERT INTO zone(admin_code, zone_name, zone_content) VALUES(1,'구역C', 'C존입니다.');
INSERT INTO zone(admin_code, zone_name, zone_content) VALUES(1,'구역D', 'D존입니다.');

-- 사이트
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(1, 'A-1',20000,'A-1 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(1, 'A-2',20000,'A-2 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(1, 'A-3',20000,'A-3 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(1, 'A-4',20000,'A-4 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(1, 'A-5',20000,'A-5 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(2, 'B-1',30000,'B-1 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(2, 'B-2',30000,'B-2 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(2, 'B-3',30000,'B-3 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(2, 'B-4',30000,'B-4 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(2, 'B-5',30000,'B-5 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(3, 'C-1',40000,'C-1 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(3, 'C-2',40000,'C-2 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(3, 'C-3',40000,'C-3 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(3, 'C-4',40000,'C-4 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(3, 'C-5',40000,'C-5 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(4, 'D-1',50000,'D-1 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(4, 'D-2',50000,'D-2 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(4, 'D-3',50000,'D-3 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(4, 'D-4',50000,'D-4 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(4, 'D-5',50000,'D-5 입니다.');

-- 결제
insert into `payment`(merchant_uid,pay_method, imp_uid) values('1','카드','1');
insert into `payment`(merchant_uid,pay_method, imp_uid) values('2','카드','1');
insert into `payment`(merchant_uid,pay_method, imp_uid) values('3','무통장','1');
insert into `payment`(merchant_uid,pay_method, imp_uid) values('4','계좌이체','1');

-- 예약
insert into `book`(site_code, user_code, merchant_uid, book_member, book_checkin, book_checkout, book_price, book_car_number) values(1,1,'1',3,'2023-02-03','2023-02-04',30000,'12가1234');
insert into `book`(site_code, user_code, merchant_uid, book_member, book_checkin, book_checkout, book_price, book_car_number) values(7,2,'2',2,'2023-02-01','2023-02-02',35000,'13나1234');
insert into `book`(site_code, user_code, merchant_uid, book_member, book_checkin, book_checkout, book_price) values(1,2,'3',1,'2023-02-04','2023-02-07',20000);
insert into `book`(site_code, user_code, merchant_uid, book_member, book_checkin, book_checkout, book_price, book_car_number) values(15,3,'4',2,'2023-02-02','2023-02-05',45000,'13나1234');

-- 스케줄
insert into `schedule`(admin_code, schedule_date, schedule_name) values(1,'2023-02-06','방역');
insert into `schedule`(admin_code, schedule_date, schedule_name) values(1,'2023-02-07','방역');

-- 리뷰
insert into `review`(book_code, review_content, review_score) values(1,'맛있어요',9);
insert into `review`(book_code, review_content, review_score) values(2,'추워요',4);
insert into `review`(book_code, review_content, review_score) values(4,'풍경이 멋있어요',7);

-- 이미지
insert into image(company_code, zone_code, image_file) VALUES(1, 1, 'zone_img.png');
insert into image(company_code, site_code, image_file) VALUES(1, 1, 'site_img.png');
insert into image(company_code, facility_code, image_file) VALUES(1, 1, 'facility_img.png');
insert into image(company_code, home_code, image_file) VALUES(1, 1, 'home_img.png');

-- 예약된 날짜
insert into reservation(book_code,reservation_date) values(1, '2023-02-03');
insert into reservation(book_code,reservation_date) values(2, '2023-02-01');
insert into reservation(book_code,reservation_date) values(3, '2023-02-04');
insert into reservation(book_code,reservation_date) values(3, '2023-02-05');
insert into reservation(book_code,reservation_date) values(3, '2023-02-06');
insert into reservation(book_code,reservation_date) values(4, '2023-02-02');
insert into reservation(book_code,reservation_date) values(4, '2023-02-03');
insert into reservation(book_code,reservation_date) values(4, '2023-02-04');