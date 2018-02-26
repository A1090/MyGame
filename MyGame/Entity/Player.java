package com.MyGame.Entity;

import com.MyGame.Game;
import com.MyGame.Handler;
import com.MyGame.ID;
import com.MyGame.Input.Sound;
import com.MyGame.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;

/**
 * @author Andreina
 */
public class Player extends MnmEntity{

    private static int facing;
    private static int Scor=0;
    private static int Coins = 0;

    private BufferedImage playerimage = null;
    public Player(int _x, int _y, int _width, int _height, boolean _solid,ID _entityID, Handler _handler)
    {
        super(_x, _y, _width, _height, _solid, _entityID, _handler);
        playerimage = Utils.loadImage(new File("res/mnmright.png"));
    }

    @Override
    public void display(Graphics gf)
    {
        if (playerimage != null)
            gf.drawImage(playerimage, x, y, null);
    }

    @Override
    public void update()
    {
        if(facing==0)
            playerimage = Utils.loadImage(new File("res/mnmright.png"));
        else
            playerimage =Utils.loadImage(new File("res/mnmleft.png"));
        x += velX;
        y += velY;
        if(x<=0)
            x = 0;
        if(y<=0)
            y = 0;
        if(x >= 1080)
            x = 1080 ;
        if(y >= 675)
            y = 675 ;

        for(Tile t:handler.getTileList())
        {
            if(!t.isSolid()) break;
            if(t.getID()==ID.Wall)
            {
                if(getBoundsTop().intersects(t.getBounds()))
                {
                    setVelY(0);
                    y=t.getY()+t.height;
                }
                if(getBoundsBottom().intersects(t.getBounds()))
                {
                    setVelY(0);
                    y=t.getY()-height;
                }
                if(getBoundsLeft().intersects(t.getBounds()))
                {
                    setVelX(0);
                    x=t.getX()+t.width;
                }
                if(getBoundsRight().intersects(t.getBounds()))
                {
                    setVelX(0);
                    x=t.getX()-width;
                }
            }
        }

        Iterator<Monsters> it = handler.getMonsterlist().iterator();
        while(it.hasNext())
        {
            Monsters m  = it.next();
            if(!m.solid) break;
            if(getBounds().intersects(m.getBoundsTop()))
            {
                setVelY(0);
                it.remove();
                Sound collide;
                collide=new Sound("res/collide.wav");
                collide.start();
                Game.setLives(Game.getLives()-1);
                if(Game.getLives()<=0)
                {
                    handler.getEntitylist().remove();
                }
            }
            if(getBounds().intersects(m.getBoundsBottom()))
            {
                setVelY(0);
                it.remove();
                Sound collide;
                collide=new Sound("res/collide.wav");
                collide.start();
                Game.setLives(Game.getLives()-1);
                if(Game.getLives()<=0)
                {
                    handler.getEntitylist().remove();
                }
            }
            if(getBounds().intersects(m.getBoundsLeft()))
            {
                setVelX(0);
                Scor+=1;
               it.remove();
                Sound collide;
                collide=new Sound("res/collide.wav");
                collide.start();
            }
            if(getBounds().intersects(m.getBoundsRight()))
            {
                setVelX(0);
                it.remove();
                Sound collide;
                collide=new Sound("res/collide.wav");
                collide.start();
                Game.setLives(Game.getLives()-1);
                if(Game.getLives()<=0)
                {
                    handler.getEntitylist().remove();
                }
            }
        }
        Iterator<Coins> itc = handler.getCoinlist().iterator();
        while(itc.hasNext())
        {
            Coins c = itc.next();
            if(getBounds().intersects(c.getBounds()))
            {
                Coins+=1;
                itc.remove();
            }
        }
    }
    public void setVelX(int velX)
    {
        this.velX = velX;
    }

    public void setVelY(int velY)
    {
        this.velY = velY;
    }

    public static void setFacing(int facing)
    {
        Player.facing = facing;
    }

    public static int getScor()
    {
        return Scor;
    }

    public static int getCoins()
    {
        return Coins;
    }
}