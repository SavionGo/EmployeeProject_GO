package version6;

public class Version6Test {
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

    private static void printCaught(Exception e) {
        System.out.println("Caught Expected Exception: ["
                + e.getClass().getSimpleName() + "] " + e.getMessage());
    }

    public static void main(String[] args) {
        int targetMonth = 9;

        // Instantiation Blocking: Employee is abstract, so the line below won't compile at all.
        // Employee test = new Employee(9, new Name("Unassigned", "Staff"),
        //         new MyDate(1, 1, 2000), new MyDate(1, 1, 2025));

        // 1. Defensive Copying
        printHeader("1. TESTING ENCAPSULATION & DEFENSIVE COPYING");
        MyDate andreiBirthDate = new MyDate(21, 4, 1999);
        HourlyEmployee andrei = new HourlyEmployee(5, new Name("Andrei", "Santos"),
                andreiBirthDate, new MyDate(1, 3, 2023), 45f, 20);

        int originalMonth = andrei.getBirthDate().getMonth();
        System.out.println("Original Birth Month: " + originalMonth
                + " (" + MONTH_NAMES[originalMonth - 1] + ")");
        System.out.println("Attempting external tampering: emp.getBirthDate().setMonth(9)...");
        andrei.getBirthDate().setMonth(9);
        System.out.println("Employee's Actual Birth Date after tampering attempt: "
                + andrei.getBirthDate());
        if (andrei.getBirthDate().getMonth() == originalMonth) {
            System.out.println("Result: SUCCESS (Internal state protected via defensive copying)");
        } else {
            System.out.println("Result: FAILED (Internal state was modified)");
        }
        System.out.println();

        // 2. Exception Handling
        printHeader("2. TESTING EXCEPTION HANDLING & INPUT VALIDATION");
        System.out.println("Attempting to create HourlyEmployee with rate: -150.00...");
        try {
            new HourlyEmployee(10, new Name("Invalid", "Rate"),
                    new MyDate(1, 1, 2000), new MyDate(1, 1, 2025), 40f, -150);
        } catch (IllegalArgumentException e) {
            printCaught(e);
        }
        System.out.println();

        System.out.println("Attempting to assign invalid calendar date: 31 Feb 2026...");
        try {
            new MyDate(31, 2, 2026);
        } catch (IllegalArgumentException e) {
            printCaught(e);
        }
        System.out.println();

        // 3. Polymorphic Payroll
        EmployeeRoster roster = new EmployeeRoster();
        roster.addEmployee(new HourlyEmployee(1, new Name("Savion", "Aqui", "Go"),
                new MyDate(6, 9, 2008), new MyDate(15, 1, 2024), 60f, 15.5));
        roster.addEmployee(new PieceWorkerEmployee(2, new Name("Travis", "Dela", "Cruz"),
                new MyDate(12, 11, 1997), new MyDate(8, 7, 2022), 150, 20));
        roster.addEmployee(new CommissionEmployee(3, new Name("Matthew", "Ian", "Torres"),
                new MyDate(5, 6, 1996), new MyDate(20, 10, 2021), 500000));
        roster.addEmployee(new BasePlusCommissionEmployee(4, new Name("Dan", "Andres", "Lim", "Jr."),
                new MyDate(9, 9, 1995), new MyDate(1, 6, 2020), 150000, 35000));
        roster.addEmployee(andrei);
        roster.addEmployee(new PieceWorkerEmployee(6, new Name("Ramson", "Dizon"),
                new MyDate(3, 9, 2000), new MyDate(12, 5, 2023), 220, 18));
        roster.addEmployee(new CommissionEmployee(7, new Name("Andrea", "Mendoza"),
                new MyDate(14, 2, 2001), new MyDate(3, 9, 2024), 240000));
        roster.addEmployee(new BasePlusCommissionEmployee(8, new Name("Kryzhaunne", "Bautista"),
                new MyDate(27, 9, 1994), new MyDate(5, 2, 2019), 38500, 11250));

        printHeader("3. POLYMORPHIC PAYROLL EXECUTION (Target Month: "
                + MONTH_NAMES[targetMonth - 1] + ")\n"
                + "[Dynamic Dispatch via Abstract Contract computeSalary()]");
        roster.displayPayroll(targetMonth);
        System.out.println("=".repeat(70));
    }
}
