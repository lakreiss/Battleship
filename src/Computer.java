import java.util.HashSet;

/**
 * Created by liamkreiss on 11/28/17.
 */
public class Computer extends Player{
    //make field that holds all guesses, field for last hit, field for triedUp, triedDown, triedLeft, triedRight
    private HashSet<Guess> allGuesses;
    private Guess lastHit;
    private boolean triedUp, triedDown, triedLeft, triedRight;

    //I think the best data structure for making a smart computer would be a priority queue

    public Computer(int boardSize) {
        super(boardSize);
        allGuesses = new HashSet<>();
        lastHit = null;
    }

    public void shoot() {

    }
}
