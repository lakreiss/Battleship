import java.util.HashSet;
import java.util.Scanner;

public class Player
{
    protected Board board;
    protected int boardSize;
    protected Scanner kb;
    protected HashSet<Guess> guesses;


    public Player(int boardSize)
    {
        this.kb = new Scanner(System.in);
        this.boardSize = boardSize;
        board = new Board(boardSize);
        board.shipsToArray();
        guesses = new HashSet<Guess>();

    }

    public void shoot(){
        board.showBoard();

        System.out.print("Enter your row guess 0 to " + (boardSize - 1) + ": ");
        int guessx = getGuess(0, boardSize);

        System.out.print("Enter your column guess 0 to " + (boardSize - 1) + ": ");
        int guessy = getGuess(0, boardSize);

        Guess guess = new Guess(guessx, guessy, boardSize);

        if (guesses.contains(guess)) {
            System.out.println("You've already guessed that index. Please try again.");
            shoot();
        } else {
            board.shoot(guess);
        }
    }


    /**
     * min is inclusive, max is exclusive
     * @param min
     * @param max
     * @return
     */
    private int getGuess(int min, int max) {
        Scanner input = new Scanner(kb.nextLine());
        if (input.hasNextInt()) {
            int guess = input.nextInt();
            if (guess < min || guess >= max)
            {
                System.out.println("Please guess between 0 and " + (boardSize - 1) + "!");
                input.close(); //this is unnecessary but technically saves memory. you can get rid of these .close() if you want
                return getGuess(min, max);
            }
            else
            {
                return guess;
            }
        }
        System.out.println("Please guess between 0 and " + (boardSize - 1) + "!");
        input.close();
        return getGuess(min, max);
    }

    public Board getBoard() {
        return this.board;
    }
    
}