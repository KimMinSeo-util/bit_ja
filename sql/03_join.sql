select * from EMP;

select
from
where
order by

select ename,sal from EMP where deptno=10;

select ename,sal from EMP;
--order by 정렬
select ename,sal,deptno from EMP order by deptno;

##################################################
join
##################################################
--<카디젼 프로덕트> n*n으로 곱해서 결과가나온다
select ename,dname
from emp,dept;

--테이블 2개일 경우 1개의 조건 (조건은 테이블-1)
select ename,dname
from emp,dept
where emp.deptno = dept.deptno; --forkey와 prikey에서의 조건

--deptno가 양쪽에 걸쳐져 있어서 헷갈리므로 정확한 명시가 필요함 
select ename,dname,deptno
from emp,dept
where emp.deptno = dept.deptno;

--원하는 곳의 deptno를 명확하게 알려줌
select ename,dname,dept.deptno
from emp,dept
where emp.deptno = dept.deptno;

--추가예시
select ename,dept.deptno,dname,loc
from emp,dept
where emp.deptno = dept.deptno;

--alias시킨것
select ename,dept.deptno as 부서번호,dname,loc
from emp,dept
where emp.deptno = dept.deptno;

--table이름 alias
select ename,d.deptno as 부서번호,dname,loc
from emp e,dept d
where e.deptno = d.deptno;

-- * 전체 테이블 합쳐서 나오게 하도록
select *
from emp e,dept d
where e.deptno = d.deptno;

--급여가 2500이상인 사람 and조건으로 쓰기
select *
from emp e,dept d
where e.deptno = d.deptno and sal>2500;

##########################################
ANCI join 표준           ,=>join  where=>on --ANCI문법형태(table join에서 해당)
##########################################
--orcle join
select ename,d.deptno,dname,loc
from emp e,dept d
where e.deptno = d.deptno;

orcle join ==> ANCI join

select ename,d.deptno,dname,loc
from emp e join dept d
on e.deptno = d.deptno;

--inner join은 양쪽 table에 모두 있는 내용 출력(생략가능)
select ename,d.deptno,dname,loc
from emp e inner join dept d 
on e.deptno = d.deptno;

--급여 2500이상
select ename,d.deptno,dname,loc
from emp e inner join dept d 
on e.deptno = d.deptno
where sal > 2500;

###########################################
outer join
###########################################

select * from emp;
select * from dept;

select ename,sal,dname,loc,e.deptno
from emp e, dept d
where e.deptno=d.deptno;

-- (+) null 쪽에 마킹
--13 rows
select ename,sal,dname,loc,e.deptno
from emp e, dept d
where e.deptno(+)=d.deptno;
--12 rows
select ename,sal,dname,loc,e.deptno
from emp e, dept d
where e.deptno=d.deptno(+);

--left와 right로 마스터(기준)를 정해준다.
--right쪽이 마스터 즉  dept 테이블이 마스터 테이블(dept내용이 모두출력)
select ename,sal,dname,loc,e.deptno
from emp e right outer join dept d
on e.deptno=d.deptno;

--left쪽이 마스터 즉  emp 테이블이 마스터 테이블
select ename,sal,dname,loc,e.deptno
from emp e left outer join dept d
on e.deptno=d.deptno;

#########################################################
non-equi join
#########################################################
select * from salgrade;

--orcle
select ename,sal,grade
from emp e, salgrade s
where sal between losal and hisal;

--ANCI
select ename,sal,grade
from emp e join salgrade s
on sal between losal and hisal;

########################################################
세개의 테이블 join
#########################################################
--테이블 3개에 2개의 조건(3개의 테이블 emp,dept,salgrade)
select ename,sal,dname,loc,grade
from emp,dept,salgrade
where emp.deptno = dept.deptno and sal between losal and hisal
order by emp.deptno; --dept는 양쪽에 있으므로 emp로 명시해주기

--deptno가 20번인 사람들 추출
select ename,sal,dname,loc,grade
from emp,dept,salgrade
where emp.deptno = dept.deptno and sal between losal and hisal and emp.deptno=20
order by emp.deptno;

-- < ANCI join >
select ename,sal,dname,loc,grade
from emp
	join dept
	on emp.deptno = dept.deptno
	join salgrade
	on sal between losal and hisal
order by emp.deptno;

--deptno가 10번인 사람들 추출
select ename,sal,dname,loc,grade
from emp
	join dept
	on emp.deptno = dept.deptno
	join salgrade
	on sal between losal and hisal
where emp.deptno=10
order by emp.deptno;

########################################################
self join
#########################################################
--1개의 테이블을 나눠서 두개로 생각
select e.empno,e.ename 사원명, e.mgr, m.empno,m.ename 상사명
from emp e , emp m
where e.mgr=m.empno;

--누락된 king 되살리기(null 쪽에  +마킹 해주기)
select e.empno,e.ename 사원명, e.mgr, m.empno,m.ename 상사명
from emp e , emp m
where e.mgr=m.empno(+);

--ANCI으로 join변경
select e.empno,e.ename 사원명, e.mgr, m.empno,m.ename 상사명
from emp e join emp m
on e.mgr=m.empno(+);

select e.empno,e.ename 사원명, e.mgr, m.empno,m.ename 상사명
from emp e inner join emp m
on e.mgr=m.empno;

select e.empno,e.ename 사원명, e.mgr, m.empno,m.ename 상사명
from emp e left outer join emp m
on e.mgr=m.empno;

select e.empno,e.ename 사원명,m.ename 상사명
from emp e left outer join emp m
on e.mgr=m.empno;

