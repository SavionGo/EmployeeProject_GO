package version2;

public class Version2Test {
    private static final String[] MONTH_NAMES = {
        "Jan", "Feb", "Mar", "Apr", "May", "Jun",
        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    private static int otherMonth(int month) {
        return (month % 12) + 1;
    }

    private static void printIncentiveCheck(String label, int birthMonth,
                                            double regular, double birthday) {
        int regularMonth = otherMonth(birthMonth);
        System.out.println("[Birthday Incentive Check - " + label + "]");
        System.out.println("Regular Month (" + MONTH_NAMES[regularMonth - 1] + ") Salary: $"
                + String.format("%.2f", regular));
        System.out.println("Birth Month (" + MONTH_NAMES[birthMonth - 1] + ") Salary (+$5000.00): $"
                + String.format("%.2f", birthday));
    }

    public static void main(String[] args) {
        // Composition Verification
        System.out.println("--- Name & Date Output Verification ---");
        Name defaultName = new Name();
        Name twoPartName = new Name("Alice", "Smith");
        Name threePartName = new Name("Alice", "Marie", "Smith");
        Name fullName = new Name("Bob", "Charles", "Jones", "Jr.");
        System.out.print("Default Name: ");
        defaultName.displayName();
        System.out.print("Two-Part Name: ");
        twoPartName.displayName();
        System.out.print("Three-Part Name: ");
        threePartName.displayName();
        System.out.print("Full Name: ");
        fullName.displayName();

        MyDate defaultDate = new MyDate();
        MyDate fullDate = new MyDate(18, 9, 2026);
        MyDate invalidDate = new MyDate(40, 13, 2026);
        System.out.print("Default Date: ");
        defaultDate.displayDate();
        System.out.print("Full Date: ");
        fullDate.displayDate();
        System.out.print("Invalid Date (40/13/2026): ");
        invalidDate.displayDate();
        System.out.println("\n");

        // Hourly Employees
        System.out.println("Hourly Employees:\n");
        HourlyEmployee h1 = new HourlyEmployee(1,
                new Name("Savion", "Aqui", "Go"),
                new MyDate(6, 3, 2008), new MyDate(15, 1, 2024), 60f, 15.5);
        h1.displayHourlyEmployee();
        System.out.println(h1);
        printIncentiveCheck("h1", h1.getBirthDate().getMonth(),
                h1.computeSalary(otherMonth(h1.getBirthDate().getMonth())),
                h1.computeSalary(h1.getBirthDate().getMonth()));
        System.out.println("\n");

        HourlyEmployee h2 = new HourlyEmployee(5, new Name("Andrei", "Santos"));
        h2.setBirthDate(new MyDate(21, 4, 1999));
        h2.setDateHired(new MyDate(1, 3, 2023));
        h2.setTotalHoursWorked(45f);
        h2.setRatePerHour(20);
        h2.displayHourlyEmployee();
        System.out.println(h2);
        printIncentiveCheck("h2", h2.getBirthDate().getMonth(),
                h2.computeSalary(otherMonth(h2.getBirthDate().getMonth())),
                h2.computeSalary(h2.getBirthDate().getMonth()));
        System.out.println("\n");

        // Piece Worker Employees
        System.out.println("Piece Worker Employees:\n");
        PieceWorkerEmployee p1 = new PieceWorkerEmployee(2,
                new Name("Travis", "Dela", "Cruz"),
                new MyDate(12, 11, 1997), new MyDate(8, 7, 2022), 150, 20);
        p1.displayPieceWorkerEmployee();
        System.out.println(p1);
        printIncentiveCheck("p1", p1.getBirthDate().getMonth(),
                p1.computeSalary(otherMonth(p1.getBirthDate().getMonth())),
                p1.computeSalary(p1.getBirthDate().getMonth()));
        System.out.println("\n");

        PieceWorkerEmployee p2 = new PieceWorkerEmployee(6,
                new Name("Ramson", "Garcia"),
                new MyDate(30, 9, 2001), new MyDate(14, 2, 2025));
        p2.setTotalPiecesFinished(20);
        p2.setRatePerPiece(55);
        p2.displayPieceWorkerEmployee();
        System.out.println(p2);
        printIncentiveCheck("p2", p2.getBirthDate().getMonth(),
                p2.computeSalary(otherMonth(p2.getBirthDate().getMonth())),
                p2.computeSalary(p2.getBirthDate().getMonth()));
        System.out.println("\n");

        // Commission Employees
        System.out.println("Commission Employees:\n");
        CommissionEmployee c1 = new CommissionEmployee(3,
                new Name("Matthew", "Ian", "Torres"),
                new MyDate(5, 6, 1996), new MyDate(20, 10, 2021), 500000);
        c1.displayCommissionEmployee();
        System.out.println(c1);
        printIncentiveCheck("c1", c1.getBirthDate().getMonth(),
                c1.computeSalary(otherMonth(c1.getBirthDate().getMonth())),
                c1.computeSalary(c1.getBirthDate().getMonth()));
        System.out.println("\n");

        CommissionEmployee c2 = new CommissionEmployee(7, new Name("Andrea", "Rose", "Villanueva"));
        c2.setBirthDate(new MyDate(17, 12, 1998));
        c2.setDateHired(new MyDate(3, 5, 2024));
        c2.setTotalSale(240000);
        c2.displayCommissionEmployee();
        System.out.println(c2);
        printIncentiveCheck("c2", c2.getBirthDate().getMonth(),
                c2.computeSalary(otherMonth(c2.getBirthDate().getMonth())),
                c2.computeSalary(c2.getBirthDate().getMonth()));
        System.out.println("\n");

        // Base Plus Commission Employees
        System.out.println("Base Plus Commission Employees:\n");
        BasePlusCommissionEmployee bc1 = new BasePlusCommissionEmployee(4,
                new Name("Dan", "Andres", "Lim"),
                new MyDate(9, 9, 1995), new MyDate(1, 6, 2020), 150000, 35000);
        bc1.displayBasePlusCommissionEmployee();
        System.out.println(bc1);
        printIncentiveCheck("bc1", bc1.getBirthDate().getMonth(),
                bc1.computeSalary(otherMonth(bc1.getBirthDate().getMonth())),
                bc1.computeSalary(bc1.getBirthDate().getMonth()));
        System.out.println("\n");

        BasePlusCommissionEmployee bc2 = new BasePlusCommissionEmployee(8, new Name("Kryzhaunne", "Mendoza"));
        bc2.setBirthDate(new MyDate(25, 1, 2000));
        bc2.setDateHired(new MyDate(11, 8, 2024));
        bc2.setTotalSale(38500);
        bc2.setBaseSalary(11250);
        bc2.displayBasePlusCommissionEmployee();
        System.out.println(bc2);
        printIncentiveCheck("bc2", bc2.getBirthDate().getMonth(),
                bc2.computeSalary(otherMonth(bc2.getBirthDate().getMonth())),
                bc2.computeSalary(bc2.getBirthDate().getMonth()));
        System.out.println("\n");
    }
}
