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
insert into `admin`(company_code, admin_id, admin_password) values(2,'admin02','zefgWF8WQvW8/vwu8l2Nk2cBbk0BhTBwDkU3x8Wa9w5aq5FBI5WBz+SoBa4j15G1h8FeAyhkuV3GWkjfBj1qJg==');

-- Noob camping 샘플

-- 공지
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(1, 1, '예약 및 이용시 유의사항', "1. 입장시간은 14:00시 이후 / 퇴장시간은 익일 정오 12:00시 까지 입니다.\n(입퇴장 시간은 청소 및 다음 준비를 위하여 필히 준수하여 주시기 바랍니다.)\n\n2. 예약 차량(1대) 및 예약 인원 이외에는 출입할 수 없습니다.\n     (기준인원 초과시 1인당 10,000원의 추가요금이 적용됩니다.)\n\n3.지정 주차장 제도로 인하여 추가 차량은 캠핑장내에 주차를 하시면 안됩니다.\n\n4. 화재 예방을 위해 텐트 내에서는 절대 금연이며, 휴대용 가스버너, 양초,\n    폭죽 등의 사용을 금지하며 반려 동물의 동반입소는 불가능합니다.\n\n5. 입장하신 후 텐트내 귀중품 도난 방지를 위해 신경 써 주세요.\n\n6. 미성년자는 보호자 동반 없이 이용이 불가능 합니다.");
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(1, 1, '[자주 묻는 질문]우천시 환불 안내', "우천시 환불 안내 단순, 우천으로 인한 환불은 100% 환불 받을 수 없습니다.\n\n달천공원오토캠핑장에서 이용이 전혀 불가능하능 할 경우 정한 바에 따라 100%환불이 됩니다.\n\n(호우특보 및 태풍등의 직접적인 영향 기타사항일 경우)\n\n 감사합니다.");
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(1, 1, '[환불 안내]환불요청은 홈페이지에서 하셔야 합니다.', "승인완료 후 예약자 본인이 직접 홈페이지에서 환불요청 해주셔야 합니다.\n\n홈페이지 예약확인해서 확인후 환불요청 하시면 됩니다.\n\n※ 환불신청시 참고사항 - 천재지변과 우천으로 사용이 전혀 불가능할때에는 배상금없이 사용료만 환불한다.\n\n- 사용자가 사용당일 11시간까지 통보가 없는 경우에는 환불이 불가능하다.");
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(1, NULL, '[휴업 안내]휴업안내', "코로나19 확진자가 다수 발생되어, 1주간 휴업을 하도록 결정이 났습니다.\n\n그리하여 02/24 ~ 03/07 정도 휴업에 들어갑니다.\n\n차후 일정이 변경되면 개별적으로 연락을 드리도록 하겠습니다.\n\n3월24일부터 3월31 일까지 예약승인되신 분은 홈페이지에서 환불 요청 부탁들립니다.\n\n기타문의는  02-1234-1234로 연락 부탁드립니다.");
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(1, NULL, '전화문의가능시간 (오전9시-오후6시)', "전화문의는 오전 9시-오후 6시에 부탁드립니다.");

-- 시설
INSERT INTO facility(admin_code, facility_name, facility_content) VALUES(1, "샤워장", "온수는 07:00~23:00에 이용 가능합니다.");
INSERT INTO facility(admin_code, facility_name, facility_content) VALUES(1, "매점", "평일(월~목) : 10:00~18:00  \n주말 : 24시간 이용 가능");
INSERT INTO facility(admin_code, facility_name, facility_content) VALUES(1, "카페", "평일 08:30~21:30 / 주말 10:00~19:00  \n커피, 디저트, 쥬스 다양한 메뉴를 제공하고있습니다.");
INSERT INTO facility(admin_code, facility_name, facility_content) VALUES(1, "화장실", "캠핑장용 남자화장실 2개소, 여자화장실 2개소가 있습니다. \n타일, 수전 하나까지 엄선하여 청결함과 편리함을 극대화 하였습니다.");

