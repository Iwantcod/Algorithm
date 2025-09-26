select distinct CAR_ID,
case
when car_id in (
select distinct CAR_ID from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where '2022-10-16' between start_date and end_date)
then '대여중'
else '대여 가능'
end as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
order by car_id desc;