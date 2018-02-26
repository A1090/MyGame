package com.MyGame.Entity;

import com.MyGame.Handler;
import com.MyGame.ID;
import com.MyGame.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

/**
 * @author Andreina
 */
public class Monsters extends MnmEntity{

    private BufferedImage monsterimage = null;
    private Random random = new Random();

    public Monsters(int _x, int _y, int _width, int _height, boolean _solid, ID _entityID, Handler _handler)
    {
        super(_x, _y, _width, _height, _solid, _entityID, _handler);

        monsterimage = Utils.loadImage(new File("res/goomba.png"));

        int dir = random.nextInt(2);
        switch(dir)
        {
            case 0:
                setVelX(-3);
                break;
            case 1:
                setVelX(3);
                break;
        }
    }

    @Override
    public void display(Graphics gf)
    {
        if (monsterimage != null)
            gf.drawImage(monsterimage, x, y, null);
    }

    @Override
    public void update()
    {
        x += velX;
        y += velY;
        if(x<=200)
            setVelX(1);
        if(x>=2000)
            setVelX(-1);

        for(Tile t:handler.getTileList()){
            if(!t.isSolid()) break;
            if(t.getID()==ID.Wall){
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
                    setVelX(1);
                    x=t.getX()+t.width;
                }
                if(getBoundsRight().intersects(t.getBounds()))
                {
                    setVelX(-1);
                    x=t.getX()-width;
                }
            }
        }
    }
}