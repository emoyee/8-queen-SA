package pkg8queen;

public class Queen implements Cloneable {

    private int row;
    private int col;

    public Queen(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public Queen clone() {
        return new Queen(row, col);
    }
}
