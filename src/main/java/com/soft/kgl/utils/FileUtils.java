package com.soft.kgl.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileUtils {

    private static final Log logger = LogFactory.getLog(FileUtils.class);

    private FileUtils () {
        // Do nothing
    }

    public static void saveImage (String fileName, BufferedImage img) {
        try {
            File tmpFile = File.createTempFile(fileName, ".png");
            ImageIO.write(img, "png", tmpFile);
            logger.info("File successfully created: " + tmpFile.getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
