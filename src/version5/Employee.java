package version5;

import java.util.Objects;

public class Employee implements Cloneable {
    private static final double BIRTHDAY_BONUS = 5000;

    public Employee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
    }

    public Employee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
    }

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public void setEmpName(Name empName) {
        this.empName = (empName == null) ? new Name() : empName;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = (birthDate == null) ? new MyDate() : birthDate;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = (dateHired == null) ? new MyDate() : dateHired;
    }

    public double computeSalary(int currentMonth) {
        return 0.0;
    }

    public double computeSalary() {
        return computeSalary(-1);
    }

    // Shared birthday incentive rule used by the subclasses.
    protected double getBirthdayBonus(int currentMonth) {
        if (birthDate.getMonth() == currentMonth) {
            return BIRTHDAY_BONUS;
        }
        return 0;
    }

    public boolean hasBirthday(int currentMonth) {
        return birthDate.getMonth() == currentMonth;
    }

    public void displayEmployee() {
        System.out.println(employeeInfo());
    }

    protected String employeeInfo() {
        return "ID: " + empID +
                " | Name: " + empName +
                " | Birth Date: " + birthDate +
                " | Date Hired: " + dateHired;
    }

    @Override
    public String toString() {
        return employeeInfo();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Employee other = (Employee) obj;
        return empID == other.empID
                && empName.equals(other.empName)
                && birthDate.equals(other.birthDate)
                && dateHired.equals(other.dateHired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empID, empName, birthDate, dateHired);
    }

    @Override
    public Employee clone() {
        try {
            Employee copy = (Employee) super.clone();
            copy.empName = empName.clone();
            copy.birthDate = birthDate.clone();
            copy.dateHired = dateHired.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
