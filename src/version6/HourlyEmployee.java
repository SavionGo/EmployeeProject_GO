package version6;

import java.util.Objects;

public class HourlyEmployee extends Employee {
    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                          float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    private float totalHoursWorked;
    private double ratePerHour;

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked < 0) {
            throw new IllegalArgumentException("Total hours worked cannot be negative.");
        }
        this.totalHoursWorked = totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour < 0) {
            throw new IllegalArgumentException("Rate per hour cannot be negative.");
        }
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double computeSalary(int currentMonth) {
        double salary;
        if (totalHoursWorked <= 40) {
            salary = totalHoursWorked * ratePerHour;
        } else {
            double regularPay = 40 * ratePerHour;
            double overtimePay = (totalHoursWorked - 40) * (ratePerHour * 1.5);
            salary = regularPay + overtimePay;
        }
        return salary + getBirthdayBonus(currentMonth);
    }

    @Override
    public double computeSalary() {
        return computeSalary(0);
    }

    @Override
    protected String employeeInfo() {
        return super.employeeInfo() +
                " | Hours: " + String.format("%.2f", totalHoursWorked) +
                " | Rate: $" + String.format("%.2f", ratePerHour) + "/hr";
    }

    @Override
    public void displayEmployee() {
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
        HourlyEmployee other = (HourlyEmployee) obj;
        return totalHoursWorked == other.totalHoursWorked
                && ratePerHour == other.ratePerHour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalHoursWorked, ratePerHour);
    }

    @Override
    public HourlyEmployee clone() {
        return (HourlyEmployee) super.clone();
    }
}
