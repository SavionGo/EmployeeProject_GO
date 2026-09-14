package version1;

/**
 *
 * @author User
 */
public class PieceWorkerEmployee {

    private int empID;
    private String empName;
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, String empName, int totalPiecesFinished, double ratePerPiece) {
        this.empID = empID;
        this.empName = empName;
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = (empName == null || empName.trim().isEmpty())
                ? "N/A" : empName;
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

    public double computeSalary() {
        if (totalPiecesFinished <= 100) {
            return totalPiecesFinished * ratePerPiece;
        }
        int bonusAmount = totalPiecesFinished / 100;
        double basePay = totalPiecesFinished * ratePerPiece;
        double bonusPay = bonusAmount * (10 * ratePerPiece);

        return basePay + bonusPay;
    }

    public void displayPieceWorkerEmployee() {
        System.out.printf(
                "ID: %d | Name: %s | Pieces Finished: %d | Rate/Piece: $%.2f%n",
                empID, empName, totalPiecesFinished, ratePerPiece
        );
    }

    @Override
    public String toString() {
        return "PieceWorkerEmployee {" + "empID=" + empID + ", empName=" + empName + ", totalPiecesFinished=" + totalPiecesFinished + ", ratePerPiece=$" + String.format("%.2f", ratePerPiece) + ", Total Salary=$" + String.format("%.2f", computeSalary()) + '}';
    }

}

