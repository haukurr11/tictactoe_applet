package domain;

public class TTTGame extends Game
{
    int[][] board;

    public TTTGame()
    {
    }

    public TTTGame(Player player1, Player player2)
    {

    }

    public boolean finished()
    {
        return false;
    }

    public void addToBoard(int x,int y)
    {

    }

    public int getValueOnBoard(int x, int y)
    {
       return board[x][y];
    }
}
