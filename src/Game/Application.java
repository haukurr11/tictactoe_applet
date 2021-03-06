package Game;

import domain.Player;
import domain.TTTGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


/**
 * Creators: Red Team
 * Date: 23.11.2012
 *
 * The class which generates the graphics and functionality of a {@link Game} object. This class creates a Java Applet
 * which uses the logic from the {@link TTTGame} class to create a playable game of TicTacToe for two players.
 * The players input their names and the number of wins in the current session will be tallied.
 */
public class Application extends JApplet
    implements MouseListener, MouseMotionListener, Runnable
{
    private Player player1, player2;
    private TTTGame ticTacToe;

    /**
     * Main function which creates a new instance of the {@link Application},
     * runs the initializer and starts a new {@link TTTGame}. It also creates
     * the new JFrame for the window of the game and sets it to visible.
     * @param args arguments
     */
    public static void main(String[] args)
    {
        Application ttt = new Application();
        ttt.init();
        ttt.start();
        javax.swing.JFrame window = new javax.swing.JFrame("TicTacToe");
        window.setContentPane(ttt);
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
    }

    /**
     * Initializer for the Java Applet. First it adds a functionality for the mouse so it can be used to play the game.
     * Then it prompts an input box for the players to insert their names, and creates these {@link Player} objects
     * for the current game. Finally, it starts a new game.
     */
    public void init()
    {
        setPreferredSize( new Dimension(500, 500) );
        addMouseListener(this);
        String name1 = JOptionPane.showInputDialog("Name of Player 1");
        String name2 = JOptionPane.showInputDialog("Name of Player 2");
        player1 = new Player(name1);
        player2 = new Player(name2);
        startGame();
    }

    /**
     * Function which starts a new game, but switches the{@link Player}
     * objects so the two players take turns on being the first player.
     */
    public void startGame()
    {
        Player temp = player1;
        player1 = player2;
        player2 = temp;
        ticTacToe = new TTTGame(player2, player1);
        repaint();
    }

    /**
     * Function which determines the actions when a mouse clicks on the game board.
     * Here is also implemented the messages players get when a game finishes, and
     * asks the players whether they want to play another game in the end, which is
     * triggered when the mouse has clicked on the last field available or the field
     * that results in a win for the player.
     * @param e     Determines the {@link MouseEvent} the mouse triggers.
     */
    public void mousePressed( MouseEvent e )
    {
        double x = e.getX();
        double y  = e.getY();
        if(x >= 2 * getWidth() / 3)
        {
            if(y >= 2 * getHeight() / 3)
                ticTacToe.addToBoard(2, 2);
            else if(y >= getHeight() / 3)
                ticTacToe.addToBoard(1, 2);
            else
                ticTacToe.addToBoard(0, 2);
        }
        else if(x >= getWidth() / 3)
        {
            if(y >= 2 * getHeight() / 3)
                ticTacToe.addToBoard(2, 1);
            else if(y >= getHeight() / 3)
                ticTacToe.addToBoard(1, 1);
            else
                ticTacToe.addToBoard(0, 1);
        }
        else
        {
            if(y >= 2 * getHeight() / 3)
                ticTacToe.addToBoard(2, 0);
            else if(y >= getHeight() / 3)
                ticTacToe.addToBoard(1, 0);
            else
                ticTacToe.addToBoard(0, 0);
        }
        repaint();
        int winningStatus = ticTacToe.finished();
        if(winningStatus != -1)
            {
                String win;
                if(winningStatus != 0)
                    {
                        String winnerName;
                        if(winningStatus == 1)
                            winnerName  = ticTacToe.getPlayer1().getName();
                        else
                            winnerName = ticTacToe.getPlayer2().getName();
                        win = winnerName + " has won!, Continue playing?";
                    }
                else win = "Tie! Continue Playing?";
                boolean keepPlaying = JOptionPane.showConfirmDialog(
                                          null, win, "TicTacToe",
                                          JOptionPane.YES_NO_OPTION
                                      ) == 0;
                if(keepPlaying)
                    startGame();
                else System.exit(0);
            }
        e.consume();
    }

    /**
     * Function which handles the graphics of the game board and the symbols players put on it.
     * @param g     The {@link Graphics} object which creates the graphics for the {@link Game}.
     */
    public void paint( Graphics g )
    {
        g.setColor( Color.BLACK);
        g.clearRect(0, 0, getWidth(), getHeight());
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.RED);
        g.drawString(ticTacToe.getPlayer1().getName()
                     + " has " + ticTacToe.getPlayer1().getWins()
                     + " points", 10, 15
                    );
        g.setColor(Color.WHITE);
        g.drawString(ticTacToe.getCurrentPlayer().getName()
                     + "'s turn!", (getWidth() / 3) + 5, 15
                    );
        g.setColor(Color.BLUE);
        g.drawString(ticTacToe.getPlayer2().getName()
                     + " has " + ticTacToe.getPlayer2().getWins()
                     + " points", 2 * getWidth() / 3 + 5, 15);
        g.setColor( Color.WHITE );
        //Draw the tic tac toe lines on background
        g.drawLine( getWidth() / 3, 0, getWidth() / 3, getHeight() );
        g.drawLine( 2 * (getWidth() / 3), 0, 2 * (getWidth() / 3), getHeight() );
        g.drawLine( 0, getHeight() / 3, getWidth(), getHeight() / 3 );
        g.drawLine( 0, getHeight() / 3 * 2, getWidth(), getHeight() / 3 * 2 );

        //make a 2d object to control the thickness
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(8F));  // set stroke getWidth() of 10

        //Set the cool red X color
        g2D.setColor(Color.RED);

        //draw top right
        if(ticTacToe.getValueOnBoard(0, 0) == 1)
            {
                g2D.setColor(Color.RED);
                g2D.drawLine(getWidth() / 3 / 2 - 10, getHeight() / 3 / 2 - 10, getWidth() / 3 / 2 + 10,
                        getHeight() / 3 / 2 + 10);
                g2D.drawLine(getWidth() / 3 / 2 - 10, getHeight() / 3 / 2 + 10, getWidth() / 3 / 2 + 10,
                        getHeight() / 3 / 2 - 10);
            }

        if(ticTacToe.getValueOnBoard(0, 0) == 2)
            {
                g2D.setColor(Color.BLUE);
                g2D.drawOval(getWidth() / 3 / 2 - 10, getHeight() / 3 / 2 - 10, 20, 20);
            }

        //draw top middle
        if(ticTacToe.getValueOnBoard(0,  1) == 1)
            {
                g2D.setColor(Color.RED);
                g2D.drawLine(getWidth() / 2 - 10, getHeight() / 3 / 2 - 10, getWidth() / 2 + 10,
                        getHeight() / 3 / 2 + 10);
                g2D.drawLine(getWidth() / 2 - 10, getHeight() / 3 / 2 + 10, getWidth() / 2 + 10,
                        getHeight() / 3 / 2 - 10);
            }
        if(ticTacToe.getValueOnBoard(0, 1) == 2)
            {
                g2D.setColor(Color.BLUE);
                g2D.drawOval(getWidth() / 2 - 10, getHeight() / 3 / 2 - 10, 20, 20);
            }

        //draw top right
        if(ticTacToe.getValueOnBoard(0, 2) == 1)
            {
                g2D.setColor(Color.RED);
                g2D.drawLine(getWidth() - getWidth() / 3 / 2 - 10, getHeight() / 3 / 2 - 10,
                        getWidth() - getWidth() / 3 / 2 + 10, getHeight() / 3 / 2 + 10);
                g2D.drawLine(getWidth() - getWidth() / 3 / 2 - 10, getHeight() / 3 / 2 + 10,
                        getWidth() - getWidth() / 3 / 2 + 10, getHeight() / 3 / 2 - 10);
            }
        if(ticTacToe.getValueOnBoard(0, 2) == 2)
            {
                g2D.setColor(Color.BLUE);
                g2D.drawOval(getWidth() - getWidth() / 3 / 2 - 10, getHeight() / 3 / 2 - 10, 20, 20);
            }

        //draw middle left
        if(ticTacToe.getValueOnBoard(1, 0) == 1)
            {
                g2D.setColor(Color.RED);
                g2D.drawLine(getWidth() / 3 / 2 - 10, getHeight() / 2 - 10,
                        getWidth() / 3 / 2 + 10, getHeight() / 2 + 10);
                g2D.drawLine(getWidth() / 3 / 2 - 10, getHeight() / 2 + 10,
                        getWidth() / 3 / 2 + 10, getHeight() / 2 - 10);
            }
        if(ticTacToe.getValueOnBoard(1, 0) == 2)
            {
                g2D.setColor(Color.BLUE);
                g2D.drawOval(getWidth() / 3 / 2 - 10, getHeight() / 2 - 10, 20, 20);
            }

        //draw middle mid
        if(ticTacToe.getValueOnBoard(1, 1) == 1)
            {
                g2D.setColor(Color.RED);
                g2D.drawLine(getWidth() / 2 - 10, getHeight() / 2 - 10, getWidth() / 2 + 10, getHeight() / 2 + 10);
                g2D.drawLine(getWidth() / 2 - 10, getHeight() / 2 + 10, getWidth() / 2 + 10, getHeight() / 2 - 10);
            }
        if(ticTacToe.getValueOnBoard(1, 1) == 2)
            {
                g2D.setColor(Color.BLUE);
                g2D.drawOval(getWidth() / 2 - 10, getHeight() / 2 - 10, 20, 20);
            }

        //draw middle right
        if(ticTacToe.getValueOnBoard(1, 2) == 1)
            {
                g2D.setColor(Color.RED);
                g2D.drawLine(getWidth() - getWidth() / 3 / 2 - 10, getHeight() / 2 - 10,
                        getWidth() - getWidth() / 3 / 2 + 10, getHeight() / 2 + 10);
                g2D.drawLine(getWidth() - getWidth() / 3 / 2 - 10, getHeight() / 2 + 10,
                        getWidth() - getWidth() / 3 / 2 + 10, getHeight() / 2 - 10);
            }
        if(ticTacToe.getValueOnBoard(1, 2) == 2)
            {
                g2D.setColor(Color.BLUE);
                g2D.drawOval(getWidth() - getWidth() / 3 / 2 - 10, getHeight() / 2 - 10, 20, 20);
            }

        //draw bottom left
        if(ticTacToe.getValueOnBoard(2, 0) == 1)
            {
                g2D.setColor(Color.RED);
                g2D.drawLine(getWidth() / 3 / 2 - 10, getHeight() - getHeight() / 3 / 2 - 10, getWidth() / 3 / 2 + 10,
                        getHeight() - getHeight() / 3 / 2 + 10);
                g2D.drawLine(getWidth() / 3 / 2 - 10, getHeight() - getHeight() / 3 / 2 + 10, getWidth() / 3 / 2 + 10,
                        getHeight() - getHeight() / 3 / 2 - 10);
            }

        if(ticTacToe.getValueOnBoard(2, 0) == 2)
            {
                g2D.setColor(Color.BLUE);
                g2D.drawOval(getWidth() / 3 / 2 - 10, getHeight() - getHeight() / 3 / 2 - 10, 20, 20);
            }

        //draw bottom middle
        if(ticTacToe.getValueOnBoard(2, 1) == 1)
            {
                g2D.setColor(Color.RED);
                g2D.drawLine(getWidth() / 2 - 10, getHeight() - getHeight() / 3 / 2 - 10, getWidth() / 2 + 10,
                        getHeight() - getHeight() / 3 / 2 + 10);
                g2D.drawLine(getWidth() / 2 - 10, getHeight() - getHeight() / 3 / 2 + 10, getWidth() / 2 + 10,
                        getHeight() - getHeight() / 3 / 2 - 10);
            }
        if(ticTacToe.getValueOnBoard(2, 1) == 2)
            {
                g2D.setColor(Color.BLUE);
                g2D.drawOval(getWidth() / 2 - 10, getHeight() - getHeight() / 3 / 2 - 10, 20, 20);
            }

        //draw bottom right
        if(ticTacToe.getValueOnBoard(2, 2) == 1)
            {
                g2D.setColor(Color.RED);
                g2D.drawLine(getWidth() - getWidth() / 3 / 2 - 10, getHeight() - getHeight() / 3 / 2 - 10,
                        getWidth() - getWidth() / 3 / 2 + 10, getHeight() - getHeight() / 3 / 2 + 10);
                g2D.drawLine(getWidth() - getWidth() / 3 / 2 - 10, getHeight() - getHeight() / 3 / 2 + 10,
                        getWidth() - getWidth() / 3 / 2 + 10, getHeight() - getHeight() / 3 / 2 - 10);
            }
        if(ticTacToe.getValueOnBoard(2, 2) == 2)
            {
                g2D.setColor(Color.BLUE);
                g2D.drawOval(getWidth() - getWidth() / 3 / 2 - 10, getHeight() - getHeight() / 3 / 2 - 10, 20, 20);
            }
    }

    /**
     * These functions implement the actions of the mouse.
     * @param e The event which the mouse triggers.
     */
    public void mouseReleased( MouseEvent e)
    {
        e.consume();
    }

    /**
     * This function might be used in the future.
     * @param e The event which the mouse triggers.
     */
    public void mouseMoved( MouseEvent e )
    {
    }

    /**
     * This function might be used in the future.
     * @param e The event which the mouse triggers.
     */
    public void mouseEntered( MouseEvent e )
    {
    }

    /**
     * This function might be used in the future.
     * @param e The event which the mouse triggers.
     */
    public void mouseExited( MouseEvent e )
    {
    }

    /**
     * This function might be used in the future.
     * @param e The event which the mouse triggers.
     */
    public void mouseClicked( MouseEvent e )
    {
    }

    /**
     * This function might be used in the future.
     * @param e The event which the mouse triggers.
     */
    public void mouseDragged( MouseEvent e )
    {
    }

    /**
     * This function might be used in the future.
     */
    @Override
    public void run()
    {
        init();
    }
}

