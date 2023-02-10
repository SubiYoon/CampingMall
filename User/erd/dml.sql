use campdb;

-- 유저
INSERT INTO user VALUES(0, 'user1111', 'zefgWF8WQvW8/vwu8l2Nk2cBbk0BhTBwDkU3x8Wa9w5aq5FBI5WBz+SoBa4j15G1h8FeAyhkuV3GWkjfBj1qJg==', '이진실', 900101, '010-1234-5678');
INSERT INTO user VALUES(0, 'user2222', 'zefgWF8WQvW8/vwu8l2Nk2cBbk0BhTBwDkU3x8Wa9w5aq5FBI5WBz+SoBa4j15G1h8FeAyhkuV3GWkjfBj1qJg==', '김사랑', 951223, '010-1584-5678');
INSERT INTO user VALUES(0, 'user3333', 'zefgWF8WQvW8/vwu8l2Nk2cBbk0BhTBwDkU3x8Wa9w5aq5FBI5WBz+SoBa4j15G1h8FeAyhkuV3GWkjfBj1qJg==', '김수호', 851212, '010-5238-4828');
INSERT INTO user VALUES(0, 'user4444', 'zefgWF8WQvW8/vwu8l2Nk2cBbk0BhTBwDkU3x8Wa9w5aq5FBI5WBz+SoBa4j15G1h8FeAyhkuV3GWkjfBj1qJg==', '박민정', 900101, '010-1234-5678');
INSERT INTO user VALUES(0, 'user5555', 'zefgWF8WQvW8/vwu8l2Nk2cBbk0BhTBwDkU3x8Wa9w5aq5FBI5WBz+SoBa4j15G1h8FeAyhkuV3GWkjfBj1qJg==', '박세로이', 951223, '010-1584-5678');
INSERT INTO user VALUES(0, 'user6666', 'zefgWF8WQvW8/vwu8l2Nk2cBbk0BhTBwDkU3x8Wa9w5aq5FBI5WBz+SoBa4j15G1h8FeAyhkuV3GWkjfBj1qJg==', '박열', 851212, '010-5238-4828');
INSERT INTO user VALUES(0, 'user7777', 'zefgWF8WQvW8/vwu8l2Nk2cBbk0BhTBwDkU3x8Wa9w5aq5FBI5WBz+SoBa4j15G1h8FeAyhkuV3GWkjfBj1qJg==', '최수정', 900101, '010-1234-5678');
INSERT INTO user VALUES(0, 'user8888', 'zefgWF8WQvW8/vwu8l2Nk2cBbk0BhTBwDkU3x8Wa9w5aq5FBI5WBz+SoBa4j15G1h8FeAyhkuV3GWkjfBj1qJg==', '황인우', 951223, '010-1584-5678');
INSERT INTO user VALUES(0, 'user9999', 'zefgWF8WQvW8/vwu8l2Nk2cBbk0BhTBwDkU3x8Wa9w5aq5FBI5WBz+SoBa4j15G1h8FeAyhkuV3GWkjfBj1qJg==', '김미정', 851212, '010-5238-4828');

-- 상호
INSERT INTO company(company_name, company_logo1, company_logo2) VALUES('NoopCamping', "logo.png","book_ocline_logo.png"); -- 차후 변경
INSERT INTO company(company_name, company_logo1, company_logo2) VALUES('NiceCamping', "logo1.png", "sample.png"); -- 차후 변경

-- 관리자
insert into `admin`(company_code, admin_id, admin_password) values(1,'admin01','zefgWF8WQvW8/vwu8l2Nk2cBbk0BhTBwDkU3x8Wa9w5aq5FBI5WBz+SoBa4j15G1h8FeAyhkuV3GWkjfBj1qJg==');
insert into `admin`(company_code, admin_id, admin_password) values(1,'admin02','zefgWF8WQvW8/vwu8l2Nk2cBbk0BhTBwDkU3x8Wa9w5aq5FBI5WBz+SoBa4j15G1h8FeAyhkuV3GWkjfBj1qJg==');
insert into `admin`(company_code, admin_id, admin_password) values(2,'admin03','zefgWF8WQvW8/vwu8l2Nk2cBbk0BhTBwDkU3x8Wa9w5aq5FBI5WBz+SoBa4j15G1h8FeAyhkuV3GWkjfBj1qJg==');

