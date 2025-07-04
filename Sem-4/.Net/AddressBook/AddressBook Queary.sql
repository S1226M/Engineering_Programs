------------------------------------- Create Tables ----------------------------
create table [dbo].[AddressBook_User](
		UserID			Int Primary Key Identity(1,1),
		UserName		Varchar(100) Not Null,
		MobileNo		Varchar(50) Not Null,
		EmailID			Varchar(100) Not Null,
		CreationDate	DateTime Default GetDate()
);
create table [dbo].[AddressBook_Country](
		CountryID		Int Primary Key Identity(1,1),
		CountryName		varchar(100) Unique Not Null,
		CountryCode		varchar(50) Not Null,
		CreationDate	DateTime Default GetDate(),
		UserID			Int Not Null,
		Constraint FK_Country_User Foreign Key(UserID) References [AddressBook_User](UserID)
);
create table [dbo].[AddressBook_State](
		StateID			Int Primary Key Identity(1,1),
		CountryID		Int Not Null,
		StateName		Varchar(100) Unique Not Null,
		StateCode		Varchar(50) Not Null,
		CreationDate	DateTime Default GetDate(),
		UserID			Int Not Null,
		Constraint FK_State_User Foreign Key(UserID) References [AddressBook_User](UserID),
		Constraint FK_State_Country Foreign Key(CountryID) References [AddressBook_Country](CountryID)
);
create table [dbo].[AddressBook_City](
		CityID			Int Primary Key Identity(1,1),
		StateID			Int Not Null,
		CountryID		Int Not Null,
		CityName		Varchar(100) Unique Not Null,
		STDCode			Varchar(50),
		PinCode			Varchar(6),
		CreationDate	DateTime Default GetDate(),
		UserID			Int Not Null,
		Constraint FK_City_User Foreign Key(UserID) References [AddressBook_User](UserID),
		Constraint FK_City_State Foreign Key(StateID) References [AddressBook_State](StateID)
);

------------------------------------- <------ Store Procedure ---------> -------------------
------------------------------- User Table --------------------------------------
-------------------------------------- Insert User -------------------------------------------------
-- Exec PR_Insert_User 'ABC','9889899898','ABC16@gmail.com'
Select * from AddressBook_User
CREATE OR ALTER PROCEDURE PR_Insert_User
    @UserName		VARCHAR(100),
    @MobileNo		VARCHAR(50),
    @EmailID		VARCHAR(100)
AS
BEGIN
    INSERT INTO [dbo].[AddressBook_User](
		UserName,
		MobileNo, 
		EmailID
	)
    VALUES (
		@UserName, 
		@MobileNo,
		@EmailID
	);
END;

-------------------------------------- Update User -------------------------------------------------
-- Exec PR_Update_User ,'demo','asdfgh','asdfgh@gmail.com'
CREATE OR ALTER PROCEDURE PR_Update_User
    @UserID			INT,
    @UserName		VARCHAR(100),
    @MobileNo		VARCHAR(50),
    @EmailID		VARCHAR(100)
AS
BEGIN
    UPDATE [dbo].[AddressBook_User]
    SET 
			[dbo].[AddressBook_User].[UserName]		=	@UserName,
			[dbo].[AddressBook_User].[MobileNo]		=	@MobileNo, 
			[dbo].[AddressBook_User].[EmailID]		=	@EmailID
    WHERE [dbo].[AddressBook_User].[UserID]			=	@UserID;
END;

-------------------------------------- Delete User -------------------------------------------------
-- Exec PR_User_Delete 4
Create Or ALTER PROCEDURE PR_User_Delete
    @UserID INT
AS
BEGIN
    DELETE FROM [dbo].[AddressBook_User]
    WHERE [dbo].[AddressBook_User].[UserID] = @UserID;
END;

