package com.soft.kgl.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileUtils {

    private FileUtils() {
        // Do nothing
    }

    public static void saveImage(String filePath, BufferedImage img) {
        try {
            ImageIO.write(img, "png", new File(filePath));
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
