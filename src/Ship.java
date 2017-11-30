public class Ship
{
    private int shipLength = 3;
    private int posx, pos2, pos3, posy;
    private boolean alive;
    private boolean upDown; //if true, ship is up & down on board; false = left * right
    private int shipNumber;

    public Ship(int boardSize, int shipNumber)
    {
        this.shipNumber = shipNumber;
        //This strategy allows overlap of ships, which I don't think you want - Liam
        // initialise instance variables
        int leftRight = ((int)(Math.random() * (2))); //determines if the ship faces up and down or left and right
        upDown = (leftRight == 0);
        if (upDown) 
        {
            posx = (int)(Math.random() * (boardSize)); //sets the x postition of the ship
            posy = (int)(Math.random() * (boardSize - shipLength)); //sets the y position
            pos2 = posy + 1;
        } 
        else 
        {
            posx = (int)(Math.random() * (boardSize - shipLength)); //sets the x postition of the ship
            posy = (int)(Math.random() * (boardSize)); //sets the y position
            pos2 = posx + 1;
        }
        pos3 = pos2 + 1;

        alive = true;
    }


    public int getPosx()
    {
        return posx;
    }

    public int getPos3()
    {
        return pos3;
    }

    public int getPos2()
    {
        return pos2;
    }

    public int getPosy()
    {
        return posy;
    }

    public boolean getAlive()
    {
        return alive;
    }

    public boolean getUpDown()
    {
        return upDown;
    }

    public int livesLeft(int[][] board)
    {
        int count = 0;
        if(upDown == true)
        {
            if(board[posx][posy] == 1)
                count++;
            if(board[posx][pos2] == 1)
                count++;
            if(board[posx][pos3] == 1)
                count++;
        }
        else
        {
            if(board[posx][posy] == 1)
                count++;
            if(board[pos2][posy] == 1)
                count++;
            if(board[pos3][posy] == 1)
                count++;
        }
        return count;
    }

    public boolean updateAliveReturnSunk(int[][] board)
    {
        if (!alive) {
            return false;
        } else {
            if (livesLeft(board) == 0) {
                alive = false;
                return true;
            } else {
                return false;
            }
        }
    }

    //you never call this method
    public void changePos()
    {
        if(upDown == true)
        {
            posy = ((int)(Math.random() * (4)));
            pos2 = posy + 1;
            pos3 = pos2 + 1;
        }
        else
        {
            posx = ((int)(Math.random() * (4)));
            pos2 = posx + 1;
            pos3 = pos2 + 1;
        }

    }

    public String getState() {
        if (alive) 
        {
            return "alive";
        }
        return "sunk";
    }

    public String toString() {
        return "Ship " + shipNumber;
    }
}