-- Noob camping 샘플

-- 공지
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(1, 1, '[휴무안내]공지사항1제목입니다', "공지사항 1입니다.");
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(1, 1, '[안전수칙안내]공지사항2제목입니다', "공지사항 2입니다.");
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(1, 1, '[분실물안내]공지사항3제목입니다', "공지사항 3입니다.");
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(1, NULL, '[시설수리완료]공지사항4제목입니다', "공지사항 4입니다.");
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(1, NULL, '[시설수리예정]공지사항5제목입니다', "공지사항 5입니다.");
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(1, NULL, '[이벤트안내]공지사항6제목입니다', "공지사항 6입니다.");

-- 시설
INSERT INTO facility(admin_code, facility_name, facility_content) VALUES(1, "샤워실", "샤워실 입니다.");
INSERT INTO facility(admin_code, facility_name, facility_content) VALUES(1, "매점", "매점입니다.");
INSERT INTO facility(admin_code, facility_name, facility_content) VALUES(1, "카페", "카페입니다.");
INSERT INTO facility(admin_code, facility_name, facility_content) VALUES(1, "화장실", "화장실입니다.");

-- 홈페이지
INSERT INTO home(admin_code, home_owner, home_address, home_https, home_tell, home_content, home_longitude, home_latitude, home_image)VALUES(1, '나대표', '서울시 어딘가', 'www.naver.com', '02-1234-1234', '1번상호설명입니다. 심문도 찍히지 그 것, 인류가 어머니로서 기강에 나오다. 이름에게 많이 재벌이 엄중히, 들어가아서 모르다 읽죠 건설에 예기하세요.', 37.5039781087508, 127.04273317956381, "sample.png");

-- 구역
INSERT INTO zone(admin_code, zone_name, zone_content) VALUES(1,'호수 뷰', '호수존 설명입니다. 있다 성읍인 연습할 같을 특히, 집이, 향합니다. 벚꽃이다 장바구니, 건강은, 힘으로 확실하다 없는 대상에 대하다.');
INSERT INTO zone(admin_code, zone_name, zone_content) VALUES(1,'텐트', '텐트존입니다. 있다 성읍인 연습할 같을 특히, 집이, 향합니다. 벚꽃이다 장바구니, 건강은, 힘으로 확실하다 없는 대상에 대하다.');
INSERT INTO zone(admin_code, zone_name, zone_content) VALUES(1,'마운틴 뷰', '마운틴존입니다. 있다 성읍인 연습할 같을 특히, 집이, 향합니다. 벚꽃이다 장바구니, 건강은, 힘으로 확실하다 없는 대상에 대하다.');
INSERT INTO zone(admin_code, zone_name, zone_content) VALUES(2,'리버 뷰', 'D존입니다. 있다 성읍인 연습할 같을 특히, 집이, 향합니다. 벚꽃이다 장바구니, 건강은, 힘으로 확실하다 없는 대상에 대하다.');

