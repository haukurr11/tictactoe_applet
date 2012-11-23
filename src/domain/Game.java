package domain;

public abstract class Game
{
    private int turns = 0;
    Player player1;
    Player player2;
    public int finished()
    {
        return 0;
    }

    public Game(Player player1,Player player2)
    {
        this.player1 = player1;
        this.player2 = player2;
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
