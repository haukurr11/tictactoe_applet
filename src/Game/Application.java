package Game;

import domain.Player;
import domain.TTTGame;

import javax.swing.*;
import java.awt.*;
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

    public void paint( Graphics g ) {
        g.setColor( Color.BLACK);
        g.clearRect(0,0,getWidth(),getHeight());
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.RED);
        g.drawString(player1.getName() + " has " + player1.getWins() + " points",10,15);
        g.setColor(Color.BLUE);
        g.drawString(player2.getName() + " has " + player2.getWins() + " points",2*getWidth()/3 + 5,15);
        g.setColor( Color.WHITE );
        //Draw the tic tac toe lines on background
        g.drawLine( getWidth()/3, 0, getWidth()/3, getHeight() );
        g.drawLine( 2*(getWidth()/3), 0, 2*(getWidth()/3), getHeight() );
        g.drawLine( 0, getHeight()/3, getWidth(), getHeight()/3 );
        g.drawLine( 0, getHeight()/3*2, getWidth(), getHeight()/3*2 );

        //make a 2d object to control the thickness
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(8F));  // set stroke getWidth() of 10

        //Set the cool red X color
        g2D.setColor(Color.RED);

        //draw top right
        if(tictactoe.getValueOnBoard(0,0)==1)
        {
            g2D.setColor(Color.RED);
            g2D.drawLine(getWidth()/3/2-10,getHeight()/3/2-10,getWidth()/3/2+10,getHeight()/3/2+10);
            g2D.drawLine(getWidth()/3/2-10,getHeight()/3/2+10,getWidth()/3/2+10,getHeight()/3/2-10);
        }

        if(tictactoe.getValueOnBoard(0,0)==2)
        {
            g2D.setColor(Color.BLUE);
            g2D.drawOval(getWidth()/3/2-10,getHeight()/3/2-10,20,20);
        }

        //draw top middle
        if(tictactoe.getValueOnBoard(0,1)==1)
        {
            g2D.setColor(Color.RED);
            g2D.drawLine(getWidth()/2-10,getHeight()/3/2-10,getWidth()/2+10,getHeight()/3/2+10);
            g2D.drawLine(getWidth()/2-10,getHeight()/3/2+10,getWidth()/2+10,getHeight()/3/2-10);
        }
        if(tictactoe.getValueOnBoard(0,1)==2)
        {
            g2D.setColor(Color.BLUE);
            g2D.drawOval(getWidth()/2-10,getHeight()/3/2-10,20,20);
        }

        //draw top right
        if(tictactoe.getValueOnBoard(0,2)==1)
        {
            g2D.setColor(Color.RED);
            g2D.drawLine(getWidth()-getWidth()/3/2-10,getHeight()/3/2-10,getWidth()-getWidth()/3/2+10,getHeight()/3/2+10);
            g2D.drawLine(getWidth()-getWidth()/3/2-10,getHeight()/3/2+10,getWidth()-getWidth()/3/2+10,getHeight()/3/2-10);
        }
        if(tictactoe.getValueOnBoard(0,2)==2)
        {
            g2D.setColor(Color.BLUE);
            g2D.drawOval(getWidth()-getWidth()/3/2-10,getHeight()/3/2-10,20,20);
        }

        //draw middle left
        if(tictactoe.getValueOnBoard(1,0)==1)
        {
            g2D.setColor(Color.RED);
            g2D.drawLine(getWidth()/3/2-10,getHeight()/2-10,getWidth()/3/2+10,getHeight()/2+10);
            g2D.drawLine(getWidth()/3/2-10,getHeight()/2+10,getWidth()/3/2+10,getHeight()/2-10);
        }
        if(tictactoe.getValueOnBoard(1,0)==2)
        {
            g2D.setColor(Color.BLUE);
            g2D.drawOval(getWidth()/3/2-10,getHeight()/2-10,20,20);
        }

        //draw middle mid
        if(tictactoe.getValueOnBoard(1,1)==1)
        {
            g2D.setColor(Color.RED);
            g2D.drawLine(getWidth()/2-10,getHeight()/2-10,getWidth()/2+10,getHeight()/2+10);
            g2D.drawLine(getWidth()/2-10,getHeight()/2+10,getWidth()/2+10,getHeight()/2-10);
        }
        if(tictactoe.getValueOnBoard(1,1)==2)
        {
            g2D.setColor(Color.BLUE);
            g2D.drawOval(getWidth()/2-10,getHeight()/2-10,20,20);
        }

        //draw middle right
        if(tictactoe.getValueOnBoard(1,2)==1)
        {
            g2D.setColor(Color.RED);
            g2D.drawLine(getWidth()-getWidth()/3/2-10,getHeight()/2-10,getWidth()-getWidth()/3/2+10,getHeight()/2+10);
            g2D.drawLine(getWidth()-getWidth()/3/2-10,getHeight()/2+10,getWidth()-getWidth()/3/2+10,getHeight()/2-10);
        }
        if(tictactoe.getValueOnBoard(1,2)==2)
        {
            g2D.setColor(Color.BLUE);
            g2D.drawOval(getWidth()-getWidth()/3/2-10,getHeight()/2-10,20,20);
        }

        //draw bottom left
        if(tictactoe.getValueOnBoard(2,0)==1)
        {
            g2D.setColor(Color.RED);
            g2D.drawLine(getWidth()/3/2-10,getHeight()-getHeight()/3/2-10,getWidth()/3/2+10,getHeight()-getHeight()/3/2+10);
            g2D.drawLine(getWidth()/3/2-10,getHeight()-getHeight()/3/2+10,getWidth()/3/2+10,getHeight()-getHeight()/3/2-10);
        }

        if(tictactoe.getValueOnBoard(2,0)==2)
        {
            g2D.setColor(Color.BLUE);
            g2D.drawOval(getWidth()/3/2-10,getHeight()-getHeight()/3/2-10,20,20);
        }

        //draw bottom middle
        if(tictactoe.getValueOnBoard(2,1)==1)
        {
            g2D.setColor(Color.RED);
            g2D.drawLine(getWidth()/2-10,getHeight()-getHeight()/3/2-10,getWidth()/2+10,getHeight()-getHeight()/3/2+10);
            g2D.drawLine(getWidth()/2-10,getHeight()-getHeight()/3/2+10,getWidth()/2+10,getHeight()-getHeight()/3/2-10);
        }
        if(tictactoe.getValueOnBoard(2,1)==2)
        {
            g2D.setColor(Color.BLUE);
            g2D.drawOval(getWidth()/2-10,getHeight()-getHeight()/3/2-10,20,20);
        }

        //draw bottom right
        if(tictactoe.getValueOnBoard(2,2)==1)
        {
            g2D.setColor(Color.RED);
            g2D.drawLine(getWidth()-getWidth()/3/2-10,getHeight()-getHeight()/3/2-10,getWidth()-getWidth()/3/2+10,getHeight()-getHeight()/3/2+10);
            g2D.drawLine(getWidth()-getWidth()/3/2-10,getHeight()-getHeight()/3/2+10,getWidth()-getWidth()/3/2+10,getHeight()-getHeight()/3/2-10);
        }
        if(tictactoe.getValueOnBoard(2,2)==2)
        {
            g2D.setColor(Color.BLUE);
            g2D.drawOval(getWidth()-getWidth()/3/2-10,getHeight()-getHeight()/3/2-10,20,20);
        }
    }

        public void mouseReleased( MouseEvent e) { e.consume(); }
        public void mouseMoved( MouseEvent e ) { }
        public void mouseEntered( MouseEvent e ) { }
        public void mouseExited( MouseEvent e ) { }
        public void mouseClicked( MouseEvent e ) { }
        public void mouseDragged( MouseEvent e ) { }
}

