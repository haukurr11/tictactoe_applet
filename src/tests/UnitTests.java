package tests;

import domain.Player;
import domain.TTTGame;
import junit.framework.TestCase;

/**
 * This test class handles the UnitTest for {@link TTTGame} & {@link Player},
 * and tests all the possible ways a player can win.
 */
public class UnitTests extends TestCase
{
    /**
     * Checks if a {@link Player} can create a name.
     */
    public void testPlayer()
    {
        Player player = new Player("name");
        assertEquals(player.getName(), "name");
        assertEquals("name", "name");
        assertEquals(player.getWins(), 0);
    }

    /**
     * Checks if the {@link Player} objects can be added to the game and if the
     * {@link TTTGame} board is empty at the start.
     */
    public void testStartGame()
    {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        TTTGame game = new TTTGame(player1, player2);
        assertNotNull(game.getPlayer1());
        assertNotNull(game.getPlayer2());
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                assertEquals(game.getValueOnBoard(i, j), 0);

    }

    /**
     * Checks if a {@link Player} can win a game by getting a
     * horizontal line.
     */
    public void testHorizontalWin()
    {

        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        TTTGame game = new TTTGame(player1, player2);
        //Horizontal test for player 1
        game.addToBoard(0, 1);
        game.addToBoard(1, 1);
        game.addToBoard(0, 2);
        game.addToBoard(1, 2);
        game.addToBoard(0, 0);
        assertEquals(1, game.finished());

        game = new TTTGame(player1, player2);
        game.addToBoard(1, 0);
        game.addToBoard(0, 0);
        game.addToBoard(1, 1);
        game.addToBoard(0, 1);
        game.addToBoard(1, 2);
        assertEquals(1, game.finished());

        game = new TTTGame(player1, player2);
        game.addToBoard(2, 0);
        game.addToBoard(0, 0);
        game.addToBoard(2, 1);
        game.addToBoard(1, 1);
        game.addToBoard(2, 2);
        assertEquals(1, game.finished());


        //Horizontal test for player 2
        game = new TTTGame(player1, player2);
        game.addToBoard(1, 0);
        game.addToBoard(0, 0);
        game.addToBoard(1, 1);
        game.addToBoard(0, 1);
        game.addToBoard(2, 0);
        game.addToBoard(0, 2);
        assertEquals(2, game.finished());

        game = new TTTGame(player1, player2);
        game.addToBoard(2, 0);
        game.addToBoard(1, 0);
        game.addToBoard(2, 1);
        game.addToBoard(1, 1);
        game.addToBoard(0, 1);
        game.addToBoard(1, 2);
        assertEquals(2, game.finished());


        game = new TTTGame(player1, player2);
        game.addToBoard(0, 0);
        game.addToBoard(2, 0);
        game.addToBoard(0, 1);
        game.addToBoard(2, 1);
        game.addToBoard(1, 0);
        game.addToBoard(2, 2);
        assertEquals(2, game.finished());

    }

    /**
     * Checks if a {@link Player} can win a game by getting a
     * diagonal line.
     */
    public void testCrossWin()
    {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        TTTGame game = new TTTGame(player1, player2);
        //Test Cross for player 1
        game.addToBoard(0, 0);
        game.addToBoard(1, 0);
        game.addToBoard(1, 1);
        game.addToBoard(2, 0);
        game.addToBoard(2, 2);
        assertEquals(1, game.finished());
        game = new TTTGame(player1, player2);
        game.addToBoard(0, 2);
        game.addToBoard(0, 1);
        game.addToBoard(1, 1);
        game.addToBoard(0, 0);
        game.addToBoard(2, 0);
        assertEquals(1, game.finished());
        game = new TTTGame(player1, player2);
        game.addToBoard(0, 1);
        game.addToBoard(0, 0);
        game.addToBoard(0, 2);
        game.addToBoard(1, 1);
        game.addToBoard(2, 1);
        game.addToBoard(2, 2);
        assertEquals(2, game.finished());
        game = new TTTGame(player1, player2);
        game.addToBoard(0, 0);
        game.addToBoard(0, 2);
        game.addToBoard(0, 1);
        game.addToBoard(1, 1);
        game.addToBoard(1, 0);
        game.addToBoard(2, 0);
        assertEquals(2, game.finished());
    }

    /**
     * Checks if a {@link Player} can win a game by getting a
     * vertical line.
     */
    public void testVerticalWin()
    {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");

        TTTGame game = new TTTGame(player1, player2);
        game.addToBoard(0, 0);
        game.addToBoard(0, 1);
        game.addToBoard(1, 0);
        game.addToBoard(1, 1);
        game.addToBoard(2, 0);
        assertEquals(1, game.finished());

        game = new TTTGame(player1, player2);
        game.addToBoard(0, 1);
        game.addToBoard(0, 2);
        game.addToBoard(1, 1);
        game.addToBoard(1, 2);
        game.addToBoard(2, 1);
        assertEquals(1, game.finished());

        game = new TTTGame(player1, player2);
        game.addToBoard(0, 2);
        game.addToBoard(1, 1);
        game.addToBoard(1, 2);
        game.addToBoard(1, 0);
        game.addToBoard(2, 2);
        assertEquals(1, game.finished());


        //vertical test for player 2
        game = new TTTGame(player1, player2);
        game.addToBoard(0, 1);
        game.addToBoard(0, 0);
        game.addToBoard(1, 1);
        game.addToBoard(1, 0);
        game.addToBoard(0, 2);
        game.addToBoard(2, 0);
        assertEquals(2, game.finished());

        game = new TTTGame(player1, player2);
        game.addToBoard(0, 2);
        game.addToBoard(0, 1);
        game.addToBoard(1, 2);
        game.addToBoard(1, 1);
        game.addToBoard(1, 0);
        game.addToBoard(2, 1);
        assertEquals(2, game.finished());

        game = new TTTGame(player1, player2);
        game.addToBoard(0, 0);
        game.addToBoard(0, 2);
        game.addToBoard(1, 0);
        game.addToBoard(1, 2);
        game.addToBoard(1, 1);
        game.addToBoard(2, 2);
        assertEquals(2, game.finished());

    }

    /**
     * Checks if a game can end in a stalemate.
     */
    public void testStalemate()
    {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        TTTGame game = new TTTGame(player1, player2);
        game.addToBoard(0, 0);
        game.addToBoard(0, 1);
        game.addToBoard(1, 2);
        game.addToBoard(1, 0);
        game.addToBoard(1, 1);
        game.addToBoard(0, 2);
        game.addToBoard(2, 0);
        game.addToBoard(2, 2);
        game.addToBoard(2, 1);
        assertEquals(0, game.finished());
    }
}
