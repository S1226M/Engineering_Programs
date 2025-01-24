-- Creating PersonInfo Table
CREATE TABLE PersonInfo (
 PersonID INT PRIMARY KEY,
 PersonName VARCHAR(100) NOT NULL,
 Salary DECIMAL(8,2) NOT NULL,
 JoiningDate DATETIME NULL,
 City VARCHAR(100) NOT NULL,
 Age INT NULL,
 BirthDate DATETIME NOT NULL
);

-- Creating PersonLog Table
CREATE TABLE PersonLog (
 PLogID INT PRIMARY KEY IDENTITY(1,1),
 PersonID INT NOT NULL,
 PersonName VARCHAR(250) NOT NULL,
 Operation VARCHAR(50) NOT NULL,
 UpdateDate DATETIME NOT NULL,
);


-------------------------------Part – A----------------------------------
--1. Create a trigger that fires on INSERT, UPDATE and DELETE operation on the PersonInfo table to display a message “Record is Affected.”  
Create Trigger TR_I_U_D_PERSONINFO_MESSAGE
On PersonInfo
After Insert , Update , Delete
As
Begin
	Print 'Record is Affected.'
End
Drop Trigger TR_I_U_D_PERSONINFO_MESSAGE

--2. Create a trigger that fires on INSERT, UPDATE and DELETE operation on the PersonInfo table. For that, log all operations performed on the person table into PersonLog.
Create Trigger TR_I_PERSONLOG_MESSAGE
On PersonInfo
After Insert
As
Begin
	Declare
		@PersonID INT,
		@PersonName VARCHAR(100)
	Insert Into PersonLog Values (@PersonID,@PersonName,'Insert Record',GetDate())
	select * from PersonLog
End
Drop Trigger TR_I_PERSONLOG_MESSAGE

Create Trigger TR_U_PERSONLOG_MESSAGE
On PersonInfo
After Update
As
Begin
	Declare
		@PersonID INT,
		@PersonName VARCHAR(100)
	Insert Into PersonLog Values (@PersonID,@PersonName,'Update Record',GetDate())
	select * from PersonLog
End
Drop Trigger TR_U_PERSONLOG_MESSAGE

Create Trigger TR_D_PERSONLOG_MESSAGE
On PersonInfo
After Delete
As
Begin
	Declare
		@PersonID INT,
		@PersonName VARCHAR(100)
	Insert Into PersonLog Values (@PersonID,@PersonName,'Delete Record',GetDate())
	select * from PersonLog
End
Drop Trigger TR_D_PERSONLOG_MESSAGE

--3. Create an INSTEAD OF trigger that fires on INSERT, UPDATE and DELETE operation on the PersonInfo table. For that, log all operations performed on the person table into PersonLog. 
Create Trigger TR_I_PERSONLOG_MESSAGE
On PersonInfo
INSTEAD OF Insert
As
Begin
	Declare
		@PersonID INT,
		@PersonName VARCHAR(100)
	Insert Into PersonLog Values (@PersonID,@PersonName,'Insert Record',GetDate())
	select * from PersonLog
End
Drop Trigger TR_I_PERSONLOG_MESSAGE

Create Trigger TR_U_PERSONLOG_MESSAGE
On PersonInfo
INSTEAD OF Update
As
Begin
	Declare
		@PersonID INT,
		@PersonName VARCHAR(100)
	Insert Into PersonLog Values (@PersonID,@PersonName,'Update Record',GetDate())
	select * from PersonLog
End
Drop Trigger TR_U_PERSONLOG_MESSAGE

Create Trigger TR_D_PERSONLOG_MESSAGE
On PersonInfo
INSTEAD OF Delete
As
Begin
	Declare
		@PersonID INT,
		@PersonName VARCHAR(100)
	Insert Into PersonLog Values (@PersonID,@PersonName,'Delete Record',GetDate())
	select * from PersonLog
End
Drop Trigger TR_D_PERSONLOG_MESSAGE

--4. Create a trigger that fires on INSERT operation on the PersonInfo table to convert person name into uppercase whenever the record is inserted.
Create Trigger TR_I_PERSONLOG_MESSAGE
On PersonInfo
After Insert
As
Begin
	Declare
		@PersonID INT,
		@PersonName VARCHAR(100)
	Insert Into PersonLog Values (@PersonID,@PersonName,'Insert Record',GetDate())
	Update PersonInfo set PersonName = UPPER(@PersonName) Where PersonID = @PersonID 
	select * from PersonLog
End
Drop Trigger TR_I_PERSONLOG_MESSAGE

--5. Create trigger that prevent duplicate entries of person name on PersonInfo table. 
Create Trigger TR_I_PERSONINFO_MESSAGE
On PersonInfo
INSTEAD OF Insert
As
Begin
	Insert InTo PersonInfo
	Select
		PersonID,
		PersonName,
		Salary,
		JoiningDate,
		City,
		Age ,
		BirthDate 
	From inserted
	Where PersonName not in (Select PersonName from PersonInfo)
End
Drop Trigger TR_I_PERSONINFO_MESSAGE

--6. Create trigger that prevent Age below 18 years.
Create Trigger TR_I_PERSONINFO_MESSAGE
On PersonInfo
INSTEAD OF Insert
As
Begin
	Insert InTo PersonInfo
	Select
		PersonID,
		PersonName,
		Salary,
		JoiningDate,
		City,
		Age ,
		BirthDate 
	From inserted
	Where Age > 18
End
Drop Trigger TR_I_PERSONINFO_MESSAGE