-- 홈페이지
INSERT INTO home(admin_code, home_owner, home_address, home_https, home_tell, home_content, home_longitude, home_latitude, home_image)VALUES(1, '나대표', '서울시 어딘가', 'www.naver.com', '02-1234-1234', '산과 강과 호수로 둘러쌓인 천혜의 자연 환경을 갖춘 캠핑장에서 도심 속을 벗어나 편안한 힐링을 즐겨보세요.\n4계절마다 각 계절의 특색을 갖추고 있으며 캠핑장을 가득 채운 고목들이 즐비하여 캠핑장 전체에 시원한 그늘을 제공하고 있습니다.', 37.5039781087508, 127.04273317956381, "오시는 길.png");

-- 구역
INSERT INTO zone(admin_code, zone_name, zone_content) VALUES(1,'호수 뷰', '캠핑장의 자랑인 아름다운 저수지 바로 옆에 자리하고 있습니다.\n총 7개의 사이트가 파쇄석으로 이루어져 있으며 5.7m * 8m의 넉넉한 넓이를 자랑하고 있습니다.\n(5.7m ~ 6.7m로 사이트마다 다름)');
INSERT INTO zone(admin_code, zone_name, zone_content) VALUES(1,'텐트', '충분한 그늘 수목을 식재하고 홍천강까지 데크가 연결 되어 있어 일상에 지친 사람들을 위해 충분한 휴식공간이 마련되어 있고, 강이 굽이치고 있어 주변관광을 즐길 수 있습니다.');
INSERT INTO zone(admin_code, zone_name, zone_content) VALUES(1,'마운틴 뷰', '녹음이 짙은 산자락에 위치하고 있어 조용하며 공기가 상쾌하여 캠핑의 최적지라고 할 수 있습니다.\n데크사이즈가 커서 집짓고 타프까지 가능합니다.\n배전함이 설치되어있어 릴선은 20M 면 충분합니다.');
INSERT INTO zone(admin_code, zone_name, zone_content) VALUES(1,'리버 뷰', '아름다운 계곡을 가운데 끼고 푸르른 숲으로 둘러쌓여 있어 계절의 변화와 함께 자연의 풍경, 여유, 즐거움을 느낄수 있습니다.\n360도의 조망권과 넓은 시야를 가지고 있어, 강의 아름다운 정취와 여유를 느낄 수 있습니다.');

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
insert into `book`(site_code, user_code, merchant_uid, book_member, book_checkin, book_checkout, book_price, book_car_number) values(1,1,'1',3,'2023-03-03','2023-03-04',30000,'12가1234,1,1,1');
insert into `book`(site_code, user_code, merchant_uid, book_member, book_checkin, book_checkout, book_price, book_car_number) values(6,1,'5',5,'2023-02-18','2023-02-21',300000,'13가1234,1,0,0');
insert into `book`(site_code, user_code, merchant_uid, book_member, book_checkin, book_checkout, book_price, book_car_number) values(1,2,'2',2,'2023-03-01','2023-03-02',35000,'13나1234,1,0,1');
insert into `book`(site_code, user_code, merchant_uid, book_member, book_checkin, book_checkout, book_price, book_car_number) values(12,2,'3',1,'2023-02-20','2023-02-23',200000,'차량없음,0,0,0');
insert into `book`(site_code, user_code, merchant_uid, book_member, book_checkin, book_checkout, book_price, book_car_number) values(2,3,'4',2,'2023-03-02','2023-03-05',45000,'13나1234,1,1,1');


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
insert into reservation(book_code,reservation_date) values(1, '2023-03-03');
insert into reservation(book_code,reservation_date) values(2, '2023-02-18');
insert into reservation(book_code,reservation_date) values(2, '2023-02-19');
insert into reservation(book_code,reservation_date) values(2, '2023-02-20');
insert into reservation(book_code,reservation_date) values(3, '2023-03-01');
insert into reservation(book_code,reservation_date) values(4, '2023-02-20');
insert into reservation(book_code,reservation_date) values(4, '2023-02-21');
insert into reservation(book_code,reservation_date) values(4, '2023-02-22');
insert into reservation(book_code,reservation_date) values(5, '2023-03-02');
insert into reservation(book_code,reservation_date) values(5, '2023-03-03');
insert into reservation(book_code,reservation_date) values(5, '2023-03-04');