-------------------------------------- Select All User -------------------------------------------------
-- Exec PR_User_SelectAll
Create Or ALTER PROCEDURE PR_User_SelectAll
AS												  
BEGIN
    SELECT 
		[dbo].[AddressBook_User].[UserID],
		[dbo].[AddressBook_User].[UserName],
		[dbo].[AddressBook_User].[MobileNo],
		[dbo].[AddressBook_User].[EmailID],
		[dbo].[AddressBook_User].[CreationDate]
    FROM [dbo].[AddressBook_User];
END;

-------------------------------------- Select By Id User -------------------------------------------------
-- Exec PR_User_SelectById 1
Create Or ALTER PROCEDURE PR_User_SelectById
    @UserID INT
AS
BEGIN
    SELECT 
		[dbo].[AddressBook_User].[UserID], 
		[dbo].[AddressBook_User].[UserName],
		[dbo].[AddressBook_User].[MobileNo],
		[dbo].[AddressBook_User].[EmailID],
		[dbo].[AddressBook_User].[CreationDate]
    FROM [AddressBook_User]
    WHERE [dbo].[AddressBook_User].[UserID] = @UserID;
END;

------------------------------- Country Table --------------------------------------
-------------------------------------- Insert Country -------------------------------------------------
-- Exec PR_Country_Insert 'India','91',1
Create or alter PROCEDURE PR_Country_Insert
    @CountryName	VARCHAR(100),
    @CountryCode	VARCHAR(50),
    @UserID			INT
AS
BEGIN
    INSERT INTO [dbo].[AddressBook_Country] (
		CountryName,
		CountryCode,
		UserID
	)
    VALUES (
		@CountryName,
		@CountryCode,
		@UserID
	);
END;

-------------------------------------- Update Country -------------------------------------------------
-- Exec PR_Country_Update 2,'PAK','93',2
Create or Alter PROCEDURE PR_Country_Update
    @CountryID		INT,
    @CountryName	VARCHAR(100),
    @CountryCode	VARCHAR(50),
    @UserID			INT
AS
BEGIN
    UPDATE [dbo].[AddressBook_Country]
    SET	
		[dbo].[AddressBook_Country].[CountryName]	=	@CountryName,
		[dbo].[AddressBook_Country].[CountryCode]	=	@CountryCode,
		[dbo].[AddressBook_Country].[UserID]		=	@UserID
    WHERE [dbo].[AddressBook_Country].[CountryID]	=	@CountryID;
END;

-------------------------------------- Delete Country -------------------------------------------------
--Exec PR_Country_Delete 3
Create or Alter PROCEDURE PR_Country_Delete
    @CountryID	INT
AS
BEGIN
    DELETE FROM [dbo].[AddressBook_Country]
    WHERE 
		[dbo].[AddressBook_Country].[CountryID]  =  @CountryID;
END;

-------------------------------------- Select All Country -------------------------------------------------
--exec PR_Country_SelectAll
Create or Alter PROCEDURE PR_Country_SelectAll
AS
BEGIN
    SELECT
		[dbo].[AddressBook_Country].[CountryID],
		[dbo].[AddressBook_Country].[CountryName],
		[dbo].[AddressBook_Country].[CountryCode],
		[dbo].[AddressBook_Country].[CreationDate], 
		[dbo].[AddressBook_User].[UserID]
    FROM [dbo].[AddressBook_Country] join [dbo].[AddressBook_User]
			On [dbo].[AddressBook_Country].[UserID] = [dbo].[AddressBook_User].[UserID]
END;

-------------------------------------- Select By Id Country -------------------------------------------------
-- Exec PR_Country_SelectById 1
Create or Alter PROCEDURE PR_Country_SelectById
    @CountryID INT
AS
BEGIN
    SELECT 
		[dbo].[AddressBook_Country].[CountryID],
		[dbo].[AddressBook_Country].[CountryName],
		[dbo].[AddressBook_Country].[CountryCode],
		[dbo].[AddressBook_Country].[CreationDate],
		[dbo].[AddressBook_User].[UserID]
    FROM [dbo].[AddressBook_Country] join [dbo].[AddressBook_User]
	ON [dbo].[AddressBook_User].[UserID]			=	[dbo].[AddressBook_Country].[UserID]
    WHERE [dbo].[AddressBook_Country].[CountryID]	=	@CountryID;
