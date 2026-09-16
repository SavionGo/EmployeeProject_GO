package version1;

/**
 *
 * @author User
 */
public class HourlyEmployee {
    private int empID;
    private String empName;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int empID, String empName) {
        this.empID = empID;
        setEmpName(empName);
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int empID, String empName, float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        setEmpName(empName);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

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

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked >= 0) {
            this.totalHoursWorked = totalHoursWorked;
        } else {
            this.totalHoursWorked = 0;
        }
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour >= 0) {
            this.ratePerHour = ratePerHour;
        } else {
            this.ratePerHour = 0;
        }
    }

    public double computeSalary() {
        if (totalHoursWorked < 0 || ratePerHour < 0) {
            return 0;
        }

        if (totalHoursWorked <= 40) {
            return totalHoursWorked * ratePerHour;
        }

        double regularPay = 40 * ratePerHour;
        double overtimePay
                = (totalHoursWorked - 40) * (ratePerHour * 1.5);

        return regularPay + overtimePay;
    }

    public void displayHourlyEmployee() {
        System.out.printf(
                "ID: %d | Name: %s | Hours: %.2f | Rate: $%.2f/hr%n",
                empID, empName, totalHoursWorked, ratePerHour
        );
    }

    @Override
    public String toString() {
        return "ID: " + empID +
                " | Name: " + empName +
                " | Hours: " + String.format("%.2f", totalHoursWorked) +
                " | Rate: $" + String.format("%.2f", ratePerHour) +
                "/hr | Total Salary: $" + String.format("%.2f", computeSalary());
    }

}

