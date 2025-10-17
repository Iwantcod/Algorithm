with available_cars as (select c.car_id, c.car_type, c.daily_fee * 30 fee
from CAR_RENTAL_COMPANY_CAR c
where c.car_type in ('SUV', '세단')
and not exists(select 1
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
    where h.car_id = c.car_id
    and end_date >= '2022-11-01'
    and start_date <= '2022-11-30'))
    
select ac.car_id, ac.car_type, floor(ac.fee * ((100 - p.discount_rate) / 100)) fee
from available_cars ac
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p on ac.car_type = p.car_type
where p.duration_type = '30일 이상' and fee >= 500000 and fee < 2000000
order by fee desc, car_type asc, car_id desc;