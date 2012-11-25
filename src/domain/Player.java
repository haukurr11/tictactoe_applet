package domain;

/**
 * Creators: Red Team
 * Date: 23.11.2012
 *
 *  This is a class which creates players for a {@link Game} object. It includes a constructor which sets a name for
 *  the player in a form of a string. It also has two get-functions, one to return the name of the player and one to
 *  get an integer value of number of wins in the current {@link Game}.
 */

public class Player
{
    private String name;
    private int wins = 0;

    /**
     * Constructor which sets the wins to 0
     */
    public Player()
    {
        wins = 0;
    }

    /**
     * Constructor which sets a name to the Player object which is being created.
     * @param name  Name of the player, in a form of a String.
     */
    public Player(String name)
    {
       this.name = name;
       this.wins = 0;
    }

    /**
     * Function which returns the name of the player.
     * @return  A name which is set to the player in the current {@link Game}
     */
    public String getName()
    {
        return name;
    }

    /**
     * Function which returns how often the player has won the current {@link Game}
     * @return  Number of wins for the current player.
     */
    public int getWins()
    {
        return wins;
    }

    /**
     * Function which increases the number of wins for player.
     */
    public void increaseWins()
    {
        wins++;
    }
}
