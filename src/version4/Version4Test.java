package version4;

public class Version4Test {
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

    private static void tryAdd(EmployeeRoster roster, Employee emp, String type) {
        boolean added = roster.addEmployee(emp);
        System.out.println("Added: " + emp.getEmpName() + " (" + type + ") -> "
                + (added ? "Success" : "Failed - roster is full"));
    }

    public static void main(String[] args) {
        int targetMonth = 9;

        // Roster Initialization
        printHeader("EMPLOYEE ROSTER INITIALIZATION & ENROLLMENT");
        EmployeeRoster roster = new EmployeeRoster(6);
        System.out.println("Roster created with capacity: " + roster.getMax());
        System.out.println();

        tryAdd(roster, new HourlyEmployee(1, new Name("Savion", "Aqui", "Go"),
                new MyDate(6, 9, 2008), new MyDate(15, 1, 2024), 60f, 15.5), "Hourly");
        tryAdd(roster, new PieceWorkerEmployee(2, new Name("Travis", "Dela", "Cruz"),
                new MyDate(12, 11, 1997), new MyDate(8, 7, 2022), 150, 20), "Piece Worker");
        tryAdd(roster, new CommissionEmployee(3, new Name("Matthew", "Ian", "Torres"),
                new MyDate(5, 6, 1996), new MyDate(20, 10, 2021), 500000), "Commission");
        tryAdd(roster, new BasePlusCommissionEmployee(4, new Name("Dan", "Andres", "Lim", "Jr."),
                new MyDate(9, 9, 1995), new MyDate(1, 6, 2020), 150000, 35000), "Base Plus Commission");
        tryAdd(roster, new HourlyEmployee(5, new Name("Andrei", "Santos"),
                new MyDate(21, 4, 1999), new MyDate(1, 3, 2023), 45f, 20), "Hourly");
        tryAdd(roster, new PieceWorkerEmployee(6, new Name("Ramson", "Dizon"),
                new MyDate(3, 9, 2000), new MyDate(12, 5, 2023), 220, 18), "Piece Worker");
        System.out.println();

        // Capacity Check
        printHeader("CAPACITY BOUNDARY CHECK");
        System.out.println("Roster is full? " + roster.isFull());
        tryAdd(roster, new CommissionEmployee(7, new Name("Andrea", "Mendoza"),
                new MyDate(14, 2, 2001), new MyDate(3, 9, 2024), 240000), "Commission");
        System.out.println("Adding a null reference -> "
                + (roster.addEmployee(null) ? "Success" : "Rejected"));
        System.out.println();

        // Introspection Verification
        printHeader("ROSTER COMPOSITION COUNTS");
        System.out.println("Total Employees: " + roster.getCount() + " / " + roster.getMax());
        System.out.println("Hourly Employees: " + roster.countHE());
        System.out.println("Piece Worker Employees: " + roster.countPWE());
        System.out.println("Commission Employees (Pure): " + roster.countCE());
        System.out.println("Base Plus Commission Employees: " + roster.countBPCE());
        System.out.println();

        // Categorical Display
        printHeader("CATEGORICAL RECORDS (filtered + downcast)");
        System.out.println("--- Hourly Employees ---");
        roster.displayHE();
        System.out.println("--- Piece Worker Employees ---");
        roster.displayPWE();
        System.out.println("--- Commission Employees (Pure) ---");
        roster.displayCE();
        System.out.println("--- Base Plus Commission Employees ---");
        roster.displayBPCE();
        System.out.println();

        // Search Verification
        printHeader("SEARCH VERIFICATION");
        Employee found = roster.searchEmployee(3);
        System.out.println("searchEmployee(3): " + (found == null ? "Not found" : found));
        System.out.println("searchEmployee(99): "
                + (roster.searchEmployee(99) == null ? "Not found" : "Found"));
        System.out.println();

        // Polymorphic Downcast Payroll
        printHeader("ROSTER PAYROLL REPORT (Target Month: " + MONTH_NAMES[targetMonth - 1] + ")");
        roster.displayPayroll(targetMonth);
        System.out.println();

        // Removal & Array Compaction
        printHeader("TESTING EMPLOYEE REMOVAL & ARRAY COMPACTION");
        Employee removed = roster.removeEmployee(2);
        System.out.println("Removing Employee ID 2 ("
                + (removed == null ? "not found" : removed.getEmpName())
                + ")... " + (removed == null ? "Failed." : "Successfully removed."));
        System.out.println("Removing Employee ID 99... "
                + (roster.removeEmployee(99) == null ? "Not found." : "Removed."));
        System.out.println("Current Employee Count: " + roster.getCount());
        System.out.println();
        System.out.println("Remaining Employees in Roster:");
        roster.displayAllEmployees();
        System.out.println("=".repeat(70));
    }
}
