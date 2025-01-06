-------------------------Inser In User---------------------------------
Create or Alter Procedure [dbo].[PR_USER_INSERT]
	@UserName nvarchar(100),@Password nvarchar(100),@Email nvarchar(100),
	@Mobile nvarchar(100),@IsActive bit,@Modified datetime
As
Begin
	Insert Into [dbo].[User]
	values(@UserName,@Password,@Email,@Mobile,@IsActive,getDate(),@Modified)
End

--------------------------Select All-------------------
Create or Alter Procedure [dbo].[PR_USER_SELECTALL]
As
Begin
	Select * From [dbo].[User]
End