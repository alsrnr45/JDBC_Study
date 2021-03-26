INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, 'XXX', 'XXXX', 'X', XX, 'XXXX', 'XXXXX', 'XXXX', SYSDATE);

-- 회원 전체 조회 요청시 실행할 sql문
SELECT * FROM MEMBER;

-- 회원 아이디로 검색 요청시 실행할 sql문
SELECT *
FROM MEMBER
WHERE USERID = 'admin';

-- 회원 이름으로 키워드 검색 요청시 실행할 sql문
SELECT FROM MEMBER WHERE USERNAME LIKE '%똥%';

-- 회원 정보변경(비번,이메일,전화번호,주소) 요청시 실행할 sql문
UPDATE MEMBER 
SET USERPWD = 'XXX', EMAIL = 'XXX', PHONE = 'XXX', ADDRESS = 'XXX'
WHERE USERID = 'XXX';

-- 회원 탈퇴 요청시 실행할 sql문
DELETE FROM MEMBER WHERE USERID = 'XXXX' ;