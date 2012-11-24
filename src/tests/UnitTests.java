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

    public void testHorizontalWin()
    {

        Player Player1 = new Player("player1");
        Player Player2 = new Player("player2");
        TTTGame game = new TTTGame(Player1, Player2);
        //Horizontal test for player 1
                   game.addToBoard(0,1);
                   game.addToBoard(1,1);
                   game.addToBoard(0,2);
                   game.addToBoard(1,2);
                   game.addToBoard(0,0);
                   assertEquals(1,game.finished());

            game = new TTTGame(Player1, Player2);
                    game.addToBoard(1,0);
                    game.addToBoard(0,0);
                    game.addToBoard(1,1);
                    game.addToBoard(0,1);
                    game.addToBoard(1,2);
                    assertEquals(1,game.finished());

            game = new TTTGame(Player1, Player2);
                    game.addToBoard(2,0);
                    game.addToBoard(0,0);
                    game.addToBoard(2,1);
                    game.addToBoard(1,1);
                    game.addToBoard(2,2);
                    assertEquals(1,game.finished());


       //Horizontal test for player 2
            game = new TTTGame(Player1, Player2);
                game.addToBoard(1,0);
                game.addToBoard(0,0);
                game.addToBoard(1,1);
                game.addToBoard(0,1);
                game.addToBoard(2,0);
                game.addToBoard(0,2);
                assertEquals(2,game.finished());

           game = new TTTGame(Player1, Player2);
                 game.addToBoard(2,0);
                 game.addToBoard(1,0);
                 game.addToBoard(2,1);
                 game.addToBoard(1,1);
                 game.addToBoard(0,1);
                 game.addToBoard(1,2);
                 assertEquals(2,game.finished());


            game = new TTTGame(Player1, Player2);
                    game.addToBoard(0,0);
                    game.addToBoard(2,0);
                    game.addToBoard(0,1);
                    game.addToBoard(2,1);
                    game.addToBoard(1,0);
                    game.addToBoard(2,2);
                    assertEquals(2,game.finished());

    }

    public void testCrossWin()
    {
        Player Player1 = new Player("player1");
        Player Player2 = new Player("player2");
        TTTGame game = new TTTGame(Player1, Player2);
        //Test Cross for player 1
        game.addToBoard(0,0);
        game.addToBoard(1,0);
        game.addToBoard(1,1);
        game.addToBoard(2,0);
        game.addToBoard(2,2);
        assertEquals(1,game.finished());
        game = new TTTGame(Player1, Player2);
        game.addToBoard(0,2);
        game.addToBoard(0,1);
        game.addToBoard(1,1);
        game.addToBoard(0,0);
        game.addToBoard(2,0);
        assertEquals(1,game.finished());
        game = new TTTGame(Player1, Player2);
        game.addToBoard(0,1);
        game.addToBoard(0,0);
        game.addToBoard(0,2);
        game.addToBoard(1,1);
        game.addToBoard(2,1);
        game.addToBoard(2,2);
        assertEquals(2,game.finished());
        game = new TTTGame(Player1, Player2);
        game.addToBoard(0,0);
        game.addToBoard(0,2);
        game.addToBoard(0,1);
        game.addToBoard(1,1);
        game.addToBoard(1,0);
        game.addToBoard(2,0);
        assertEquals(2,game.finished());
    }
    public void testVerticalWin()
    {
        Player Player1 = new Player("player1");
        Player Player2 = new Player("player2");

        TTTGame game = new TTTGame(Player1, Player2);
            game.addToBoard(0,0);
            game.addToBoard(0,1);
            game.addToBoard(1,0);
            game.addToBoard(1,1);
            game.addToBoard(2,0);
        assertEquals(1,game.finished());

        game = new TTTGame(Player1, Player2);
             game.addToBoard(0,1);
             game.addToBoard(0,2);
             game.addToBoard(1,1);
             game.addToBoard(1,2);
             game.addToBoard(2,1);
            assertEquals(1,game.finished());

        game = new TTTGame(Player1, Player2);
            game.addToBoard(0,2);
            game.addToBoard(1,1);
            game.addToBoard(1,2);
            game.addToBoard(1,0);
            game.addToBoard(2,2);
            assertEquals(1,game.finished());


       //vertical test for player 2
       game = new TTTGame(Player1, Player2);
            game.addToBoard(0,1);
            game.addToBoard(0,0);
            game.addToBoard(1,1);
            game.addToBoard(1,0);
            game.addToBoard(0,2);
            game.addToBoard(2,0);
            assertEquals(2,game.finished());

       game = new TTTGame(Player1, Player2);
            game.addToBoard(0,2);
            game.addToBoard(0,1);
            game.addToBoard(1,2);
            game.addToBoard(1,1);
            game.addToBoard(1,0);
            game.addToBoard(2,1);
            assertEquals(2,game.finished());

       game = new TTTGame(Player1, Player2);
            game.addToBoard(0,0);
            game.addToBoard(0,2);
            game.addToBoard(1,0);
            game.addToBoard(1,2);
            game.addToBoard(1,1);
            game.addToBoard(2,2);
            assertEquals(2,game.finished());

 }
        public void testStalemate()
        {
           Player Player1 = new Player("player1");
           Player Player2 = new Player("player2");
           TTTGame game = new TTTGame(Player1, Player2);
           game.addToBoard(0,0);
           game.addToBoard(0,1);
           game.addToBoard(1,2);
           game.addToBoard(1,0);
           game.addToBoard(1,1);
           game.addToBoard(0,2);
           game.addToBoard(2,0);
           game.addToBoard(2,2);
           game.addToBoard(2,1);
           assertEquals(0,game.finished());
        }
}
