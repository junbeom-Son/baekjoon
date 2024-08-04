# with cc as (
#     select parent_id, ifnull(count(*), 0) as child_count
#     from ecoli_data
#     group by parent_id
# )

select l.id, count(r.parent_id) as child_count
from ecoli_data l left join ecoli_data r on l.id = r.parent_id
group by l.id;