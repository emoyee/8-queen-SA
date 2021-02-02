package pkg8queen;

import java.util.ArrayList;

public class State implements Cloneable {

    private Queen[] queen; // index stands for column of queen
    private ArrayList<State> successors;

    // Random state generator constructor
    public State() {
        int row;
        queen = new Queen[8];
        for (int col = 0; col < 8; col++) {
            row = (int) (Math.random() * 8);
            queen[col] = new Queen(row, col);
        }
    }

    public State(Queen[] queen) {
        this.queen = queen;
    }

    public void generateSuccessors() {
        successors = new ArrayList();
        State successor;
        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                if (row == queen[col].getRow()) {
                    continue;
                }
                successor = clone();
                successor.queen[col].setRow(row);
                successors.add(successor);
            }
        }
    }

    // counts number of threatens for a queen of a row with others
    int threatenPoints(Queen queen) {
        int threatens = 0;
        for (Queen q : this.queen) {
            if (q == queen) {
                continue;
            }
            //هم سطری
            if (queen.getRow() == q.getRow()) {
                threatens++;
            }
            // روی یک قطر راست به چپ
            if (queen.getRow() + queen.getCol() == q.getRow() + q.getCol()) {
                threatens++;
            }
            // روی یک قطر چپ به راست
            if ((queen.getRow() - queen.getCol()) == (q.getRow() - q.getCol())) {
                threatens++;
            }
        }
        
        return threatens;
    }

    // H* is 0 and lower heuristic is better one 
    int getH() {
        int h = 0;
        for (Queen q : queen) {
            h += threatenPoints(q);
        }
        return h/2; // or h/2 cause each threat is counted twice
    }

    @Override
    public State clone() {
        Queen[] clonedQueen = new Queen[8];
        for (int col = 0; col < 8; col++) {
            clonedQueen[col] = queen[col].clone();
        }
        return new State(clonedQueen);
    }

    public Queen[] getQueen() {
        return queen;
    }

    public void setQueen(Queen[] queen) {
        this.queen = queen;
    }

    public ArrayList<State> getSuccessors() {
        return successors;
    }

    public void setSuccessors(ArrayList<State> successors) {
        this.successors = successors;
    }

    public String toString() {
        String result = "";
        for (Queen q : queen) {
            result += q.getRow() + " ";
        }
        return result;
    }

}
