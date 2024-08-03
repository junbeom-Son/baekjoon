select YEAR, round(avg(PM_VAL1), 2) as PM10, round(avg(PM_VAL2), 2) as "PM2.5"
from (
    select year(YM) as YEAR, PM_VAL1, PM_VAL2
    from AIR_POLLUTION
    where LOCATION2 = '수원') sw
group by YEAR
order by YEAR;