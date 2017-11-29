public class Guess {
    private int row, col, id;

    public Guess(int row, int col, int boardSize) {
        this.row = row;
        this.col = col;
        this.id = row * boardSize + col;
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

    public int hashCode() {
        return id;
    }
}