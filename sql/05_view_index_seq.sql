#################################
P231 view(권한체크!)
#################################


select ename,sal,d.deptno,dname,loc
from emp e,dept d
where e.deptno = d.deptno;

--view 만들기 전 ERROR :권한부여
conn system/1234;
grant dba to SCOTT;
conn SCOTT/TIGER;

--view가 없으면 새로 만들고 있으면 교체
create or replace view emp_dept
as
select ename,sal,d.deptno,dname,loc
from emp e,dept d
where e.deptno = d.deptno;
--view 삭제
drop view emp_dept;

--새로 view 생성
create or replace view emp_dept
as
select ename,sal,hiredate,d.deptno,dname,loc
from emp e,dept d
where e.deptno = d.deptno;
--view 확인
select * from emp_dept;
select * from tab;
select user from dual;

자기가 속한 부서의 평균 급여보다 많이 받는 사람들의 명단을 view로 만드세요.(highsalavg)
create or replace view highsalavg
as
select ename,sal,deptno from emp outer
where sal >(select avg(sal) from emp where deptno= outer.deptno);

select * from highsalavg;

select * from emp;
--emp 전체 평균
select avg(sal) from emp;
--10번 부서 평균
select avg(sal) from emp where deptno=10;
select * from emp
--10번 부서 평균급여보다 더 많이 급여를 받는 사람(outer 외부조인)
create or replace view vvvv
as
select * from emp outer
where sal > (select avg(sal) from emp where deptno=outer.deptno);



##################################################################
sequence
##################################################################

delete from dept2;
select * from dept2;
select * from emp2;


insert into dept2 (deptno,dname,loc) values(1,'인사부','비트');

create sequence deptno_seq;
--다음 nextval(제한 없이 계속 만들 수 있다.)
insert into dept2 (deptno,dname,loc) values(deptno_seq.nextval,'인사부','비트');
select * from dept2;

--현재 currentval: currval
select deptno_seq.currval from dual;
--sequence 삭제
drop sequence deptno_seq;

--재생성 sequence 10부터 10씩 증가
create sequence deptno_seq start with 10 increment by 10;
insert into dept2 (deptno,dname,loc) values(deptno_seq.nextval,'인사부','비트');
select * from dept2;
--sequence 삭제
delete from dept2;
commit;
--일련의 번호 관리
insert into dept2 (deptno,dname,loc)
values((select nvl(MAX(deptno),0)+10 from dept2) ,'인사부','비트');

##################################################################
index 목차표
##################################################################

select * from emp;
select * from dept;

select * from emp where empno=7698;					//index 기반
select * from emp where ename='FORD';				//full scan

set autotrace on;
select * from emp where ename='FORD';
select * from emp where empno=7698;

--index 생성
create index emp_ename_idx on emp(ename);
select * from emp where ename='FORD';
--index 삭제
drop index emp_ename_idx; 

set autotrace off;

select * from emp where empno=7698;

select index_name, table_name from user_indexes;

##################################################################
backup
##################################################################
--기본 준비
sqlplus "/as sysdba"

create or replace directory mdbackup as 'c:\madang\mdbackup';

grant read,write on directory mdbackup to madang;

--EXPDP
C:\madang EXPDP madang/madang DIRECTORY=mdbackup DUMPFILE=madang_20140701.dmp

--IMPDP
sqlplus madang/madang
drop table orders;
select * from orders;
exit

--복원
C:\madang IMPDP madang/madang DIRECTORY=mdbackup DUMPFILE=madang_20140701.dmp TABLES=orders
--확인
sqlplus madang/madang
select * from orders;




































