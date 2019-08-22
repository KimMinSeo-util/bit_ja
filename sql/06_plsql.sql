SET SERVEROUTPUT ON ;

Create Procedure SALARY_CAL
    실행가능한 모듈이 데이터베이스에 만들어진다.  
   
##############################
   Procedure
##############################
--procedure 생성(empno)
create or replace procedure update_sal(v_empno in number)
is
begin
 update emp
 set sal=sal*1.1
 where empno=v_empno;
end;
/
--procedure 삭제
drop procedure update_sal;

select * from emp;
--procedure 실행
execute update_sal(7369);
commit;
--procedure 생성,삭제(deptno)
create or replace procedure update_sal(v_deptno in number)
is
begin
 update emp
 set sal=sal*1.1
 where deptno=v_deptno;
end;
/
execute update_sal(20);
select * from emp;
rollback;
drop procedure update_sal;

*******************

Drop table book;

CREATE TABLE Book (
  bookid      NUMBER(2) PRIMARY KEY,
  bookname    VARCHAR2(40),
  publisher   VARCHAR2(40),
  price       NUMBER(8) 
);


CREATE OR REPLACE PROCEDURE InsertBook(
    myBookID IN NUMBER,
     myBookName IN VARCHAR2,
     myPublisher IN VARCHAR2,
     myPrice IN NUMBER)
 AS
 BEGIN
      INSERT INTO Book(bookid, bookname, publisher, price)
      VALUES(myBookID, myBookName, myPublisher, myPrice);
 END;
/

execute InsertBook(1,'java ~~~','한빛',27000);
exec InsertBook(2,'java ~~~','한빛',27000);

select * from book;
rollback;




**********************************
동일한 도서가 있는지 점검한 후 
삽입하는 프로시저(BookInsertOrUpdate)

CREATE OR REPLACE PROCEDURE BookInsertOrUpdate(
    myBookID NUMBER,
    myBookName VARCHAR2,
    myPublisher VARCHAR2,
    myPrice INT) 
 AS
    mycount NUMBER; --mycount를 NUMBER로 변수선언
 BEGIN
   SELECT COUNT(*) INTO mycount FROM Book	--mybookName과 똑같은게 있는지 확인
     WHERE bookname LIKE myBookName;
   IF mycount!=0 THEN			--IF시작
     UPDATE Book SET price = myPrice
       WHERE bookname LIKE myBookName;
   ELSE
     INSERT INTO Book(bookid, bookname, publisher, price)
       VALUES(myBookID, myBookName, myPublisher, myPrice);
   END IF;						--IF끝
 END;
/

exec BookInsertOrUpdate(1,'db','비트',0);
select * from book;

exec BookInsertOrUpdate(1,'db','비트',200);
select * from book;
rollback;

##########################################
FUNCTION void허용하지않음
########################################
CREATE OR REPLACE FUNCTION fn1(
    price NUMBER) RETURN INT
  IS
     myInterest NUMBER;
  BEGIN
  /* price가 30,000원 이상이면 10%, 3,000원 미만이면 5% */
    IF Price >= 3000 THEN myInterest := Price * 0.1;
    ELSE myInterest := Price * 0.05;
   END IF;
   RETURN myInterest;
  END;
/

--사용자 정의 함수 실행
select empno,ename,sal,fn1(sal) from emp;

####################################
trigger 
####################################
drop table warehouse;
drop table item;

create table item(
  code char(6) primary key, --물품 코드
  name varchar2(15) not null,
  company varchar2(15),
  price number(8),
  cnt number default 0 -- 재고 수량  
);


create table warehouse(
   num number(6) primary key, --입고 번호
   code char(6) references item(code),
   indate date default sysdate, --입고날짜
   incnt number(6),
   inprice number(6),
   totalprice number(8)
);

select * from  item;
select * from warehouse;

insert into item(code, name, company, price)
values('c0001', '에어콘', '삼성', 1000000);

insert into item(code, name, company, price)
values('c0002', '선풍기', 'LG', 50000);

commit;

SELECT * FROM item;

--재고수량 갱신하기위한 트리거 생성
create or replace trigger cnt_add
after insert on warehouse
for each row
  begin
     update item set cnt = cnt+:new.incnt
     where code=:new.code; --new 선언은 insert문, update문에서만 사용
end;
/
select * from  item;
select * from warehouse;

insert into warehouse(num, code, incnt, inprice, totalprice)
values(1,'c0001',10, 900000, 9000000 );

SELECT * FROM item;
SELECT * FROM warehouse;

#################################################
trigger  book  p270
:book테이블에 데이터를 넣으면 Book_log에 자동으로 똑같은 데이터 생성
################################################
set serveroutput on;


CREATE TABLE Book (
  bookid      NUMBER(2) PRIMARY KEY,
  bookname    VARCHAR2(40),
  publisher   VARCHAR2(40),
  price       NUMBER(8) 
);

 CREATE TABLE Book_log(
    bookid_l NUMBER,
    bookname_l VARCHAR2(40),
    publisher_l VARCHAR2(40),
    price_l NUMBER
 );
 
select * from book;
select * from Book_log;

--trigger 생성        
CREATE OR REPLACE TRIGGER AfterInsertBook
     AFTER INSERT ON Book FOR EACH ROW
     DECLARE
     BEGIN
        INSERT INTO Book_log
           VALUES(:new.bookid, :new.bookname, :new.publisher, :new.price);
        DBMS_OUTPUT.PUT_LINE('Book_log 테이블에 백업..');
     END;
/
insert into book values(1,'java ~~~~','한빛미디어',2900);
select * from book;
select * from Book_log;

set serveroutput on;

insert into book values(2,'SQL','bit',9900);

######################################################################
CURSOR 
######################################################################

drop PROCEDURE Interest;
CREATE OR REPLACE PROCEDURE Interest
 AS
    myInterest NUMERIC;
    Price NUMERIC;
    CURSOR InterestCursor IS SELECT saleprice FROM Orders;
 BEGIN
   myInterest := 0.0;
   OPEN InterestCursor;
   LOOP
       FETCH InterestCursor INTO Price;
       EXIT WHEN InterestCursor%NOTFOUND;
       IF Price >= 30000 THEN
           myInterest := myInterest + Price * 0.1;
       ELSE
           myInterest := myInterest + Price * 0.05;
       END IF;
    END LOOP;
    CLOSE InterestCursor;
    DBMS_OUTPUT.PUT_LINE(' 전체 이익 금액 = ' || myInterest);
 END;
 
 
 