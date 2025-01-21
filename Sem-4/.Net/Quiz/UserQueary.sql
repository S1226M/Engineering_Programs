-- Creating MST_User table
CREATE TABLE MST_User (
    UserID INT PRIMARY KEY IDENTITY(1,1),
    UserName NVARCHAR(100) NOT NULL,
    Password NVARCHAR(100) NOT NULL,
    Email NVARCHAR(100) NOT NULL,
    Mobile NVARCHAR(100) NOT NULL,
    IsActive BIT NOT NULL DEFAULT 1,
    IsAdmin BIT NOT NULL DEFAULT 0,
    Created DATETIME NOT NULL DEFAULT GETDATE(),
    Modified DATETIME NOT NULL
);

-- Creating MST_Quiz table
CREATE TABLE MST_Quiz (
    QuizID INT PRIMARY KEY IDENTITY(1,1),
    QuizName NVARCHAR(100) NOT NULL,
    TotalQuestions INT NOT NULL,
    QuizDate DATETIME NOT NULL,
    UserID INT NOT NULL,
    Created DATETIME NOT NULL DEFAULT GETDATE(),
    Modified DATETIME NOT NULL,
    FOREIGN KEY (UserID) REFERENCES MST_User(UserID)
);

-- Creating MST_Question table
CREATE TABLE MST_Question (
    QuestionID INT PRIMARY KEY IDENTITY(1,1),
    QuestionText NVARCHAR(MAX) NOT NULL,
    QuestionLevelID INT NOT NULL,
    OptionA NVARCHAR(100) NOT NULL,
    OptionB NVARCHAR(100) NOT NULL,
    OptionC NVARCHAR(100) NOT NULL,
    OptionD NVARCHAR(100) NOT NULL,
    CorrectOption NVARCHAR(100) NOT NULL,
    QuestionMarks INT NOT NULL,
    IsActive BIT NOT NULL DEFAULT 1,
    UserID INT NOT NULL,
    Created DATETIME NOT NULL DEFAULT GETDATE(),
    Modified DATETIME NOT NULL,
    FOREIGN KEY (UserID) REFERENCES MST_User(UserID)
);

-- Creating MST_QuestionLevel table
CREATE TABLE MST_QuestionLevel (
    QuestionLevelID INT PRIMARY KEY IDENTITY(1,1),
    QuestionLevel NVARCHAR(100) NOT NULL,
    UserID INT NOT NULL,
    Created DATETIME NOT NULL DEFAULT GETDATE(),
    Modified DATETIME NOT NULL,
    FOREIGN KEY (UserID) REFERENCES MST_User(UserID)
);

-- Creating MST_QuizWiseQuestions table
CREATE TABLE MST_QuizWiseQuestions (
    QuizWiseQuestionsID INT PRIMARY KEY IDENTITY(1,1),
    QuizID INT NOT NULL,
    QuestionID INT NOT NULL,
    UserID INT NOT NULL,
    Created DATETIME NOT NULL DEFAULT GETDATE(),
    Modified DATETIME NOT NULL,
    FOREIGN KEY (QuizID) REFERENCES MST_Quiz(QuizID),
    FOREIGN KEY (QuestionID) REFERENCES MST_Question(QuestionID),
    FOREIGN KEY (UserID) REFERENCES MST_User(UserID)
);


------------------------------------------------------------------------------------------------------------------------------

-- Stored Procedures for MST_User Table
CREATE OR ALTER PROC PR_User_Insert
@UserName NVARCHAR(100),
@Password NVARCHAR(100),
@Email NVARCHAR(100),
@Mobile NVARCHAR(100),
@IsActive BIT,
@IsAdmin BIT,
@Created DATETIME,
@Modified DATETIME
AS
BEGIN
	INSERT INTO [dbo].[MST_User] VALUES
	(
		@UserName,
		@Password,
		@Email,
		@Mobile,
		@IsActive,
		@IsAdmin,
		@Created,
		@Modified
	)
END

CREATE OR ALTER PROC PR_User_Update
@UserID INT,
@UserName NVARCHAR(100),
@Password NVARCHAR(100),
@Email NVARCHAR(100),
@Mobile NVARCHAR(100),
@IsActive BIT,
@IsAdmin BIT,
@Modified DATETIME
AS
BEGIN
	UPDATE [dbo].[MST_User]
	SET 
		[dbo].[MST_User].[UserName] = @UserName,
		[dbo].[MST_User].[Password] = @Password,
		[dbo].[MST_User].[Email] = @Email,
		[dbo].[MST_User].[Mobile] = @Mobile,
		[dbo].[MST_User].[IsActive] = @IsActive,
		[dbo].[MST_User].[IsAdmin] = @IsAdmin,
		[dbo].[MST_User].[Modified] = @Modified
	WHERE [dbo].[MST_User].[UserID] = @UserID
