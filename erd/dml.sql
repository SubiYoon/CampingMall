-- 유저
INSERT INTO user VALUES(0, 1, 'admin', '111111', '관리자', 000101, '010-1234-5678');
INSERT INTO user VALUES(0, 0, 'abc01', '1234', '유저1', 010101, '010-1584-5678');
INSERT INTO user VALUES(0, 0, 'abc02', '1234', '유저2', 020202, '010-5238-4828');

-- 구역
INSERT INTO zone(zone_name, zone_content) VALUES('구역A', 'A존입니다.');
INSERT INTO zone(zone_name, zone_content) VALUES('구역B', 'B존입니다.');
INSERT INTO zone(zone_name, zone_content) VALUES('구역C', 'C존입니다.');
INSERT INTO zone(zone_name, zone_content) VALUES('구역D', 'D존입니다.');

-- 달력
INSERT INTO `calendar` VALUES('2023-02-01', 0);
INSERT INTO `calendar` VALUES('2023-02-02', 0);
INSERT INTO `calendar` VALUES('2023-02-03', 0);
INSERT INTO `calendar` VALUES('2023-02-04', 0);
INSERT INTO `calendar` VALUES('2023-02-05', 0);
INSERT INTO `calendar` VALUES('2023-02-06', 0);
INSERT INTO `calendar` VALUES('2023-02-07', 0);
INSERT INTO `calendar` VALUES('2023-02-08', 0);
INSERT INTO `calendar` VALUES('2023-02-09', 0);
INSERT INTO `calendar` VALUES('2023-02-10', 0);
INSERT INTO `calendar` VALUES('2023-02-11', 0);
INSERT INTO `calendar` VALUES('2023-02-12', 0);
INSERT INTO `calendar` VALUES('2023-02-13', 0);
INSERT INTO `calendar` VALUES('2023-02-14', 2);
INSERT INTO `calendar` VALUES('2023-02-15', 2);
INSERT INTO `calendar` VALUES('2023-02-16', 0);
INSERT INTO `calendar` VALUES('2023-02-17', 0);
INSERT INTO `calendar` VALUES('2023-02-18', 0);
INSERT INTO `calendar` VALUES('2023-02-19', 0);
INSERT INTO `calendar` VALUES('2023-02-20', 0);
INSERT INTO `calendar` VALUES('2023-02-21', 0);
INSERT INTO `calendar` VALUES('2023-02-22', 0);
INSERT INTO `calendar` VALUES('2023-02-23', 0);
INSERT INTO `calendar` VALUES('2023-02-24', 0);
INSERT INTO `calendar` VALUES('2023-02-25', 0);
INSERT INTO `calendar` VALUES('2023-02-26', 0);
INSERT INTO `calendar` VALUES('2023-02-27', 0);
INSERT INTO `calendar` VALUES('2023-02-28', 0);
INSERT INTO `calendar` VALUES('2023-03-01', 1);
INSERT INTO `calendar` VALUES('2023-03-02', 1);

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


SELECT * FROM user;
SELECT * FROM zone;
SELECT * FROM calendar;
SELECT * FROM site;