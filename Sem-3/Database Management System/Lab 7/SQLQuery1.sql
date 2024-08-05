-------CREATE TABLE--------
CREATE TABLE EMP
(
	EID INT,
	ENAME VARCHAR(50),
	DEPARTMENT VARCHAR(50),
	SALARY DECIMAL(8,2),
	JOININGDATE DATETIME,
	CITY VARCHAR(50)
);

--------- Insert data into the EMP table----------
INSERT INTO EMP (EID, ENAME, DEPARTMENT, SALARY, JOININGDATE, CITY)
VALUES
(101, 'RAHUL', 'ADMIN', 56000 , '01-JAN-1990', 'RAJKOT'),
(102, 'HARDIK', 'IT', 18000 , '25-SEP-1990', 'AHEMDABAD'),
(103, 'BHAVIN', 'HR', 25000 , '14-MAY-1991', 'BARODA'),
(104, 'BHOOMI', 'ADMIN', 39000 , '08-FEB-1991', 'RAJKOT'),
(105, 'ROHIT', 'IT', 17000 , '23-JUL-1990', 'JAMNAGAR'),
(106, 'PRIYA', 'IT', 9000 , '18-OCT-1990', 'AHEMDABAD'),
(107, 'BHOOMI', 'HR', 34000 , '25-DEC-1991', 'RAJKOT')

-------------------------------------PART A----------------------------------
--1. Display the Highest, Lowest, Label the columns Maximum, Minimum respectively. 
SELECT MIN(SALARY) AS MINIMUM_SALARY,MAX(SALARY) AS MAXIMUM_SALARY FROM EMP

--2. Display Total, and Average salary of all employees. Label the columns Total_Sal and Average_Sal, respectively.
SELECT SUM(SALARY) AS TOTAL_SALARY,AVG(SALARY) AS AVERAGE_SALARY FROM EMP

--3. Find total number of employees of EMPLOYEE table. 
SELECT COUNT(EID) NO_OF_EMPLOY FROM EMP

--4. Find highest salary from Rajkot city. 
SELECT MAX(SALARY) AS MAX_FROM_RAJKOT FROM EMP WHERE CITY ='RAJKOT'

--5. Give maximum salary from IT department.
SELECT MAX(SALARY) AS MAX_SALARY FROM EMP WHERE DEPARTMENT = 'IT'

--6. Count employee whose joining date is after 8-feb-91.
SELECT COUNT(EID) AS NO_OF_EMP FROM EMP WHERE JOININGDATE > '08-FEB-1991'

--7. Display average salary of Admin department.
SELECT AVG(SALARY) AS AVG_SALARY FROM EMP WHERE DEPARTMENT='ADMIN'

--8. Display total salary of HR department.
SELECT SUM(SALARY) AS TOTAL_SALARY FROM EMP WHERE DEPARTMENT = 'HR'

--9. Count total number of cities of employee without duplication.
SELECT COUNT(DISTINCT CITY) FROM EMP

--10. Count unique departments. 
SELECT COUNT(DISTINCT DEPARTMENT) FROM EMP

--11. Give minimum salary of employee who belongs to Ahmedabad.
SELECT MIN(SALARY) FROM EMP WHERE CITY = 'AHEMDABAD'

--12. Find city wise highest salary. 
SELECT MAX(SALARY),CITY AS MAX_SALARY FROM EMP GROUP BY CITY

--13. Find department wise lowest salary. 
SELECT MIN(SALARY),DEPARTMENT FROM EMP GROUP BY DEPARTMENT

--14. Display city with the total number of employees belonging to each city. 
SELECT COUNT(EID),CITY FROM EMP GROUP BY CITY

--15. Give total salary of each department of EMP table. 
SELECT SUM(SALARY),DEPARTMENT FROM EMP GROUP BY DEPARTMENT

--16. Give average salary of each department of EMP table without displaying the respective department name. 
SELECT AVG(SALARY) FROM EMP GROUP BY DEPARTMENT

------------------PART B-------------------------
--1. Count the number of employees living in Rajkot. 
SELECT COUNT(EID) FROM EMP WHERE CITY = 'RAJKOT'

--2. Display the difference between the highest and lowest salaries. Label the column DIFFERENCE. 
SELECT MAX(SALARY)-MIN(SALARY) AS DIF_IN_MAX_MIN FROM EMP

--3. Display the total number of employees hired before 1st January, 1991.
SELECT COUNT(EID) AS NO_OF_EMP FROM EMP WHERE JOININGDATE < '01-JAN-1991'

-----------------------PART C----------------------------------
--1. Count the number of employees living in Rajkot or Baroda. 
SELECT COUNT(EID) FROM EMP WHERE CITY = 'RAJKOT' OR CITY = 'BARODA'

--2. Display the total number of employees hired before 1st January, 1991 in IT department. 
SELECT COUNT(EID) AS NO_OF_EMP FROM EMP WHERE JOININGDATE < '01-JAN-1991' AND DEPARTMENT = 'IT'

--3. Find the Joining Date wise Total Salaries. 
SELECT SUM(SALARY) AS SALARY ,JOININGDATE FROM EMP GROUP BY JOININGDATE

--4. Find the Maximum salary department & city wise in which city name starts with ‘R’. 
  SELECT department,city,MAX(salary) AS max_salary FROM emp WHERE city LIKE 'R%' GROUP BY department,city;