select * from employees;

select * from emp;
select * from dept;
-- 대소문자 구분하지 않는다(ID,PW는 구분함!)
select ename,hiredate from emp;
select ENAME,HIREDATE from emp;
SELECT ENAME,HIREDATE FROM EMP;

desc dept;
select ename,sal,comm from emp;
-- 연산도 가능하다
select ename,sal,sal*12,comm from emp;
-- as로 이름 바꾸기(column name을 alias시킬 때만 "" 사용)
select ename,sal,sal*12 as "년  봉",comm from emp;
-- as생략
select ename,sal,sal*12  "년  봉",comm from emp;
-- dept테이블에서 이름과 위치 추출
select dname,loc from dept;

-- hr/hr 계정
conn hr/hr
select * from employees;
select first_name,job_id,department_id from employees;

-- SCOTT/TIGER 계정
conn SCOTT/TIGER
select empno, ename,sal,comm from emp;

-- null을 포함한 산술식은 null
-- 월급여로  alias
select empno, ename,sal,comm, sal+comm 월급여 from emp;

-- nvl()comm의 값이 null이라면 0으로 변환
select empno, ename,sal,comm, nvl(comm,0) from emp;

-- nvl()comm의 값이 null이라면 0으로 변환, 월급여로 alias =>위에 두 문장을 합친것
select empno, ename,sal,comm,nvl(comm,0),sal+nvl(comm,0) 월급여 from emp;

--년봉 구하기, 괄호를 넣어서 우선순위 지정
select empno, ename,sal,comm,(sal+nvl(comm,0))*12 년봉 from emp;

--mgr출력
select empno, ename,mgr,deptno from emp;
--mgr은 숫자타입인데 데이터타입이 일치하지 않아서 에러
select empno, ename,nvl(mgr,'CEO'),deptno from emp;
-- mgr을 문자형으로 형변환 시켜주는 to_char()
select empno, ename,nvl(to_char(mgr),'CEO') as mgr,deptno from emp;

### 문자열 연결 연산자 ||
select empno, ename,deptno from emp;
select empno||ename||deptno from emp; -- 다 이어서 출력
select empno||'  '||ename||'  '||deptno from emp;
select empno,ename,sal||'원' from emp;

select 10*24*24 from emp; --10개 출력
select 10*24*24 from dept; --4개 출력
--dual 가상의 테이블
select 10*24*24 from dual; --원하는 하나만 출력
--system 날짜출력
select sysdate from dual;

--중복제거(distinct)
--job에서 중복제거
select job from emp;
select distinct job from emp; 
--deptno에서 중복제거
select deptno from emp;
select distinct deptno from emp;

select * from emp;

--row 제한 (where)절 사용
--deptno가 20번인 사람 추출
select * 
from emp
where deptno=20;
--deptno가 30번인 사람 추출
select * 
from emp
where deptno=30;

--job이 MANAGER인 사람 추출
select * 
from emp
where job='MANAGER'; --대소문자 구분하므로 꼭 맞춰서 써주기

--대소문자 구분하지 않고 검색 가능 하도록 합니다.
select *
from emp 
where upper(job)=upper('MANAGER');

--오늘 날짜에 입사한 사람 찾기
select *
from emp
where hiredate = sysdate;

--81/09/28에 입사한 사람 찾기
select *
from emp
where hiredate = '81/09/28';

--81/09/28이후에 입사한 사람 찾기
select *
from emp
where hiredate > '81/09/28';

--81/09/28이전에 입사한 사람 찾기
select *
from emp
where hiredate < '81/09/28';

--81/09/28가 아닌 입사한 사람 찾기
select *
from emp
where hiredate <> '81/09/28';

--81/09/28가 아닌 입사한 사람 찾기
select *
from emp
where hiredate != '81/09/28';

--급여가 3000이상
select *
from emp
where sal> 3000;

--급여가 3000~5000사이
select *
from emp
where sal>= 3000 and sal <= 5000;
--급여가 3000~5000사이
--between연산자에서는 낮은값이 먼저 지정
select *
from emp
where sal between 3000 and 5000;

--급여가 3000~5000사이가 아닌사람
select *
from emp
where sal not between 3000 and 5000;

--10번 부서이거나 20번 부서인 사람(큰값,낮은값 상관없음)
select *
from emp
where deptno =20 or deptno = 10;

--집합연산자 IN

--10번 부서이거나 20번 부서인 사람
select *
from emp
where deptno IN(10,20);
--10번 부서이거나 20번 부서가 아닌 사람
select *
from emp
where deptno NOT IN(10,20);

--deptno가10번 이면서(AND)loc가 DALLAS 이거나(or) deptno가 30이면서(AND)loc가 CHICAGO인 사람
--각 자리 콤마로 AND,OR 구분
select *
from dept
where (deptno,loc) IN((10,'DALLAS'),(30,'CHICAGO'));

## like 연산자(비슷한거 찾기)
-- (=)은 완전히 일치하는 것
select *
from emp
where ename='ALLEN';

