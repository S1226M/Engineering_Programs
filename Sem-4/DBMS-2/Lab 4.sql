--1. Write a function to print "hello world".
Create or Alter function FN_PrintHello()
Returns varchar(20)
AS
Begin
	Declare @S varchar(20)
	set @S = 'Hello World'
	Return @S
End

Select dbo.FN_PrintHello()

--2. Write a function which returns addition of two numbers. 
Create or Alter function FN_ADD_TWO(@a int , @b int)
Returns int
As
Begin
	Declare @ANS int
	set @ANS = (@a+@b)
	Return @ANS
End

Select dbo.FN_ADD_TWO(2,3)

--3. Write a function to check whether the given number is ODD or EVEN. 
Create or Alter function FN_EVEN_ODD(@a int)
Returns Varchar(20)
As
Begin
	Declare @ANS varchar(20)
	If @a%2 = 0
		set @ANS = 'Even'
	Else
		set @ANS = 'Odd'
	Return @ANS
End

select dbo.FN_EVEN_ODD(-3)

--4. Write a function which returns a table with details of a person whose first name starts with B. 
Create or Alter function FN_PRINT_TABLE()
Returns TABLE
As
	Return(
		Select * from Person where FirstName like 'B%'
	)

SELECT * from FN_PRINT_TABLE()


--5. Write a function which returns a table with unique first names from the person table. 
Create or Alter function FN_PRINT_TABLE_UNIQUE()
Returns TABLE
As
	Return(
		Select Distinct FirstName from Person
	)

select * from FN_PRINT_TABLE_UNIQUE()

--6. Write a function to print number from 1 to N. (Using while loop) 
create or alter function FN_PRINT_N(@n int)
Returns varchar(100)
As
Begin
	Declare @ANS varchar(100) = '',@i int = 1
	While @i <= @n
	Begin
		set @ANS = @ANS + CAST(@i AS varchar) + ' '
		set @i = @i + 1
	End
	Return @ANS
End

select dbo.FN_PRINT_N(10)

--7. Write a function to find the factorial of a given integer.
create or alter function FN_Factorial(@n int)
Returns INT
As
Begin
	Declare @ANS INT = 1,@i int = 1
	While @i <= @n
	Begin
		set @ANS = @ANS * @i
		set @i = @i + 1
	End
	Return @ANS
End

select dbo.FN_Factorial(5)

--------------------------------------Part B----------------------------
--8. Write a function to compare two integers and return the comparison result. (Using Case statement) 
create or alter function FN_COMPARISON(@a int ,@b int)
Returns varchar(200)
AS
Begin
	Declare @ans varchar(20) = ''
	set @ans= 
	Case
		When @a > @b then Cast(@a as varchar) + ' Is grater then ' + cast(@b as varchar)
		When @a < @b then Cast(@a as varchar) + ' Is less then ' + cast(@b as varchar)
		When @a = @b then Cast(@a as varchar) + ' Is equal ' + cast(@b as varchar)
	End
	return @ans
End

select dbo.FN_COMPARISON(20,10)
--9. Write a function to print the sum of even numbers between 1 to 20. 
create or alter function FN_SUM_EVEN()
Returns int
AS
Begin
	Declare @ans int = 0 , @i int = 1
	While @i <= 20
	begin
		if @i%2 = 0
		begin
			set @ans = @ans + @i
		end
		set @i = @i + 1
	End
	return @ans
end

select dbo.FN_SUM_EVEN()
--10. Write a function that checks if a given string is a palindrome 
create or alter function FN_PELINDROM(@n int)
returns varchar(20)
AS
Begin
	declare @a varchar(20) = ''
	if @n = REVERSE(@n)
		set @a = 'PELINDROM'
	else
		set @a = 'not PELINDROM'
	return @a
end

select dbo.FN_PELINDROM(121)

-----------------------------part c-------------------------
--11. Write a function to check whether a given number is prime or not. 
create or alter function FN_PRIME(@n int)
returns varchar(20)
as
begin
	declare @ans varchar(20) = '',@i int = 1,@count int = 0
	while @i <= @n
	begin
		if @n%@i = 0
		begin
			set @count = @count + 1
			set @i = @i + 1
		end
	end
	if @count = 2
	set @ans = 'prime'
	else
	set @ans = 'not'
	return @ans
end

select dbo.FN_PRIME(5)

--12. Write a function which accepts two parameters start date & end date, and returns a difference in days. 
--13. Write a function which accepts two parameters year & month in integer and returns total days each year. 
--14. Write a function which accepts departmentID as a parameter & returns a detail of the persons. 
--15. Write a function that returns a table with details of all persons who joined after 1-1-1991.