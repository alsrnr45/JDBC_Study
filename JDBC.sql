INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, 'XXX', 'XXXX', 'X', XX, 'XXXX', 'XXXXX', 'XXXX', SYSDATE);

-- ȸ�� ��ü ��ȸ ��û�� ������ sql��
SELECT * FROM MEMBER;

-- ȸ�� ���̵�� �˻� ��û�� ������ sql��
SELECT *
FROM MEMBER
WHERE USERID = 'admin';

-- ȸ�� �̸����� Ű���� �˻� ��û�� ������ sql��
SELECT FROM MEMBER WHERE USERNAME LIKE '%��%';

-- ȸ�� ��������(���,�̸���,��ȭ��ȣ,�ּ�) ��û�� ������ sql��
UPDATE MEMBER 
SET USERPWD = 'XXX', EMAIL = 'XXX', PHONE = 'XXX', ADDRESS = 'XXX'
WHERE USERID = 'XXX';

-- ȸ�� Ż�� ��û�� ������ sql��
DELETE FROM MEMBER WHERE USERID = 'XXXX' ;