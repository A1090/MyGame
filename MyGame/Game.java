package com.MyGame;

import com.MyGame.Input.Sound;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author Andreina
 */
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
        GuiFrame gui = new GuiFrame(game);
        gui.showOnScreen("MenuPanel");
    }
}