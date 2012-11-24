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
        //If for player1 wins
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
        //if for player2 wins
        if(board[0][0] ==2 && board[0][1]==2 && board[0][2] == 2 )
        {
            return 2;
        }
        if(board[1][0] ==2 && board[1][1]==2 && board[1][2] == 2 )
        {
            return 2;
        }
        if(board[2][0] ==2 && board[2][1]==2 && board[2][2] == 2 )
        {
            return 2;
        }
        if(board[0][0] ==2 && board[1][0]==2 && board[2][0] == 2 )
        {
            return 2;
        }
        if(board[0][1] ==2 && board[1][1]==2 && board[2][1] == 2 )
        {
            return 2;
        }
        if(board[0][2] ==2 && board[1][2]==2 && board[2][2] == 2 )
        {
            return 2;
        }
        if(board[0][0] ==2 && board[1][1]==2 && board[2][2] == 2 )
        {
            return 2;
        }
        if(board[2][0] ==2 && board[1][1]==2 && board[0][2] == 2 )
        {
            return 2;
        }
        if (turns > 8)
            return 0;          // returns 0 if it was a tie
        return -1; //returns -1 if nobody was the winner
    }

    public void addToBoard(int x,int y)
    {
        if(board[x][y]==0)
        {
            if(turns %2 ==0)
                board[x][y]=1;
            else
                board[x][y]=2;
            turns++;
        }
    }

    public int getValueOnBoard(int x, int y)
    {
       return board[x][y];
    }
}
