package tests;

import domain.*;
import junit.framework.TestCase;

public class UnitTests extends TestCase
{
    public void testPlayer()
    {
       Player player = new Player("name");
       assertEquals(player.getName(),"name");
       assertEquals("name","name");
       assertEquals(player.getWins(),0);
    }

    public void testStartGame()
    {
        Player Player1 = new Player("player1");
        Player Player2 = new Player("player2");
        TTTGame game = new TTTGame(Player1, Player2);
        assertNotNull(game.getPlayer1());
        assertNotNull(game.getPlayer2());
        for(int i = 0;i<3;i++)
            for(int j=0;j<3;j++)
                assertEquals(game.getValueOnBoard(i,j),0);
    }
}
