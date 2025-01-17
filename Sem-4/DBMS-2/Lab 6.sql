--  Create the Products table 
CREATE TABLE Products ( 
	Product_id INT PRIMARY KEY, 
	Product_Name VARCHAR(250) NOT NULL, 
	Price DECIMAL(10, 2) NOT NULL
);

--  Insert data into the Products table 
INSERT INTO Products (Product_id, Product_Name, Price)
VALUES 
	(1, 'Smartphone', 35000), 
	(2, 'Laptop', 65000), 
	(3, 'Headphones', 5500), 
	(4, 'Television', 85000), 
	(5, 'Gaming Console', 32000);

-----------------------------------Part - A------------------- 
--1. Create a cursor Product_Cursor to fetch all the rows from a products table. 
Declare @P_ID int , @P_NAME varchar(20) , @PRICE decimal(8,2)
Declare Product_Cursor Cursor
For Select * From Products
Open Product_Cursor
Fetch next from Product_Cursor Into @P_Id,@P_NAME,@PRICE
While @@FETCH_STATUS = 0
Begin
	Select @P_ID as ID , @P_NAME as Name , @PRICE as Price
	Fetch next from Product_Cursor Into @P_Id,@P_NAME,@PRICE
End
Close Product_Cursor
Deallocate Product_Cursor

--2. Create a cursor Product_Cursor_Fetch to fetch the records in form of ProductID_ProductName.(Example: 1_Smartphone) 
Declare @P_ID int , @P_NAME varchar(20)
Declare Product_Cursor_Fetch Cursor
For Select Product_id , Product_Name From Products
Open Product_Cursor_Fetch
Fetch next from Product_Cursor_Fetch Into @P_Id,@P_NAME
While @@FETCH_STATUS = 0
Begin
	Select CAST(@P_ID as varchar)+CAST('_' as varchar)+ @P_NAME
	Fetch next from Product_Cursor_Fetch Into @P_Id,@P_NAME
End
Close Product_Cursor_Fetch
Deallocate Product_Cursor_Fetch

--3. Create a Cursor to Find and Display Products Above Price 30,000. 
Declare @PID int , @PNAME varchar(20) , @PPRICE decimal(8,2)
Declare Product_Cursor_Display_Above Cursor
For Select * From Products where Price > 30000
Open Product_Cursor_Display_Above
Fetch next from Product_Cursor_Display_Above Into @PId,@PNAME,@PPRICE
While @@FETCH_STATUS = 0
Begin
	Select @PID as ID , @PNAME as Name , @PPRICE as Price
	Fetch next from Product_Cursor_Display_Above Into @PId,@PNAME,@PPRICE
End
Close Product_Cursor_Display_Above
Deallocate Product_Cursor_Display_Above

--4. Create a cursor Product_CursorDelete that deletes all the data from the Products table. 
Declare @ID int
Declare Product_Cursor_Delete Cursor
For Select Product_id From Products
Open Product_Cursor_Delete
Fetch next from Product_Cursor_Delete Into @Id
While @@FETCH_STATUS = 0
Begin
	Delete from Products where Product_id = @ID
	Fetch next from Product_Cursor_Delete Into @Id
End
Close Product_Cursor_Delete
Deallocate Product_Cursor_Delete

select * from Products

--------------------------------------------PART - B----------------------------
--5. Create a cursor Product_CursorUpdate that retrieves all the data from the products table and increases the price by 10%. 
Declare @ID int
Declare Product_Cursor_Update Cursor
For Select Product_id From Products
Open Product_Cursor_Update
Fetch next from Product_Cursor_Update Into @Id
While @@FETCH_STATUS = 0
Begin
	Update Products Set Price = Cast((Price + (Price*0.1)) as varchar) where Product_id = @ID
	Fetch next from Product_Cursor_Update Into @Id
End
Close Product_Cursor_Update
Deallocate Product_Cursor_Update

--6. Create a Cursor to Rounds the price of each product to the nearest whole number.
Declare @PPRICE decimal(8,2)
Declare Product_Cursor_Price_Round Cursor
For Select Price From Products
Open Product_Cursor_Price_Round
Fetch next from Product_Cursor_Price_Round Into @PPRICE
While @@FETCH_STATUS = 0
Begin
	Select cast(ROUND(@PPRICE,2) as varchar) as Price_Round
	Fetch next from Product_Cursor_Price_Round Into @PPRICE
End
Close Product_Cursor_Price_Round
Deallocate Product_Cursor_Price_Round

-------------------------------Part - C---------------------------------
--7. Create a cursor to insert details of Products into the NewProducts table if the product is “Laptop” 
--(Note: Create NewProducts table first with same fields as Products table) 
CREATE TABLE NewProducts ( 
	Product_id INT PRIMARY KEY, 
	Product_Name VARCHAR(250) NOT NULL, 
	Price DECIMAL(10, 2) NOT NULL
);

Declare @PID int , @PNAME varchar(20), @PPRICE decimal(8,2)
Declare Product_Cursor_Insert_New Cursor
For Select * From Products where Product_Name = 'Laptop'
Open Product_Cursor_Insert_New
Fetch next from Product_Cursor_Insert_New Into @PID,@PNAME,@PPRICE
While @@FETCH_STATUS = 0
Begin
	Insert into NewProducts values (@PID,@PNAME,@PPRICE)
	Fetch next from Product_Cursor_Insert_New Into @PID,@PNAME,@PPRICE
End
Close Product_Cursor_Insert_New
Deallocate Product_Cursor_Insert_New

select * from NewProducts

--8. Create a Cursor to Archive High-Price Products in a New Table (ArchivedProducts), Moves products 
--with a price above 50000 to an archive table, removing them from the original Products table. 
CREATE TABLE ArchivedProducts ( 
	Product_id INT PRIMARY KEY, 
	Product_Name VARCHAR(250) NOT NULL, 
	Price DECIMAL(10, 2) NOT NULL
);

Declare @PID int , @PNAME varchar(20), @PPRICE decimal(8,2)
Declare Product_Cursor_Insert_Delete Cursor
For Select * From Products where Price > 50000
Open Product_Cursor_Insert_Delete
Fetch next from Product_Cursor_Insert_Delete Into @PID,@PNAME,@PPRICE
While @@FETCH_STATUS = 0
Begin
	Insert into ArchivedProducts values (@PID,@PNAME,@PPRICE)
	Delete From Products where Product_id = @PID
	Fetch next from Product_Cursor_Insert_Delete Into @PID,@PNAME,@PPRICE
End
Close Product_Cursor_Insert_Delete
Deallocate Product_Cursor_Insert_Delete

select * from ArchivedProducts
Select * from Products
SELECT * FROM NewProducts
