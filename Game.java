//programmer key: n->neutral, f->food, u->userBot
import java.io.*;
import javax.swing.*;

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

class Board
{
    private char pBoard[][]= new char[200][200];

    public Board()
    {
        for(int i=0;i<200;i++)
            for(int j=0;j<200;j++)
                pBoard[i][j]='n';
    }

    public void updatePosition( int x,  int y, char c)
    {
        pBoard[x][y]=c;
    }

}

public class Game
{
    public static void main(String argv[])throws Exception
    {
        JFrame gBoard=new JFrame();
        gBoard.setSize(400,400);
        gBoard.setLayout(null);
        gBoard.setVisible(true);
    }
}