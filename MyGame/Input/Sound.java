package com.MyGame.Input;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * @author Andreina
 */
public class Sound extends Thread{

    private String path;

    public Sound(String _path)
    {
        path=_path;
    }
    private final Object MUTEX = new Object();
    private boolean shouldstop;

    public void run()
    {


        try {
            shouldstop=false;
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(path));
            Clip test = AudioSystem.getClip();

            test.open(ais);
            test.start();


            while (!test.isRunning()) {
                Thread.sleep(10);
                if (isStopOrdered()) break;
            }
            while (test.isRunning()) {
                Thread.sleep(10);
                if (isStopOrdered()) break;
            }

            test.stop();
            test.close();
        }catch(IOException | LineUnavailableException |UnsupportedAudioFileException|InterruptedException ex){
            ex.printStackTrace();
        }


    }

    private void orderStop()
    {
       // synchronized(MUTEX)
        {
            shouldstop = true;
        }
    }

    private boolean isStopOrdered()
    {
      //  synchronized(MUTEX)
        {
            return shouldstop;
        }
    }


    @Override
    public void interrupt(){

        orderStop();
    }
}
