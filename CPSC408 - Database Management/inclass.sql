-- Practice questions
-- Given Schema:
-- Person (name, age gender)
-- frequents (name, pizzeria)
-- Eats (name, pizza)
-- Serves (pizzeria, pizza, price)

-- 1.) Find all pizzerias frequented by males under the age of 18
SELECT DISTINCT f.pizzeria
FROM Frequents f
INNER JOIN Person AS p
  ON f.name = p.name
WHERE p.age < 18 AND p.gender = 'Male'
-- OR
SELECT DISTINCT pizzeria
FROM Person p, Frequents f
WHERE p.name = f.name AND gender = 'Male' AND age < 18

-- 2.) Find the names of all females who eat either mushroom or pepperoni
SELECT DISTINCT p.name
FROM Person p
INNER JOIN Eats AS e
  ON p.name = e.name
WHERE e.pizza in ('mushroom', 'pepperoni') AND p.gender = 'Female'
-- OR
SELECT DISTINCT name
FROM Eats e, Person p
WHERE e.name = p.name AND gender = 'Female' AND e.pizza in ('mushroom', 'pepperoni')

-- 3.) Find the average price that Joe pays for all the pizzerias he frequents. Assume he eats every kind of pizza at each pizzerias
SELECT AVG(s.price)
FROM Frequents AS f
INNER JOIN Serves AS s
  ON f.pizzeria = s.pizzeria
GROUP BY f.name
HAVING f.name = 'Joe'


-- You are given 3 table schemas as listed below:
-- Customers: customer_id | first_name | last_name | account_num
-- Customer_address: customer_id | city | state | zip
-- Account_info: account_num | date_created | card_nums
-- Write a query that will return, as a result set, a customer's first_name, last_name, zip, and card_nums

SELECT c.first_name, c.last_name, ca.zip, ai.card_nums
FROM Customers AS c
LEFT JOIN Customer_address AS ca
  ON c.customer_id = ca.customer_id
LEFT JOIN account_info AS ai
  ON c.account_num = ai.account_num
