with MAX_SIZE as (
    select year(DIFFERENTIATION_DATE) as year,
    max(size_of_colony) as max_size
    from ecoli_data
    group by 1)

select MAX_SIZE.year, (max_size - size_of_colony) as YEAR_DEV, ID
from ecoli_data
left join MAX_SIZE on year(ecoli_data.DIFFERENTIATION_DATE) = MAX_SIZE.year
order by 1, 2;