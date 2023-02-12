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


-- 공지
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(1, 1, '[이용안내] 캠핑장 예약 및 이용시 유의사항 안내', "\n안녕하세요, NoopCamping입니다.\n\n1. 입장시간은 14:00시 이후 / 퇴장시간은 익일 정오 12:00시 까지 입니다.\n   (입퇴장 시간은 청소 및 다음 준비를 위하여 필히 준수하여 주시기 바랍니다.)\n\n2. 예약 차량(1대) 및 예약 인원 이외에는 출입할 수 없습니다.\n   (기준인원 초과시 1인당 10,000원의 추가요금이 적용됩니다.)\n\n3.지정 주차장 제도로 인하여 추가 차량은 캠핑장 내 주차가 불가능합니다.\n\n4. 화재 예방을 위해 텐트 내에서는 절대 금연이며, 휴대용 가스버너, 양초,\n   폭죽 등의 사용을 금지하며 반려 동물의 동반입소는 불가능합니다.\n\n5. 입장하신 후 텐트내 귀중품 도난에 유의하시기 바랍니다.\n\n6. 미성년자는 보호자 동반 없이 캠핑장 이용이 불가능 합니다.\n\n감사합니다.\n\n\n");
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(1, 1, '[자주 묻는 질문] Q. 환불은 어디서 요청하나요?', "\n안녕하세요, NoopCamping입니다.\n\n예악 환불 신청은 예약이 승인된 상태에서 본인이 직접 진행해주셔야 합니다.\n홈페이지 로그인 후 [마이페이지]-[예약내역]-[환불요청] 으로 진행합니다.\n\n※ 환불신청시 참고사항 - 천재지변과 우천으로 사용이 전혀 불가능할때에는 배상금없이 사용료만 환불됩니다.\n※ 사용자가 사용당일 11시간까지 통보가 없는 경우에는 환불이 불가능합니다.\n\n감사합니다.\n\n\n");
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(1, NULL, '[자주 묻는 질문] Q. 비가 와서 못 갈것 같은데 환불이 가능한가요?', "\n안녕하세요, NoopCamping입니다.\n\n가벼운 우천으로 인한 환불은 100% 환불 받을 수 없습니다.\n기상 상황 및 천재지변으로 인해 캠핑장 이용이 전혀 불가능 할 경우에는 환불 규정에 따라 100% 환불이 가능합니다.\n(호우특보, 태풍 직접적인 영향 등)\n\n감사합니다.\n\n\n");
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(1, 1, '[휴무일 안내] (방역)긴급 휴장 안내', "\n안녕하세요, NoopCamping입니다.\n\n코로나19 확진자 다수 발생으로 인한 방역 일정으로 1주간 휴장 예정입니다.\n\n※ 휴무기간: 02/24 ~ 03/07(예정)\n\n추후 일정 변경시 개별적으로 연락을 드리도록 하겠습니다.\n2월24일부터 3월31 일까지 예약승인되신 분은 홈페이지에서 환불 요청 부탁드립니다.\n기타문의는 02-1234-1234로 연락 부탁드립니다.\n※ 전화문의 가능시간 (오전9시-오후6시)\n\n감사합니다.\n\n\n");
INSERT INTO notice(admin_code, notice_level, notice_title, notice_content) VALUES(1, 1, '[휴무일 안내] 정화조 보수공사로 인한 휴장 안내', "\n안녕하세요, NoopCamping입니다.\n\n캠핑장 정화조 보수공사 일정으로 1주간 휴장 예정입니다.\n\n※ 휴무기간: 02/24 ~ 03/07(예정)\n\n추후 일정 변경시 개별적으로 연락을 드리도록 하겠습니다.\n2월24일부터 3월31 일까지 예약승인되신 분은 홈페이지에서 환불 요청 부탁드립니다.\n기타문의는 02-1234-1234로 연락 부탁드립니다.\n※ 전화문의 가능시간 (오전9시-오후6시)\n\n감사합니다.\n\n\n");

-- 시설
INSERT INTO facility(admin_code, facility_name, facility_content) VALUES(1, "샤워장", "마사지, 때밀이, 빨래, 자리독점 등 타인에게 피해를 유발시키는 행위를 금지합니다.\n안전사고 방지 및 환경보호를 위해 오일, 팩, 우유, 염색 등의 사용을 금지합니다.\n공용 이용 시설인 관계로 샤워실 내 휴대폰 반입을 금지합니다.\n온수는 07:00~24:00에 이용 가능합니다.");
INSERT INTO facility(admin_code, facility_name, facility_content) VALUES(1, "매점", "관리동 왼편에 위치한 매점입니다. \n\n- 평일(월~금) : 10:00~18:00\n- 주말 : 24시간 이용 가능\n※ 01:30 이후 무인 키오스크로 운영됩니다.\n");
INSERT INTO facility(admin_code, facility_name, facility_content) VALUES(1, "카페", "커피류, 쥬스류, 베이커리류 등 다양한 메뉴를 제공하고 있습니다.\n외부 음료 반입은 자제 부탁드립니다.\n\n- 평일(월~금) : 08:30~21:30\n- 주말 : 10:00~19:00");
INSERT INTO facility(admin_code, facility_name, facility_content) VALUES(1, "화장실", "각 구역 입구에 남자화장실 2개소, 여자화장실 2개소가 설치되어 있습니다.\n위생용품 문의는 관리동으로 요청 바랍니다.\n\n- 청소 시간 : 23:00~23:30");

