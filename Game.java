//programmer key: n->neutral, f->food, u->userBot
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.Math;

class UserBot
{
    private   int posX;
    private   int posY;
    private   int curLife;

    public UserBot()
    {
        curLife=20;
        posX=25;
        posY=25;
    }

    public void updateXY( int x,  int y)
    {
        posX=x;
        posY=y;
    }

    public int getX()
    {
        return posX;
    }

    public int getY()
    {
        return posY;
    }
    public void updateCurLife(int a)
    {
        curLife=curLife+a;
    }

    public int returnCurLife()
    {
        return curLife;
    }
}





class Food
{
    public int x[]=new int[20];
    public int y[]=new int[20];
    public int itemsOnBoard;

    public Food()
    {
        replenish();
    }
    public void replenish()
    {
        int sector=(int)(Math.random()*4);

        switch(sector)
        {
            case 0: 
                    for(int i=0;i<8;i++)
                    {
                        x[i]=(int)(Math.random()*24);
                        y[i]=(int)(Math.random()*24);
                    }

                    for(int i=9;i<12;i++)
                    {
                        x[i]=(int)(Math.random()*24);
                        y[i]=24+(int)(Math.random()*24);
                    }

                    for(int i=12;i<16;i++)
                    {
                        x[i]=24+(int)(Math.random()*24);
                        y[i]=(int)(Math.random()*24);
                    }

                    for(int i=16;i<20;i++)
                    {
                        x[i]=24+(int)(Math.random()*24);
                        y[i]=24+(int)(Math.random()*24);
                    }

                    break;

            case 1: 
                    for(int i=0;i<8;i++)
                    {
                        x[i]=24+(int)(Math.random()*24);
                        y[i]=(int)(Math.random()*24);
                    }

                    for(int i=9;i<12;i++)
                    {
                        x[i]=(int)(Math.random()*24);
                        y[i]=24+(int)(Math.random()*24);
                    }

                    for(int i=12;i<16;i++)
                    {
                        x[i]=24+(int)(Math.random()*24);
                        y[i]=24+(int)(Math.random()*24);
                    }

                    for(int i=16;i<20;i++)
                    {
                        x[i]=(int)(Math.random()*24);
                        y[i]=(int)(Math.random()*24);
                    }

                    break;


            case 2: 
                    for(int i=0;i<8;i++)
                    {
                        x[i]=(int)(Math.random()*24);
                        y[i]=24+(int)(Math.random()*24);
                    }

                    for(int i=9;i<12;i++)
                    {
                        x[i]=(int)(Math.random()*24);
                        y[i]=(int)(Math.random()*24);
                    }

                    for(int i=12;i<16;i++)
                    {
                        x[i]=24+(int)(Math.random()*24);
                        y[i]=(int)(Math.random()*24);
                    }

                    for(int i=16;i<20;i++)
                    {
                        x[i]=24+(int)(Math.random()*24);
                        y[i]=24+(int)(Math.random()*24);
                    }

                    break;

            case 3: 
                    for(int i=0;i<8;i++)
                    {
                        x[i]=24+(int)(Math.random()*24);
                        y[i]=24+(int)(Math.random()*24);
                    }

                    for(int i=9;i<12;i++)
                    {
                        x[i]=(int)(Math.random()*24);
                        y[i]=(int)(Math.random()*24);
                    }

                    for(int i=12;i<16;i++)
                    {
                        x[i]=24+(int)(Math.random()*24);
                        y[i]=(int)(Math.random()*24);
                    }

                    for(int i=16;i<20;i++)
                    {
                        x[i]=(int)(Math.random()*24);
                        y[i]=24+(int)(Math.random()*24);
                    }

                    break;
        }
        itemsOnBoard=20;
    }

}





class Board extends JFrame
{
    private char pBoard[][]= new char[50][50];
    int userMoves;

    public Board()
    {
        for(int i=0;i<50;i++)
            for(int j=0;j<50;j++)
                pBoard[i][j]='n';
        
        setVisible(true);
        setSize(600,700);
    }

    public void updatePosition( int x,  int y, char c)
    {
        pBoard[x][y]=c;
    }

    public char getPositionValue(int x, int y)
    {
        return pBoard[x][y];
    }


    public void copyFood(Food f)
    {
        for(int i=0;i<f.itemsOnBoard;i++)
            pBoard[f.x[i]][f.y[i]]='f';
    }

    public void copyUser(UserBot u)
    {
        pBoard[u.getX()][u.getY()]='u';
        userMoves=u.returnCurLife();
    }



    public void paint(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawLine(0,300,600,300);
        g.drawLine(300,0,300,600);
        g.drawLine(0,600,600,600);
        g.setColor(Color.WHITE);
        g.fillRect(0,601,600,100);
        g.setColor(Color.BLACK);
        g.drawString("Life : "+Integer.toString(userMoves),50,650);

        for(int i=0;i<50;i++)
        for(int j=0;j<50;j++)
        {
            if(pBoard[i][j]=='f')
            {
                //set color to Green
                g.setColor(Color.GREEN);
        
                //draw rectangle outline
                g.fillRect(12*i,12*j,12,12);

            }
            else if(pBoard[i][j]=='u')
            {
                //set color to Green
                g.setColor(Color.RED);
                
                //draw rectangle outline
                g.fillRect(12*i,12*j,12,12);    
            }
            else if(pBoard[i][j]=='e')
            {
                //set color to Green
                g.setColor(Color.WHITE);
                pBoard[i][j]='n';
                //draw rectangle outline
                g.fillRect(12*i,12*j,12,12);    
            }
        }

    }

    public void renderBoard()
    {
        repaint();
    }
}


public class Game extends KeyAdapter
{

    Board b=new Board();
    Food f=new Food();
    UserBot ub=new UserBot();

    public Game()
    {
        b.setBackground(Color.WHITE);
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.addKeyListener(this);
        b.copyFood(f);
        b.copyUser(ub);
        b.renderBoard();
    }

    public void keyPressed(KeyEvent evt)
    {
        int x=ub.getX();
        int y=ub.getY();

        if(evt.getKeyChar()=='w' && y>0)
        {
            ub.updateXY(x, y-1);
            b.updatePosition(x, y, 'e');
            b.updatePosition(x, y-1, 'u');
            ub.updateCurLife(-1);
            b.renderBoard();
        }
        else if(evt.getKeyChar()=='a' && x>0)
        {
            ub.updateXY(x-1, y);
            b.updatePosition(x, y, 'e');
            b.updatePosition(x-1, y, 'u');
            ub.updateCurLife(-1);
            b.renderBoard();
        }
        else if(evt.getKeyChar()=='s' && y<49)
        {
            ub.updateXY(x, y+1);
            b.updatePosition(x, y, 'e');
            b.updatePosition(x, y+1, 'u');
            ub.updateCurLife(-1);
            b.renderBoard();
        }
        else if(evt.getKeyChar()=='d' && x<49)
        {
            ub.updateXY(x+1, y);
            b.updatePosition(x, y, 'e');
            b.updatePosition(x+1, y, 'u');
            ub.updateCurLife(-1);
            b.renderBoard();
        }
        b.copyUser(ub);
    }

}

class GamePlay
{
    public static void main(String argv[])throws Exception
    {
        
        Game g=new Game();
        
    }
}