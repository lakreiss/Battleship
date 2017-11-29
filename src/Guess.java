import java.util.Comparator;

public class Guess {
    private int row, col, id;
    private double probabilityOfHit;
    private boolean hit;

    public Guess(int row, int col, int boardSize) {
        this.row = row;
        this.col = col;
        this.id = row * boardSize + col;

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

                / (5 * boardSize);
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

//    public int compare(Guess g1, Guess g2) {
//        if (g1.getProbabilityOfHit() - g2.getProbabilityOfHit() > 0) {
//            return 1;
//        } else if (g1.getProbabilityOfHit() - g2.getProbabilityOfHit() < 0) {
//            return -1;
//        } else {
//            return 0;
//        }
//    }

    public int hashCode() {
        return id;
    }

    public double getProbabilityOfHit() {
        return this.probabilityOfHit;
    }

    public void updateProbabilityOfHit() {
        //TODO
    }

}