package com.MyGame;

import com.MyGame.Entity.*;
import com.MyGame.Input.Sound;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Game implements Runnable {


    private static final String Title = "An M&M game";
    private BufferedImage image ;
    private static Sound thememusic;

    private Thread thread;
    private boolean isRunning = false;
    private static int lives=2;

    private static Handler handler;

    public static Handler getHandler()
    {
        return handler;
    }

    public static Sound getThememusic() {
        return thememusic;
    }

    public static int getLives()
    {
        return lives;
    }

    public static void setLives(int lives)
    {
        Game.lives = lives;
    }

    public synchronized void start()
    {
        if (isRunning) return;
        isRunning = true;
        thread = new Thread(this, "GameThread");
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
        initialize();
        System.out.println("Scor initial:" + Player.getScor());

        while (isRunning)
        {
            long time = System.currentTimeMillis();
            handler.update();
            while (System.currentTimeMillis()-time <= 3)
            {
                try
                {
                    Thread.sleep(1);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
        stop();
    }

    private void initialize()
    {
       handler = new Handler();

        image = Utils.loadImage(new File("res/level.png"));

        handler.createlevel(image);

        thememusic=new Sound("res/level.wav");
        thememusic.start();
    }

    public static void main(String[] args)
    {
        Game game = new Game();
        Display display = new Display() ;

        JFrame frame = new JFrame(Title);
        frame.add(display);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        display.start();
        game.start();
    }
}