-- S% S로 시작하는 사람
select *
from emp
where ename like 'S%';

--이름 중 S가 들어가는 사람
select *
from emp
where ename like '%S%';

-- (_)는 중간에 한글자
select *
from emp
where ename like '%M_T%';

--81년도에 입사한 사원 목록 추출
select *
from emp
where hiredate like '81%';

--이름이 A B C D 로 시작하는 사원의 목록
--가독성이 좋지못함(비추)
select *
from emp
where ename like 'A%'or ename like 'B%'or ename like 'C%'or ename like 'D%';

## 정규식 사용 (regexp의미: Regularexpression)
--이름 중에 ABCD를 포함 하는 사람 추출
select *
from emp
where regexp_like(ename, 'A|B|C|D');
--이름 중에 ABCD를 포함 하는 사람 추출
select *
from emp
where regexp_like(ename, '[A-D]');

--이름 중에 ABCD를 시작 하는 사람 추출 (^)넣기
select *
from emp
where regexp_like(ename, '^[A-D]');

--이름 중에 ABCD로 끝나는 사람 추출 ($)넣기
select *
from emp
where regexp_like(ename, '[A-D]$');

## null(null비교는 is로 쓴다)
--comm이 null 추출
select *
from emp
where comm is null;
--comm이 null이 아닌 것 추출
select *
from emp
where comm is not null;

## row 제한 where 절 사용, 별칭 사용 안됨
select ename, sal, comm, sal+nvl(comm,0) total
from emp
where sal+nvl(comm,0) >3000;

select ename, sal, comm, sal+nvl(comm,0) total
from emp
where deptno=20;

##정렬p order by  기본 오름차순,
 --deptno 순으로 정렬
select ename, sal, comm, sal+nvl(comm,0) total, deptno
from emp 
order by deptno;
--deptno 순으로 내림차순
select ename, sal, comm, sal+nvl(comm,0) total, deptno
from emp 
order by deptno desc;
--total순으로 정렬
select ename, sal, comm, sal+nvl(comm,0) total, deptno
from emp 
order by total;
--2번째 열 순으로 정렬
select ename, sal, comm, sal+nvl(comm,0) total, deptno
from emp 
order by 2;
 --1차기준은 deptno 내림차순으로 , 2번째는 total순으로
select ename, sal, comm, sal+nvl(comm,0) total, deptno
from emp 
order by deptno desc, total;
--dept가 30인 사람 중에서, sal 기준으로 정렬
select *
from emp
where deptno = 30
order by sal;

select *
from emp
where deptno in (20,30)
order by sal;

select *
from emp
where deptno = any (20,30)
order by sal;
--20,30을 제외한 나머지모두
select *
from emp
where deptno != all(20,30)
order by sal;

## 내장함수P204 single row function
select * from dept;
select dname,loc from dept;
select dname,lower(dname),loc,lower(loc) from dept;
--round는 반올림, trunc는 절삭
select round( 45.5678 ),trunc( 45.5678) from dual;
select round( 45.5678,2 ),trunc( 45.5678,2) from dual;
--날짜 1일 증가
select sysdate , sysdate+1 from dual;
--날짜 한달 뒤 
select sysdate , sysdate+30 from dual;
--입사연도
select ename, hiredate from emp;
--SUBSTR 사용해서 입사연도만 추출(sql은 1부터 시작//java는 0부터 시작)
select ename, hiredate,SUBSTR(hiredate,1,2) 입사연도 from emp;
--오늘 날짜에서 연도추출(+형변환)
select sysdate, to_char(sysdate,'YYYY') from dual;
select sysdate, to_char(sysdate,'YY') from dual;
select sysdate, to_char(sysdate,'day') from dual;

## emp 테이블에서 사원들의 입사월 추출
select ename,hiredate, to_char(hiredate,'mm') from emp;
--문자열 날짜
select sysdate, '2019/08/14' from dual;
--문자열로 인식하므로 날짜로 변환
select sysdate, to_date('2019/08/14') from dual;
--월/일/년 으로 출력하지만 에러
select sysdate, to_date('08/14/2019') from dual;
--날짜형식지정
select sysdate, to_date('08/14/19','mm/dd/yy') from dual;

## nvl()함수 --nvl은 매개변수2개
select ename, mgr,comm from emp;
--comm의 null값을 ( _ )로 표시한다
select ename, mgr,nvl(to_char(comm),'_') from emp;
select ename, mgr,nvl(comm,0) from emp;

##nvl2(a,b,c); --nvl2는 매개변수가 3개
select ename, mgr,nvl2(comm,comm,0) from emp;
select ename, nvl2(mgr,'O','X'), nvl(comm,0) from emp;

## decode 함수(if,else if와 같은 의미)
select ename ,sal, deptno,decode(deptno, 10, sal*1,
										 20, sal*2,
										 30, sal*3,
										sal) 계산 from emp;
















