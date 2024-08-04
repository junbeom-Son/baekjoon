select dept_id, dept_name_en, round(avg(sal)) as AVG_SAL
from hr_employees join hr_department using (dept_id)
group by dept_id, dept_name_en
order by AVG_SAL desc;