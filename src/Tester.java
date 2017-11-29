
import java.util.*;
public class Tester
{
    public static void main(String[] args)
    {
        Player player1 = new Player(7);
        Player player2 = new Computer(7);

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
    }
}