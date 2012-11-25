package domain;

/**
 * Creators: Red Team
 * Date: 23.11.2012
 *
 * The logic behind the TicTacToe game. It inherits from the abstract {@link Game} class to create an instance of a
 * TicTacToe game for two players. Here we create the game board, functions to make players able to add their symbol
 * to the game board, get the value of each square to determine which player has marked the board and the rules to the
 * game, or how a player can win a game.
 */

public class TTTGame extends Game
{
    private int[][] board;

    /**
     * Constructor which sets the {@link Player} objects for a new {@link Game}.
     * @param player1   The first player of this TicTacToe game.
     * @param player2   The second player of this TicTacToe game.
     */
    public TTTGame(Player player1, Player player2)
    {
        super(player1,player2);
        board = new int[3][3];
    }

    /**
     * Function which sets the logic of the game, or how a player can successfully win the current TicTacToe game.
     * Also, it handles stalemates if they occur.
     * @return      Value 1 if Player1 wins, Value 2 if Player2 wins, and Value 0 if there is a stalemate.
     */
    public int finished()
    {
        //If for player1 wins
        if(board[0][0] ==1 && board[0][1]==1 && board[0][2] == 1 )
            return 1;
        if(board[1][0] ==1 && board[1][1]==1 && board[1][2] == 1 )
            return 1;
        if(board[2][0] ==1 && board[2][1]==1 && board[2][2] == 1 )
            return 1;
        if(board[0][0] ==1 && board[1][0]==1 && board[2][0] == 1 )
            return 1;
        if(board[0][1] ==1 && board[1][1]==1 && board[2][1] == 1 )
            return 1;
        if(board[0][2] ==1 && board[1][2]==1 && board[2][2] == 1 )
            return 1;
        if(board[0][0] ==1 && board[1][1]==1 && board[2][2] == 1 )
            return 1;
        if(board[2][0] ==1 && board[1][1]==1 && board[0][2] == 1 )
            return 1;
        //if for player2 wins
        if(board[0][0] ==2 && board[0][1]==2 && board[0][2] == 2 )
            return 2;
        if(board[1][0] ==2 && board[1][1]==2 && board[1][2] == 2 )
            return 2;
        if(board[2][0] ==2 && board[2][1]==2 && board[2][2] == 2 )
            return 2;
        if(board[0][0] ==2 && board[1][0]==2 && board[2][0] == 2 )
            return 2;
        if(board[0][1] ==2 && board[1][1]==2 && board[2][1] == 2 )
            return 2;
        if(board[0][2] ==2 && board[1][2]==2 && board[2][2] == 2 )
            return 2;
        if(board[0][0] ==2 && board[1][1]==2 && board[2][2] == 2 )
            return 2;
        if(board[2][0] ==2 && board[1][1]==2 && board[0][2] == 2 )
            return 2;
        if (turns > 8)
            return 0;
        return -1;
    }

    /**
     * Function which adds a symbol to the game board and marks the spot for the current {@link Player}. It uses the
     * number of turns played to determine which player marked the following spot.
     * @param x     Determines in what row of the game board to insert the symbol.
     * @param y     Determines in what column of the game board to insert the symbol.
     */
    public void addToBoard(int x,int y)
    {
        if(board[x][y]==0)
        {
            if(turns %2 ==0)
                board[x][y]=1;
            else
                board[x][y]=2;
            turns++;
            if(finished() == 1)
                getPlayer1().increaseWins();
            else if(finished() == 2)
                getPlayer2().increaseWins();
        }
    }

    /**
     * Function which can tell the players if this spot on the game board has already been marked by another player or
     * if it is empty.
     * @param x     Row of the game board which the particular spot is located.
     * @param y     Column of the game board which the particular spot is located.
     * @return      The position of the symbol on the game board.
     */
    public int getValueOnBoard(int x, int y)
    {
       return board[x][y];
    }

    /**
     * Function which will return the current player, whose turn it is to play.
     * @return      The Player whose turn it is to play.
     */
    public Player getCurrentPlayer()
    {
        if(turns % 2 == 0)
           return getPlayer1();
        return getPlayer2();
    }
}
