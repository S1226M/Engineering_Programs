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

-- 9. From the following table write a query in SQL to retrieve total quantity of each productid which are 
-- in shelf of 'A' or 'C' or 'H'. Filter the results for sum quantity is more than 500. Return productid 
-- and sum of the quantity. Sort the results according to the productid in ascending order.
select productid , sum(quantity) as total_quentity 
from production.productinventory 
where Shelf in ('A','C','H') 
group by ProductID 
having sum(quantity) > 500

-- 10. From the following table write a query in SQL to find the total quentity for a group of locationid multiplied by 10.
SELECT SUM(quantity) AS total_quantity
FROM production.productinventory
GROUP BY (locationid * 10);

-- 11. From the following tables write a query in SQL to find the persons whose last name starts with 
--letter 'L'. Return BusinessEntityID, FirstName, LastName, and PhoneNumber. Sort the result on lastname and firstname.
select p1.BusinessEntityID , p2.FirstName , p2.LastName , p1.PhoneNumber
from Person.PersonPhone as p1
inner join Person.Person as p2
on	p1.BusinessEntityID = p2.BusinessEntityID
where p2.LastName like 'L%'
order by p2.LastName,p2.FirstName asc

-- 12. From the following table write a query in SQL to find the sum of subtotal column. Group the 
-- sum on distinct salespersonid and customerid. Rolls up the results into subtotal and running total. 
-- Return salespersonid, customerid and sum of subtotal column i.e. sum_subtotal.
SELECT salespersonid, customerid, sum(subtotal) AS sum_subtotal
FROM sales.salesorderheader s 
GROUP BY ROLLUP (salespersonid, customerid);

-- 13. From the following table write a query in SQL to find the sum of the quantity of all combination of group 
-- of distinct locationid and shelf column. Return locationid, shelf and sum of quantity as TotalQuantity.

