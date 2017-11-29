
import java.util.*;
public class Tester
{
    public static void main(String[] args)
    {
        Player player1 = new Player(7);
        Player player2 = new Player(7);

        while(!(player1.board.boardIsClear()) && !(player2.board.boardIsClear()))
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
        player1.board.showBoard();
        if(player1.board.ship1.getAlive())
            System.out.println("Player 1 Ship 1 is alive");
        else
            System.out.println("Player 1 Ship 1 is sunk");
        if(player1.board.ship2.getAlive())
            System.out.println("Player 1 Ship 2 is alive");
        else
            System.out.println("Player 1 Ship 2 is sunk");
        if(player1.board.ship3.getAlive())
            System.out.println("Player 1 Ship 3 is alive");
        else
            System.out.println("Player 1 Ship 3 is sunk");
        player2.board.showBoard();
        if(player1.board.ship1.getAlive())
            System.out.println("Player 2 Ship 1 is alive");
        else
            System.out.println("Player 2 Ship 1 is sunk");
        if(player1.board.ship2.getAlive())
            System.out.println("Player 2 Ship 2 is alive");
        else
            System.out.println("Player 2 Ship 2 is sunk");
        if(player1.board.ship3.getAlive())
            System.out.println("Player 2 Ship 3 is alive");
        else
            System.out.println("Player 2 Ship 3 is sunk");
        System.out.println("Good game!");

        player1.board.printCopyPasta();
    }
}