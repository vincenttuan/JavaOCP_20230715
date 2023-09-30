CREATE VIEW `all_sales` AS
SELECT s.id, s.date, s.qty,
	   p.product_id, p.product_name, p.price,
       b.branch_id, b.city, b.branch_name
FROM sales s, product p, branch b
WHERE s.product_id = p.product_id AND s.branch_id = b.branch_id
ORDER BY s.date, s.id;