select sum(score) as SCORE, EMP_NO, emp_name, position, email
from hr_grade hg join hr_employees using(emp_no)
where year = 2022
group by emp_no
order by score desc
limit 1;