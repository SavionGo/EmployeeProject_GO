package version1;

/**
 *
 * @author User
 */
public class BasePlusCommissionEmployee {

    private int empID;
    private String empName;
    private double totalSale;
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalSale = 0;
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0;
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, String empName, double totalSale, double baseSalary) {
        this.empID = empID;
        this.empName = empName;
        setTotalSale(totalSale);
        setBaseSalary(baseSalary);
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

    public double computeSalary() {
        if (totalSale < 50000) {
            return totalSale * 0.05 + baseSalary;
        } else if (totalSale < 100000) {
            return totalSale * 0.10 + baseSalary;
        } else if (totalSale < 500000) {
            return totalSale * 0.15 + baseSalary;
        } else {
            return totalSale * 0.20 + baseSalary;
        }
    }

    public void displayBasePlusCommissionEmployee() {
        System.out.printf(
                "ID: %d | Name: %s | Total Sale: $%.2f | Base Salary: $%.2f%n",
                empID, empName, totalSale, baseSalary
        );
    }

    @Override
    public String toString() {
        return "BasePlusCommissionEmployee {" + "empID=" + empID + ", empName=" + empName + ", totalSale=$" + String.format("%.2f", totalSale) + ", baseSalary=$" + String.format("%.2f", baseSalary) + ", Total Salary=$" + String.format("%.2f", computeSalary()) + '}';
    }

}
