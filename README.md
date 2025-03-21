# SPRING PLUS

## 개발자
    Blog : https://strnetwork.tistory.com/
    github : https://github.com/mixedsider

## 트러블 슈팅
    https://strnetwork.tistory.com/63

## 프로젝트 개요
    [https://github.com/f-api/spring-advanced](https://github.com/f-api/spring-plus)
해당 프로젝트는 위의 프로젝트를 fork 하여 밑에서 서술할 레벨별 개선 및 테스트 코드를 추가를 하는 프로젝트입니다.


## 기능 설명
해당 프로젝트는 단순한 일정 공유 프로젝트입니다.

이 프로젝트는 회원 가입 및 로그인을 해야 사용을 하실 수 있습니다.

대표작 일정을 만들고 관리할 매니저를 추가를 할 수 있으며, 밑에 댓글을 추가를 하여 동참을 할 수 있습니다.

## 레벨별 개선한 부분 ( Commit 기준 )
1. 코드 개선 퀴즈 - Commit 8dd38d5
2. 코드 추가 퀴즈 - Commit 2d91b54
3. 코드 개선 퀴즈 - Commit ed29b6b
4.테스트 코드 퀴즈 - Commit ed29b6b
5. 코드 개선 퀴즈 - Commit b77c40e
6. JPA Cascade - Commit 1a77cf0
7. N+1 - Commit 1a77cf0
8. QueryDSL - Commit d02f4a3
9. Spring Security - Commit 7ab1642
10. QueryDSL 을 사용하여 검색 기능 만들기 - Commit 6589b1c
11. Transaction 심화 - Commit eae64b7
12. AWS 활용 - Commit e468545, 111d2f7
13. 대용량 데이터 처리 - Commit d43466e, 2865572, 66c8366, 24dcb37

## AWS
### EC2
![ec2](https://github.com/user-attachments/assets/abe1da94-2c3f-4752-be14-374914923805)

![image](https://github.com/user-attachments/assets/519a6e42-f61d-4302-a9c1-79eef63fd580)


### RDS
![image](https://github.com/user-attachments/assets/a6985d88-3e3f-4eba-952f-671d842d213b)

![rds2](https://github.com/user-attachments/assets/53de302f-2703-41cc-a763-12dacbf89e9d)

### S3
![s3](https://github.com/user-attachments/assets/2fc31ef8-3f6a-4dcc-a265-984d70760b40)


## 대용량 트래픽
각 JPA 와 QueryDSL의 차이와 유니크키, Index 측정을 하여보았다.

측정 기준은 랜덤한 id넘버를 우선 검색을 하여 닉네임을 찾아온다.

이후 각각 JPA, QueryDSL -> Unique -> Index 순으로 진행을 하였다.
### Jpa
![jpa](https://github.com/user-attachments/assets/dcafb00b-9ac9-4247-8874-529994be8cc7)

약 1.105913s
### JPA-Unique
![jpa-unique](https://github.com/user-attachments/assets/3acf5ad2-9e57-4088-bc5a-3e34c4abb17e)

약 0.003481302s

### JPA-Index
![jpa-index](https://github.com/user-attachments/assets/b21cd8ba-8347-4738-b7e3-14c5f06236af)

약 0.001083021s


### QueryDSL
![querydsl](https://github.com/user-attachments/assets/06c69f50-bc06-4a2e-9b5a-6d1b61e8e300)

약 0.9864132s

### QueryDSL-Unique
![querydsl-unique](https://github.com/user-attachments/assets/2a584ad4-b1ab-4643-aaa4-500d5c507b7c)

약 0.175139582s

### QueryDSL-Index
![querydsl-index](https://github.com/user-attachments/assets/4fce552e-0f36-4a99-a760-e09a6416e1dc)

약 0.001176992s

## 결과 ( default 대비 )
JPA > JPA-Unique (약 317배) > JPA-Index (약 1021배)

QueryDSL > QueryDSL-Unique (약 5.6배) > QueryDSL-Index (약 838배)

처음 시작을 하면 응답이 그렇게 빠르지 않아서 응답이 튀는 현상도 발견을 하였다.
아마 시행횟수가 많아지면 Unique 와 Index가 그리차이가 나지 않을듯하다.

기본적으로 편차가 심한 편이다.
20% 차이가 나는가 하면 많으면 200% 차이가 나는 것도 확인하였다.
