--References: Brandon Makin, Alex Hamel

-- 1.) How many receipts did KIP ARNN have?
-- 9
SELECT COUNT(*)
FROM receipts
WHERE customer_id = (SELECT customer_id
                     FROM customers
                     WHERE last_name = "ARNN");

-- 2.) Return the receipt_number, item_id, and price of the receipt that had the highest priced item.
-- 51991,26-8x10,15.95 (receipt_number could be different)
SELECT receipt_id, item_id, price
FROM bakery_goods
JOIN orders ON orders.item_id = bakery_goods.bakery_id
ORDER BY price DESC LIMIT 1;

-- 3.) Find the top 5 busiest dates for the bakery. (HINT: which days had the highest number of items ordered? Use the SUM function with GROUP BY)
-- 12-Oct-2007	92
-- 16-Oct-2007	81
-- 10-Oct-2007	77
-- 30-Oct-2007	76
-- 4-Oct-2007	  54
SELECT date, SUM(amount_ordered)
FROM receipts
JOIN orders
ON receipts.receipt_id = orders.receipt_id
GROUP BY date
ORDER BY SUM(amount_ordered)
DESC LIMIT 5;

-- 4.) What was the total price of the order with receipt number 51991? Return only the summed price. (HINT: use a subquery)
-- $86.30
SELECT SUM(price * amount_ordered)
FROM bakery_goods
JOIN (SELECT item_id, amount_ordered
      FROM orders
      WHERE receipt_id = 51991) AS a
ON bakery_id = item_id;

-- 5.) How many unique foods were ordered on 29-Oct-2007? (HINT: use a subquery and join to the subquery)
-- 7
SELECT COUNT(DISTINCT item_id)
FROM orders
JOIN receipts
ON receipts.receipt_id = orders.receipt_id
WHERE date = "29-Oct-2007";

--6.) What is the name of the customer who had the most orders(receipts)?
-- RUPERT HELING
SELECT *
FROM customers
WHERE customer_id = (SELECT customer_id
                     FROM receipts
                     GROUP BY customer_id
                     ORDER BY COUNT(customer_id)
                     DESC LIMIT 1);