--king을 CEO로 표기
select e.empno , e.ename 사원명 , nvl(m.ename ,'<CEO>') 상사명
from emp e left outer join emp m
on e.mgr=m.empno;

--상사보다 급여가 많은 사원 목록
select e.ename ,e.sal ,m.ename, m.sal
from emp e join emp m on e.mgr=m.empno
where e.sal>m.sal;
--추가) 사원의 부서와 지역출력
select e.ename ,e.sal,dname,loc,m.ename, m.sal
from emp e
	join emp m
	on e.mgr=m.empno
	join dept
	on e.deptno = dept.deptno
where e.sal>m.sal;

##################################################################
집계함수
##################################################################

select ename,round(sal) from emp;
select avg(sal) from emp;

select round(avg(sal)) 평균급여 from emp;

select
count(empno),count(comm),count(*),count(mgr),round(avg(sal)) 평균급여
from emp;

--회사 job개수
select count(job) from emp;
--회사 job개수(중복제거)
select count(distinct job) from emp;

--
select sum(sal) , count(*), round(avg(sal)),sum(sal)/count(*) from emp;

--emp 평균급여구하기
select round(avg(sal)) 평균급여 from emp;
--10번 부서 평균급여
select round(avg(sal)) 평균급여 from emp where deptno=10;
--20번 부서 평균급여
select round(avg(sal)) 평균급여 from emp where deptno=20;
--30번 부서 평균급여
select round(avg(sal)) 평균급여 from emp where deptno=30;
--40번 부서 평균급여
select round(avg(sal)) 평균급여 from emp where deptno=40;

select * from emp order by deptno;
--group by 월별, 부서별, 연도별(*무조건)
select deptno, round(avg(sal)) 평균급여
from emp
group by deptno;

select
from
where
group by
order by

-- 부서 이름 별 평균급여 구하기
select emp.deptno,dname, round(avg(sal)) 평균급여
from emp,dept
where emp.deptno=dept.deptno
group by dname,emp.deptno
order by 1;

select max(sal),min(sal),count(*),avg(sal) from emp;

select deptno, max(sal),min(sal),count(*),avg(sal)
from emp
group by deptno;

--ANCI 변환
select emp.deptno,dname, round(avg(sal)) 평균급여
from emp
	join dept
	on emp.deptno=dept.deptno
group by dname,emp.deptno
order by 1;

--부서별 평균급여가 2000이상인 부서 리스트
select emp.deptno,dname, round(avg(sal)) 평균급여
from emp
	join dept
	on emp.deptno=dept.deptno
group by dname,emp.deptno
having avg(sal) > 2000 
order by 1;

##################################################
--group by 후에 나올 때는 having절 
select
from
where
group by
having
order by
##################################################

select emp.deptno,dname, round(avg(sal)) 평균급여
from emp
	join dept
	on emp.deptno=dept.deptno
where sal > 1000
group by dname,emp.deptno
having avg(sal) > 2000 
order by 1;

########################################################
SUB Query
########################################################
## FORD 보다 급여를 많이 받는 사원 리스트
--1) FORD급여 구하기
select sal from emp where ename='FORD';
--2) 3000(FORD 급여)보다 많이 받는사람
select * from emp where sal > 3000;

select *
from emp 
where sal > (select sal from emp where ename='FORD');

##평균 급여보다 적게 받는 사원 목록
select *
from emp 
where sal < (select avg(sal) from emp);

##회사 내에서 가장 적게 받는 사람 리스트
select *
from emp 
where sal = (select MIN(sal) from emp);

##회사 내에서 가장 많이 받는 사람 리스트
select *
from emp 
where sal = (select MAX(sal) from emp);

-- '=' 다음에는 스칼라  'in' 다음에는 벡터
##########################################################
스칼라=단일값				벡터=다중값
##########################################################

##각 부서별 급여가 가장 작은 사원 리스트
select deptno,ename,sal
from emp
where sal in (select MIN(sal) from emp group by deptno);

##각 부서별 급여가 가장 많은 사원 리스트
select deptno,ename,sal
from emp
where sal in (select MAX(sal) from emp group by deptno);

select deptno,ename,sal
from emp
where (deptno,sal)
in (select deptno, MAX(sal) from emp group by deptno);

####################################################################
상관관계 서브쿼리		: outer 쿼리의 컬럼 중 하나가 inner 쿼리문에서 사용되는 쿼리문 
####################################################################

##자신이 속한 부서의 평균 급여보다 적은 사원 리스트
select * 
from emp outer
where sal < (select avg(sal) from emp where deptno=outer.deptno);

###############
rownum
###############
select rownum,ename,sal,hiredate
from emp;

select rownum,ename,sal,hiredate
from emp
order by sal desc;

--sort 후 내림차순으로 데이터 정렬
select rownum,ename,sal,hiredate
from (select * from emp order by sal desc);

--TOP3만 추출
select rownum,ename,sal,hiredate
from (select * from emp order by sal desc)
where rownum<4;

--주의(X)
select rownum,ename,sal,hiredate
from (select * from emp order by sal desc)
where rownum>4;

--between and 사용
select rownum,ename,sal,hiredate
from (select * from emp order by sal desc)
where rownum between 1 and 4;

--1부터는 접근가능하지만 중간부터는 불가능
select rownum,ename,sal,hiredate
from (select * from emp order by sal desc)
where rownum between 4 and 7;

############################################################
page 처리
############################################################

select * from (
select rownum row#,ename,sal,hiredate
from (select * from emp order by sal desc)
)
where row# between 11 and 15;

2
				start		end
1page 1~5		5*0+1		+4
2page 6~10		5*1+1		+4
3page 11~15		5*2+1		+4












