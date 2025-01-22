---Exec PR_MST_User_SelectByUserNamePassword 'Smit','1234'
Create Procedure PR_MST_User_SelectByUserNamePassword
		@UserName	varchar(50),
		@Password	varchar(50)
As
Begin
Select
		[dbo].[MST_User].[UserName],
		[dbo].[MST_User].[Password]
From [dbo].[MST_User]
Where (UserName = @USerName OR Email = @UserName OR Mobile = @UserName) And Email = @Password
End