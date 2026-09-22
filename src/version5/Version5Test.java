package version5;

public class Version5Test {
    private static final String[] MONTH_NAMES = {
        "Jan", "Feb", "Mar", "Apr", "May", "Jun",
        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    private static void printHeader(String title) {
        String line = "=".repeat(70);
        System.out.println(line);
        System.out.println(title);
        System.out.println(line);
    }

    private static void enroll(EmployeeRoster roster, Employee emp, String type) {
        roster.addEmployee(emp);
        System.out.println("Enrolled: " + emp.getEmpName() + " (" + type + ")");
    }

    public static void main(String[] args) {
        int targetMonth = 9;

        // Instantiation & Auto-Growth
        printHeader("DYNAMIC ROSTER INITIALIZATION (ArrayList Backend)");
        EmployeeRoster roster = new EmployeeRoster(2);
        System.out.println("Roster started with an initial capacity hint of 2.");
        System.out.println("The list grows on its own, so there is no boundary guard to write.");
        System.out.println();

        enroll(roster, new HourlyEmployee(1, new Name("Savion", "Aqui", "Go"),
                new MyDate(6, 9, 2008), new MyDate(15, 1, 2024), 60f, 15.5), "Hourly");
        enroll(roster, new PieceWorkerEmployee(2, new Name("Travis", "Dela", "Cruz"),
                new MyDate(12, 11, 1997), new MyDate(8, 7, 2022), 150, 20), "Piece Worker");
        enroll(roster, new CommissionEmployee(3, new Name("Matthew", "Ian", "Torres"),
                new MyDate(5, 6, 1996), new MyDate(20, 10, 2021), 500000), "Commission");
        enroll(roster, new BasePlusCommissionEmployee(4, new Name("Dan", "Andres", "Lim", "Jr."),
                new MyDate(9, 9, 1995), new MyDate(1, 6, 2020), 150000, 35000), "Base Plus Commission");
        enroll(roster, new HourlyEmployee(5, new Name("Andrei", "Santos"),
                new MyDate(21, 4, 1999), new MyDate(1, 3, 2023), 45f, 20), "Hourly");
        enroll(roster, new PieceWorkerEmployee(6, new Name("Ramson", "Dizon"),
                new MyDate(3, 9, 2000), new MyDate(12, 5, 2023), 220, 18), "Piece Worker");
        enroll(roster, new CommissionEmployee(7, new Name("Andrea", "Mendoza"),
                new MyDate(14, 2, 2001), new MyDate(3, 9, 2024), 240000), "Commission");
        enroll(roster, new BasePlusCommissionEmployee(8, new Name("Kryzhaunne", "Bautista"),
                new MyDate(27, 9, 1994), new MyDate(5, 2, 2019), 38500, 11250), "Base Plus Commission");

        System.out.println();
        System.out.println("Total Roster Size: " + roster.countEmployees() + " employees");
        System.out.println("Adding a null reference -> "
                + (roster.addEmployee(null) ? "Accepted" : "Rejected"));
        System.out.println();

        // Administrative Breakdown
        printHeader("ROSTER COMPOSITION COUNTS");
        System.out.println("Hourly Employees: " + roster.countHE());
        System.out.println("Piece Worker Employees: " + roster.countPWE());
        System.out.println("Commission Employees (Pure): " + roster.countCE());
        System.out.println("Base Plus Commission Employees: " + roster.countBPCE());
        System.out.println();

        // Dynamic Polymorphism Demonstration
        printHeader("PURE POLYMORPHIC PAYROLL REPORT (Target Month: "
                + MONTH_NAMES[targetMonth - 1] + ")\n"
                + "[No downcasting; dynamic dispatch via Employee.computeSalary()]");
        roster.displayPayroll(targetMonth);
        System.out.println();

        // A plain Employee falls back to the baseline 0.0 implementation.
        printHeader("BASELINE IMPLEMENTATION CHECK");
        Employee plain = new Employee(9, new Name("Unassigned", "Staff"),
                new MyDate(1, 1, 2000), new MyDate(1, 1, 2025));
        System.out.println("A plain Employee has no earning formula of its own.");
        System.out.println("plain.computeSalary(" + targetMonth + ") = $"
                + String.format("%.2f", plain.computeSalary(targetMonth)));
        System.out.println();

        // Search Verification
        printHeader("SEARCH VERIFICATION");
        Employee found = roster.searchEmployee(3);
        System.out.println("searchEmployee(3): " + (found == null ? "Not found" : found));
        System.out.println("searchEmployee(99): "
                + (roster.searchEmployee(99) == null ? "Not found" : "Found"));
        System.out.println();

        // Collection Removal Verification
        printHeader("COLLECTION REMOVAL TEST");
        System.out.println("Roster Size Before Removal: " + roster.countEmployees());
        Employee removed = roster.removeEmployee(2);
        System.out.println("Removing Employee ID 2 ("
                + (removed == null ? "not found" : removed.getEmpName())
                + ")... " + (removed == null ? "Failed." : "Successfully removed."));
        System.out.println("Removing Employee ID 99... "
                + (roster.removeEmployee(99) == null ? "Not found." : "Removed."));
        System.out.println("Updated Roster Size: " + roster.countEmployees());
        System.out.println();
        System.out.println("Current Active Employees:");
        roster.displayAllEmployees();
        System.out.println("=".repeat(70));
    }
}
