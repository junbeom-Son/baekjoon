-- 코드를 입력하세요
SELECT a.apnt_no, p.pt_name, p.pt_no, a.mcdp_cd, d.dr_name, a.apnt_ymd
from appointment a, patient p, doctor d
where a.pt_no = p.pt_no and a.mddr_id = d.dr_id and year(a.apnt_ymd) = 2022 and month(a.apnt_ymd) = 4 and day(a.apnt_ymd) = 13 and a.apnt_cncl_yn = 'N' and a.mcdp_cd = 'CS'
order by a.apnt_ymd;

# select * from appointment where year(apnt_ymd) = 2022 and month(apnt_ymd) = 4 and day(apnt_ymd) = 13;