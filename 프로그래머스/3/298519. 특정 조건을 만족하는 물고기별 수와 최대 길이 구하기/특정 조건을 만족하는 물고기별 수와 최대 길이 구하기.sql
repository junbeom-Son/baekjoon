select count(*) as fish_count, max(length) as max_length, fish_type
from (
    select fish_type, case when length is null then 10 else length end length
    from fish_info
) new_fish_info
group by fish_type
having avg(length) >= 33
order by fish_type;