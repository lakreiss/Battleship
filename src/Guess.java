import java.util.ArrayList;
import java.util.HashSet;

public class Guess {
    private int row, col, boardSize;
    private double probabilityOfHit;
    private boolean hit, sunk;

    public Guess(int row, int col, int boardSize) {
        this.row = row;
        this.col = col;
        this.boardSize = boardSize;
        this.sunk = false;

        this.probabilityOfHit =

                //This gives a guess 'points' for being on a diagonal and being towards the center of the board
                //I'm not sure if this is best
                //we could change the weights around to figure out better values

                //max is boardSize, min is 0
                ((boardSize - Math.abs((row - col)))

                //max is (boardSize / 2), min is 0
                + ((boardSize / 2) - Math.abs((boardSize / 2) - row))

                //max is (boardSize / 2), min is 0
                + ((boardSize / 2) - Math.abs((boardSize / 2) - col)))

                * 1.0 / (5 * boardSize);
    }

    public boolean equals(Object o) {
        if (o instanceof Guess) {
            return this.row == ((Guess) o).row && ((Guess) o).col == this.col;
        }
        return false;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public boolean isHit() {
        return this.hit;
    }

    public void setSunk(boolean sunk) {
        this.sunk = sunk;
    }

    public boolean sunkShip() {
        return this.sunk;
    }

    public int hashCode() {
        return row * boardSize + col;
    }

    public double getProbabilityOfHit() {
        return this.probabilityOfHit;
    }

    public void updateProbabilityOfHit(double probabilityToAdd) {
        this.probabilityOfHit += probabilityToAdd;
    }

    public ArrayList<Guess> getNeighbors(Board b, HashSet<Guess> allGuesses) {
        ArrayList<Guess> neighbors = new ArrayList<>();

        if (row != boardSize - 1) {
            Guess below = new Guess(row + 1, col, boardSize);
            if (!allGuesses.contains(below)) {
                neighbors.add(below);
            }
        }

        if (row != 0) {
            Guess above = new Guess(row - 1, col, boardSize);
            if (!allGuesses.contains(above)) {
                neighbors.add(above);
            }
        }

        if (col != boardSize - 1){
            Guess right = new Guess(row, col + 1, boardSize);
            if (!allGuesses.contains(right)) {
                neighbors.add(right);
            }
        }

        if (col != 0){
            Guess left = new Guess(row, col - 1, boardSize);
            if (!allGuesses.contains(left)) {
                neighbors.add(left);
            }
        }

        return neighbors;
    }

    public String toString() {
//        return "row: " + row + " col: " + col + " hit: " + hit + " sunk: " + sunk + " hit prob: " + probabilityOfHit;
        return "row: " + row + " col: " + col + " hit prob: " + probabilityOfHit;
    }
}