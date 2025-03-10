CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    FirstName NVARCHAR(50),
    LastName NVARCHAR(50),
    BirthDate DATE,
    HireDate DATE,
    DepartmentID INT,
    Salary DECIMAL(10, 2)
);

CREATE TABLE Departments (
    DepartmentID INT PRIMARY KEY,
    DepartmentName NVARCHAR(50)
);

INSERT INTO Departments (DepartmentID, DepartmentName) VALUES (1, 'HR');
INSERT INTO Departments (DepartmentID, DepartmentName) VALUES (2, 'IT');
INSERT INTO Departments (DepartmentID, DepartmentName) VALUES (3, 'Finance');

INSERT INTO Employees (EmployeeID, FirstName, LastName, BirthDate, HireDate, DepartmentID, Salary) VALUES
(1, 'John', 'Doe', '1980-01-01', '2010-06-01', 1, 50000.00),
(2, 'Jane', 'Smith', '1985-02-15', '2012-09-15', 2, 60000.00),
(3, 'Michael', 'Johnson', '1979-03-20', '2008-11-20', 3, 70000.00);

CREATE PROCEDURE GetEmployeeDetails
    @EmployeeID INT
AS
BEGIN
    SELECT e.EmployeeID, e.FirstName, e.LastName, e.BirthDate, e.HireDate, d.DepartmentName, e.Salary
    FROM Employees e
    INNER JOIN Departments d ON e.DepartmentID = d.DepartmentID
    WHERE e.EmployeeID = @EmployeeID;
END;

CREATE TRIGGER trgAfterInsertEmployee
ON Employees
AFTER INSERT
AS
BEGIN
    DECLARE @EmployeeID INT;
    DECLARE @FirstName NVARCHAR(50);
    DECLARE @LastName NVARCHAR(50);

    SELECT @EmployeeID = inserted.EmployeeID, @FirstName = inserted.FirstName, @LastName = inserted.LastName
    FROM inserted;

    PRINT 'New employee added: ' + @FirstName + ' ' + @LastName + ' (ID: ' + CAST(@EmployeeID AS NVARCHAR) + ')';
END;

UPDATE Employees
SET Salary = Salary * 1.10
WHERE DepartmentID = 2;

DELETE FROM Employees
WHERE EmployeeID = 3;

CREATE VIEW EmployeeDetails AS
SELECT e.EmployeeID, e.FirstName, e.LastName, e.BirthDate, e.HireDate, d.DepartmentName, e.Salary
FROM Employees e
INNER JOIN Departments d ON e.DepartmentID = d.DepartmentID;

SELECT * FROM EmployeeDetails;

CREATE INDEX idxEmployeeLastName ON Employees (LastName);

CREATE FUNCTION GetDepartmentName(@DepartmentID INT)
RETURNS NVARCHAR(50)
AS
BEGIN
    DECLARE @DepartmentName NVARCHAR(50);
    SELECT @DepartmentName = DepartmentName FROM Departments WHERE DepartmentID = @DepartmentID;
    RETURN @DepartmentName;
END;

SELECT dbo.GetDepartmentName(1) AS DepartmentName;