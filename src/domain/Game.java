package domain;

/**
 * Creators: Red Team
 * Date: 23.11.2012
 *
 *  This is an abstract class to create a new game with two players. It sets the two players with a constructor and
 *  uses get-functions to return them as {@link Player} objects. Another function closes the game once a winner has
 *  been established.
 */

public abstract class Game
{
    protected int turns = 0;
    private Player player1;
    private Player player2;

    /**
     * Constuctor which sets the {@link Player} objects for the game.
     * @param player1   First player of the game.
     * @param player2   Second player of the game.
     */
    public Game(Player player1,Player player2)
    {
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * Get-function which gets the {@link Player}
     * object which was set to the first player.
     * @return      A {@link Player} object set to the first player.
     */
    public Player getPlayer1()
    {
        return player1;
    }

    /**
     * Get-function which gets the {@link Player}
     * object which was set to the first player.
     * @return      A {@link Player} object set to the second player.
     */
    public Player getPlayer2()
    {
        return player2;
    }

    /**
     * Function which exits the Game session
     * when it is finished.
     * @return      0, which terminates the game.
     */
    public int finished()
    {
        return 0;
    }
}
