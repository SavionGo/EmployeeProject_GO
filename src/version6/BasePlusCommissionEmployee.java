package version6;

import java.util.Objects;

public final class BasePlusCommissionEmployee extends CommissionEmployee {
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
        if (baseSalary < 0) {
            throw new IllegalArgumentException("Base salary cannot be negative.");
        }
        this.baseSalary = baseSalary;
    }

    // Overrides the version inherited from CommissionEmployee.
    // super.computeSalary() already adds the commission and the birthday bonus.
    @Override
    public double computeSalary(int currentMonth) {
        return baseSalary + super.computeSalary(currentMonth);
    }

    @Override
    protected String employeeInfo() {
        return super.employeeInfo() +
                " | Base Salary: $" + String.format("%.2f", baseSalary);
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
