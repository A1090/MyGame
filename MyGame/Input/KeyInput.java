package com.MyGame.Input;

import com.MyGame.Entity.MnmEntity;
import com.MyGame.Entity.Player;
import com.MyGame.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Andreina
 */
public class KeyInput implements KeyListener{

private static boolean ispressedup=false;
private static boolean ispresseddown=false;
private static boolean ispressedleft=false;
private static boolean ispressedright=false;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        for(MnmEntity en: Game.getHandler().getEntitylist())
        {
            switch (key) {
                case KeyEvent.VK_UP:
                    en.setVelY(-2);
                    ispressedup = true;
                    break;
                case KeyEvent.VK_DOWN:
                    en.setVelY(2);
                    ispresseddown = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    Player.setFacing(0);
                    en.setVelX(2);
                    ispressedright = true;
                    break;
                case KeyEvent.VK_LEFT:
                    Player.setFacing(1);
                    en.setVelX(-2);
                    ispressedleft = true;
                    break;
            }
            if (ispressedright == ispressedleft)
            {
                en.setVelX(0);
            }
            if(ispresseddown==ispressedup)
            {
                en.setVelY(0);
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        for(MnmEntity en: Game.getHandler().getEntitylist())
        {
            switch (key)
            {
                case KeyEvent.VK_UP:
                    if(ispresseddown==true)
                    {
                        en.setVelY(2);
                    }
                    else
                    en.setVelY(0);
                    ispressedup=false;
                    break;

                case KeyEvent.VK_DOWN:
                    if(ispressedup==true)
                    {
                        en.setVelY(-2);
                    }
                    else
                    en.setVelY(0);
                    ispresseddown=false;
                    break;

                case KeyEvent.VK_RIGHT:
                    if(ispressedleft==true)
                    {
                        en.setVelX(-2);
                        Player.setFacing(1);
                    }
                    else
                    en.setVelX(0);
                    ispressedright=false;
                    break;

                case KeyEvent.VK_LEFT:
                    if(ispressedright==true)
                    {
                        en.setVelX(2);
                        Player.setFacing(0);
                    }
                    else
                    en.setVelX(0);
                    ispressedleft=false;
                    break;
            }
        }
    }
}
