package version6;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {
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
        if (totalPiecesFinished < 0) {
            throw new IllegalArgumentException("Total pieces finished cannot be negative.");
        }
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece < 0) {
            throw new IllegalArgumentException("Rate per piece cannot be negative.");
        }
        this.ratePerPiece = ratePerPiece;
    }

    @Override
    public double computeSalary(int currentMonth) {
        double basePay = totalPiecesFinished * ratePerPiece;
        double bonusPay = (totalPiecesFinished / 100) * (10 * ratePerPiece);
        return basePay + bonusPay + getBirthdayBonus(currentMonth);
    }

    @Override
    public double computeSalary() {
        return computeSalary(0);
    }

    @Override
    protected String employeeInfo() {
        return super.employeeInfo() +
                " | Pieces Finished: " + totalPiecesFinished +
                " | Rate/Piece: $" + String.format("%.2f", ratePerPiece);
    }

    @Override
    public void displayEmployee() {
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
