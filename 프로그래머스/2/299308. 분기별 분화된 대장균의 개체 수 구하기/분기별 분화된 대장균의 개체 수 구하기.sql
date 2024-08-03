select case 
    when month(differentiation_date) in (1, 2, 3) then "1Q"
    when month(differentiation_date) in (4, 5, 6) then "2Q"
    when month(differentiation_date) in (7, 8, 9) then "3Q"
    else "4Q" end QUARTER, COUNT(*) AS ECOLI_COUNT
from ecoli_data
GROUP BY QUARTER
ORDER BY QUARTER;