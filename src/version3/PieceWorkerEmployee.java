package version3;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {
    public PieceWorkerEmployee() {
        super();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                               int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    private int totalPiecesFinished;
    private double ratePerPiece;

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished >= 0) {
            this.totalPiecesFinished = totalPiecesFinished;
        } else {
            this.totalPiecesFinished = 0;
        }
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece >= 0) {
            this.ratePerPiece = ratePerPiece;
        } else {
            this.ratePerPiece = 0;
        }
    }

    @Override
    public double computeSalary(int currentMonth) {
        double basePay = totalPiecesFinished * ratePerPiece;
        double bonusPay = (totalPiecesFinished / 100) * (10 * ratePerPiece);
        return basePay + bonusPay + super.computeSalary(currentMonth);
    }

    @Override
    protected String employeeInfo() {
        return super.employeeInfo() +
                " | Pieces Finished: " + totalPiecesFinished +
                " | Rate/Piece: $" + String.format("%.2f", ratePerPiece);
    }

    public void displayPieceWorkerEmployee() {
        System.out.println(employeeInfo());
    }

    @Override
    public String toString() {
        return employeeInfo() +
                " | Total Salary: $" + String.format("%.2f", computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        PieceWorkerEmployee other = (PieceWorkerEmployee) obj;
        return totalPiecesFinished == other.totalPiecesFinished
                && ratePerPiece == other.ratePerPiece;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalPiecesFinished, ratePerPiece);
    }

    @Override
    public PieceWorkerEmployee clone() {
        return (PieceWorkerEmployee) super.clone();
    }
}