-- 홈페이지
INSERT INTO home(admin_code, home_owner, home_address, home_https, home_tell, home_content, home_longitude, home_latitude, home_image)VALUES(1, '나대표', '서울시 어디구 어디대로 245길 13-256 ', 'www.naver.com', '02-1234-1234', '산과 강과 호수로 둘러쌓인 천혜의 자연 환경을 갖춘 캠핑장에서 도심 속을 벗어나 편안한 힐링을 즐겨보세요.\n4계절마다 각 계절의 특색을 갖추고 있으며 캠핑장을 가득 채운 고목들이 즐비하여 캠핑장 전체에 시원한 그늘을 제공하고 있습니다.', 37.5039781087508, 127.04273317956381, "오시는 길.png");

-- 구역
insert into `review`(book_code, review_content, review_score) values(1,'일단 사장님 너무 친절하시고 유쾌하시고 맛집이랑 차박지 추천 다 알려주시고 텐트치는 법 몰라도 다 알려주시니까 걱정이 없었습니다',4);
insert into `review`(book_code, review_content, review_score) values(2,'4박 5일 일정 중에 가장 기억에 남는 순간이었어요! 좀 추웠어요',3);
insert into `review`(book_code, review_content, review_score) values(3,'저희는 다른 용품은 있어서 모닥불만 대여했는데 사장님 친절하시고 사용법도 잘 알려주셔서 안전하고 갬성있게 불멍할 수 있었어요',5);
insert into `review`(book_code, review_content, review_score) values(5,'물품 깨끗하고 좋은 캠핑 스팟 잘 알려주셨으며 설치하는데 사장님께서 오셔서 엄청 도와주셨어요',5);

