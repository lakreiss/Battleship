import java.util.*;
public class Board

/*
It's really good!
I cleaned up your code a bit, you should look over the changes and figure out why I made them and why they work.
I changed:
- the mechanism you used to make sure the user enters valid input. Your way was broken and now
it will be easier to debug. I used recursion, not sure if you've studied that yet, but hopefully
it makes sense when you look at the code. it's the method called "getGuess"
- added a global static variable which describes the size of the board. Size is a pretty standard thing
to use as a field (global variable), and that way if you ever want to make the board bigger or smaller,
you just have to change one line instead of a bunch of lines
-renamed your second ship to ships[1] because I don't know why it used to just be called 'ship'
Other things that would be good to change:
-make sure ships don't overlap
-allow for different sized ships, and different numbers of ships
-the biggest thing for potentially making bots is figuring out the overall design a little better.
I would suggest making a class that runs the game, and have that class contain two Player objects
(you'd have to make a player class), and have each player object contain their own board. I think
that best simulates a real game of battleship, and it would allow you to make ComputerPlayer as
a subclass of Player
 */
{
    private String[][] boardView;
    private int[][] gameBoard;
    private int boardSize;
    private Ship[] ships;
    private static final int NUM_SHIPS = 3;

    public Board(int boardSize)
    {
        this.boardSize = boardSize;
        this.ships = new Ship[NUM_SHIPS];
        for (int i = 0; i < NUM_SHIPS; i++) {
            ships[i] = new Ship(boardSize, i + 1);
        }

        // initialise instance variables
        boardView = new String[boardSize][boardSize];
        for(int i = 0; i < boardSize; i++)
        {
            for(int j = 0; j < boardSize; j++)
                boardView[i][j] = "_";
        }
        gameBoard = new int[boardSize][boardSize];
        for(int i = 0; i < boardSize; i++)
        {
            for(int j = 0; j < boardSize; j++)
                gameBoard[i][j] = 0;
        }

    }

    public void shipsToArray()
    {
        if(ships[0].getUpDown())
        {
            gameBoard[ships[0].getPosx()][ships[0].getPosy()] = 1; 
            gameBoard[ships[0].getPosx()][ships[0].getPos2()] = 1; 
            gameBoard[ships[0].getPosx()][ships[0].getPos3()] = 1;
        }
        else
        {
            gameBoard[ships[0].getPosx()][ships[0].getPosy()] = 1; 
            gameBoard[ships[0].getPos2()][ships[0].getPosy()] = 1; 
            gameBoard[ships[0].getPos3()][ships[0].getPosy()] = 1;
        }
        if(ships[1].getUpDown())
        {
            gameBoard[ships[1].getPosx()][ships[1].getPosy()] = 1;
            gameBoard[ships[1].getPosx()][ships[1].getPos2()] = 1;
            gameBoard[ships[1].getPosx()][ships[1].getPos3()] = 1;
        }
        else
        {
            gameBoard[ships[1].getPosx()][ships[1].getPosy()] = 1;
            gameBoard[ships[1].getPos2()][ships[1].getPosy()] = 1;
            gameBoard[ships[1].getPos3()][ships[1].getPosy()] = 1;
        }
        if(ships[2].getUpDown())
        {
            gameBoard[ships[2].getPosx()][ships[2].getPosy()] = 1; 
            gameBoard[ships[2].getPosx()][ships[2].getPos2()] = 1; 
            gameBoard[ships[2].getPosx()][ships[2].getPos3()] = 1;
        }
        else
        {
            gameBoard[ships[2].getPosx()][ships[2].getPosy()] = 1; 
            gameBoard[ships[2].getPos2()][ships[2].getPosy()] = 1; 
            gameBoard[ships[2].getPos3()][ships[2].getPosy()] = 1;
        }
    }

    public void showBoard()
    {
        for(int i = 0; i < boardSize; i++)
        {
            System.out.print(i + "  ");
            for(int j = 0; j < boardSize; j++)
            {
                System.out.print(boardView[i][j] + " | ");
            }
            System.out.println();
        }
        printColumnTitles();
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

    /**
     * equivalent to System.out.println("   0   1   2   3   4   5   6");
    but it can go to numbers other than 6
     */
    private void printColumnTitles() {
        for (int i = 0; i < boardSize; i++) {
            System.out.print("   " + i);
        }
        System.out.println();
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

    public void shoot(Guess guess)
    {

        System.out.println("PEW!");
        if(gameBoard[guess.getRow()][guess.getCol()] == 1)
        {
            guess.setHit(true);
            System.out.println("Hit!");
            gameBoard[guess.getRow()][guess.getCol()] = gameBoard[guess.getRow()][guess.getCol()] - 1;
            boardView[guess.getRow()][guess.getCol()] = "X";
        }
        else
        {
            guess.setHit(false);
            System.out.println("Miss!");
            boardView[guess.getRow()][guess.getCol()] = "O";
        }

        for (int i = 0; i < ships.length; i++) {
            if (ships[i].updateAliveReturnSunk(gameBoard)) {
                guess.setSunk(true);
            }
        }

        for (Ship s : ships) {
            System.out.println(s.toString() + " is " + s.getState());
        }

        /* TODO
        To make this faster and more efficient, each ship could have a field
        which tells how many lives a ship has left
         */
        for (Ship s : ships) {
            System.out.println(s.toString() + " has " + s.livesLeft(gameBoard) + " lives left");
        }
        showBoard();
        System.out.println();
    }

    public void printCopyPasta() {
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

    public Ship[] getShips() {
        return this.ships;
    }
}