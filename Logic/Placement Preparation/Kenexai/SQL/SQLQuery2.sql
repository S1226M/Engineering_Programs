-- 1. From the following table write a query in SQL to retrieve all rows and 
-- columns from the employee table in the Adventureworks database. 
-- Sort the result set in ascending order on jobtitle.
select * from HumanResources.Employee order by JobTitle asc

-- 2. From the following table write a query in SQL to retrieve all rows and 
-- columns from the employee table using table aliasing in the Adventureworks 
-- database. Sort the output in ascending order on lastname.
select * from Person.Person order by LastName asc

-- 3. From the following table write a query in SQL to return all rows and 
-- a subset of the columns (FirstName, LastName, businessentityid) from the 
-- person table in the AdventureWorks database. The third column heading is 
-- renamed to Employee_id. Arranged the output in ascending order by lastname
select FirstName , LastName , BusinessEntityID as Employee_id from Person.Person order by LastName asc

-- 4. From the following table write a query in SQL to return only the rows 
-- for product that have a sellstartdate that is not NULL and a productline of 
-- 'T'. Return productid, productnumber, and name. Arranged the output in ascending order on name.
select ProductID , ProductNumber , Name from Production.Product where SellStartDate is not null and ProductLine = 'T'

-- 5. From the following table write a query in SQL to return all rows from the 
-- salesorderheader table in Adventureworks database and calculate the percentage of 
-- tax on the subtotal have decided. Return salesorderid, customerid, orderdate, subtotal, 
-- percentage of tax column. Arranged the result set in ascending order on subtotal.
select SalesOrderID , CustomerID , OrderDate ,SubTotal , (TaxAmt*100)/SubTotal as percentage_of_tax from sales.salesorderheader order by SubTotal asc

-- 6. From the following table write a query in SQL to create a list of unique jobtitles in 
--the employee table in Adventureworks database. Return jobtitle column and arranged the resultset in ascending order.
select DISTINCT JobTitle from HumanResources.Employee order by JobTitle asc

-- 7. From the following table write a query in SQL to calculate the total freight paid by each customer. 
-- Return customerid and total freight. Sort the output in ascending order on customerid.
select CustomerID , sum(freight) as total_freight from sales.salesorderheader group by CustomerID order by CustomerID asc

-- 8. From the following table write a query in SQL to find the average and the sum of the subtotal for every 
-- customer. Return customerid, average and sum of the subtotal. Grouped the result on customerid and salespersonid. 
-- Sort the result on customerid column in descending order.
SELECT 
	customerid, 
	salespersonid, 
	AVG(subtotal) AS avg_subtotal,
	SUM(subtotal) AS sum_subtotal 
FROM sales.salesorderheader 
GROUP BY customerid, salespersonid
ORDER BY customerid DESC;