-- Nice camping 샘플

-- 공지
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(2, 1, '[휴무안내]공지사항1제목입니다', "공지사항 1입니다.");
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(2, 1, '[안전수칙안내]공지사항2제목입니다', "공지사항 2입니다.");
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(2, 1, '[분실물안내]공지사항3제목입니다', "공지사항 3입니다.");
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(2, NULL, '[시설수리완료]공지사항4제목입니다', "공지사항 4입니다.");
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(2, NULL, '[시설수리예정]공지사항5제목입니다', "공지사항 5입니다.");
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(2, NULL, '[이벤트안내]공지사항6제목입니다', "공지사항 6입니다.");

-- 시설
INSERT INTO facility(admin_code, facility_name, facility_content) VALUES(2, "샤워실", "샤워실 입니다.");
INSERT INTO facility(admin_code, facility_name, facility_content) VALUES(2, "매점", "매점입니다.");
INSERT INTO facility(admin_code, facility_name, facility_content) VALUES(2, "카페", "카페입니다.");
INSERT INTO facility(admin_code, facility_name, facility_content) VALUES(2, "화장실", "화장실입니다.");

-- 홈페이지
INSERT INTO home(admin_code, home_owner, home_address, home_https, home_tell, home_content, home_longitude, home_latitude, home_image)VALUES(2, '이만기', '충청도 어딘가', 'www.yahoo.co.kr', '043-229-1234', '안녕하세요2', 37.56517320755754, 126.97909982283633, "sample.png");

-- 구역
INSERT INTO zone(admin_code, zone_name, zone_content) VALUES(2,'호수 뷰', '호수존 설명입니다. 있다 성읍인 연습할 같을 특히, 집이, 향합니다. 벚꽃이다 장바구니, 건강은, 힘으로 확실하다 없는 대상에 대하다.');
INSERT INTO zone(admin_code, zone_name, zone_content) VALUES(2,'텐트', '텐트존입니다. 있다 성읍인 연습할 같을 특히, 집이, 향합니다. 벚꽃이다 장바구니, 건강은, 힘으로 확실하다 없는 대상에 대하다.');
INSERT INTO zone(admin_code, zone_name, zone_content) VALUES(2,'마운틴 뷰', '마운틴존입니다. 있다 성읍인 연습할 같을 특히, 집이, 향합니다. 벚꽃이다 장바구니, 건강은, 힘으로 확실하다 없는 대상에 대하다.');
INSERT INTO zone(admin_code, zone_name, zone_content) VALUES(2,'리버 뷰', 'D존입니다. 있다 성읍인 연습할 같을 특히, 집이, 향합니다. 벚꽃이다 장바구니, 건강은, 힘으로 확실하다 없는 대상에 대하다.');

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
insert into `book`(site_code, user_code, merchant_uid, book_member, book_checkin, book_checkout, book_price, book_car_number) values(21,2,'9',1,'2023-02-04','2023-02-07',20000, '차량없음,0,0,0');
insert into `book`(site_code, user_code, merchant_uid, book_member, book_checkin, book_checkout, book_price, book_car_number) values(21,3,'10',2,'2023-02-02','2023-02-05',45000,'13나1234,1,1,1');


-- 스케줄
insert into `schedule`(admin_code, schedule_date, schedule_name) values(2,'2023-02-06','방역');
insert into `schedule`(admin_code, schedule_date, schedule_name) values(2,'2023-02-07','방역');

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