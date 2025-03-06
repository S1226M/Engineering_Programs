Create table Employee_ASP_NET_Demo
(
	EID int,
	EName Varchar(100),
	Salary Decimal(8,2),
	Department Varchar(100),
	JoiningDate Date
)
Insert Into Employee_ASP_NET_Demo
Values(1,'Smit',100000,'CSE','2025-02-01'),
(2,'ABC',5000,'CSE','2025-03-01'),
(1,'asdfg',9620,'fghj','2026-01-31')

Exec PR_SELECTALL_EMPLOYEE
Create Proc PR_SELECTALL_EMPLOYEE
As
Begin
	Select 
		[Employee_ASP_NET_Demo].[EID],
		[Employee_ASP_NET_Demo].[EName],
		[Employee_ASP_NET_Demo].[Department],
		[Employee_ASP_NET_Demo].[JoiningDate],
		[Employee_ASP_NET_Demo].[Salary]
	From Employee_ASP_NET_Demo
End