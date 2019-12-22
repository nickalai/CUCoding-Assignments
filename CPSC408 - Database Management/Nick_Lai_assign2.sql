-- 1.) Creates a table called Customers with Customer ID (primary key), Customer first name, Customer last name, Customer age
PRAGMA foreign_keys = ON;
CREATE TABLE Customers (
  id_number INT PRIMARY KEY,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  age INT
);

-- 2.) Insert 3 full customer records into the table
INSERT INTO Customers VALUES
  (1, 'Nick', 'Lai', 21),
  (2, 'Moises', 'Lopez', 20),
  (3, 'Brian', 'Do', 22);

-- 3.) New customer, only know their first name and last name
INSERT INTO Customers VALUES (4, 'Jim', 'Terf', NULL); -- New Customer

-- 4.) Updates all customer's names to be upper case
UPDATE Customers SET first_name = UPPER(first_name), last_name = UPPER(last_name);

-- 5.) Create a table called Customer_Address with Customer ID (foreign key), Street Number, Street Name, City, State, and zipcode
CREATE TABLE Customer_Address (
  id_number NOT NULL,
  street_number INT,
  street_name VARCHAR(50),
  city VARCHAR(20),
  state VARCHAR(2),
  zip INT,
  FOREIGN KEY (id_number) REFERENCES Customers(id_number)
  ON UPDATE NO ACTION
  ON DELETE CASCADE
);

-- 6.) Insert an address for each of the customers from 2.)
INSERT INTO Customer_Address VALUES
  (1, 700, 'W La Veta Ave', 'Orange', 'CA', 92868),
  (2, 69, 'W State Dr', 'Trussville', 'AL', 35173),
  (3, 8827, 'Honey Creek Ave', 'Lady Lake', 'FL', 32159);

-- 7.) Update Jim Terf's customer ID to be something different
UPDATE Customers SET id_number = 5 WHERE first_name = 'JIM' AND last_name = 'TERF';

-- 8.) Delete a record from #2
DELETE FROM Customers WHERE id_number = 3;
