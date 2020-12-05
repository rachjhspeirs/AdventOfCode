package Day5;

public class BoardingPass {

    int rowNumber;
    int seatNumber;
    int ID;

    BoardingPass(int rowNumber, int seatNumber, int ID){

        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.ID = ID;

    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
