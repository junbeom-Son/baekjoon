-- 코드를 입력하세요
select flavor
from (
    select flavor, total_order
    from first_half
    union
    select flavor, total_order
    from july) total
group by flavor
order by sum(total_order) desc
limit 3;