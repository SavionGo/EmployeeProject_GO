package version3;

public class Version3Test {
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

    public static void main(String[] args) {
        int targetMonth = 9;

        Employee[] employees = {
            new HourlyEmployee(1, new Name("Savion", "Aqui", "Go"),
                    new MyDate(6, 9, 2008), new MyDate(15, 1, 2024), 60f, 15.5),
            new PieceWorkerEmployee(2, new Name("Travis", "Dela", "Cruz"),
                    new MyDate(12, 11, 1997), new MyDate(8, 7, 2022), 150, 20),
            new CommissionEmployee(3, new Name("Matthew", "Ian", "Torres"),
                    new MyDate(5, 6, 1996), new MyDate(20, 10, 2021), 500000),
            new BasePlusCommissionEmployee(4, new Name("Dan", "Andres", "Lim", "Jr."),
                    new MyDate(9, 9, 1995), new MyDate(1, 6, 2020), 150000, 35000)
        };

        // Polymorphic Collection & Payroll Processing
        printHeader("POLYMORPHIC PAYROLL REPORT (Target Month: " + MONTH_NAMES[targetMonth - 1] + ")");
        for (int i = 0; i < employees.length; i++) {
            Employee emp = employees[i];
            double basePay = emp.computeSalary();
            double totalPay = emp.computeSalary(targetMonth);
            double bonus = totalPay - basePay;
            String eligibility = (bonus > 0) ? "Eligible" : "Ineligible";

            System.out.println((i + 1) + ". " + emp.getClass().getSimpleName() + " [" + emp + "]");
            System.out.println("   Base Pay: $" + String.format("%.2f", basePay) +
                    " | Birthday Bonus: $" + String.format("%.2f", bonus) + " (" + eligibility + ")");
            System.out.println("   Total Payout: $" + String.format("%.2f", totalPay));
            System.out.println();
        }

        // Equivalence & Hash Code Verification
        printHeader("OBJECT CONTRACT TESTS (equals & hashCode)");
        HourlyEmployee emp1 = new HourlyEmployee(5, new Name("Andrei", "Santos"),
                new MyDate(21, 4, 1999), new MyDate(1, 3, 2023), 45f, 20);

        HourlyEmployee emp1Identical = new HourlyEmployee(5, new Name("Andrei", "Santos"),
                new MyDate(21, 4, 1999), new MyDate(1, 3, 2023), 45f, 20);

        HourlyEmployee emp2 = new HourlyEmployee(5, new Name("Andrei", "Santos"),
                new MyDate(21, 4, 1999), new MyDate(1, 3, 2023), 50f, 20);

        System.out.println("emp1 equals emp1Identical: " + emp1.equals(emp1Identical));
        System.out.println("emp1 hashCode: " + emp1.hashCode() +
                " | emp1Identical hashCode: " + emp1Identical.hashCode() +
                " (Match: " + (emp1.hashCode() == emp1Identical.hashCode()) + ")");
        System.out.println("emp1 equals emp2: " + emp1.equals(emp2));
        System.out.println();

        // Deep Copy Verification
        printHeader("DEEP CLONE VERIFICATION");
        HourlyEmployee original = (HourlyEmployee) employees[0];
        HourlyEmployee copy = original.clone();

        System.out.println("Original Name before modification: " + original.getEmpName());
        copy.getEmpName().setLastName("Tan");
        copy.getBirthDate().setMonth(12);
        System.out.println("Clone Name changed to:             " + copy.getEmpName());
        System.out.println("Clone Birth Date changed to:       " + copy.getBirthDate());
        System.out.println("Original Name after modification:  " + original.getEmpName());
        System.out.println("Original Birth Date after:         " + original.getBirthDate());
        boolean deepCopy = !original.getEmpName().equals(copy.getEmpName())
                && !original.getBirthDate().equals(copy.getBirthDate());
        System.out.println(deepCopy ? "Deep copy successful!" : "Deep copy failed.");
        System.out.println();
        System.out.println("Original: " + original);
        System.out.println("Clone:    " + copy);
    }
}
