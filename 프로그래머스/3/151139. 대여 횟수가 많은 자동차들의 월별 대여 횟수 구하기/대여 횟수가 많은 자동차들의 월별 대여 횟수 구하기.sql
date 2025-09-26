select month(start_date) MONTH, CAR_ID, count(*) RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date >= '2022-08-01' and start_date <= '2022-10-31'
and car_id in (select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date >= '2022-08-01' and start_date <= '2022-10-31'
group by car_id having count(*) >= 5)
group by month(start_date), car_id
having count(*) > 0
order by MONTH, CAR_ID desc;