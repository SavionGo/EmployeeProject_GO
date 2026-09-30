package version5;

import java.util.ArrayList;

public class EmployeeRoster {
    public EmployeeRoster() {
        this.empList = new ArrayList<>();
    }

    public EmployeeRoster(int initialCapacity) {
        this.empList = new ArrayList<>(initialCapacity);
    }

    private ArrayList<Employee> empList;

    // ---------- Collection Operations ----------

    public boolean addEmployee(Employee emp) {
        if (emp == null) {
            return false;
        }
        empList.add(emp);
        return true;
    }

    public Employee removeEmployee(int empID) {
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getEmpID() == empID) {
                // remove() closes the gap for us, so there is no manual shifting.
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

    // ---------- Payroll ----------

    // No instanceof and no casting. Every element is handled as an Employee,
    // and the JVM runs whichever computeSalary() the real object overrides.
    public void displayPayroll(int currentMonth) {
        for (Employee emp : empList) {
            double salary = emp.computeSalary(currentMonth);
            String bonusNote = emp.hasBirthday(currentMonth) ? " (Birthday Bonus Applied)" : "";
            System.out.printf("ID: %-4d | Name: %-22s | Payout: $%.2f%s%n",
                    emp.getEmpID(), emp.getEmpName(), salary, bonusNote);
        }
    }

    // ---------- Administrative breakdown (instanceof still useful here) ----------

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
