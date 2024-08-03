select count(*) as fish_count, month(TIME) as MONTH
from fish_info
group by month(TIME)
order by month;