END

CREATE OR ALTER PROC PR_User_Delete
@UserID INT
AS
BEGIN
	DELETE FROM [dbo].[MST_User]
	WHERE [dbo].[MST_User].[UserID] = @UserID
END

CREATE OR ALTER PROC PR_User_SelectAll
AS
BEGIN
	SELECT 
		[dbo].[MST_User].[UserID],
		[dbo].[MST_User].[UserName],
		[dbo].[MST_User].[Password],
		[dbo].[MST_User].[Email],
		[dbo].[MST_User].[Mobile],
		[dbo].[MST_User].[IsActive],
		[dbo].[MST_User].[IsAdmin],
		[dbo].[MST_User].[Created],
		[dbo].[MST_User].[Modified]
	FROM [dbo].[MST_User]
END

CREATE OR ALTER PROC PR_User_SelectByID
@UserID INT
AS
BEGIN
	SELECT 
		[dbo].[MST_User].[UserName],
		[dbo].[MST_User].[Password],
		[dbo].[MST_User].[Email],
		[dbo].[MST_User].[Mobile],
		[dbo].[MST_User].[IsActive],
		[dbo].[MST_User].[IsAdmin],
		[dbo].[MST_User].[Created],
		[dbo].[MST_User].[Modified]
	FROM [dbo].[MST_User]
	WHERE [dbo].[MST_User].[UserID] = @UserID
END
------------------------------------------------------------------------------------------------------------------------------
-- Stored Procedures for MST_Quiz Table
CREATE OR ALTER PROC PR_Quiz_Insert
@QuizName NVARCHAR(100),
@TotalQuestions INT,
@QuizDate DATETIME,
@UserID INT,
@Created DATETIME,
@Modified DATETIME
AS
BEGIN
	INSERT INTO [dbo].[MST_Quiz] VALUES
	(
		@QuizName,
		@TotalQuestions,
		@QuizDate,
		@UserID,
		@Created,
		@Modified
	)
END

CREATE OR ALTER PROC PR_Quiz_Update
@QuizID INT,
@QuizName NVARCHAR(100),
@TotalQuestions INT,
@QuizDate DATETIME,
@UserID INT,
@Modified DATETIME
AS
BEGIN
	UPDATE [dbo].[MST_Quiz]
	SET 
		[dbo].[MST_Quiz].[QuizName] = @QuizName,
		[dbo].[MST_Quiz].[TotalQuestions] = @TotalQuestions,
		[dbo].[MST_Quiz].[QuizDate] = @QuizDate,
		[dbo].[MST_Quiz].[UserID] = @UserID,
		[dbo].[MST_Quiz].[Modified] = @Modified
	WHERE [dbo].[MST_Quiz].[QuizID] = @QuizID
END

CREATE OR ALTER PROC PR_Quiz_Delete
@QuizID INT
AS
BEGIN
	DELETE FROM [dbo].[MST_Quiz]
	WHERE [dbo].[MST_Quiz].[QuizID] = @QuizID
END

CREATE OR ALTER PROC PR_Quiz_SelectAll
AS
BEGIN
	SELECT 
		[dbo].[MST_Quiz].[QuizID],
		[dbo].[MST_Quiz].[QuizName],
		[dbo].[MST_Quiz].[TotalQuestions],
		[dbo].[MST_Quiz].[QuizDate],
		[dbo].[MST_Quiz].[UserID],
		[dbo].[MST_Quiz].[Created],
		[dbo].[MST_Quiz].[Modified]
	FROM [dbo].[MST_Quiz]
END

CREATE OR ALTER PROC PR_Quiz_SelectByID
@QuizID INT
AS
BEGIN
	SELECT 
		[dbo].[MST_Quiz].[QuizID],
		[dbo].[MST_Quiz].[QuizName],
		[dbo].[MST_Quiz].[TotalQuestions],
		[dbo].[MST_Quiz].[QuizDate],
		[dbo].[MST_Quiz].[UserID],
		[dbo].[MST_Quiz].[Created],
		[dbo].[MST_Quiz].[Modified]
	FROM [dbo].[MST_Quiz]
	WHERE [dbo].[MST_Quiz].[QuizID] = @QuizID
END

------------------------------------------------------------------------------------------------------------------------------

-- Stored Procedures for MST_Question Table
CREATE OR ALTER PROC PR_Question_Insert
@QuestionText NVARCHAR(MAX),
@QuestionLevelID INT,
@OptionA NVARCHAR(100),
@OptionB NVARCHAR(100),
@OptionC NVARCHAR(100),
@OptionD NVARCHAR(100),
@CorrectOption NVARCHAR(100),
@QuestionMarks INT,
@IsActive BIT,
@UserID INT,
@Created DATETIME,
@Modified DATETIME
AS
BEGIN
	INSERT INTO [dbo].[MST_Question] VALUES
	(
		@QuestionText,
		@QuestionLevelID,
		@OptionA,
		@OptionB,
		@OptionC,
		@OptionD,
		@CorrectOption,
		@QuestionMarks,
		@IsActive,
		@UserID,
		@Created,
		@Modified
	)
