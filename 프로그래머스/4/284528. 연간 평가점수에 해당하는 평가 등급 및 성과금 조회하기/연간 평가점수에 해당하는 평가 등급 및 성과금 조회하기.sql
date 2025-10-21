-- 코드를 작성해주세요

with agg as (
    select emp_no, case
        when(avg(score) >= 96) then 'S'
        when(avg(score) >= 90) then 'A'
        when(avg(score) >= 80) then 'B'
        else 'C' end as grade
    from HR_GRADE
    where year = 2022
    group by emp_no
)
select a.emp_no, e.emp_name, a.grade,
    case
    when(a.grade = 'S') then e.sal * 0.2
    when(a.grade = 'A') then e.sal * 0.15
    when(a.grade = 'B') then e.sal * 0.1
    else 0 end as bonus
from agg a
join HR_EMPLOYEES e on a.emp_no = e.emp_no
order by e.emp_no;