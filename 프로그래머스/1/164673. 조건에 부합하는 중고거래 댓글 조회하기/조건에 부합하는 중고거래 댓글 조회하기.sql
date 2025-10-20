select b.title, r.board_id, r.reply_id, r.writer_id, r.contents, date_format(r.created_date, '%Y-%m-%d') created_date
from USED_GOODS_REPLY r
join USED_GOODS_BOARD b on r.board_id = b.board_id
where b.created_date between '2022-10-01' and '2022-10-31'
order by created_date asc, title asc;