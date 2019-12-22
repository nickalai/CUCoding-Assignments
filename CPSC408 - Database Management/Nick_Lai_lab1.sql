-- 1.) How many records are in the cars data? 394
SELECT COUNT (*) FROM cars;
-- 2.) How many cars originated in the US? 246
SELECT COUNT (*) FROM cars WHERE Origin = 'US';
-- 3.) How many cars were built in years 70-75? 180
SELECT COUNT (*) FROM cars WHERE Year BETWEEN 70 AND 75;
-- 4.) How many cars get more than 30 MPG? 84
SELECT COUNT (*) FROM cars WHERE MPG > 30;
-- 5.) Are there any cars with more horsepower than displacement? If so, what models?"mazda rx2 coupe"
-- 6 Models, "maxda rx3", "mazda rx-4", "mazda rx-7 gs", "renault 18i", "amc concord dl"
SELECT Model FROM cars WHERE Horsepower > Displacement;
-- 6.) How many car models have an MPG lower than 11? 3
SELECT COUNT (*) FROM cars WHERE MPG < 11;
-- 7.)Where were the cars from #6 built? (Hint: use a subquery) All from the US
SELECT DISTINCT Origin FROM cars WHERE MPG < 11;
-- 8.) Which car manufacturer origin has the lowest average Horsepower? Europe, 79.39 avg Horsepower
SELECT Origin FROM (SELECT Origin, MIN(avg_hp) FROM (SELECT Origin, avg(Horsepower) AS avg_hp FROM cars GROUP BY Origin));
-- 9.) How many cars made in the US have MPG under 20? 142
SELECT COUNT (*) FROM cars WHERE Origin = 'US' AND MPG < 20;
-- 10.) How much horsepower does a ford fiesta have? 66
SELECT Horsepower FROM cars WHERE Model = 'ford fiesta';
-- 11.) Which number of cylinders has the highest average HP? 8
SELECT Cylinders FROM (SELECT Cylinders, MAX(avg_hp) FROM (SELECT Cylinders, avg(Horsepower) AS avg_hp FROM cars GROUP BY Cylinders));
-- 12.) What countries have 4-cylinder cars? Japan, Europe, US
SELECT DISTINCT Origin FROM cars WHERE Cylinders = 4;
-- 13.) How many cars that weigh under 2000 get an MPG lower than 30? 11
SELECT COUNT (*) FROM cars WHERE Weight < 2000 AND Cylinders = 4;
-- 14.) How many cylinders do the cars that get over 40 MPG have? 4
SELECT DISTINCT Cylinders FROM cars WHERE MPG > 40;
-- 15.) What countries did the cars in #13 originate in? Europe, Japan, US
SELECT DISTINCT Origin FROM cars WHERE Weight < 2000 AND Cylinders = 4;
-- 16.) What is the percentage (out of all the data) of cars that originate in the US? 62.44%
SELECT 100.0 * COUNT (*) / (SELECT COUNT (*) FROM cars) AS percent_us FROM cars WHERE Origin = 'US';
-- 17.) What is the percentage (out of all the data) of cars have 8 cylinders? 26.14%
SELECT 100.0 * COUNT (*) / (SELECT COUNT (*) FROM cars) AS percent_us FROM cars WHERE Cylinders = 8;
-- 18.) Write a query to return the average displacement per origin+cylinder combo. What is the result?
SELECT Origin, Cylinders, avg(Displacement) FROM cars GROUP BY Cylinders, Origin;
-- 19.) Write a query to only return the cylinders and average displacement, where the origin is Japan, from the query in #18. (Hint: use a subquery)
SELECT Origin, Cylinders, avg(Displacement) FROM cars WHERE Origin='Japan' GROUP BY Cylinders, Origin;
-- 20.) Find the model of the car that has the max HP in the US. (Hint: use a subquery) Pontiac Grand Prix
SELECT Model,MAX(Horsepower) FROM cars WHERE Origin = 'US' AND NOT Horsepower = 'NA'GROUP BY Origin;
