package domain;

public class TTTGame extends Game
{
    int[][] board;

    public TTTGame(Player player1, Player player2)
    {
        super(player1,player2);
        board = new int[3][3];
    }

    public int finished()
    {
        if(board[0][0] ==1 && board[0][1]==1 && board[0][2] == 1 )
        {
            return 1;
        }
        if(board[1][0] ==1 && board[1][1]==1 && board[1][2] == 1 )
        {
            return 1;
        }
        if(board[2][0] ==1 && board[2][1]==1 && board[2][2] == 1 )
        {
            return 1;
        }
        if(board[0][0] ==1 && board[1][0]==1 && board[2][0] == 1 )
        {
            return 1;
        }
        if(board[0][1] ==1 && board[1][1]==1 && board[2][1] == 1 )
        {
            return 1;
        }
        if(board[0][2] ==1 && board[1][2]==1 && board[2][2] == 1 )
        {
            return 1;
        }
        if(board[0][0] ==1 && board[1][1]==1 && board[2][2] == 1 )
        {
            return 1;
        }
        if(board[2][0] ==1 && board[1][1]==1 && board[0][2] == 1 )
        {
            return 1;
        }
        return 0;
    }

    public void addToBoard(int x,int y,int value)
    {
         board[x][y]=value;
    }

    public int getValueOnBoard(int x, int y)
    {
       return board[x][y];
    }
}
