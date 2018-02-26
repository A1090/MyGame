package com.MyGame.Entity;

import com.MyGame.Handler;
import com.MyGame.ID;

import java.awt.*;

/**
 * @author Andreina
 */
public abstract class Tile {


    public int x,y;
    public int width,height;

    public boolean solid;

    public ID ID;

    public Handler handler;

    public Tile(int _x,int _y,int _width,int _height,boolean _solid,ID _ID,Handler _handler)
    {
        x = _x;
        y = _y;
        width = _width;
        height = _height;
        solid = _solid;
        ID = _ID;
        handler = _handler;
    }

    public abstract void display(Graphics gf);

    public ID getID(){
        return ID;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isSolid() {
        return solid;
    }

    public Rectangle getBounds()
    {
        return new Rectangle(getX(),getY(),width,height);
    }

}