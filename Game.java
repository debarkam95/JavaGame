//programmer key: n->neutral, f->food, u->userBot
import java.io.*;
import javax.swing.*;
import java.awt.*;

class UserBot
{
    private   int posX;
    private   int posY;
    private   int maxLife;
    private   int curLife;

    public UserBot()
    {
        maxLife=10;
    }

    public void updateXY( int x,  int y)
    {
        posX=x;
        posY=y;
    }

    public void updateMaxLife()
    {
        maxLife++;
    }

    public void updateCurLife(boolean justAte)
    {
        if(justAte==true)
        {
            this.updateMaxLife();
            curLife=maxLife;
        }
        else
            curLife--;
    }


}

class foodItem
{
    public  int posX;
    public  int posY;
}

class Board extends JFrame
{
    private char pBoard[][]= new char[200][200];

    public Board()
    {
        for(int i=0;i<200;i++)
            for(int j=0;j<200;j++)
                pBoard[i][j]='n';
        
        setVisible(true);
        setSize(400,400);
    }

    public void updatePosition( int x,  int y, char c)
    {
        pBoard[x][y]=c;
    }

    public char getPositionValue(int x, int y)
    {
        return pBoard[x][y];
    }

    public void paint(Graphics g)
    {
        for(int i=0;i<200;i++)
        for(int j=0;j<200;j++)
        {
            if(pBoard[i][j]=='f')
            {
                //set color to Green
                g.setColor(Color.GREEN);
        
                //draw rectangle outline
                g.fillRect(2*i,2*j,10,10);
            }
        }
    }

    public void renderBoard()
    {
        repaint();
    }
}



public class Game
{
 
    public static void main(String argv[])throws Exception
    {
        Board b=new Board();

        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.updatePosition(10,50,'f');
        b.updatePosition(110,150,'f');
        b.updatePosition(150,50,'f');
        b.updatePosition(50,50,'f');

        b.renderBoard();
    }
}