END;


------------------------------- State Table --------------------------------------
-------------------------------------- Insert State -------------------------------------------------
-- Exec PR_State_Insert 1,'Delhi','7',1
Create or Alter PROCEDURE PR_State_Insert
    @CountryID	INT,
    @StateName	VARCHAR(100),
    @StateCode	VARCHAR(50),
    @UserID		INT
AS
BEGIN
    INSERT INTO [dbo].[AddressBook_State] (
		CountryID,
		StateName, 
		StateCode, 
		UserID
	)
    VALUES (
		@CountryID, 
		@StateName, 
		@StateCode, 
		@UserID
	);
END;

-------------------------------------- Update State -------------------------------------------------
-- Exec PR_State_Update 3,1,'Goa',30,1
Create or Alter PROCEDURE PR_State_Update
    @StateID	INT,
    @CountryID	INT,
    @StateName	VARCHAR(100),
    @StateCode	VARCHAR(50),
    @UserID		INT
AS
BEGIN
    UPDATE [dbo].[AddressBook_State]
    SET
		[dbo].[AddressBook_State].[CountryID]	= @CountryID, 
		[dbo].[AddressBook_State].[StateName]	= @StateName, 
		[dbo].[AddressBook_State].[StateCode]	= @StateCode, 
		[dbo].[AddressBook_State].[UserID]		= @UserID
    WHERE [dbo].[AddressBook_State].[StateID]	= @StateID;
END;

-------------------------------------- Delete State -------------------------------------------------
-- Exec PR_State_Delete 3
CREATE OR ALTER PROCEDURE PR_State_Delete
    @StateID INT
AS
BEGIN
    DELETE FROM [dbo].[AddressBook_State]
    WHERE [dbo].[AddressBook_State].[StateID] = @StateID;
END;

-------------------------------------- Select All State -------------------------------------------------
-- exec PR_State_SelectAll
CREATE OR ALTER PROCEDURE PR_State_SelectAll
AS
BEGIN
    SELECT 
		[dbo].[AddressBook_State].[StateID],
		[dbo].[AddressBook_Country].[CountryID],
		[dbo].[AddressBook_State].[StateName],
		[dbo].[AddressBook_State].[StateCode], 
		[dbo].[AddressBook_State].[CreationDate],
		[dbo].[AddressBook_User].[UserID]
    FROM [dbo].[AddressBook_State] 
	inner join [dbo].[AddressBook_User] On [dbo].[AddressBook_State].[UserID] = [dbo].[AddressBook_User].[UserID]
	inner join [dbo].[AddressBook_Country] On [dbo].[AddressBook_Country].[CountryID] = [dbo].[AddressBook_State].[CountryID]
END;

-------------------------------------- Select By Id State -------------------------------------------------
-- exec  PR_State_SelectById 1
CREATE OR ALTER PROCEDURE PR_State_SelectById
    @StateID INT
AS
BEGIN
    SELECT 
		[dbo].[AddressBook_State].[CountryID],
		[dbo].[AddressBook_State].[CountryID],
		[dbo].[AddressBook_State].[StateName],
		[dbo].[AddressBook_State].[StateCode],
		[dbo].[AddressBook_State].[CreationDate],
		[dbo].[AddressBook_User].[UserID]
    FROM [dbo].[AddressBook_State] join [dbo].[AddressBook_User] On [dbo].[AddressBook_State].[UserID] = [dbo].[AddressBook_User].[UserID]
    WHERE [dbo].[AddressBook_State].[StateID] = @StateID;
END;

