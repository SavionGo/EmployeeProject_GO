package version3;

import java.util.Objects;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    public BasePlusCommissionEmployee() {
        super();
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                                      double totalSale, double baseSalary) {
        super(empID, empName, birthDate, dateHired, totalSale);
        setBaseSalary(baseSalary);
    }

    private double baseSalary;

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        } else {
            this.baseSalary = 0;
        }
    }

    @Override
    public double computeSalary(int currentMonth) {
        return baseSalary + super.computeSalary(currentMonth);
    }

    @Override
    protected String employeeInfo() {
        return super.employeeInfo() +
                " | Base Salary: $" + String.format("%.2f", baseSalary);
    }

    public void displayBasePlusCommissionEmployee() {
        System.out.println(employeeInfo());
    }

    @Override
    public String toString() {
        return employeeInfo() +
                " | Total Salary: $" + String.format("%.2f", computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        BasePlusCommissionEmployee other = (BasePlusCommissionEmployee) obj;
        return baseSalary == other.baseSalary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), baseSalary);
    }

    @Override
    public BasePlusCommissionEmployee clone() {
        return (BasePlusCommissionEmployee) super.clone();
    }
}