-- 사이트
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(1, '호수 뷰-1',20000,'호수 뷰-1 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(1, '호수 뷰-2',20000,'호수 뷰-2 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(1, '호수 뷰-3',20000,'호수 뷰-3 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(1, '호수 뷰-4',20000,'호수 뷰-4 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(1, '호수 뷰-5',20000,'호수 뷰-5 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(2, '텐트-1',30000,'텐트-1 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(2, '텐트-2',30000,'텐트-2 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(2, '텐트-3',30000,'텐트-3 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(2, '텐트-4',30000,'텐트-4 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(2, '텐트-5',30000,'텐트-5 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(3, '마운틴 뷰-1',40000,'마운틴 뷰-1 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(3, '마운틴 뷰-2',40000,'마운틴 뷰-2 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(3, '마운틴 뷰-3',40000,'마운틴 뷰-3 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(3, '마운틴 뷰-4',40000,'마운틴 뷰-4 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(3, '마운틴 뷰-5',40000,'마운틴 뷰-5 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(4, '리버 뷰-1',50000,'리버 뷰1 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(4, '리버 뷰-2',50000,'리버 뷰2 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(4, '리버 뷰-3',50000,'리버 뷰3 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(4, '리버 뷰-4',50000,'리버 뷰4 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(4, '리버 뷰-5',50000,'리버 뷰5 입니다.');

-- 결제
insert into `payment`(merchant_uid,pay_method, imp_uid) values('1','카드','1');
insert into `payment`(merchant_uid,pay_method, imp_uid) values('2','카드','1');
insert into `payment`(merchant_uid,pay_method, imp_uid) values('3','무통장','1');
insert into `payment`(merchant_uid,pay_method, imp_uid) values('4','계좌이체','1');
insert into `payment`(merchant_uid,pay_method, imp_uid) values('5','카드','1');

-- 예약
insert into `book`(site_code, user_code, merchant_uid, book_member, book_checkin, book_checkout, book_price, book_car_number) values(1,1,'1',3,'2023-02-03','2023-02-04',30000,'12가1234,1,1,1');
insert into `book`(site_code, user_code, merchant_uid, book_member, book_checkin, book_checkout, book_price, book_car_number) values(6,1,'5',5,'2023-02-18','2023-02-21',300000,'13가1234,1,0,0');
insert into `book`(site_code, user_code, merchant_uid, book_member, book_checkin, book_checkout, book_price, book_car_number) values(1,2,'2',2,'2023-02-01','2023-02-02',35000,'13나1234,1,0,1');
insert into `book`(site_code, user_code, merchant_uid, book_member, book_checkin, book_checkout, book_price) values(12,2,'3',1,'2023-02-04','2023-02-07',20000);
insert into `book`(site_code, user_code, merchant_uid, book_member, book_checkin, book_checkout, book_price, book_car_number) values(1,3,'4',2,'2023-02-02','2023-02-05',45000,'13나1234,1,1,1');


-- 스케줄
insert into `schedule`(admin_code, schedule_date, schedule_name) values(1,'2023-02-06','방역');
insert into `schedule`(admin_code, schedule_date, schedule_name) values(1,'2023-02-07','방역');

-- 리뷰
insert into `review`(book_code, review_content, review_score) values(1,'맛있어요',3);
insert into `review`(book_code, review_content, review_score) values(2,'추워요',4);
insert into `review`(book_code, review_content, review_score) values(4,'풍경이 멋있어요',5);

-- 이미지
insert into image(company_code, zone_code, image_file) VALUES(1, 1, 'lake.jpg');
insert into image(company_code, zone_code, image_file) VALUES(1, 2, 'tent.png');
insert into image(company_code, zone_code, image_file) VALUES(1, 3, 'mountain.jpg');
insert into image(company_code, zone_code, image_file) VALUES(1, 4, 'river.png');

insert into image(company_code, site_code, image_file) VALUES(1, 1, 'lake1.png');
insert into image(company_code, site_code, image_file) VALUES(1, 2, 'lake2.png');
insert into image(company_code, site_code, image_file) VALUES(1, 3, 'lake3.png');
insert into image(company_code, site_code, image_file) VALUES(1, 4, 'lake4.png');
insert into image(company_code, site_code, image_file) VALUES(1, 5, 'lake5.png');
insert into image(company_code, site_code, image_file) VALUES(1, 6, 'tent1.png');
insert into image(company_code, site_code, image_file) VALUES(1, 7, 'tent2.png');
insert into image(company_code, site_code, image_file) VALUES(1, 8, 'tent3.png');
insert into image(company_code, site_code, image_file) VALUES(1, 9, 'tent4.png');
insert into image(company_code, site_code, image_file) VALUES(1, 10, 'tent5.png');
insert into image(company_code, site_code, image_file) VALUES(1, 11, 'mountain1.jpeg');
insert into image(company_code, site_code, image_file) VALUES(1, 12, 'mountain2.jpeg');
insert into image(company_code, site_code, image_file) VALUES(1, 13, 'mountain3.jpeg');
insert into image(company_code, site_code, image_file) VALUES(1, 14, 'mountain4.jpeg');
insert into image(company_code, site_code, image_file) VALUES(1, 15, 'mountain5.jpeg');
insert into image(company_code, site_code, image_file) VALUES(1, 16, 'river1.png');
insert into image(company_code, site_code, image_file) VALUES(1, 17, 'river2.png');
insert into image(company_code, site_code, image_file) VALUES(1, 18, 'river3.png');
insert into image(company_code, site_code, image_file) VALUES(1, 19, 'river4.png');
insert into image(company_code, site_code, image_file) VALUES(1, 20, 'river5.png');

insert into image(company_code, facility_code, image_file) VALUES(1, 1, 'shower.jpg');
insert into image(company_code, facility_code, image_file) VALUES(1, 2, 'store.jpg');
insert into image(company_code, facility_code, image_file) VALUES(1, 3, 'cafe.jpg');
insert into image(company_code, facility_code, image_file) VALUES(1, 4, 'toilet.jpg');

insert into image(company_code, home_code, image_file) VALUES(1, 1, 'slide1.png');
insert into image(company_code, home_code, image_file) VALUES(1, 1, 'slide2.jpg');
insert into image(company_code, home_code, image_file) VALUES(1, 1, 'slide3.jpg');

-- 예약된 날짜
insert into reservation(book_code,reservation_date) values(1, '2023-02-03');
insert into reservation(book_code,reservation_date) values(2, '2023-02-01');
insert into reservation(book_code,reservation_date) values(3, '2023-02-04');
insert into reservation(book_code,reservation_date) values(3, '2023-02-05');
insert into reservation(book_code,reservation_date) values(3, '2023-02-06');
insert into reservation(book_code,reservation_date) values(4, '2023-02-02');
insert into reservation(book_code,reservation_date) values(4, '2023-02-03');
insert into reservation(book_code,reservation_date) values(4, '2023-02-04');
insert into reservation(book_code,reservation_date) values(5, '2023-02-18');
insert into reservation(book_code,reservation_date) values(5, '2023-02-19');
insert into reservation(book_code,reservation_date) values(5, '2023-02-20');
insert into reservation(book_code,reservation_date) values(5, '2023-02-21');

-- Nice camping 샘플

-- 공지
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(3, 1, '[휴무안내]공지사항1제목입니다', "공지사항 1입니다.");
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(3, 1, '[안전수칙안내]공지사항2제목입니다', "공지사항 2입니다.");
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(3, 1, '[분실물안내]공지사항3제목입니다', "공지사항 3입니다.");
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(3, NULL, '[시설수리완료]공지사항4제목입니다', "공지사항 4입니다.");
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(3, NULL, '[시설수리예정]공지사항5제목입니다', "공지사항 5입니다.");
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(3, NULL, '[이벤트안내]공지사항6제목입니다', "공지사항 6입니다.");

-- 시설
INSERT INTO facility(admin_code, facility_name, facility_content) VALUES(3, "샤워실", "샤워실 입니다.");
INSERT INTO facility(admin_code, facility_name, facility_content) VALUES(3, "매점", "매점입니다.");
INSERT INTO facility(admin_code, facility_name, facility_content) VALUES(3, "카페", "카페입니다.");
INSERT INTO facility(admin_code, facility_name, facility_content) VALUES(3, "화장실", "화장실입니다.");

-- 홈페이지
INSERT INTO home(admin_code, home_owner, home_address, home_https, home_tell, home_content, home_longitude, home_latitude, home_image)VALUES(3, '이만기', '충청도 어딘가', 'www.yahoo.co.kr', '043-229-1234', '안녕하세요2', 37.56517320755754, 126.97909982283633, "sample.png");

-- 구역
INSERT INTO zone(admin_code, zone_name, zone_content) VALUES(3,'호수 뷰', '호수존 설명입니다. 있다 성읍인 연습할 같을 특히, 집이, 향합니다. 벚꽃이다 장바구니, 건강은, 힘으로 확실하다 없는 대상에 대하다.');
INSERT INTO zone(admin_code, zone_name, zone_content) VALUES(3,'텐트', '텐트존입니다. 있다 성읍인 연습할 같을 특히, 집이, 향합니다. 벚꽃이다 장바구니, 건강은, 힘으로 확실하다 없는 대상에 대하다.');
INSERT INTO zone(admin_code, zone_name, zone_content) VALUES(3,'마운틴 뷰', '마운틴존입니다. 있다 성읍인 연습할 같을 특히, 집이, 향합니다. 벚꽃이다 장바구니, 건강은, 힘으로 확실하다 없는 대상에 대하다.');
INSERT INTO zone(admin_code, zone_name, zone_content) VALUES(3,'리버 뷰', 'D존입니다. 있다 성읍인 연습할 같을 특히, 집이, 향합니다. 벚꽃이다 장바구니, 건강은, 힘으로 확실하다 없는 대상에 대하다.');

-- 사이트
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(5, '호수 뷰-1',20000,'호수 뷰-1 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(5, '호수 뷰-2',20000,'호수 뷰-2 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(5, '호수 뷰-3',20000,'호수 뷰-3 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(5, '호수 뷰-4',20000,'호수 뷰-4 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(5, '호수 뷰-5',20000,'호수 뷰-5 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(6, '텐트-1',30000,'텐트-1 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(6, '텐트-2',30000,'텐트-2 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(6, '텐트-3',30000,'텐트-3 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(6, '텐트-4',30000,'텐트-4 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(6, '텐트-5',30000,'텐트-5 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(7, '마운틴 뷰-1',40000,'마운틴 뷰-1 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(7, '마운틴 뷰-2',40000,'마운틴 뷰-2 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(7, '마운틴 뷰-3',40000,'마운틴 뷰-3 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(7, '마운틴 뷰-4',40000,'마운틴 뷰-4 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(7, '마운틴 뷰-5',40000,'마운틴 뷰-5 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(8, '리버 뷰-1',50000,'리버 뷰1 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(8, '리버 뷰-2',50000,'리버 뷰2 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(8, '리버 뷰-3',50000,'리버 뷰3 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(8, '리버 뷰-4',50000,'리버 뷰4 입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(8, '리버 뷰-5',50000,'리버 뷰5 입니다.');

-- 결제
insert into `payment`(merchant_uid,pay_method, imp_uid) values('6','카드','1');
insert into `payment`(merchant_uid,pay_method, imp_uid) values('7','카드','1');
insert into `payment`(merchant_uid,pay_method, imp_uid) values('8','무통장','1');
insert into `payment`(merchant_uid,pay_method, imp_uid) values('9','계좌이체','1');
insert into `payment`(merchant_uid,pay_method, imp_uid) values('10','카드','1');

-- 예약
insert into `book`(site_code, user_code, merchant_uid, book_member, book_checkin, book_checkout, book_price, book_car_number) values(21,1,'6',3,'2023-02-03','2023-02-04',30000,'12가1234,1,1,1');
insert into `book`(site_code, user_code, merchant_uid, book_member, book_checkin, book_checkout, book_price, book_car_number) values(21,1,'7',5,'2023-02-18','2023-02-21',300000,'13가1234,1,0,0');
insert into `book`(site_code, user_code, merchant_uid, book_member, book_checkin, book_checkout, book_price, book_car_number) values(21,2,'8',2,'2023-02-01','2023-02-02',35000,'13나1234,1,0,1');
insert into `book`(site_code, user_code, merchant_uid, book_member, book_checkin, book_checkout, book_price) values(21,2,'9',1,'2023-02-04','2023-02-07',20000);
insert into `book`(site_code, user_code, merchant_uid, book_member, book_checkin, book_checkout, book_price, book_car_number) values(21,3,'10',2,'2023-02-02','2023-02-05',45000,'13나1234,1,1,1');


-- 스케줄
insert into `schedule`(admin_code, schedule_date, schedule_name) values(3,'2023-02-06','방역');
insert into `schedule`(admin_code, schedule_date, schedule_name) values(3,'2023-02-07','방역');

-- 리뷰
insert into `review`(book_code, review_content, review_score) values(6,'맛있어요',3);
insert into `review`(book_code, review_content, review_score) values(7,'추워요',4);
insert into `review`(book_code, review_content, review_score) values(8,'풍경이 멋있어요',5);

-- 이미지
insert into image(company_code, zone_code, image_file) VALUES(2, 5, 'about.png');
insert into image(company_code, zone_code, image_file) VALUES(2, 6, 'blog1.jpg');
insert into image(company_code, zone_code, image_file) VALUES(2, 7, 'blog2.jpg');
insert into image(company_code, zone_code, image_file) VALUES(2, 8, 'blog3.jpg');

insert into image(company_code, site_code, image_file) VALUES(2, 21, 'lake1.png');
insert into image(company_code, site_code, image_file) VALUES(2, 22, 'lake2.png');
insert into image(company_code, site_code, image_file) VALUES(2, 23, 'lake3.png');
insert into image(company_code, site_code, image_file) VALUES(2, 24, 'lake4.png');
insert into image(company_code, site_code, image_file) VALUES(2, 25, 'lake5.png');
insert into image(company_code, site_code, image_file) VALUES(2, 26, 'tent1.png');
insert into image(company_code, site_code, image_file) VALUES(2, 27, 'tent2.png');
insert into image(company_code, site_code, image_file) VALUES(2, 28, 'tent3.png');
insert into image(company_code, site_code, image_file) VALUES(2, 29, 'tent4.png');
insert into image(company_code, site_code, image_file) VALUES(2, 30, 'tent5.png');
insert into image(company_code, site_code, image_file) VALUES(2, 31, 'mountain1.jpeg');
insert into image(company_code, site_code, image_file) VALUES(2, 32, 'mountain2.jpeg');
insert into image(company_code, site_code, image_file) VALUES(2, 33, 'mountain3.jpeg');
insert into image(company_code, site_code, image_file) VALUES(2, 34, 'mountain4.jpeg');
insert into image(company_code, site_code, image_file) VALUES(2, 35, 'mountain5.jpeg');
insert into image(company_code, site_code, image_file) VALUES(2, 36, 'river1.png');
insert into image(company_code, site_code, image_file) VALUES(2, 37, 'river2.png');
insert into image(company_code, site_code, image_file) VALUES(2, 38, 'river3.png');
insert into image(company_code, site_code, image_file) VALUES(2, 39, 'river4.png');
insert into image(company_code, site_code, image_file) VALUES(2, 30, 'river5.png');

insert into image(company_code, facility_code, image_file) VALUES(2, 5, 'gallery1.jpg');
insert into image(company_code, facility_code, image_file) VALUES(2, 6, 'gallery2.jpg');
insert into image(company_code, facility_code, image_file) VALUES(2, 7, 'gallery3.jpg');
insert into image(company_code, facility_code, image_file) VALUES(2, 8, 'gallery4.jpg');

insert into image(company_code, home_code, image_file) VALUES(2, 2, 'banner1.jpg');
insert into image(company_code, home_code, image_file) VALUES(2, 2, 'banner2.jpg');
insert into image(company_code, home_code, image_file) VALUES(2, 2, 'banner3.jpg');

-- 예약된 날짜
insert into reservation(book_code,reservation_date) values(6, '2023-02-03');
insert into reservation(book_code,reservation_date) values(7, '2023-02-01');
insert into reservation(book_code,reservation_date) values(8, '2023-02-04');
insert into reservation(book_code,reservation_date) values(8, '2023-02-05');
insert into reservation(book_code,reservation_date) values(8, '2023-02-06');
insert into reservation(book_code,reservation_date) values(9, '2023-02-02');
insert into reservation(book_code,reservation_date) values(9, '2023-02-03');
insert into reservation(book_code,reservation_date) values(9, '2023-02-04');
insert into reservation(book_code,reservation_date) values(10, '2023-02-18');
insert into reservation(book_code,reservation_date) values(10, '2023-02-19');
insert into reservation(book_code,reservation_date) values(10, '2023-02-20');
insert into reservation(book_code,reservation_date) values(10, '2023-02-21');