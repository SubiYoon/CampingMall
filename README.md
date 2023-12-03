# **CampingMall Project**

<br>
<div align="center">
    <img style="width:300px; height:400px;" src="https://user-images.githubusercontent.com/117332869/218310675-ac69e653-025a-4b30-bb22-af611652570a.png">
</div>
<br>

# 0. 홈페이지 링크(현재 서버가 내려가 있어 이용이 불가합니다.)
- 서버가 좋지않아 다소 느린저 양해부타 드립니다.
- <a href='http://101.101.216.229/'>사용자 홈페이지 (Click)</a>
- <a href='http://101.101.216.229/admin'>관리자 홈페이지 (Click)</a>
- 관리자 ID : admin01
- 관리자 Password : asdf123!

# 1. 기획목적
- 여러 캠핑장을 한곳에 모아 원하는 캠핑장을 선택하여 해당 캠핑장에 예약 할 수 있도록 도와주는 사이트 
<br><br>

> 교육 목적
- 팀 프로젝트 과정으로 협업에 필요한 여러 툴을 사용한 프로젝트 완성
- 교육받은 내용을 바탕으로 팀원 모두 프론트/백을 설계, 개발하며 프로세스 이해도 향상 
- 네이버 클라우드 플랫폼(NCP)을 사용한 배포를 통해 도메인, 서버에 대한 이해도 향상 및 서버 운영, 유지 보수 경험 축적
- 아임포트, kakao, naver, google 등의 다양한 API를 이용하여 예약/결제 및 소셜 로그인, 카카오맵, 날씨 기능, 챗봇 등 구현
<br><br><br>

# 2. 목표 및 차별성

- 유저(이용 고객)와 관리자(캠핑장 업체) 페이지를 별도로 두어 보안을 강화한 캠핑장 종합 예약 웹 서비스로 기획
- 다양한 API 활용과 반응형 웹, 직관적인 UI로 사용자 편의 제공
- 캠핑장 업체 관리자의 넓은 웹 컨텐츠 수정 권한 제공
- AES512방식의 단방향 암호화 사용

<br><br><br>

# 3. 배운점

- API사용에 있어서 문서를 이해하고 이해한 내용을 문서화하여 저장하는 습관의 중요성을 깨달음
- 단순히 query문의 작성법이 아닌 DB와 서버 연결시 고려해야 할 상황들까지 신경써야 한다는 것을 깨달음
- 문제 발생 시 해당 문제를 스스로 해결하고 내것으로 만들기 위한 메모습관의 중요성
- 협업을 경험하고 팀장역을 새로 맡으면서 의사소통의 중요성과 프로젝트 완료에 대한 책임감을 배움

<br><br><br>

# 4. 시스템 구성/개발도구

### 🏕  시스템 구성
<img width="1743" alt="Camping Mall" src="https://user-images.githubusercontent.com/117332903/218227062-2f92280a-312b-4d4d-b7ba-4dd7c381bc2c.png">

<br>

<div align="center">

| IDE | Back | Front | DB | FrameWork | API | Etc - Tools | Server |
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
| Eclipse<br> IntelliJ<br> VSCode | Java JDK 11 | HTML<br> JavaScript<br> Jquery<br> Ajax<br> ThymeLeaf<br> BootStrap | MySQL<br> v8.0.31 | SpringBoot<br> Mybatis | Weather<br> Kakao<br> Import<br> Naver ChatBot | GitHub<br> WorkBanch<br> Gather Town<br> Coggle<br> Figma<br> ERDCloud<br> CloudCraft<br> Google Sheet |	Tomcat<br> NCP(Naver Cloud Platform)<br> CentOS |

</div>

<br><br><br>

