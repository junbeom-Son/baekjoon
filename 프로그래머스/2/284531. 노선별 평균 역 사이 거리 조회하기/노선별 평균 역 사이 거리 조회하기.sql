-- 코드를 작성해주세요
select route, concat(round(sum(D_BETWEEN_DIST), 1), 'km') as TOTAL_DISTANCE, concat(round(avg(D_BETWEEN_DIST), 2), 'km') as AVERAGE_DISTANCE
from subway_distance
group by route
order by sum(D_BETWEEN_DIST) desc;