import edu.princeton.cs.algs4.MaxPQ;

import java.util.Comparator;
import java.util.HashSet;

/**
 * Created by liamkreiss on 11/28/17.
 */
public class Computer extends Player{
    private HashSet<Guess> allGuesses;
    private Guess lastHit;
    private boolean triedUp, triedDown, triedLeft, triedRight;

    //The MaxPQ Object was built by Robert Sedgewick and Kevin Wayne
    //I got the code from Josh Hug in my CS61B class
    //All credit for the MaxPQ Object should be attributed to him
    private MaxPQ<Guess> guessOrder;

    public Computer(int boardSize) {
        super(boardSize);
        allGuesses = new HashSet<>();
        lastHit = null;

        //MaxPQ is initialized with an initCapacity and a comparator
        guessOrder = new MaxPQ<>(boardSize * boardSize, new SortByProbability());
        guessOrder.insert(new Guess(1, 2, 7));
    }

    public void shoot() {

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
