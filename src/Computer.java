import edu.princeton.cs.algs4.MaxPQ;

import java.util.Comparator;
import java.util.HashSet;

/**
 * Created by liamkreiss on 11/28/17.
 */

/**
 * could make another guess constructor with an intArray passed in which gives weights to different guess criterion
 */
public class Computer extends Player{
    private HashSet<Guess> allGuesses;
    private Guess lastGuess, nextGuess;
    private boolean triedUp, triedDown, triedLeft, triedRight;

    //The MaxPQ Object was built by Robert Sedgewick and Kevin Wayne
    //I got the code from Josh Hug in my CS61B class
    //All credit for the MaxPQ Object should be attributed to him
    private MaxPQ<Guess> guessOrder;

    public Computer(int boardSize) {
        super(boardSize);
        allGuesses = new HashSet<>();
        lastGuess = null;
        nextGuess = null;

        //MaxPQ is initialized with an initCapacity and a comparator
        guessOrder = new MaxPQ<>(boardSize * boardSize, new SortByProbability());
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {

                if (row % 3 == col % 3) {       //this optimizes guesses because boats have length = 3
                    guessOrder.insert(new Guess(row, col, boardSize));
                }
            }
        }
    }

    public void shoot() {
        if (lastGuess != null) {
            for (Guess g : lastGuess.getNeighbors(board, allGuesses)) {
                if (!lastGuess.sunkShip()) {
                    if (lastGuess.isHit()) {
                        g.updateProbabilityOfHit(.2 + (Math.random() / 100));
                        guessOrder.insert(g);
                    }
                }
            }
        }
        nextGuess = guessOrder.delMax();
        while (allGuesses.contains(nextGuess)) {
            nextGuess = guessOrder.delMax();
        }
        allGuesses.add(nextGuess);
        lastGuess = nextGuess;
        System.out.println(nextGuess);
        board.shoot(nextGuess);
    }

    class SortByProbability implements Comparator<Guess>
    {
        // Used for sorting in ascending order of
        // roll name
        public int compare(Guess g1, Guess g2)
        {
            if (g1.getProbabilityOfHit() - g2.getProbabilityOfHit() > 0) {
                return 1;
            } else if (g1.getProbabilityOfHit() - g2.getProbabilityOfHit() < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