------------------------------- City Table --------------------------------------
-------------------------------------- Insert City -------------------------------------------------
--exec PR_City_Insert 1,1,'Rajkot','2152','360311',1
CREATE OR ALTER PROCEDURE PR_City_Insert
    @StateID	INT,
    @CountryID	INT,
    @CityName	VARCHAR(100),
    @STDCode	VARCHAR(50),
    @PinCode	VARCHAR(6),
    @UserID		INT
AS
BEGIN
    INSERT INTO [dbo].[AddressBook_City]
	(
		StateID,
		CountryID,
		CityName,
		STDCode,
		PinCode,
		UserID
	)
    VALUES
	(
		@StateID, 
		@CountryID, 
		@CityName, 
		@STDCode, 
		@PinCode, 
		@UserID
	);
END;

-------------------------------------- Update City -------------------------------------------------
-- Exec PR_City_Update 1,1,1,'Rajkot','000000','010101',2
CREATE OR ALTER PROCEDURE PR_City_Update
    @CityID		INT,
    @StateID	INT,
    @CountryID	INT,
    @CityName	VARCHAR(100),
    @STDCode	VARCHAR(50),
    @PinCode	VARCHAR(6),
    @UserID		INT
AS
BEGIN
    UPDATE [dbo].[AddressBook_City]
    SET 
		[dbo].[AddressBook_City].[StateID]		=	@StateID,
		[dbo].[AddressBook_City].[CountryID]	=	@CountryID, 
		[dbo].[AddressBook_City].[CityName]		=	@CityName, 
        [dbo].[AddressBook_City].[STDCode]		=	@STDCode, 
		[dbo].[AddressBook_City].[PinCode]		=	@PinCode, 
		[dbo].[AddressBook_City].[UserID]		=	@UserID
    WHERE [dbo].[AddressBook_City].[CityID] = @CityID;
END;

-------------------------------------- Delete City -------------------------------------------------
-- Exec PR_City_Delete 2
CREATE OR ALTER PROCEDURE PR_City_Delete
    @CityID INT
AS
BEGIN
    DELETE FROM [dbo].[AddressBook_City]
    WHERE [dbo].[AddressBook_City].[CityID] = @CityID;
END;

-------------------------------------- Select All City -------------------------------------------------
-- Exec PR_City_SelectAll
CREATE OR ALTER PROCEDURE PR_City_SelectAll
AS
BEGIN
    SELECT 
		[dbo].[AddressBook_City].[CityID],
		[dbo].[AddressBook_City].[StateID],
		[dbo].[AddressBook_State].[StateName],
		[dbo].[AddressBook_City].[CountryID],
		[dbo].[AddressBook_Country].[CountryName],
		[dbo].[AddressBook_City].[CityName],
		[dbo].[AddressBook_City].[STDCode],
		[dbo].[AddressBook_City].[PinCode],
		[dbo].[AddressBook_City].[CreationDate],
		[dbo].[AddressBook_User].[UserID]
    FROM [dbo].[AddressBook_City] join [dbo].[AddressBook_User] on [dbo].[AddressBook_City].[UserID] = [dbo].[AddressBook_User].[UserID]
	join [dbo].[AddressBook_State] On [dbo].[AddressBook_State].[StateID] = [dbo].[AddressBook_City].[StateID]
	join [dbo].[AddressBook_Country] On [dbo].[AddressBook_Country].[CountryID] = [dbo].[AddressBook_City].[CountryID]
END;

-------------------------------------- Select By Id City -------------------------------------------------
-- exec PR_City_SelectById 2
CREATE OR ALTER PROCEDURE PR_City_SelectById
    @CityID INT
AS
BEGIN
    SELECT [dbo].[AddressBook_City].[CityID],
	[dbo].[AddressBook_City].[StateID],
	[dbo].[AddressBook_City].[CountryID],
	[dbo].[AddressBook_City].[CityName],
	[dbo].[AddressBook_City].[STDCode],
	[dbo].[AddressBook_City].[PinCode],
	[dbo].[AddressBook_City].[CreationDate],
	[dbo].[AddressBook_User].[UserID]
    FROM [dbo].[AddressBook_City] join [dbo].[AddressBook_User] On [dbo].[AddressBook_City].[UserID] = [dbo].[AddressBook_User].[UserID]
    WHERE [dbo].[AddressBook_City].[CityID] = @CityID;
