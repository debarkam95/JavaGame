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




class CompBot
{
    private int curX,curY,nxtX,nxtY;
    private int curLife;
    public CompBot()
    {
        curX=curY=24;
        curLife=20;
    }

    public int getCurX()
    {
        return curX;
    }

    public int getCurY()
    {
        return curY;
    }

    public int getCurLife()
    {
        return curLife;
    }

    public void computerTurn(Food f, Board b, UserBot ub)
    {
        int minX,minY,minDist,tempDist,userDist,userX,userY,tempX,tempY;
        //firstly find the closest food item that is far from UserBot
        minDist=200000;
        userX=ub.getX();
        userY=ub.getY();
        minX=25;
        minY=25;
        for(int i=0;i<20;i++)
        {
            tempX=f.x[i];
            tempY=f.y[i];
            if(b.getPositionValue(tempX, tempY)=='f') //if food exist
            {
                tempDist=(int)Math.sqrt((int)((curX-tempX)*(curX-tempX)+(curY-tempY)*(curY-tempY)));
                userDist=(int)Math.sqrt((int)((userX-tempX)*(userX-tempX)+(userY-tempY)*(userY-tempY)));
                if(minDist==200000)
                {
                    minDist=tempDist;
                    minX=tempX;
                    minY=tempY;
                }
                else if(tempDist<minDist && tempDist<userDist)
                {
                    minDist=tempDist;
                    minX=tempX;
                    minY=tempY;
                }
            }
        }

        if(minX<curX)
        {
            nxtY=curY;
            nxtX=curX-1;
        }
        else if(minX>curX)
        {
            nxtY=curY;
            nxtX=curX+1;
        }
        else
        {
            if(minY<curY)
            {
                nxtX=curX;
                nxtY=curY-1;
            }
            if(minY>curY)
            {
                nxtX=curX;
                nxtY=curY+1;
            }
        }


        if(b.getPositionValue(nxtX,nxtY)=='f')
        {
            curLife+=21;
            f.itemsOnBoard--;
        }
        b.updatePosition(curX, curY, 'e');
        b.updatePosition(nxtX, nxtY, 'c');
        curLife--;
        curX=nxtX;
        curY=nxtY;
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
    int userMoves,compMoves;

    public Board()
    {
        for(int i=0;i<50;i++)
            for(int j=0;j<50;j++)
                pBoard[i][j]='n';
        
        setVisible(true);
        setSize(600,700);
        pBoard[24][24]='c';
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

    public void copyComp(CompBot cb)
    {
        compMoves=cb.getCurLife();
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
        g.drawString("Comp : "+Integer.toString(compMoves),150,650);
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
            else if(pBoard[i][j]=='c')
            {
                g.setColor(Color.BLACK);
                
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
    CompBot cb=new CompBot();

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
            if(b.getPositionValue(x, y-1)=='f')
            {
                ub.updateCurLife(21);
                f.itemsOnBoard--;
            }
            b.updatePosition(x, y, 'e');
            b.updatePosition(x, y-1, 'u');
            ub.updateCurLife(-1);

        }
        else if(evt.getKeyChar()=='a' && x>0)
        {
            ub.updateXY(x-1, y);
            if(b.getPositionValue(x-1, y)=='f')
            {
                ub.updateCurLife(21);
                f.itemsOnBoard--;
            }
            b.updatePosition(x, y, 'e');
            b.updatePosition(x-1, y, 'u');
            ub.updateCurLife(-1);

        }
        else if(evt.getKeyChar()=='s' && y<49)
        {
            ub.updateXY(x, y+1);
            if(b.getPositionValue(x, y+1)=='f')
            {
                ub.updateCurLife(21);
                f.itemsOnBoard--;
            }
            b.updatePosition(x, y, 'e');
            b.updatePosition(x, y+1, 'u');
            ub.updateCurLife(-1);
           
        }
        else if(evt.getKeyChar()=='d' && x<49)
        {
            ub.updateXY(x+1, y);
            if(b.getPositionValue(x+1, y)=='f')
           {
                ub.updateCurLife(21);
                f.itemsOnBoard--;
            }
            b.updatePosition(x, y, 'e');
            b.updatePosition(x+1, y, 'u');
            ub.updateCurLife(-1);
            
        }

        if(f.itemsOnBoard<=0)
        {
            f.replenish();
            b.copyFood(f);
        }
        //System.out.println(f.itemsOnBoard);
        if(ub.returnCurLife()<=0)
        {
            System.out.println("Player dead");
            System.exit(0);
        }
        cb.computerTurn(f, b, ub);
        if(cb.getCurLife()<=0)
        {
            System.out.println("Computer dead");
            System.exit(0);
        }
        if(f.itemsOnBoard<=0)
        {
            f.replenish();
            b.copyFood(f);
        }
        b.copyUser(ub);
        b.copyComp(cb);
        b.renderBoard();
    }

}

class GamePlay
{
    public static void main(String argv[])throws Exception
    {
        
        Game g=new Game();
        
    }
}