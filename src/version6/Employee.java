package version6;

import java.util.Objects;

// "new Employee(...)" is now a compile error and only subclasses can be created.
public abstract class Employee implements Cloneable {
    private static final double BIRTHDAY_BONUS = 5000;

    public Employee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        if (empName == null) throw new NullPointerException("Employee name cannot be null");
        if (birthDate == null) throw new NullPointerException("Birth date cannot be null");
        if (dateHired == null) throw new NullPointerException("Date hired cannot be null");

        this.empID = empID;
        this.empName = empName.clone();
        this.birthDate = birthDate.clone();
        this.dateHired = dateHired.clone();
    }

    private final int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    // final: subclasses cannot override how an employee is identified. Note to me: This is valid for every employee
    public final int getEmpID() {
        return empID;
    }

    public Name getEmpName() {
        return this.empName.clone();
    }

    public void setEmpName(Name empName) {
        if (empName == null) throw new NullPointerException("Employee name cannot be null");
        this.empName = empName.clone();
    }

    public MyDate getBirthDate() {
        return this.birthDate.clone();
    }

    public void setBirthDate(MyDate birthDate) {
        if (birthDate == null) throw new NullPointerException("Birth date cannot be null");
        this.birthDate = birthDate.clone();
    }

    public MyDate getDateHired() {
        return this.dateHired.clone();
    }

    public void setDateHired(MyDate dateHired) {
        if (dateHired == null) throw new NullPointerException("Date hired cannot be null");
        this.dateHired = dateHired.clone();
    }

    // final: the birthday bonus rule is the same for everyone and cannot be overridden.
    public final double getBirthdayBonus(int currentMonth) {
        if (birthDate.getMonth() == currentMonth) {
            return BIRTHDAY_BONUS;
        }
        return 0;
    }
    public abstract double computeSalary(int currentMonth);

    public abstract double computeSalary();

    public abstract void displayEmployee();

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
