select YEAR(o.sales_date) YEAR, MONTH(o.sales_date) MONTH, count(distinct o.user_id) PURCHASED_USERS,
    round(count(distinct o.user_id) / (select count(*) from user_info where year(joined) = '2021'), 1) PUCHASED_RATIO
from user_info u
join online_sale o
on o.user_id = u.user_id
where year(u.joined) = '2021'
group by year(o.sales_date), month(o.sales_date)
order by 1, 2;


# select count(*) from user_info where year(joined) = '2021'; # 158