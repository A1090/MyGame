package com.MyGame;

import com.MyGame.Entity.Player;
import com.MyGame.Input.Camera;
import com.MyGame.Input.KeyInput;

import java.awt.image.BufferStrategy;

import java.awt.*;

/**
 * Created by eu on 12/22/2016.
 */
public class Display extends Canvas implements  Runnable {


    private Thread thread;
    private boolean isRunning = false;
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 720;
   // public static Camera cam;

    public Display()
    {
        Dimension size = new Dimension(WIDTH , HEIGHT);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
    }

    public synchronized void start()
    {
        if (isRunning) return;
        isRunning = true;
        thread = new Thread(this, "DisplayThread");
        thread.start();
    }

    public synchronized void stop()
    {
        if (!isRunning) return;
        isRunning = false;
        try
        {
            thread.join();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void run()
    {
        requestFocus();
        addKeyListener(new KeyInput());
        //cam=new Camera();
        while (true)
        {
            // 50 fps = 20 ms / frame
            long Timestart = System.currentTimeMillis();
            display();
            while (System.currentTimeMillis() - Timestart < 10)
                try
                {
                    Thread.sleep(5);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
        }
    }

    public void display()
    {
            BufferStrategy bs = getBufferStrategy();
            if(bs == null)
            {
                createBufferStrategy(3);
                return;
            }

            Graphics gf = bs.getDrawGraphics();

            if(!Game.getHandler().getMonsterlist().isEmpty())
            {
                if(Game.getLives()>0)
                {
                    gf.setColor(Color.PINK);
                    gf.fillRect(0,0,getWidth(),getHeight());
                    gf.setColor(Color.WHITE);
                    gf.setFont(new Font("Courier",Font.BOLD,20));
                    gf.drawString("Coins x "+ Player.getCoins(),20,30);
                    gf.drawString("Score : "+Player.getScor(),20,50);
                    gf.drawString("Lives x "+Game.getLives(),20,70);
                    Game.getHandler().display(gf);
                    gf.dispose();
                }
                else if(Game.getLives()==0)
                {
                    gf.setColor(Color.BLACK);
                    gf.fillRect(0,0,getWidth(),getHeight());
                    gf.setColor(Color.WHITE);
                    gf.setFont(new Font("Courier",Font.BOLD,100));
                    gf.drawString("YOU LOST!",350,200);
                    gf.drawString("Coins x "+ Player.getCoins(),370,400);
                    gf.drawString("Score : "+Player.getScor(),400,600);
                  //  Game.getThememusic().interrupt();
                }
            }
            else if(Game.getLives()>0)
            {
                gf.setColor(Color.BLACK);
                gf.fillRect(0,0,getWidth(),getHeight());
                gf.setColor(Color.WHITE);
                gf.setFont(new Font("Courier",Font.BOLD,100));
                gf.drawString("YOU WON!",350,200);
                gf.drawString("Coins x "+ Player.getCoins(),370,400);
                gf.drawString("Score : "+Player.getScor(),400,600);
              //  Game.getThememusic().interrupt();
            }
            else
            {
                gf.setColor(Color.BLACK);
                gf.fillRect(0,0,getWidth(),getHeight());
                gf.setColor(Color.WHITE);
                gf.setFont(new Font("Courier",Font.BOLD,100));
                gf.drawString("YOU LOST!",350,200);
                gf.drawString("Coins x "+ Player.getCoins(),370,400);
                gf.drawString("Score : "+Player.getScor(),400,600);
              //  Game.getThememusic().interrupt();
            }
           // gf.translate(cam.getX(),cam.getY());
            bs.show();
    }

    public static int getWIDTH()
    {
        return WIDTH;
    }

    public static int getHEIGHT()
    {
        return HEIGHT;
    }
}