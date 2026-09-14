import version1.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Hourly Employees
        System.out.println("Hourly Employees:\n");
        HourlyEmployee h1 = new HourlyEmployee(1, "Savion", 60f, 15.5);
        h1.displayHourlyEmployee();
        System.out.println(h1);
        System.out.println("\n");

        HourlyEmployee h2 = new HourlyEmployee(5, "Andrei");
        h2.setTotalHoursWorked(45f);
        h2.setRatePerHour(20);
        h2.displayHourlyEmployee();
        System.out.println(h2);
        System.out.println("\n");

        // Piece Worker Employees
        System.out.println("Piece Worker Employees:\n");
        PieceWorkerEmployee p1 = new PieceWorkerEmployee(2, "Travis", 150, 20);
        p1.displayPieceWorkerEmployee();
        System.out.println(p1);
        System.out.println("\n");

        PieceWorkerEmployee p2 = new PieceWorkerEmployee(6, "Ramson");
        p2.setTotalPiecesFinished(20);
        p2.setRatePerPiece(55);
        p2.displayPieceWorkerEmployee();
        System.out.println(p2);
        System.out.println("\n");

        // Commission Employees
        System.out.println("Commission Employees:\n");
        CommissionEmployee c1 = new CommissionEmployee(3, "Matthew", 500000);
        c1.displayCommissionEmployee();
        System.out.println(c1);
        System.out.println("\n");

        CommissionEmployee c2 = new CommissionEmployee(7, "Andrea");
        c2.setTotalSale(240000);
        c2.displayCommissionEmployee();
        System.out.println(c2);
        System.out.println("\n");

        // Base Plus Commission Employees
        System.out.println("Base Plus Commission Employees:\n");
        BasePlusCommissionEmployee bc1 = new BasePlusCommissionEmployee(4, "Dan", 150000, 35000);
        bc1.displayBasePlusCommissionEmployee();
        System.out.println(bc1);
        System.out.println("\n");

        BasePlusCommissionEmployee bc2 = new BasePlusCommissionEmployee(8, "Kryzhaunne");
        bc2.setTotalSale(38500);
        bc2.setBaseSalary(11250);
        bc2.displayBasePlusCommissionEmployee();
        System.out.println(bc2);
        System.out.println("\n");
    }
}