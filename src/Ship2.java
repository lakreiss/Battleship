public class Ship2
{
    private int posx, pos2, pos3, posy;
    private boolean alive;
    private boolean upDown; //if true, ship is up & down on board; false = left * right

    public Ship2()
    {
        // initialise instance variables
        posx = ((int)(Math.random() * (4))); //sets the x postition of the ship
        posy = (int)(Math.random() * 4); //sets the y position
        alive = true;
        int leftRight = ((int)(Math.random() * (2))); //determines if the ship faces up and down or left and right
        if(leftRight == 0)
        {
            upDown = true;
            pos2 = posy + 1;
            pos3 = pos2 + 1;
        }
        else
        {
            upDown = false;
            pos2 = posx + 1;
            pos3 = pos2 + 1;
        }
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

    public void isAlive(int[][] board)
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
            // for(int i = 0; i < board.length; i++)
            // {
            // for(int j = 0; j < board[0].length; j++)
            // {
            // if(i == posx && j == posy || i == pos2 && j == posy || i == pos3 && j == posy)
            // {
            // if(board[i][j] == 1)
            // count++;
            // }
            // }
            // }
        }
        else
        {
            if(board[posx][posy] == 1)
                count++;
            if(board[pos2][posy] == 1)
                count++;
            if(board[pos3][posy] == 1)
                count++;
            // for(int i = 0; i < board.length; i++)
            // {
            // for(int j = 0; j < board[0].length; j++)
            // {
            // if(i == posx && j == posy || i == posx && j == pos2 || i == posx && j == pos3)
            // {
            // if(board[i][j] == 1)
            // count++;
            // }
            // }
            // }
        }
        if(count == 0)
            alive = false;
    }

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
}
