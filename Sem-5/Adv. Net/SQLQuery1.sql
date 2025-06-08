CREATE TABLE Student (
	ID INT PRIMARY KEY,
	StudentName VARCHAR(50),
	StudentGender VARCHAR(20),
	Age INT,
	Standard VARCHAR(10),
	FatherName VARCHAR(50)
);


Insert Into Student(ID, StudentName, StudentGender, Age, Standard, FatherName)
VALUES
	(1, 'Aarav Mehta', 'Male', 14, '8th', 'Rakesh Mehta'),
	(2, 'Ananya Sharma', 'Female', 13, '7th', 'Sanjay Sharma'),
	(3, 'Kabir Singh', 'Male', 15, '9th', 'Rajeev Singh'),
	(4, 'Isha Patel', 'Female', 12, '6th', 'Kiran Patel'),
	(5, 'Vivaan Roy', 'Male', 14, '8th', 'Amit Roy'),
	(6, 'Diya Verma', 'Female', 13, '7th', 'Manoj Verma'),
	(7, 'Rehan Khan', 'Male', 15, '9th', 'Salman Khan'),
	(8, 'Meera Nair', 'Female', 12, '6th', 'Suresh Nair'),
	(9, 'Yash Rathore', 'Male', 14, '8th', 'Mahesh Rathore'),
	(10, 'Simran Kaur', 'Female', 13, '7th', 'Harpreet Kaur');

Select * From Student 