END

CREATE OR ALTER PROC PR_Question_Update
@QuestionID INT,
@QuestionText NVARCHAR(MAX),
@QuestionLevelID INT,
@OptionA NVARCHAR(100),
@OptionB NVARCHAR(100),
@OptionC NVARCHAR(100),
@OptionD NVARCHAR(100),
@CorrectOption NVARCHAR(100),
@QuestionMarks INT,
@IsActive BIT,
@UserID INT,
@Modified DATETIME
AS
BEGIN
	UPDATE [dbo].[MST_Question]
	SET 
		[dbo].[MST_Question].[QuestionText] = @QuestionText,
		[dbo].[MST_Question].[QuestionLevelID] = @QuestionLevelID,
		[dbo].[MST_Question].[OptionA] = @OptionA,
		[dbo].[MST_Question].[OptionB] = @OptionB,
		[dbo].[MST_Question].[OptionC] = @OptionC,
		[dbo].[MST_Question].[OptionD] = @OptionD,
		[dbo].[MST_Question].[CorrectOption] = @CorrectOption,
		[dbo].[MST_Question].[QuestionMarks] = @QuestionMarks,
		[dbo].[MST_Question].[IsActive] = @IsActive,
		[dbo].[MST_Question].[UserID] = @UserID,
		[dbo].[MST_Question].[Modified] = @Modified
	WHERE [dbo].[MST_Question].[QuestionID] = @QuestionID
END

CREATE OR ALTER PROC PR_Question_Delete
@QuestionID INT
AS
BEGIN
	DELETE FROM [dbo].[MST_Question]
	WHERE [dbo].[MST_Question].[QuestionID] = @QuestionID
END

CREATE OR ALTER PROC PR_Question_SelectAll
AS
BEGIN
	SELECT 
		[dbo].[MST_Question].[QuestionID],
		[dbo].[MST_Question].[QuestionText],
		[dbo].[MST_Question].[QuestionLevelID],
		[dbo].[MST_Question].[OptionA],
		[dbo].[MST_Question].[OptionB],
		[dbo].[MST_Question].[OptionC],
		[dbo].[MST_Question].[OptionD],
		[dbo].[MST_Question].[CorrectOption],
		[dbo].[MST_Question].[QuestionMarks],
		[dbo].[MST_Question].[IsActive],
		[dbo].[MST_Question].[UserID],
		[dbo].[MST_Question].[Created],
		[dbo].[MST_Question].[Modified]
	FROM [dbo].[MST_Question]
END

-- Stored Procedures for MST_Question Table (continued)
CREATE OR ALTER PROC PR_Question_SelectByID
@QuestionID INT
AS
BEGIN
	SELECT 
		[dbo].[MST_Question].[QuestionID],
		[dbo].[MST_Question].[QuestionText],
		[dbo].[MST_Question].[QuestionLevelID],
		[dbo].[MST_Question].[OptionA],
		[dbo].[MST_Question].[OptionB],
		[dbo].[MST_Question].[OptionC],
		[dbo].[MST_Question].[OptionD],
		[dbo].[MST_Question].[CorrectOption],
		[dbo].[MST_Question].[QuestionMarks],
		[dbo].[MST_Question].[IsActive],
		[dbo].[MST_Question].[UserID],
		[dbo].[MST_Question].[Created],
		[dbo].[MST_Question].[Modified]
	FROM [dbo].[MST_Question]
	WHERE [dbo].[MST_Question].[QuestionID] = @QuestionID
END

------------------------------------------------------------------------------------------------------------------------------

-- Stored Procedures for MST_QuestionLevel Table
CREATE OR ALTER PROC PR_QuestionLevel_Insert
@QuestionLevel NVARCHAR(100),
@UserID INT,
@Created DATETIME,
@Modified DATETIME
AS
BEGIN
	INSERT INTO [dbo].[MST_QuestionLevel] VALUES
	(
		@QuestionLevel,
		@UserID,
		@Created,
		@Modified
	)
END

CREATE OR ALTER PROC PR_QuestionLevel_Update
@QuestionLevelID INT,
@QuestionLevel NVARCHAR(100),
@UserID INT,
@Modified DATETIME
AS
BEGIN
	UPDATE [dbo].[MST_QuestionLevel]
	SET 
		[dbo].[MST_QuestionLevel].[QuestionLevel] = @QuestionLevel,
		[dbo].[MST_QuestionLevel].[UserID] = @UserID,
		[dbo].[MST_QuestionLevel].[Modified] = @Modified
	WHERE [dbo].[MST_QuestionLevel].[QuestionLevelID] = @QuestionLevelID
