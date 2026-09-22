package version4;

public class EmployeeRoster {
    private static final int DEFAULT_MAX = 10;

    public EmployeeRoster() {
        this.max = DEFAULT_MAX;
        this.empList = new Employee[max];
        this.count = 0;
    }

    public EmployeeRoster(int max) {
        this.max = (max > 0) ? max : DEFAULT_MAX;
        this.empList = new Employee[this.max];
        this.count = 0;
    }

    private Employee[] empList;
    private int max;
    private int count;

    public int getMax() {
        return max;
    }

    public int getCount() {
        return count;
    }

    public boolean isFull() {
        return count == max;
    }

    // ---------- Manager Methods ----------

    public boolean addEmployee(Employee emp) {
        if (emp == null || count >= max) {
            return false;
        }
        empList[count] = emp;
        count++;
        return true;
    }

    public Employee removeEmployee(int empID) {
        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) {
                Employee removed = empList[i];

                // Compaction: shift every element after i one slot to the left
                // so the array never keeps a null gap in the middle.
                for (int j = i; j < count - 1; j++) {
                    empList[j] = empList[j + 1];
                }
                empList[count - 1] = null;
                count--;
                return removed;
            }
        }
        return null;
    }

    public Employee searchEmployee(int empID) {
        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) {
                return empList[i];
            }
        }
        return null;
    }

    // ---------- Introspection Methods (instanceof) ----------

    public int countHE() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) {
                total++;
            }
        }
        return total;
    }

    public int countPWE() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) {
                total++;
            }
        }
        return total;
    }

    // BasePlusCommissionEmployee extends CommissionEmployee, so
    // "instanceof CommissionEmployee" would be true for both of them.
    // getClass() == CommissionEmployee.class matches the exact type only.
    public int countCE() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i].getClass() == CommissionEmployee.class) {
                total++;
            }
        }
        return total;
    }

    public int countBPCE() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) {
                total++;
            }
        }
        return total;
    }

    // ---------- Categorical Display (filter + downcast) ----------

    public void displayHE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) {
                HourlyEmployee he = (HourlyEmployee) empList[i];
                he.displayHourlyEmployee();
            }
        }
    }

    public void displayPWE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) {
                PieceWorkerEmployee pwe = (PieceWorkerEmployee) empList[i];
                pwe.displayPieceWorkerEmployee();
            }
        }
    }

    public void displayCE() {
        for (int i = 0; i < count; i++) {
            if (empList[i].getClass() == CommissionEmployee.class) {
                CommissionEmployee ce = (CommissionEmployee) empList[i];
                ce.displayCommissionEmployee();
            }
        }
    }

    public void displayBPCE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee bpce = (BasePlusCommissionEmployee) empList[i];
                bpce.displayBasePlusCommissionEmployee();
            }
        }
    }

    public void displayAllEmployees() {
        for (int i = 0; i < count; i++) {
            Employee emp = empList[i];
            System.out.printf("%d. ID: %-4d | Name: %-22s | Type: %s%n",
                    i + 1, emp.getEmpID(), emp.getEmpName(),
                    emp.getClass().getSimpleName());
        }
    }

    // ---------- Payroll (downcasting, because Employee has no computeSalary) ----------

    public void displayPayroll(int currentMonth) {
        for (int i = 0; i < count; i++) {
            Employee emp = empList[i];
            String label;
            double salary;

            // Check BasePlusCommissionEmployee FIRST. It is also an instance of
            // CommissionEmployee, so the reverse order would never reach this branch.
            if (emp instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee bpce = (BasePlusCommissionEmployee) emp;
                label = "Base Plus Commission";
                salary = bpce.computeSalary(currentMonth);
            } else if (emp instanceof CommissionEmployee) {
                CommissionEmployee ce = (CommissionEmployee) emp;
                label = "Commission";
                salary = ce.computeSalary(currentMonth);
            } else if (emp instanceof HourlyEmployee) {
                HourlyEmployee he = (HourlyEmployee) emp;
                label = "Hourly";
                salary = he.computeSalary(currentMonth);
            } else if (emp instanceof PieceWorkerEmployee) {
                PieceWorkerEmployee pwe = (PieceWorkerEmployee) emp;
                label = "Piece Worker";
                salary = pwe.computeSalary(currentMonth);
            } else {
                // A plain Employee has no salary formula at all.
                label = "Employee";
                salary = 0;
            }

            String bonusNote = emp.hasBirthday(currentMonth) ? " (Birthday Bonus Applied)" : "";
            System.out.printf("[%s] ID: %d | Name: %s | Salary: $%.2f%s%n",
                    label, emp.getEmpID(), emp.getEmpName(), salary, bonusNote);
        }
    }
}
