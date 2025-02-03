CREATE TABLE EMPLOYEEDETAILS
(
	EmployeeID		Int Primary Key,
	EmployeeName	Varchar(100) Not Null,
	ContactNo		Varchar(100) Not Null,
	Department		Varchar(100) Not Null,
	Salary			Decimal(10,2) Not Null,
	JoiningDate		DateTime Null
)

CREATE TABLE EmployeeLogs (
    LogID INT PRIMARY KEY IDENTITY(1,1),
    EmployeeID INT NOT NULL,
    EmployeeName VARCHAR(100) NOT NULL,
    ActionPerformed VARCHAR(100) NOT NULL,
    ActionDate DATETIME NOT NULL
);

------------------------ Queary ----------------------------
Create Trigger TR_Employee_Insert
On EMPLOYEEDETAILS
After Insert
As
Begin
	Print 'One Row Affected'
	Insert Into EmployeeLogs(EmployeeID, EmployeeName, ActionPerformed, ActionDate)
	Select EmployeeID, EmployeeName, 'INSERT', GETDATE()
	From inserted
End
Insert Into EMPLOYEEDETAILS values (1,'anc','123231','cse',10.256,GETDATE())
Insert Into EMPLOYEEDETAILS values (2,'smit','878003119','ec',256,GETDATE())
Select * from EMPLOYEEDETAILS
Select * from EmployeeLogs
Drop Trigger TR_Employee_Insert

Create Trigger TR_Employee_Update
On EMPLOYEEDETAILS
After Update
As
Begin
	Print 'One Row Update'
	Insert Into EmployeeLogs(EmployeeID, EmployeeName, ActionPerformed, ActionDate)
	Select EmployeeID, EmployeeName, 'Update', GETDATE()
	From inserted
End
Update EMPLOYEEDETAILS 
        Set EmployeeName = 'asdfasdf',
		   ContactNo	= '213132',
		   Department	= 'dsfds',
		   Salary		= 10.255,
		   JoiningDate	= GETDATE()
Where EmployeeID = 1
Select * from EMPLOYEEDETAILS
Select * from EmployeeLogs
Drop Trigger TR_Employee_Update

Create or Alter Trigger TR_Employee_Delete
On EMPLOYEEDETAILS
After Delete
As
Begin
	Print 'One Row Delete'
	Insert Into EmployeeLogs(EmployeeID, EmployeeName, ActionPerformed, ActionDate)
	Select EmployeeID, EmployeeName, 'Delete', GETDATE()
	From deleted
End
Delete From EMPLOYEEDETAILS Where EmployeeID = 4
Select * from EMPLOYEEDETAILS
Select * from EmployeeLogs
Drop Trigger TR_Employee_Delete
------------------------------------------------------
CREATE TRIGGER trg_AfterInsert_JoiningBonus
ON EmployeeDetails
AFTER INSERT
AS
BEGIN
    UPDATE EmployeeDetails
    SET Salary = i.Salary + (i.Salary * 0.10)
    FROM EmployeeDetails e
    INNER JOIN inserted i ON e.EmployeeID = i.EmployeeID;
END;
Insert Into EMPLOYEEDETAILS values (3,'asdfasrfd','362512356','wef',1256,GETDATE())
Insert Into EMPLOYEEDETAILS values (4,'abcddefg','354654','ewfds',25600,GETDATE())
Select * from EMPLOYEEDETAILS
Select * from EmployeeLogs
Drop Trigger trg_AfterInsert_JoiningBonus

-- Trigger to set JoiningDate if NULL
CREATE TRIGGER trg_SetDefaultJoiningDate
ON EmployeeDetails
AFTER INSERT
AS
BEGIN
    UPDATE EmployeeDetails
    SET JoiningDate = GETDATE()
    WHERE JoiningDate IS NULL;
END;
Insert Into EMPLOYEEDETAILS values (5,',mnm','689','wer',654,GETDATE())
Select * from EMPLOYEEDETAILS
Select * from EmployeeLogs
Drop Trigger trg_SetDefaultJoiningDate

-- Trigger to validate ContactNo length
CREATE OR ALTER TRIGGER trg_ValidateContactNo
ON EmployeeDetails
AFTER INSERT, UPDATE
AS
BEGIN
    DELETE FROM EmployeeDetails
    WHERE EmployeeID IN (
        SELECT EmployeeID FROM inserted WHERE LEN(ContactNo) <> 10
    );
    IF @@ROWCOUNT > 0
    BEGIN
        PRINT 'Number Must Be 10 Digits';
    END
END;

Insert Into EMPLOYEEDETAILS values (7,',mnm','689','wer',654,GETDATE())
Select * from EMPLOYEEDETAILS
Select * from EmployeeLogs
drop Trigger trg_ValidateContactNo
