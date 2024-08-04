with MAX_FISH as (
    select fish_type, max(length) as MAX_LENGTH
    from fish_info
    group by fish_type
)

select id, fish_name, fish_info.length as length
from fish_info join fish_name_info using (fish_type) join MAX_FISH using (fish_type)
where fish_info.length = MAX_FISH.MAX_LENGTH
order by id;