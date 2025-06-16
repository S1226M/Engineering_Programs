CREATE TABLE HospitalMaster (
    HospitalID INT PRIMARY KEY,
    HospitalName NVARCHAR(150) NOT NULL,
    HospitalAddress NVARCHAR(250) NOT NULL,
    ContactNumber NVARCHAR(10) NULL,
    EmailAddress NVARCHAR(250) NULL,
    OwnerName NVARCHAR(250) NOT NULL,
    OpeningDate DATETIME NOT NULL,
    TotalStaffs INT NOT NULL,
    SundayOpen BIT NOT NULL
);

Create table Doctor(
	DoctorID Int PRIMARY KEY,
	DoctorName NVARCHAR(100),
	Degree NVARCHAR(100),
	Experience NVARCHAR(100),
	Specialization NVARCHAR(100),
	Age Int,
	DOB DateTime
)

Create Table Patient(
	PatientID INT PRIMARY KEY,
	PatientName NVARCHAR(100),
	ContactNumber NVARCHAR(100),
	Age Int,
	EarlierOperation Bit,
	BloodGroup NVARCHAR(10)
)
