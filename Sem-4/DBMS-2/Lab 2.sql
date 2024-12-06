-- Create Department Table 
CREATE TABLE Department ( 
DepartmentID INT PRIMARY KEY, 
DepartmentName VARCHAR(100) NOT NULL UNIQUE 
); 

-- Create Designation Table 
CREATE TABLE Designation ( 
DesignationID INT PRIMARY KEY, 
DesignationName VARCHAR(100) NOT NULL UNIQUE 
);

-- Create Person Table 
CREATE TABLE Person ( 
PersonID INT PRIMARY KEY IDENTITY(101,1), 
FirstName VARCHAR(100) NOT NULL, 
LastName VARCHAR(100) NOT NULL, 
Salary DECIMAL(8, 2) NOT NULL, 
JoiningDate DATETIME NOT NULL, 
DepartmentID INT NULL, 
DesignationID INT NULL, 
FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID), 
FOREIGN KEY (DesignationID) REFERENCES Designation(DesignationID) 
); 

-----------------------------------Part A----------------------------------------
--------------Inssert in the department table------------
Create or alter procedure PR_DEPARTMENT_INSERT
@DId int , @DName varchar(50)
As
Begin
	Insert into Department values (@DId,@DName)
End

Exec PR_DEPARTMENT_INSERT 1,'Admin'
Exec PR_DEPARTMENT_INSERT 2,'IT'
Exec PR_DEPARTMENT_INSERT 3,'HR'
Exec PR_DEPARTMENT_INSERT 4,'Account'

------------------Insert in designation---------
Create or alter procedure PR_DESIGNATION_INSERT
@DeId int , @DeName varchar(50)
As
Begin
	Insert into Designation values (@DeId,@DeName)
End

Exec PR_DESIGNATION_INSERT 11,'Jobber'
Exec PR_DESIGNATION_INSERT 12,'Welder'
Exec PR_DESIGNATION_INSERT 13,'Clerk'
Exec PR_DESIGNATION_INSERT 14,'Manager'
Exec PR_DESIGNATION_INSERT 15,'CEO'

------------------------Inser in person------------
Create or alter procedure PR_PERSON_INSERT
@FName varchar(50) , @LName varchar(50) , @Salary decimal(7,2) , @JDate datetime , @DId  int , @DName varchar(50)
As
Begin
	Insert into Person values (@FName,@LName,@Salary,@JDate,@DId,@DName)
End

Exec PR_PERSON_INSERT 'Rahul','Anshu',56000,'1990-01-01',1,12
Exec PR_PERSON_INSERT 'Hardik','Hinsu',18000,'1990-09-25',2,11
Exec PR_PERSON_INSERT 'Bhavin','Kamani',25000,'1991-05-14',Null,11
Exec PR_PERSON_INSERT 'Bhoomi','Patel',39000,'2014-02-20',1,13
Exec PR_PERSON_INSERT 'Rohit','Rajgor',17000,'1990-07-23',2,15
Exec PR_PERSON_INSERT 'Priya','Mehta',25000,'1990-10-18',2,Null
Exec PR_PERSON_INSERT 'Neha','Trivedi',18000,'2014-02-20',3,15

--------------Update tables-----------------
Create or alter Procedure PR_PERSON_UPDATE
@PId int,@FName varchar(50)
As
Begin
	Update Person Set FirstName = @FName
	Where PersonID = @PId
End

Exec PR_PERSON_UPDATE 107 , 'Neha'

---------------Update Department------
Create or alter Procedure PR_DEPARTMENT_UPDATE
@DId int , @DName varchar(50)
As
Begin
	Update Department set DepartmentName = @DName
	Where DepartmentID = @DId
End

Exec PR_DEPARTMENT_UPDATE 1 , 'Admin'

----------------------Update Designation-----------
Create or alter Procedure PR_DESIGNATION_UPDATE
@DeId int , @DeName varchar(50)
As
Begin
	Update Designation set DesignationName= @DeName
	Where DesignationID = @DeId
End

Exec PR_DEsignation_UPDATE 11 , 'Jobber'

------------------Delete Person------------
Create or alter Procedure PR_PERSON_DELETE
@PId int
As
Begin
	Delete from Person
	Where PersonID = @PId
End

Exec PR_PERSON_DELETE 107

----------------------Delete Department-----------
Create or alter Procedure PR_DEPARTMENT_DELETE
@DId int
As
Begin
	Delete from Department
	Where DepartmentID = @DId
End


Exec PR_DEPARTMENT_DELETE 1

-------------------Delete designation---------
Create or alter Procedure PR_DESIGNATION_DELETE
@DeId int
As
Begin
	Delete from Designation
	Where DesignationID = @DeId
End


Exec PR_DESIGNATION_DELETE 11

------------------------Select From Person------------
Create or alter Procedure PR_PERRSON_SELECT
@PId int 
As
Begin
	Select * From Person Where PersonID = @PId 
End

Exec PR_PERRSON_SELECT 101

-----------------Select From Department--------------
Create or alter Procedure PR_DEPARTMENT_SELECT
@DId int 
As
Begin
	Select * From Department Where DepartmentID = @DId 
End

Exec PR_DEPARTMENT_SELECT 1

-----------------Select From Designation--------------
Create or alter Procedure PR_DESIGNATION_SELECT
@DeId int 
As
Begin
	Select * From Designation Where DesignationID = @DeId 
End

Exec PR_DESIGNATION_SELECT 11

----------------------------select all by primary key------
Create or alter Procedure PR_SELECT_ALL
@PId int
As
Begin
	Select * from Person join Department on Person.DepartmentID = Department.DepartmentID
	join Designation on Person.DesignationID = Designation.DesignationID
	Where PersonID = @PId
End

Exec PR_SELECT_ALL 101

--------------------select top 3---------------
Create or alter Procedure PR_SELECT_3
As
Begin
	Select Top 3 * from Person join Department on Person.DepartmentID = Department.DepartmentID
	join Designation on Person.DesignationID = Designation.DesignationID
End

Exec PR_SELECT_3

-----------------------------------Part B---------------------------------------- 
--5. Create a Procedure that takes the department name as input and returns a table with all workers 
--working in that department. 
Create or alter procedure PR_SELECT_BY_DEPARTMENT
@DName varchar(50)
AS
Begin
	Select * from person join Department
	on Person.DepartmentID = Department.DepartmentID
	Where Department.DepartmentName = @DName
End

--6. Create Procedure that takes department name & designation name as input and returns a table with 
--worker’s first name, salary, joining date & department name. 
--7. Create a Procedure that takes the first name as an input parameter and display all the details of the 
--worker with their department & designation name. 
--8. Create Procedure which displays department wise maximum, minimum & total salaries. 
--9. Create Procedure which displays designation wise average & total salaries. 