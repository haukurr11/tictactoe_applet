package Game;

import domain.Player;
import domain.TTTGame;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Application extends JApplet
        implements MouseListener, MouseMotionListener
{
    Player player1, player2;
    TTTGame tictactoe;

    public void init()
    {
        addMouseListener(this);
        String name1 = JOptionPane.showInputDialog("Name of Player 1");
        String name2 = JOptionPane.showInputDialog("Name of Player 2");
        player1 = new Player(name1);
        player2 = new Player(name2);
        startGame();
    }
    public void startGame()
    {
        Player temp = player1;
        player1 = player2;
        player2 = temp;
        tictactoe = new TTTGame(player2,player1);
        repaint();
    }
    public void mousePressed( MouseEvent e )
    {
            double x = e.getX();
            double y  = e.getY();
            if(x >= 2*getWidth()/3)
            {
               if(y>=2*getHeight()/3)
                  tictactoe.addToBoard(2,2);
               else if(y>=getHeight()/3)
                   tictactoe.addToBoard(1,2);
               else
                   tictactoe.addToBoard(0,2);
            }
            else if(x >= getWidth()/3)
            {
               if(y>=2*getHeight()/3)
                   tictactoe.addToBoard(2,1);
               else if(y>=getHeight()/3)
                   tictactoe.addToBoard(1,1);
               else
                   tictactoe.addToBoard(0,1);
            }
            else
            {
               if(y>=2*getHeight()/3)
                tictactoe.addToBoard(2,0);
               else if(y>=getHeight()/3)
                tictactoe.addToBoard(1,0);
               else
                tictactoe.addToBoard(0,0);
            }
            repaint();
            if(tictactoe.finished() != -1)
            {
                String win;
                if(tictactoe.finished() != 0)
                    win = "Player " + tictactoe.finished() + " has won!, Continue playing?";
                else win = "Tie! Continue Playing?";
                boolean keepPlaying = JOptionPane.showConfirmDialog(
                null,
                win,
                "TicTacToe",
                JOptionPane.YES_NO_OPTION
                ) == 0;
                if(keepPlaying)
                    startGame();
                else System.exit(0);
            }
            e.consume();
        }
        public void mouseReleased( MouseEvent e) { e.consume(); }
        public void mouseMoved( MouseEvent e ) { }
        public void mouseEntered( MouseEvent e ) { }
        public void mouseExited( MouseEvent e ) { }
        public void mouseClicked( MouseEvent e ) { }
        public void mouseDragged( MouseEvent e ) { }
}

