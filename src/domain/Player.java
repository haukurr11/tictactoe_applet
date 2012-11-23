package domain;

public class Player
{
    String name;
    private int wins = 0;
    public Player() { wins = 0; }
    public void getInput()
    {

    }
    public Player(String name)
    {
       this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public int getWins()
    {
        return wins;
    }
}
