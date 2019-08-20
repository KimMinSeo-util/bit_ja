--1번
select e.employee_id 사번, e.first_name 이름, d.department_name 부서명, m.first_name
from employees e 
	 inner join employees m
	 on e.manager_id = m.employee_id
	 join departments d
	 on e.department_id = d.department_id;

--2번	 
select e.LAST_NAME , e.SALARY
from employees e
	inner join employees m
	on e.manager_id = m.employee_id
	and e.salary > m.salary;

--3번
select e.FIRST_NAME, e.LAST_NAME, e.SALARY
from employees e join jobs j
on e.job_id=j.job_id
where salary between 9000 and 10000
and job_title='Sales Representative';

--7번
select FIRST_NAME, HIRE_DATE, EMPLOYEE_ID, FIRST_NAME
from employees
where to_char(hire_date, 'YY')='08';

--10번
select e.FIRST_NAME, e.HIRE_DATE, e.EMPLOYEE_ID, m.FIRST_NAME
from employees e join employees m
on to_char(e.hire_date, 'YYYY')='2003';



