select distinct c1.cart_id from (select cart_id from cart_products where name = 'Milk') c1
join (select cart_id from cart_products where name = 'Yogurt') c2
on c2.cart_id = c1.cart_id;