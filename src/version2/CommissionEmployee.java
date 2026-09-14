/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version2;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class CommissionEmployee {
    private static final double BIRTHDAY_BONUS = 5000;

    public CommissionEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, Name empName) {
        this.empID = empID;
        setEmpName(empName);
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                              double totalSale) {
        this.empID = empID;
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
        setTotalSale(totalSale);
    }

    private int empID;
    private double totalSale;
    private Name empName;
    private MyDate dateHired;
    private MyDate birthDate;

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

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        if (totalSale >= 0) {
            this.totalSale = totalSale;
        } else {
            this.totalSale = 0;
        }
    }

    public boolean isBirthMonth() {
        return birthDate.getMonth() == LocalDate.now().getMonthValue();
    }

    public double computeSalary() {
        double salary;
        if (totalSale < 50000) {
            salary = totalSale * 0.05;
        } else if (totalSale < 100000) {
            salary = totalSale * 0.10;
        } else if (totalSale < 500000) {
            salary = totalSale * 0.15;
        } else {
            salary = totalSale * 0.20;
        }

        if (isBirthMonth()) {
            salary += BIRTHDAY_BONUS;
        }
        return salary;
    }

    private String employeeInfo() {
        return "ID: " + empID +
                " | Name: " + empName +
                " | Birth Date: " + birthDate +
                " | Date Hired: " + dateHired +
                " | Total Sale: $" + String.format("%.2f", totalSale);
    }

    public void displayCommissionEmployee() {
        System.out.println(employeeInfo());
    }

    @Override
    public String toString() {
        return employeeInfo() +
                " | Total Salary: $" + String.format("%.2f", computeSalary());
    }

}
