------------------------------- CREAT TABLE = 1 ------------------
CREATE TABLE STUDENT_DATA
(
	NO INT,
	NAME VARCHAR(20),
	CITY VARCHAR(20),
	DID INT
)

DROP TABLE STUDENT_DATA

--------------------- INSERT DATA IN TABLE = 1 ------------
INSERT INTO STUDENT_DATA
VALUES
(101,'RAJU','RAJKOT',10),
(102,'AMIT','AHMEDABAD',20),
(103,'SANJAY','BARODA',40),
(104,'NEHA','RAJKOT',20),
(105,'MEERA','AHMEDABAD',30),
(106,'MAHESH','BARODA',10)

------------------------------- CREAT TABLE = 2 ------------------
CREATE TABLE ACADEMIC
(
	RNO INT,
	SPI DECIMAL(2,1),
	BKLOG INT
)

--------------------- INSERT DATA IN TABLE = 2 ------------
INSERT INTO ACADEMIC
VALUES
	(101,8.8,0),
	(102,9.2,2),
	(103,7.6,1),
	(104,8.2,4),
	(105,7,2),
	(106,8.9,3)

------------------------------- CREAT TABLE = 3 ------------------
CREATE TABLE  DEPARTMENT
(
	DID INT,
	DNAME VARCHAR(10)
)

--------------------- INSERT DATA IN TABLE = 3 ------------
INSERT INTO DEPARTMENT
VALUES
	(10,'COMPUTER'),
	(20,'ELECTRICAL'),
	(30,'MECHANICAL'),
	(40,'CIVIL')