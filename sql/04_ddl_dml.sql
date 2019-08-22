#######################################################
Table 생성	DDL: 취소가 불가능(Auto commit)
테이블은 실제로 데이터들이 저장되는 곳이라고 생각하면 쉽게 이해 할 수 있으며,
CREATE TABLE 명령어를 이용해서 테이블을 생성 할 수 있다.
#######################################################

drop table book;
create table book(
	bookno   number(5),
	title    varchar2(30),
	author   varchar2(30),
	pubdate  date
);

commit; --확정명령, 취소불가
rollback; --되돌아가기, 마지막 commit전까지 되돌아간다
select * from book;

insert into book values(1,'java','kim',sysdate);
insert into book values(2,'jsp','홍',sysdate);
insert into book values(2,'jsp','홍',sysdate);
insert into book values(2,'jsp','홍','19/02/02');

commit;
rollback;

insert into book (bookno,title) values(3,'db');
insert into book (bookno,title,author,pubdate) values(4,'db',null,null);

insert into book (bookno,title,author,pubdate)
values(4,'db',null,null);

delete from book;
rollback;
delete from book where title='db';
delete from book where author is null;
delete from book where author ='홍';

desc book; --테이블 구조

alter table book add(price number(7)); --테이블 구조변경(가격,7자리로 컬럼추가)

insert into book (bookno,title,author,pubdate,price)
values(4,'db',null,null,900);

update book set price = 10;
commit;
rollback;

update book set price = 1000.99;
commit;

update book set price =900 where title = 'db';
commit;
select * from book;

update book set author='~~~~',price =900,pubdate=sysdate where bookno = 3;

alter table book modify(price number(7,2)); --ERROR메세지: 열에 데이터가 있으므로  데이터 손실이 발생할 수 있음
--price 데이터를 null로 넣고 다시 실행
update book set price=null;
alter table book modify(price number(7,2)); --price를 실수형으로 변경
update book set price=1000.99;
commit;

alter table book drop column price;
rollback;

############################################################################################
###################     TABLE 과 관련된 명령어      ###############################################
drop table book;
create table book(
	bookno   number(5),
	title    varchar2(30),
	author   varchar2(30),
	pubdate  date
);
alter table book add(price number(7));
alter table book modify(price number(7,2));
alter table book drop column price;
rename book to book2;

insert into book (bookno,title,author,pubdate) values(4,'db',null,null);
delete from book where author = '홍';
update book set  author='~~~~~~~~~~~',price=900,pubdate=sysdate where bookno=3;

select * from book;
rename book to book;
delete from book; rollback 가능
rollback;
truncate table book; --table은 남아있다. rollback 불가능(auto commit)
drop table book; --rollback 불가능(auto commit)
############################################################################################
############################################################################################

select * from emp;
select * from dept;

--emp와 dept테이블 copy 한다. 제약조건은 copy 불가능
create table emp2 as select * from emp;
create table dept2 as select * from dept;

insert into dept values(50,'EDU','SEOUL'); 
insert into dept2 values(50,'EDU','SEOUL'); 
commit;
--제약조건 -> 데이터무결성 유지
insert into dept values(10,'EDU','SEOUL'); --실패, 제약조건으로 이미 10번 부서가 있음
insert into dept2 values(10,'EDU','SEOUL'); --성공, copy해서 제약조건이 없으므로 상관없음
rollback;

--emp에 deptno '90'번 부서가 없으므로 ERROR: 데이터 무결성
insert into emp (empno,ename,hiredate,sal,deptno)
            values(9999,'홍길동',sysdate,0,90);
--emp2는 가능
insert into emp2 (empno,ename,hiredate,sal,deptno)
            values(9999,'홍길동',sysdate,0,90);
--emp에 deptno '40'번 부서 있음
insert into emp (empno,ename,hiredate,sal,deptno)
            values(9999,'홍길동',sysdate,0,40);
--emp테이블에 또 넣을 경우 중복되어서 불가능, emp2는 제약조건이 없으므로 중복가능!

            
drop table book;
create table book(
	bookno   number(5)     constraint scott_book_pk primary key,
	title    varchar2(30)  constraint scott_book_title_unique unique, --unique중복불가, 유일함(null허용)
	author   varchar2(30),
	price    number(7,2),  constraint book_price_check check(price>0), --유효성검사와 비슷함
	pubdate  date          default sysdate
);           
            
insert into book (bookno,title,author,price,pubdate)
           values(1,'db','홍길동',900,sysdate);  
           
insert into book (bookno,title,author,price,pubdate)
           values(1,'db','홍길동',900,sysdate);            --primary key옵션에 위배
           
insert into book (bookno,title,author,price,pubdate)
           values(2,'db','홍길동',900,sysdate);                   --unique옵션에 위배 
            
insert into book (bookno,title,author,price,pubdate)
           values(2,'jsp','홍길동',-900,sysdate);   --check옵션에 위배          
            
insert into book (bookno,title,author,price,pubdate)
           values(2,'jsp','홍길동',0,sysdate); --check옵션에 위배 (0보다 커야한다)

insert into book (bookno,title,author,price,pubdate)
           values(2,'jsp','홍길동',22000,sysdate);    
           
insert into book (bookno,title,author,price,pubdate)
           values(3,'java','김길동',32000,default);  --default값으로 자동으로 세팅            
commit;          

