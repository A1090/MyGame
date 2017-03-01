package com.MyGame.Entity;

import com.MyGame.Handler;
import com.MyGame.ID;
import com.MyGame.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by eu on 1/4/2017.
 */
public class Wall extends Tile{

    private BufferedImage wallimage = null;

    public Wall(int _x, int _y, int _width, int _height, boolean _solid, ID _ID, Handler _handler)
    {
        super(_x,_y,_width,_height,_solid,_ID,_handler);
        wallimage = Utils.loadImage(new File("res/wall.jpg"));
    }

    public void display(Graphics gf)
    {
        if (wallimage != null)
            gf.drawImage(wallimage, x, y, null);
    }
}
