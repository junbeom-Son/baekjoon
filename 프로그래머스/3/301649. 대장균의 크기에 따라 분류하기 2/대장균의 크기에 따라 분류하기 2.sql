with RANK_DATA as (
    select id, percent_rank() over (order by size_of_colony desc) as pr
    from ecoli_data
)

select id, case when pr <= 0.25 then 'CRITICAL' when pr <= 0.5 then 'HIGH' when pr <= 0.75 then 'MEDIUM' else 'LOW' end COLONY_NAME
from RANK_DATA
order by id;