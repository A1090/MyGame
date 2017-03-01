package com.MyGame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by eu on 12/22/2016.
 */
public class Utils {

    public static BufferedImage loadImage(File file)
    {
        BufferedImage image = null;
        try
        {
            image = ImageIO.read(file);
        } catch(IOException e)
        {
            System.out.println("read error: " + e.getMessage());
        }
        return image;
    }
}