--book테이블에 걸린 제약조건 확인
select CONSTRAINT_name
from user_cons_columns
where table_name='BOOK';           
           
drop table book;
create table book(
	bookno   number(5)     primary key,
	title    varchar2(30)  unique, --unique중복불가, 유일함(null허용)
	author   varchar2(30),
	price    number(7,2),  check(price>0), --유효성검사와 비슷함
	pubdate  date          default sysdate
); 
 
drop table book;
create table book(
	bookno   number(5),
	title    varchar2(30)  unique, --unique중복불가, 유일함(null허용)
	author   varchar2(30),
	price    number(7,2),  check(price>0), --유효성검사와 비슷함
	pubdate  date          default sysdate
); 
--제약조건 추가
alter table book add CONSTRAINT book_bookno_pk primary key(bookno); 
--복합키(1개 제약조건에 2개키)
alter table book add CONSTRAINT book_bookno_pk primary key(bookno,author); 
--제약조건 확인
insert into book (bookno,title,author,price,pubdate)
           values(1,'db','홍길동',900,sysdate);  
insert into book (bookno,title,author,price,pubdate)
           values(1,'.....','홍길동',900,sysdate);  
insert into book (bookno,title,author,price,pubdate)
           values(2,'.....','홍길동',900,sysdate);  
commit;
--제약조건 삭제
alter table book drop CONSTRAINT book_bookno_pk; 
insert into book (bookno,title,author,price,pubdate)
           values(1,'java','김길동',32000,default);
select * from book;
--primary 제약 조건 확인
insert into book (bookno,title,author,price,pubdate)
           values(1,'java','김길동',32000,default);
--unique 제약 조건 확인           
insert into book (bookno,title,author,price,pubdate)
           values(1,null,'김길동',32000,default);

insert into book (bookno,title,author,price)
           values(5,null,'최길동',32000);           
commit;

############################################################################################
	emp				dept
############################################################################################
delete from dept where deptno=50;
commit;
select * from dept;
--------------------------------------------------------------------------------------------
drop table dept2; 
create table dept2 as select * from dept;
alter table dept2 add CONSTRAINT dep2_pk primary key(deptno); 


drop table emp2;
create table emp2 as select * from emp;
alter table emp2 add CONSTRAINT emp2_pk primary key(empno); 
alter table emp2 add foreign key(deptno) references dept2; 

select * from dept2;
insert into dept2 values(10,'EDU','SEOUL'); --불가능
insert into dept2 values(50,'EDU','SEOUL'); --가능

select * from emp2;
insert into emp2 (empno,ename,hiredate,sal,deptno)
            values(7839,'홍길동',sysdate,0,40);		--불가능
insert into emp2 (empno,ename,hiredate,sal,deptno)
            values(9999,'홍길동',sysdate,0,50);		--가능
insert into emp2 (empno,ename,hiredate,sal,deptno)
            values(7777,'고길동',sysdate,0,null);		--FK null허용

insert into emp2 (empno,ename,hiredate,sal,deptno,mgr)
            values(8888,'이길동',sysdate,0,null,10);	
--위에 mgr이 제약조건에 처리가 안되어야하므로 다시 제약조건을 만들어서 처리해주기(self join), FK는 무조건 PK참조
alter table emp2 add foreign key(mgr) references emp2; 
--------------------------------------------------------------------------------------------------
--0821
alter table emp2 add CONSTRAINT emp2_pk primary key(empno); 
alter table emp2 add CONSTRAINT emp2_fk_mgr foreign key(mgr) references emp2; 
alter table emp2 add CONSTRAINT emp2_fk1 foreign key(deptno) references dept2; 
delete from dept2 where deptno=20; --불가능


alter table emp2 drop CONSTRAINT emp2_fk1; 

alter table emp2 add CONSTRAINT emp2_fk1 foreign key(deptno) references dept2 ON DELETE SET NULL; --삭제 대신에 emp2테이블의 deptno=20번을 null로 바꿔준다.
delete from dept2 where deptno=20; --가능(deptno=20인 것들이 null로 바뀌어있음)
select * from emp2;

--연결삭제(원래 제약조건을 삭제 후(ROLLBACK으로는 안지워 지므로 drop으로 삭제) 새로 제약조건을 만든 다음에 참조하는 것을 같이 삭제, deptno=20 삭제로 확인 )
alter table emp2 drop CONSTRAINT emp2_fk1;
alter table emp2 add CONSTRAINT emp2_fk1 foreign key(deptno) references dept2 ON DELETE cascade;
delete from dept2 where deptno=20;



--------------------------------------------------------------------------------------------------

--제약조건으로 먼저 지울 수 없다.
drop table dept2;
--제약 순서대로 지우기
drop table emp2 cascade CONSTRAINT;
drop table dept2 cascade CONSTRAINT;


select * from dept;           

select * from emp;                
           

############################################################################################
트랜잭션
############################################################################################
create table emp2 as select * from emp;
select * from emp2;

sqlplus SCOTT/TIGER 창1
delete  from emp2 where deptno=10;

sqlplus SCOTT/TIGER 창2
update emp2 set comm=0 where deptno=10;

sqlplus SCOTT/TIGER 창1
rollback; --창1과 창2가 동시에 명령 불가능 , select는 가능(=읽기만 가능)
block되는 것 확인 => 창1에서 commit or rollback 명령수행하면 lock 풀림