END;

CREATE OR ALTER PROCEDURE [dbo].[PR_LOC_City_SelectById]
    @CityID INT
AS
BEGIN
    SELECT [dbo].[AddressBook_City].[CityID],
	[dbo].[AddressBook_City].[CityName],
	[dbo].[AddressBook_City].[StateID],
	[dbo].[AddressBook_City].[CountryID]
    FROM [dbo].[AddressBook_City]
    WHERE [dbo].[AddressBook_City].[CityID] = @CityID
END

Exec PR_LOC_City_SelectById 4

---------Dropdown query for AddressBook_Country table---------
-- Exec Dropdown_AddressBook_Country
CREATE OR ALTER PROC Dropdown_AddressBook_Country
AS
BEGIN
	SELECT
		CountryID,
		CountryName
	FROM [dbo].[AddressBook_Country]
	ORDER BY CountryName ASC
END

---------------- Cascade Drop Down Proceduure ---------------------------

CREATE PROCEDURE [dbo].[PR_LOC_Country_SelectComboBox]
AS 
SELECT
    CountryId,
    CountryName
FROM AddressBook_Country
ORDER BY CountryName

CREATE PROCEDURE [dbo].[PR_LOC_State_SelectComboBoxByCountryID]
@CountryID INT
AS 
SELECT
    [dbo].[AddressBook_State].[StateID],
    [dbo].[AddressBook_State].[StateName]
FROM [dbo].[AddressBook_State]
WHERE [dbo].[AddressBook_State].[CountryID] = @CountryID

----------------------------------------- Demo Count For All Three Country,State,City --------------------------------------
Create Table CountOfThree(
	ID int,
	Total_Country int,
	Total_State int,
	Total_City int
)
DELETE FROM CountOfThree;
INSERT INTO CountOfThree (ID, Total_Country, Total_State, Total_City)
VALUES (1,0, 0, 0);
Select * From CountOfThree

Drop PROCEDURE PR_Count_Of_Three
CREATE PROCEDURE PR_Count_Of_Three
AS
BEGIN
    DECLARE @CountryCount INT;
    DECLARE @StateCount INT;
    DECLARE @CityCount INT;

    SELECT @CountryCount = COUNT(CountryId) FROM AddressBook_Country;
    SELECT @StateCount = COUNT(StateId) FROM AddressBook_State;
    SELECT @CityCount = COUNT(CityId) FROM AddressBook_City;

    UPDATE [dbo].[CountOfThree]
    SET 
        Total_Country = @CountryCount, 
        Total_State = @StateCount, 
        Total_City = @CityCount
    WHERE [dbo].[CountOfThree].[ID] = 1;

	Select 
		[dbo].[CountOfThree].[Total_Country],
		[dbo].[CountOfThree].[Total_State],
		[dbo].[CountOfThree].[Total_City]
	From [dbo].[CountOfThree]
END;

Exec PR_Count_Of_Three
Select * From CountOfThree

Create Table TotalCount(
	totalCity int,
	TotalCountry int, 
	TotalState int
)

Create or ALTER   proc [dbo].[PR_LOC_TotalCount]
as
  declare  @TotalCity INT,
   @TotalCountry INT,
   @TotalState INT
begin
select @TotalCity=Count(CityID) from AddressBook_City

select @TotalCountry = Count(CountryID) from AddressBook_City

select @TotalState = Count(StateID)  from AddressBook_City

delete from TotalCount
 
insert into TotalCount(totalCity, TotalCountry, TotalState) 
values (@TotalCity, @TotalCountry, @TotalState)

select * from TotalCount
end
Exec [dbo].[PR_LOC_TotalCount]