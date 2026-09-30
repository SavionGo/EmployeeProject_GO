package version6;

import java.util.ArrayList;

public class EmployeeRoster {
    public EmployeeRoster() {
        this.empList = new ArrayList<>();
    }

    public EmployeeRoster(int initialCapacity) {
        // initialCapacity is only a starting hint. The list will still grows on its own.
        this.empList = new ArrayList<>(initialCapacity);
    }

    private final ArrayList<Employee> empList;

    // ---------- Collection Operations ----------

    public void addEmployee(Employee emp) {
        if (emp == null) {
            throw new NullPointerException("Employee cannot be null");
        }
        empList.add(emp);
    }

    public Employee removeEmployee(int empID) {
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getEmpID() == empID) {
                return empList.remove(i);
            }
        }
        return null;
    }

    public Employee searchEmployee(int empID) {
        for (Employee emp : empList) {
            if (emp.getEmpID() == empID) {
                return emp;
            }
        }
        return null;
    }

    public int countEmployees() {
        return empList.size();
    }

    // ---------- Payroll: dynamic dispatch through the abstract contract ----------

    public void displayPayroll(int currentMonth) {
        for (Employee emp : empList) {
            double salary = emp.computeSalary(currentMonth);
            String bonusNote = emp.getBirthdayBonus(currentMonth) > 0 ? " (Bonus Applied)" : "";
            System.out.printf("ID: %d | Name: %-26s | Payout: $%.2f%s%n",
                    emp.getEmpID(), emp.getEmpName(), salary, bonusNote);
        }
    }

    // ---------- Administrative breakdown ----------

    public int countHE() {
        int total = 0;
        for (Employee emp : empList) {
            if (emp instanceof HourlyEmployee) {
                total++;
            }
        }
        return total;
    }

    public int countPWE() {
        int total = 0;
        for (Employee emp : empList) {
            if (emp instanceof PieceWorkerEmployee) {
                total++;
            }
        }
        return total;
    }

    // BasePlusCommissionEmployee is also a CommissionEmployee, so an
    // instanceof test would count it twice. getClass() matches the exact type.
    public int countCE() {
        int total = 0;
        for (Employee emp : empList) {
            if (emp.getClass() == CommissionEmployee.class) {
                total++;
            }
        }
        return total;
    }

    public int countBPCE() {
        int total = 0;
        for (Employee emp : empList) {
            if (emp instanceof BasePlusCommissionEmployee) {
                total++;
            }
        }
        return total;
    }

    public void displayAllEmployees() {
        int index = 1;
        for (Employee emp : empList) {
            System.out.println(index + ". " + emp.getClass().getSimpleName() + " [" + emp + "]");
            index++;
        }
    }
}
