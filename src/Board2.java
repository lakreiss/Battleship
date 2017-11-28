import java.util.*;
public class Board2
{
    private String[][] boardView;
    private int[][] gameBoard;

    Ship2 ship1 = new Ship2();
    Ship2 ship2 = new Ship2();
    Ship2 ship3 = new Ship2();
    Scanner kb = new Scanner(System.in);
    public Board2()
    {
        // initialise instance variables
        boardView = new String[7][7];
        for(int i = 0; i < boardView.length; i++)
        {
            for(int j = 0; j < boardView[0].length; j++)
                boardView[i][j] = "_";
        }
        gameBoard = new int[7][7];
        for(int i = 0; i < gameBoard.length; i++)
        {
            for(int j = 0; j < gameBoard[0].length; j++)
                gameBoard[i][j] = 0;
        }
    }

    public String[][] getBoardView()
    {
        return boardView;
    }

    public int[][] getGameBoard()
    {
        return gameBoard;
    }

    public void shipsToArray()
    {
        if(ship1.getUpDown())
        {
            gameBoard[ship1.getPosx()][ship1.getPosy()] = 1; 
            gameBoard[ship1.getPosx()][ship1.getPos2()] = 1; 
            gameBoard[ship1.getPosx()][ship1.getPos3()] = 1;
        }
        else
        {
            gameBoard[ship1.getPosx()][ship1.getPosy()] = 1; 
            gameBoard[ship1.getPos2()][ship1.getPosy()] = 1; 
            gameBoard[ship1.getPos3()][ship1.getPosy()] = 1;
        }
        if(ship2.getUpDown())
        {
            gameBoard[ship2.getPosx()][ship2.getPosy()] = 1; 
            gameBoard[ship2.getPosx()][ship2.getPos2()] = 1; 
            gameBoard[ship2.getPosx()][ship2.getPos3()] = 1;
        }
        else
        {
            gameBoard[ship2.getPosx()][ship2.getPosy()] = 1; 
            gameBoard[ship2.getPos2()][ship2.getPosy()] = 1; 
            gameBoard[ship2.getPos3()][ship2.getPosy()] = 1;
        }
        if(ship3.getUpDown())
        {
            gameBoard[ship3.getPosx()][ship3.getPosy()] = 1; 
            gameBoard[ship3.getPosx()][ship3.getPos2()] = 1; 
            gameBoard[ship3.getPosx()][ship3.getPos3()] = 1;
        }
        else
        {
            gameBoard[ship3.getPosx()][ship3.getPosy()] = 1; 
            gameBoard[ship3.getPos2()][ship3.getPosy()] = 1; 
            gameBoard[ship3.getPos3()][ship3.getPosy()] = 1;
        }
    }

