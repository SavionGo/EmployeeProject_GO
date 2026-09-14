package version2;

public class Version2Test {
    public static void main(String[] args) {
        // Hourly Employees
        System.out.println("Hourly Employees:\n");
        HourlyEmployee h1 = new HourlyEmployee(1,
                new Name("Savion", "Go", "Aqui"),
                new MyDate(6, 3, 2008), new MyDate(15, 1, 2024), 60f, 15.5);
        h1.displayHourlyEmployee();
        System.out.println(h1);
        System.out.println("\n");

        HourlyEmployee h2 = new HourlyEmployee(5, new Name("Andrei", "Santos"));
        h2.setBirthDate(new MyDate(21, 4, 1999));
        h2.setDateHired(new MyDate(1, 3, 2023));
        h2.setTotalHoursWorked(45f);
        h2.setRatePerHour(20);
        h2.displayHourlyEmployee();
        System.out.println(h2);
        System.out.println("\n");

        // Piece Worker Employees
        System.out.println("Piece Worker Employees:\n");
        PieceWorkerEmployee p1 = new PieceWorkerEmployee(2,
                new Name("Travis", "Cruz", "Dela"),
                new MyDate(12, 11, 1997), new MyDate(8, 7, 2022), 150, 20);
        p1.displayPieceWorkerEmployee();
        System.out.println(p1);
        System.out.println("\n");

        PieceWorkerEmployee p2 = new PieceWorkerEmployee(6,
                new Name("Ramson", "Garcia"),
                new MyDate(30, 9, 2001), new MyDate(14, 2, 2025));
        p2.setTotalPiecesFinished(20);
        p2.setRatePerPiece(55);
        p2.displayPieceWorkerEmployee();
        System.out.println(p2);
        System.out.println("\n");

        // Commission Employees
        System.out.println("Commission Employees:\n");
        CommissionEmployee c1 = new CommissionEmployee(3,
                new Name("Matthew", "Torres", "Ian"),
                new MyDate(5, 6, 1996), new MyDate(20, 10, 2021), 500000);
        c1.displayCommissionEmployee();
        System.out.println(c1);
        System.out.println("\n");

        CommissionEmployee c2 = new CommissionEmployee(7, new Name("Andrea", "Villanueva", "Rose"));
        c2.setBirthDate(new MyDate(17, 12, 1998));
        c2.setDateHired(new MyDate(3, 5, 2024));
        c2.setTotalSale(240000);
        c2.displayCommissionEmployee();
        System.out.println(c2);
        System.out.println("\n");

        // Base Plus Commission Employees
        System.out.println("Base Plus Commission Employees:\n");
        BasePlusCommissionEmployee bc1 = new BasePlusCommissionEmployee(4,
                new Name("Dan", "Lim", "Andres"),
                new MyDate(9, 9, 1995), new MyDate(1, 6, 2020), 150000, 35000);
        bc1.displayBasePlusCommissionEmployee();
        System.out.println(bc1);
        System.out.println("\n");

        BasePlusCommissionEmployee bc2 = new BasePlusCommissionEmployee(8, new Name("Kryzhaunne", "Mendoza"));
        bc2.setBirthDate(new MyDate(25, 1, 2000));
        bc2.setDateHired(new MyDate(11, 8, 2024));
        bc2.setTotalSale(38500);
        bc2.setBaseSalary(11250);
        bc2.displayBasePlusCommissionEmployee();
        System.out.println(bc2);
        System.out.println("\n");
    }
}
