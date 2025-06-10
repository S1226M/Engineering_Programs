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

