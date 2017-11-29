public class Player
{
    public Board board;
    
    public Player(int boardSize)
    {
        board = new Board(boardSize);
        board.shipsToArray();
    }
    
}