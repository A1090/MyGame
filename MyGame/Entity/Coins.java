package com.MyGame.Entity;

import com.MyGame.Handler;
import com.MyGame.ID;
import com.MyGame.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author Andreina
 */
public class Coins {

    private BufferedImage coinimage = null;
    private int x, y;
    private boolean solid;
    private ID coinID;
    private Handler handler;

    public Coins(int _x, int _y, boolean _solid, ID _coinID, Handler __handler)
    {
        coinimage = Utils.loadImage(new File("res/coin.png"));
        x = _x;
        y = _y;
        solid = _solid;
        coinID=_coinID;
        handler=__handler;
    }

    public void display(Graphics gf)
    {
        if (coinimage != null)
            gf.drawImage(coinimage, x, y, null);
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public Rectangle getBounds()
    {
        return new Rectangle(getX(),getY(),20,20);
    }
}