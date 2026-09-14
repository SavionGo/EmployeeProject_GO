/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version2;

/**
 *
 * @author User
 */
public class CommissionEmployee {
    public CommissionEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, Name empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, Name empName, double totalSale) {
        this.empID = empID;
        this.empName = empName;
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

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = (empName == null || empName.trim().isEmpty())
                ? "N/A" : empName;
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

    public double computeSalary() {
        if (totalSale < 50000) {
            return totalSale * 0.05;
        } else if (totalSale < 100000) {
            return totalSale * 0.10;
        } else if (totalSale < 500000) {
            return totalSale * 0.15;
        } else {
            return totalSale * 0.20;
        }
    }

    public void displayCommissionEmployee() {
        System.out.printf(
                "ID: %d | Name: %s | Total Sale: $%.2f%n",
                empID, empName, totalSale
        );
    }

    @Override
    public String toString() {
        return  "ID: " + empID +
                " | Name: " + empName +
                " | Total Sale: $" + String.format("%.2f", totalSale) +
                " | Total Salary: $" + String.format("%.2f", computeSalary());
    }

}