# 5. WBS/프로젝트 구성원 및 담당
### 📆WBS
![WBS](https://user-images.githubusercontent.com/117332903/218639451-34e7105b-0062-4f2a-ac78-08678cfb1617.png)
<img width="1320" alt="스크린샷 2023-02-18 오후 9 06 51" src="https://user-images.githubusercontent.com/117332903/219864894-41d99735-bb88-4359-a4cf-7970cb7fa1d0.png">

<br>

### 🏕  프로젝트 구성원

NAME | Representative  
---- | ----
공통 | - 주제 선정, 일정 수립, 기획 <br> - 개발환경 구축, 테이블/주요 기능 설계 <br> - 디자인 레이아웃 설계 <br> - 테스트, 디버깅, 검수, 포트폴리오 제작|
강무성 | - DB설계 <br> - ERD/DDL/DML 제작 <br> - 메인/서브 페이지 레이아웃 작업 <br> - 예약 시스템, 예약 조회시스템 <br> - ADMIN통계 페이지, 예약정보 관리 페이지 개발|
김태욱 | - 메인/서브 레이아웃 작업 <br> - 예약 조회시스템, 예약 상세, 결제 시스템 <br> - 날씨 시스템 개발 <br> - ADMIN통계 페이지 <br> - 환불 처리 페이지 개발|
박지원 | - UI 디자인 설계 <br> - 와이어프레임 제작 <br> - 프레임 작업, 메인/서브 페이지 레이아웃 작업 <br> - 메인 페이지 CRUD, 공지사항 CRUD, 구역소개 CRUD <br> - 로그인 화면 <br> - 지도 시스템, 챗봇 시스템 개발|
윤동섭 | - DB설계 <br> - ERD/DDL/DML 제작 <br> - 메인/서브 페이지 레이아웃 작업 <br> - 메인 페이지 CRUD, 시설 CRUD, 상호 CRUD, 홈 CRUD <br> - 로그인/SNS로그인/로그아웃/회원가입/수정, 마이페이지 개발 <br> - 회원가입 시 암호화(AES512)<br> - 예약 시스템, 예약 조회시스템 <br> - 리뷰시스템 <br> - 다국어 처리 <br> - 파일업로드(중복이름파일, 교체된 이미지 삭제 처리)<br> - ADMIN로그인, 회원관리, 휴무일 지정, 예약정보 관리 페이지 개발|

<br><br>

<br><br><br>


# 6. DB 설계/기능 흐름도
### 🏕  DB 설계(ERD)

![Camping](https://user-images.githubusercontent.com/117332903/218905296-a6565359-9e29-48f9-9c9d-a6d031141864.png)

<br>

### 🏕  기능 흐름도(USER페이지)

<img width="100%" src="https://user-images.githubusercontent.com/117332869/218310757-3d3b9295-02d1-43d5-ba35-6271559f319c.jpg">

<br>

### 🏕  기능 흐름도(ADMIN페이지)

<img width="100%" src="https://user-images.githubusercontent.com/117332869/218310760-6426fec6-d29e-4695-9703-99d0ea36cf9d.jpg">

<br><br><br>

# 7. 웹 서비스 주요기능 구현 화면
## 캠핑장 선택 및 세션이 만료됐을 경우
- 여러 캠핑장을 등록 후 사용 할 수 있도록 구현
- DB에서 데이터를 불러와서 세션으로 구분
- 세션 만료시 캠핑장 선택페이지로 이동해 사용자가 에러페이지를 보는 것을 방지

![캠핑장선택,에러](https://user-images.githubusercontent.com/117332903/218694227-71c871e4-3b50-4101-b2e3-a055b1e03e06.gif)

<br><br><br>

## 반응형
- 반응형 웹으로 만들어 모바일 환경에서도 사용이 가능하게 구현

![반응](https://user-images.githubusercontent.com/117332903/218700164-2800e2f8-9370-4b4b-87ec-2abe7cb90ea5.gif)
<br><br><br>


## 회원가입 및 탈퇴
- 회원가입시 각 input마다 정규식을 사용해 유효성검사를 시행
- 비밀번호는 AES512 단방향 암호화 방식을 채택하여 DB에 저장
- 탈퇴시 DB에 있는 데이터 ID앞에 구분자를 삽입 후 나머지 정보는 삭제
- ID는 통계페이지에서 예약 데이터를 이용하기 위해 남겨둠

![회원가입](https://user-images.githubusercontent.com/117332903/218677920-775f388e-deb6-421e-a031-c0b114fe7b64.gif)

![회원탈퇴](https://user-images.githubusercontent.com/117332903/218682110-bc409d95-eb5e-44cf-ada5-7b2565153402.gif)

<br><br><br>

## 예약과정
### 1. 사이트 선택
- JavaScript의 cell을 이용하여 달력 구현
- 함수 로직을 작성하여 체크된 날짜를 표시
- DB에서 휴일로 설정된 날과 예약이 완료된 사이트를 제외하고 데이터를 불러옴
- 기상청 날씨 API를 사용하여 최근 날씨들을 보여주어 예약의 편의성 제공

![달력클릭](https://user-images.githubusercontent.com/117332903/218662949-bda7ae32-500f-4cf1-8e58-69242d989b79.gif)
<br><br><br>

### 2. 결제
- 예약완료를 위한 결제기능
- import API를 이용해 결제 요청 후 결제 정보를 DB에 저장
- 검증단계에서 import restAPI를 통해 검증과 webhook서비스를 이용한 결제정보 동기화작업을 수행

![결제](https://user-images.githubusercontent.com/117332903/218663003-53309dde-5ce3-4ee1-b263-cd3f45ec21ab.gif)
<br><br><br>

## 리뷰시스템
- 고객 후기 시스템
- 로그인을 하지 않으면 작성할 수 없음
- 예약을 완료하지 않으면 작성할 수 없음
- 예약 후 체크인을 하지 않은 예약에 대해서는 작성할 수 없음

![리뷰](https://user-images.githubusercontent.com/117332903/218890857-968dc169-d8d1-4caf-8ca1-10350483e854.gif)
<br><br><br>

---
<br><br>
## 관리자 로그인
- 각 관리자상호 별로 따로따로 각자의 홈페이지를 관리 할 수 있음
- 유저페이지와 마찬가지로 세션이 만료되면 자동으로 로그인페이지로 이동

![다른admin](https://user-images.githubusercontent.com/117332903/218661687-8e01e069-6f00-46ea-b027-0a6d88878d65.gif)
<br><br><br>

## 통계보기
- 원하는 통계만 골라서 볼 수 있습니다.
- 월별 통계, 년별 매출, 예약수, 방문객, 구역별 매출, 구역별 방문객을 조회할 수 있습니다.

![통계보기](https://user-images.githubusercontent.com/117332903/218662168-3a821845-020a-4389-b1bf-5dfadae77d9d.gif)
<br><br><br>

## 휴일 추가
- JavaScript의 cell을 이용하여 달력 구현
- 함수 로직을 작성하여 체크된 날짜를 표시
- 달력을 이용하여 해당 날짜에 예약을 못하도록 설정

![휴일추가](https://user-images.githubusercontent.com/117332903/218662412-bc440727-d840-4a9a-81bc-1f95e87d78e6.gif)
<br><br><br>

## 게시글 변경(이미지 변경)
- 해당 이미지파일이 admin프로젝트의 이미지 폴더로 저장
- User프로젝트에서 외부 폴더 사용을 설정해주어 admin폴더의 이미지를 불러옴
- 기존에 사용하던 파일은 삭제함
- 사용중인 파일의 이름과 같은 파일일 경우 구분하기 위해 (숫자)로 구분을 해줌

![이미지변경](https://user-images.githubusercontent.com/117332903/218695525-c05362f7-e7b2-4362-a655-a79e5dfbe34a.gif)
<br><br><br>

## 환불
- 관리자는 유저가 요청하는 환불건들에 대해 리스트를 확인
- 확인 후 승인 or 환불 거절을 선택 할 수 있음

![환불](https://user-images.githubusercontent.com/117332903/218693075-58da665b-4ee6-4398-9181-a8062725ba12.gif)
<br><br><br>

## API
### 1. 카카오 Login
- 카카오 로그인
- 탈퇴시 카카오와 연결도 끊고 DB에서도 데이터 삭제
- 일반 회원가입과 같은 시스템으로 DB에서 데이터 삭제 

![카카오](https://user-images.githubusercontent.com/117332903/218676346-55c65cb9-8312-44b4-b5a8-1e7b1590fa79.gif)
<br><br><br>

### 2. 날씨, 카카오 Map
- 위도, 경도를 수정하여 지도에 표시
- 날씨의 경우 기상청에서 요구하는 x좌표, y좌표로 변환하여 사용

![좌표수정](https://user-images.githubusercontent.com/117332903/218662484-7c76086b-9a62-4ac4-b4c9-49f7c49ee9a4.gif)
<br><br><br>

### 3. Naver AI챗봇
- NCP의 AI Service-챗봇을 이용한 구현

<img src="https://user-images.githubusercontent.com/117332903/218676813-58f0a4e3-6d83-4951-a70b-3795e5182227.gif" width="310px">

<br><br><br>

# 8. 나의 트러블 슈팅🧨
1. BootStrap 사용시 하위맵핑에서 js파일 실행안되는 현상 발생 (ex. localhost/user/register) - 해결
> Thymeleaf 사용시 src를 th:src로 변경하여 해결<br>
<br>

2. Mapping 실행시 추가적으로 GETMapping이 실행되는 현상 발생 - 해결
> 템플릿파일 중 JS파일에서 맵핑을 두번실행되는 것으로 추정됨<br>
> 해결은 했지만, 아직 완벽한 원인을 파악하지 못함….<br>
<br>

3. IntelliJ에서 main.java에 있는 xml파일 인식 못하는 문제 발생 - 해결
> IntelliJ 이슈인것으로 추측됨.<br>
> resources하위폴더로 Path를 새로 잡아준 후 해결<br>
> mybatis.mapper-locations=classpath:mybatis//*.xml
<br>

4. 다른페이지에서 Login시 url이 중첩되어지는 현상 발생 - 해결
> ex) Notice페이지에 맵핑된 페이지에서 Login 모달 실행시 /notice/login/loginOk로 맵핑됨<br>
> 맵핑 주소 앞에 ‘ / ‘ 를 삽입하여 해결<br>
<br>

5. Kakao Map 로그인, 회원가입 후 500에러 현상 발생 - 해결
> Controller에서 ‘ / ‘ 로 맵핑시 데이터가 전달되도록 설정되어 있음<br>
> UserController에서 main으로 return하던것을 redirect를 사용하여 ‘ / ‘ 로 리턴시켜 해결<br>
<br>

6. 예약페이지 달력에서 background-color 클릭이벤트시 한자리 숫자와 두자리 숫자 클릭시 표시 불량 - 해결
> 처음에 클릭하는 숫자앞에 0을 문자타입으로 붙여서 숫자로 인식 못하는 문제 발생<br>
> 해당 문자를 숫자로 인식하게 하기 위해 0일 빼주어 숫자로 인식하게 만듬<br>
<br>

7. Controller에서 같은 변수명 List형식으로 받아지지 않는 현상 발생 - 해결
> Controller에서 매개변수 설정시 에노테이션을 작성해 주어야함<br>
> @RequestParam 에노테이션 작성 후 문제 해결<br>
<br>

8. Admin 페이지에 파일을 upload하기 때문에 User페이지에서 데이터를 못 받아오는 현상 발생 - 해결
> Class를 생성해서 WebMVCConfigurer를 상속받아 addResourceHandlers 메서드를 Override 함<br>
> Configuration 에노테이션을 Class에 선언해주어야 함<br>
> 경로 작성시 ‘ / ‘ 닫는거 유의!!<br>
<br>

9. Jquery 동작 안하는 현상 발생.. - 해결
> $(document).ready(); 를 선언해주지 않아 작동하지 않음..<br>
<br>

10. sidebar에 데이터 뿌려주는거 main페이지에서만 작동하고 다른페이지에서 작동 안하는 현상 발생 - 해결
> 페이지 이동시 데이터를 불러오고 보내주는 단계가 없어 데이터 뿌려주지 못함<br>
> session을 이용하여 해결<br>
<br>

11. 서버와 MySQL연동시 Query문 작동 안하는 문제 발생 - 해결
> 컬럼은 상관없지만, 테이블명에서 대소문자를 구분하기 시작함<br>
> ddl에 만든 테이블명을 소문자로 입력후 dml을 사용하니 해결 됨<br>
<br>

12. 서버 배포후 지연시간이 길다고 나와 연결 안되는 문제 발생 - 해결
> ACG설정에서 다른 포트들은 넣었지만 80포트를 추가하지 않아 접속이 안됨<br>
> 80포트 추가후 해결<br>
<br>

13. Local에서는 작동하나 배포 후 siteedit맵핑에 에러발생(500) - 해결
> 서버에서 DB쿼리문 날릴때 대소문자 구분을 해줌으로 해결