-- 사이트
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(1, '호수 A',20000,'호수 존-호수 A 사이트 입니다.\n호수가 한눈에 내려다보이는 전망이 일품인 사이트입니다.\n호숫가 둘레길 바로 옆에 위치하며 잔디 위에 텐트 사이트가 있습니다.\n커플이나 성인2인+어린이 1~2명이 이용하기에 적당한 규모입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(1, '호수 B',20000,'호수 존-호수 B 사이트 입니다.\n호수가 한눈에 내려다보이는 전망이 일품인 사이트입니다.\n호숫가 둘레길 바로 옆에 위치하며 잔디 위에 텐트 사이트가 있습니다.\n커플이나 성인2인+어린이 1~2명이 이용하기에 적당한 규모입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(1, '호수 C',20000,'호수 존-호수 C 사이트 입니다.\n호수가 한눈에 내려다보이는 전망이 일품인 사이트입니다.\n호숫가 둘레길 바로 옆에 위치하며 잔디 위에 텐트 사이트가 있습니다.\n커플이나 성인2인+어린이 1~2명이 이용하기에 적당한 규모입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(1, '호수 D',20000,'호수 존-호수 D 사이트 입니다.\n호수가 한눈에 내려다보이는 전망이 일품인 사이트입니다.\n호숫가 둘레길 바로 옆에 위치하며 잔디 위에 텐트 사이트가 있습니다.\n커플이나 성인2인+어린이 1~2명이 이용하기에 적당한 규모입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(1, '호수 E',20000,'호수 존-호수 E 사이트 입니다.\n호수가 한눈에 내려다보이는 전망이 일품인 사이트입니다.\n호숫가 둘레길 바로 옆에 위치하며 잔디 위에 텐트 사이트가 있습니다.\n커플이나 성인2인+어린이 1~2명이 이용하기에 적당한 규모입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(2, '텐트 A',30000,'텐트/차박 존-텐트 A 사이트 입니다.\n개인 SUV차량과 캐러반 등으로 캠핑이 가능한 사이트입니다.\n호숫가 둘레길 바로 옆에 위치하며 잔디 위에 텐트 사이트가 있습니다.\n커플이나 성인2인+어린이 1~2명이 이용하기에 적당한 규모입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(2, '텐트 B',30000,'텐트/차박 존-텐트 B 사이트 입니다.\n개인 SUV차량과 캐러반 등으로 캠핑이 가능한 사이트입니다.\n호숫가 둘레길 바로 옆에 위치하며 잔디 위에 텐트 사이트가 있습니다.\n커플이나 성인2인+어린이 1~2명이 이용하기에 적당한 규모입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(2, '텐트 C',30000,'텐트/차박 존-텐트 C 사이트 입니다.\n개인 SUV차량과 캐러반 등으로 캠핑이 가능한 사이트입니다.\n호숫가 둘레길 바로 옆에 위치하며 잔디 위에 텐트 사이트가 있습니다.\n커플이나 성인2인+어린이 1~2명이 이용하기에 적당한 규모입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(2, '차박 A',30000,'텐트/차박 존-차박 A 사이트 입니다.\n개인 SUV차량과 캐러반 등으로 캠핑이 가능한 사이트입니다.\n호숫가 둘레길 바로 옆에 위치하며 잔디 위에 텐트 사이트가 있습니다.\n커플이나 성인2인+어린이 1~2명이 이용하기에 적당한 규모입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(2, '차박 B',30000,'텐트/차박 존-차박 B 사이트 입니다.\n개인 SUV차량과 캐러반 등으로 캠핑이 가능한 사이트입니다.\n호숫가 둘레길 바로 옆에 위치하며 잔디 위에 텐트 사이트가 있습니다.\n커플이나 성인2인+어린이 1~2명이 이용하기에 적당한 규모입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(3, '마운틴 A',40000,'마운틴 존-마운틴 A 사이트 입니다.\n계절마다 바뀌는 산 전경을 보며 노지 캠핑이 가능한 사이트입니다.\n금강산 아래쪽을 따라 잔디 위에 텐트 사이트가 있습니다.\n커플이나 성인3인+어린이 1~2명이 이용하기에 적당한 규모입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(3, '마운틴 B',40000,'마운틴 존-마운틴 B 사이트 입니다.\n계절마다 바뀌는 산 전경을 보며 노지 캠핑이 가능한 사이트입니다.\n금강산 아래쪽을 따라 잔디 위에 텐트 사이트가 있습니다.\n커플이나 성인3인+어린이 1~2명이 이용하기에 적당한 규모입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(3, '마운틴 C',40000,'마운틴 존-마운틴 C 사이트 입니다.\n계절마다 바뀌는 산 전경을 보며 노지 캠핑이 가능한 사이트입니다.\n금강산 아래쪽을 따라 잔디 위에 텐트 사이트가 있습니다.\n커플이나 성인3인+어린이 1~2명이 이용하기에 적당한 규모입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(3, '마운틴 D',40000,'마운틴 존-마운틴 D 사이트 입니다.\n계절마다 바뀌는 산 전경을 보며 노지 캠핑이 가능한 사이트입니다.\n금강산 아래쪽을 따라 잔디 위에 텐트 사이트가 있습니다.\n커플이나 성인3인+어린이 1~2명이 이용하기에 적당한 규모입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(3, '마운틴 E',40000,'마운틴 존-마운틴 E 사이트 입니다.\n계절마다 바뀌는 산 전경을 보며 노지 캠핑이 가능한 사이트입니다.\n금강산 아래쪽을 따라 잔디 위에 텐트 사이트가 있습니다.\n커플이나 성인3인+어린이 1~2명이 이용하기에 적당한 규모입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(4, '리버 뷰 A',50000,'리버 존 - 리버 뷰 A 사이트 입니다.\n탁 트인 금강의 시원한 강바람과 함께 휴식을 취할 수 있는 사이트입니다.\n강변을 따라 사이트가 늘어서 있으며 데크 위에 텐트 사이트가 있습니다.\n커플이나 성인2인+어린이 1~2명이 이용하기에 적당한 규모입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(4, '리버 뷰 B',50000,'리버 존 - 리버 뷰 B 사이트 입니다.\n탁 트인 금강의 시원한 강바람과 함께 휴식을 취할 수 있는 사이트입니다.\n강변을 따라 사이트가 늘어서 있으며 데크 위에 텐트 사이트가 있습니다.\n커플이나 성인2인+어린이 1~2명이 이용하기에 적당한 규모입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(4, '리버 뷰 C',50000,'리버 존 - 리버 뷰 C 사이트 입니다.\n탁 트인 금강의 시원한 강바람과 함께 휴식을 취할 수 있는 사이트입니다.\n강변을 따라 사이트가 늘어서 있으며 데크 위에 텐트 사이트가 있습니다.\n커플이나 성인2인+어린이 1~2명이 이용하기에 적당한 규모입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(4, '리버 뷰 D',50000,'리버 존 - 리버 뷰 D 사이트 입니다.\n탁 트인 금강의 시원한 강바람과 함께 휴식을 취할 수 있는 사이트입니다.\n강변을 따라 사이트가 늘어서 있으며 데크 위에 텐트 사이트가 있습니다.\n커플이나 성인2인+어린이 1~2명이 이용하기에 적당한 규모입니다.');
INSERT INTO `site` (zone_code, site_name, site_price, site_content)VALUES(4, '리버 뷰 E',50000,'리버 존 - 리버 뷰 E 사이트 입니다.\n탁 트인 금강의 시원한 강바람과 함께 휴식을 취할 수 있는 사이트입니다.\n강변을 따라 사이트가 늘어서 있으며 데크 위에 텐트 사이트가 있습니다.\n커플이나 성인2인+어린이 1~2명이 이용하기에 적당한 규모입니다.');

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