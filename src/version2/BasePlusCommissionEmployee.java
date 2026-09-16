package version2;

/**
 *
 * @author User
 */
public class BasePlusCommissionEmployee {
    private static final double BIRTHDAY_BONUS = 5000;

    private int empID;
    private double totalSale;
    private double baseSalary;
    private Name empName;
    private MyDate dateHired;
    private MyDate birthDate;

    public BasePlusCommissionEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
        this.totalSale = 0;
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName) {
        this.empID = empID;
        setEmpName(empName);
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
        this.totalSale = 0;
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
        this.totalSale = 0;
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                                      double totalSale, double baseSalary) {
        this.empID = empID;
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
        setTotalSale(totalSale);
        setBaseSalary(baseSalary);
    }

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

    public double computeSalary(int currentMonth) {
        double salary;
        if (totalSale < 50000) {
            salary = totalSale * 0.05 + baseSalary;
        } else if (totalSale < 100000) {
            salary = totalSale * 0.10 + baseSalary;
        } else if (totalSale < 500000) {
            salary = totalSale * 0.15 + baseSalary;
        } else {
            salary = totalSale * 0.20 + baseSalary;
        }

        if (birthDate.getMonth() == currentMonth) {
            salary += BIRTHDAY_BONUS;
        }
        return salary;
    }

    public double computeSalary() {
        return computeSalary(0);
    }

    private String employeeInfo() {
        return "ID: " + empID +
                " | Name: " + empName +
                " | Birth Date: " + birthDate +
                " | Date Hired: " + dateHired +
                " | Total Sale: $" + String.format("%.2f", totalSale) +
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

}
