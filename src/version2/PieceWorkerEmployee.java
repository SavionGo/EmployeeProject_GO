package version2;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class PieceWorkerEmployee {
    private static final double BIRTHDAY_BONUS = 5000;

    public PieceWorkerEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, Name empName) {
        this.empID = empID;
        setEmpName(empName);
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                               int totalPiecesFinished, double ratePerPiece) {
        this.empID = empID;
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    private int empID;
    private int totalPiecesFinished;
    private double ratePerPiece;
    private Name empName;
    private MyDate dateHired;
    private MyDate birthDate;

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public void setEmpName(Name empName) {
        this.empName = (empName == null) ? new Name() : empName;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = (birthDate == null) ? new MyDate() : birthDate;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = (dateHired == null) ? new MyDate() : dateHired;
    }

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

    public boolean isBirthMonth() {
        return birthDate.getMonth() == LocalDate.now().getMonthValue();
    }

    public double computeSalary() {
        double salary;
        if (totalPiecesFinished <= 100) {
            salary = totalPiecesFinished * ratePerPiece;
        } else {
            int bonusAmount = totalPiecesFinished / 100;
            double basePay = totalPiecesFinished * ratePerPiece;
            double bonusPay = bonusAmount * (10 * ratePerPiece);
            salary = basePay + bonusPay;
        }

        if (isBirthMonth()) {
            salary += BIRTHDAY_BONUS;
        }
        return salary;
    }

    private String employeeInfo() {
        return "ID: " + empID +
                " | Name: " + empName +
                " | Birth Date: " + birthDate +
                " | Date Hired: " + dateHired +
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

}