END

CREATE OR ALTER PROC PR_QuestionLevel_Delete
@QuestionLevelID INT
AS
BEGIN
	DELETE FROM [dbo].[MST_QuestionLevel]
	WHERE [dbo].[MST_QuestionLevel].[QuestionLevelID] = @QuestionLevelID
END

CREATE OR ALTER PROC PR_QuestionLevel_SelectAll
AS
BEGIN
	SELECT 
		[dbo].[MST_QuestionLevel].[QuestionLevelID],
		[dbo].[MST_QuestionLevel].[QuestionLevel],
		[dbo].[MST_QuestionLevel].[UserID],
		[dbo].[MST_QuestionLevel].[Created],
		[dbo].[MST_QuestionLevel].[Modified]
	FROM [dbo].[MST_QuestionLevel]
END

CREATE OR ALTER PROC PR_QuestionLevel_SelectByID
@QuestionLevelID INT
AS
BEGIN
	SELECT 
		[dbo].[MST_QuestionLevel].[QuestionLevelID],
		[dbo].[MST_QuestionLevel].[QuestionLevel],
		[dbo].[MST_QuestionLevel].[UserID],
		[dbo].[MST_QuestionLevel].[Created],
		[dbo].[MST_QuestionLevel].[Modified]
	FROM [dbo].[MST_QuestionLevel]
	WHERE [dbo].[MST_QuestionLevel].[QuestionLevelID] = @QuestionLevelID
END

------------------------------------------------------------------------------------------------------------------------------

-- Stored Procedures for MST_QuizWiseQuestions Table
CREATE OR ALTER PROC PR_QuizWiseQuestions_Insert
@QuizID INT,
@QuestionID INT,
@UserID INT,
@Created DATETIME,
@Modified DATETIME
AS
BEGIN
	INSERT INTO [dbo].[MST_QuizWiseQuestions] VALUES
	(
		@QuizID,
		@QuestionID,
		@UserID,
		@Created,
		@Modified
	)
END

CREATE OR ALTER PROC PR_QuizWiseQuestions_Update
@QuizWiseQuestionsID INT,
@QuizID INT,
@QuestionID INT,
@UserID INT,
@Modified DATETIME
AS
BEGIN
	UPDATE [dbo].[MST_QuizWiseQuestions]
	SET 
		[dbo].[MST_QuizWiseQuestions].[QuizID] = @QuizID,
		[dbo].[MST_QuizWiseQuestions].[QuestionID] = @QuestionID,
		[dbo].[MST_QuizWiseQuestions].[UserID] = @UserID,
		[dbo].[MST_QuizWiseQuestions].[Modified] = @Modified
	WHERE [dbo].[MST_QuizWiseQuestions].[QuizWiseQuestionsID] = @QuizWiseQuestionsID
END

CREATE OR ALTER PROC PR_QuizWiseQuestions_Delete
@QuizWiseQuestionsID INT
AS
BEGIN
	DELETE FROM [dbo].[MST_QuizWiseQuestions]
	WHERE [dbo].[MST_QuizWiseQuestions].[QuizWiseQuestionsID] = @QuizWiseQuestionsID
END

CREATE OR ALTER PROC PR_QuizWiseQuestions_SelectAll
AS
BEGIN
	SELECT 
		[dbo].[MST_QuizWiseQuestions].[QuizWiseQuestionsID],
		[dbo].[MST_QuizWiseQuestions].[QuizID],
		[dbo].[MST_QuizWiseQuestions].[QuestionID],
		[dbo].[MST_QuizWiseQuestions].[UserID],
		[dbo].[MST_QuizWiseQuestions].[Created],
		[dbo].[MST_QuizWiseQuestions].[Modified]
	FROM [dbo].[MST_QuizWiseQuestions]
END

CREATE OR ALTER PROC PR_QuizWiseQuestions_SelectByID
@QuizWiseQuestionsID INT
AS
BEGIN
	SELECT 
		[dbo].[MST_QuizWiseQuestions].[QuizWiseQuestionsID],
		[dbo].[MST_QuizWiseQuestions].[QuizID],
		[dbo].[MST_QuizWiseQuestions].[QuestionID],
		[dbo].[MST_QuizWiseQuestions].[UserID],
		[dbo].[MST_QuizWiseQuestions].[Created],
		[dbo].[MST_QuizWiseQuestions].[Modified]
	FROM [dbo].[MST_QuizWiseQuestions]
	WHERE [dbo].[MST_QuizWiseQuestions].[QuizWiseQuestionsID] = @QuizWiseQuestionsID
END