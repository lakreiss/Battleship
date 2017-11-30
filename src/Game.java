/**
 * Created by liamkreiss on 11/30/17.
 */
public class Game {
    private int numPlayers;
    private static final int BOARD_SIZE = 7;

    public Game() {
        //default is single player
        this.numPlayers = 1;
    }

    public Game(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public void playGame() {
        if (numPlayers == 1) {
            Player player = new Player(BOARD_SIZE);

            while(!(player.getBoard().boardIsClear()))
            {
                System.out.println("It is your turn!!");
                player.shoot();
                try{
                    Thread.sleep(1500);
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
            }

            player.getBoard().showBoard();

            for (int i = 0; i < player.getBoard().getShips().length; i++) {
                System.out.println("Ship " + (i + 1) + " is " + player.getBoard().getShips()[i].getState());
            }

            System.out.println("Good game!");

            player.getBoard().printCopyPasta();

        } else if (numPlayers == 2) {
            Player player1 = new Player(BOARD_SIZE);
            Player player2 = new Computer(BOARD_SIZE);

            while(!(player1.getBoard().boardIsClear()) && !(player2.getBoard().boardIsClear()))
            {
                System.out.println("It is player 1's turn!!");
                player1.shoot();
                try{
                    Thread.sleep(1500);
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
                System.out.println("It is player 2's turn!!");
                player2.shoot();
                try{
                    Thread.sleep(1500);
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
            }

            player1.getBoard().showBoard();

            for (int i = 0; i < player1.getBoard().getShips().length; i++) {
                System.out.println("Player 1 Ship " + (i + 1) + " is " + player1.getBoard().getShips()[i].getState());
            }

            player2.getBoard().showBoard();
            for (int i = 0; i < player2.getBoard().getShips().length; i++) {
                System.out.println("Player 2 Ship " + (i + 1) + " is " + player2.getBoard().getShips()[i].getState());
            }
            System.out.println("Good game!");

            player1.getBoard().printCopyPasta();

        } else {
            throw new Error("invalid number of players");
        }
    }
}
