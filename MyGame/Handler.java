package com.MyGame;

import com.MyGame.Entity.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.LinkedList;


/**
 * Created by eu on 11/15/2016.
 */
public class Handler {

    private final Object mutex = new Object();
    private LinkedList<Tile> tileList = new LinkedList<>();
    private LinkedList<Player> entitylist = new LinkedList<>();
    private LinkedList<Monsters> monsterlist = new LinkedList<>();
    private LinkedList<Coins> coinlist = new LinkedList<>();

    public void display(Graphics gf)
    {

        synchronized (mutex)
        {
            Iterator<Player> itp = entitylist.iterator();
            while(itp.hasNext())
                itp.next().display(gf);

            Iterator<Coins> itc = coinlist.iterator();
            while(itc.hasNext())
                itc.next().display(gf);

            Iterator<Monsters> it = monsterlist.iterator();
            while(it.hasNext())
                it.next().display(gf);

            Iterator<Tile> itt = tileList.iterator();
            while(itt.hasNext())
                itt.next().display(gf);

        }
    }

    public void update()
    {
        synchronized (mutex)
        {
            Iterator<Player> itp = entitylist.iterator();
            while(itp.hasNext())
                itp.next().update();

            Iterator<Monsters> itm = monsterlist.iterator();
            while(itm.hasNext())
                itm.next().update();
        }
    }

    public void addCoin(Coins cn)
    {
        coinlist.add(cn);
    }

    public void addTile(Tile ti)
    {
        tileList.add(ti);
    }

    public void addEntity(Player en)
    {
        entitylist.add(en);
    }

    public void addMonster(Monsters en)
    {
        monsterlist.add(en);
    }

    public void createlevel(BufferedImage level)
    {
        int width = level.getWidth();
        int height = level.getHeight();
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                int pixel = level.getRGB(x,y);

                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;

                if(red==0 && green==0 && blue==0) addTile(new Wall(x*28,y*28,40,40,true,ID.Wall,this));
                if(red==0 && green==0 && blue==255) addEntity(new Player(x*28,y*28,40,40,true,ID.Player,this));
                if(red==255 && green==0 && blue==0) addMonster(new Monsters(x*28,y*28,34,34,true,ID.Monsters,this));
                if(red==0 && green==255 && blue==0) addCoin(new Coins(x*28,y*28,true,ID.Coins,this));
            }
        }

    }

    public LinkedList<Tile> getTileList() {
        return tileList;
    }

    public LinkedList<Player> getEntitylist() {
        return entitylist;
    }

    public LinkedList<Monsters> getMonsterlist() {
        return monsterlist;
    }

    public LinkedList<Coins> getCoinlist() {
        return coinlist;
    }
}
