package domain;

public abstract class Game
{
    private int turns = 0;
    Player player1;
    Player player2;
    public boolean finished()
    {
        return false;
    }

    public Player getPlayer1()
    {
        return player1;
    }

    public Player getPlayer2()
    {
        return player2;
    }
}