    private void showBoard()
    {
        for(int i = 0; i < boardView.length; i++)
        {
            System.out.print(i + "  ");
            for(int j = 0; j < boardView[0].length; j++)
            {
                System.out.print(boardView[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("   0   1   2   3   4   5   6");
        // for(int i = 0; i < gameBoard.length; i++)
        // {
        // System.out.print(i + "  ");
        // for(int j = 0; j < gameBoard[0].length; j++)
        // {
        // System.out.print(gameBoard[i][j] + " | ");
        // }
        // System.out.println();
        // }
        // System.out.println("   0   1   2   3   4   5   6");
    }

    public boolean boardIsClear()
    {
        for(int i = 0; i < gameBoard.length; i++)
        {
            for(int j = 0; j < gameBoard[0].length; j++)
            {
                if(gameBoard[i][j] == 1)
                    return false;
            }
        }
        return true;
    }

    private void shoot()
    {
        System.out.print("Enter your row guess 0 to 6: ");
        int guessx = kb.nextInt();
        if(guessx < 0 || guessx > 6)
        {
            System.out.println("Please guess between 0 and 6!");
        }
        System.out.print("Enter your column guess 0 to 6: ");
        int guessy = kb.nextInt();
        if(guessy < 0 || guessy > 6)
        {
            System.out.println("Please guess between 0 and 6!");
        }
        System.out.println("PEW!");
        if(gameBoard[guessx][guessy] == 1)
        {
            System.out.println("Hit!");
            gameBoard[guessx][guessy] = gameBoard[guessx][guessy] - 1;
            boardView[guessx][guessy] = "X";
        }
        else
        {
            System.out.println("Miss!");
            boardView[guessx][guessy] = "O";
        }
        ship1.isAlive(gameBoard);
        ship2.isAlive(gameBoard);
        ship3.isAlive(gameBoard);
    }

    public void clearBoard()
    {
        shipsToArray();
        while(!boardIsClear())
        {
            showBoard();
            shoot();
            System.out.println();
            if(ship1.getAlive())
                System.out.println("Ship 1 is alive");
            else
                System.out.println("Ship 1 is sunk");
            if(ship2.getAlive())
                System.out.println("Ship 2 is alive");
            else
                System.out.println("Ship 2 is sunk");
            if(ship3.getAlive())
                System.out.println("Ship 3 is alive");
            else
                System.out.println("Ship 3 is sunk");
            System.out.println("Ship 1 has " + ship1.livesLeft(gameBoard) + " lives left");
            System.out.println("Ship 2 has " + ship2.livesLeft(gameBoard) + " lives left");
            System.out.println("Ship 3 has " + ship3.livesLeft(gameBoard) + " lives left");
        }
        showBoard();
        if(ship1.getAlive())
            System.out.println("Ship 1 is alive");
        else
            System.out.println("Ship 1 is sunk");
        if(ship2.getAlive())
            System.out.println("Ship 2 is alive");
        else
            System.out.println("Ship 2 is sunk");
        if(ship3.getAlive())
            System.out.println("Ship 3 is alive");
        else
            System.out.println("Ship 3 is sunk");
        System.out.println("Good game!");
        printCopyPasta();
        return;
    }

    private void printCopyPasta() {
        System.out.println("Life is like a cabbage: Sometimes it is green and crunchy, sometimes dad stabs the cat with a knife because his foot ball team lose again");
        System.out.println("Life is like a cabbage: sometimes it is green and round, and sometimes mom wish you were never born");
        System.out.println("If you throw a cabbage in the air he will alway come right back down to you because he is lonely without you.");
        System.out.println("If there is a fire in your house make sure you save all the cabbages before you even think about finding your children");
        System.out.println("A cabbage does not wear a watch but he always have time for you");
        System.out.println("Instead of drinking coffee in the morning try laying down with a cabbage on your stomach and you will be wide awake trust me");
        System.out.println("If you push a cabbage under water he will alway float right back up to the top because he miss you so much");
        System.out.println("A cabbage does not have ears but that does not mean that he is immune to your lies");
        System.out.println("Some time you think about a cabbage and you get so excited that forget to go to sleep again for five days");
        System.out.println("Sometimes you hate your life and dont want to be alive anymore but then you think about cabbage and know that everything will be ok");
        System.out.println("You can paint a cabbage green but that is a waste of paint because he is already green you idiot");
        System.out.println("If you run out of pillows maybe try using a cabbage");
        System.out.println("You can tell a cabbage has gone bad if he is wearing a leather jacket");
        System.out.println("if you are sad put a cabbage in your back pack and carry him every where so it feel like you have a friend that want to spend time with you");
        System.out.println("A cabbage is so pretty but you are real ugly");
        System.out.println("You can ask a cabbage for financial advice but he will not say any thing because he is a cabbage");
        System.out.println("You can put a cabbage on the hood of your car. People will not under stand what you are doing but at least you are doing some thing");
        System.out.println("If you put plastic eyeballs on a cabbage and take him to the movies it might feel like you have a friend I hate my life");
        System.out.println("Dr. Suess did not ever make a poem about cababge And now he is dead");
        System.out.println("A cabbage can not get pregnant believe me I tried");
        System.out.println("You can put a cabbage in a baby carriage amd take him for a walk and people will say who this and you can say he is my cabbaby");
        System.out.println("If you want to trick your parents put a cabbage on your pillow at night and they will think you are sleeping but you are actually crying");
        System.out.println("Good game!");
    }
}
