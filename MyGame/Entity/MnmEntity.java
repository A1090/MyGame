package com.MyGame.Entity;

import com.MyGame.Handler;
import com.MyGame.ID;

import java.awt.*;

/**
 * Created by eu on 11/15/2016.
 */
public abstract class MnmEntity {

    public int x,y;
    public int width,height;

    public boolean solid;

    public int velX,velY;

    public ID entityID;

    public Handler handler;

    public MnmEntity(int _x,int _y,int _width,int _height,boolean _solid,ID _entityID,Handler _handler)
    {
        x = _x;
        y = _y;
        width = _width;
        height = _height;
        solid = _solid;
        entityID = _entityID;
        handler = _handler;
    }

    public abstract void display(Graphics gf);

    public abstract void update();


    public ID getID()
    {
        return entityID;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public boolean isSolid()
    {
        return solid;
    }

    public void setIsSolid(Boolean b)
    {
        solid = b;
    }

    public void setVelX(int velX)
    {
        this.velX = velX;
    }

    public void setVelY(int velY)
    {
        this.velY = velY;
    }

    public Rectangle getBounds()
    {
        return new Rectangle(getX(),getY(),width,height);
    }

    public Rectangle getBoundsTop()
    {
        return new Rectangle(getX()+10,getY(),width-20,5);
    }

    public Rectangle getBoundsBottom()
    {
        return new Rectangle(getX()+10,getY()+height-5,width-20,5);
    }

    public Rectangle getBoundsLeft()
    {
        return new Rectangle(getX(),getY()+10,5,height-20);
    }

    public Rectangle getBoundsRight()
    {
        return new Rectangle(getX()+width-5,getY()+10,5,height-20);
    }
}
