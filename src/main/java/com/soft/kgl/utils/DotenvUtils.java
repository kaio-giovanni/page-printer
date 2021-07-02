package com.soft.kgl.utils;

import io.github.cdimascio.dotenv.Dotenv;

public class DotenvUtils {

    private static final Dotenv dotenv = Dotenv.configure()
            .ignoreIfMissing()
            .load();

    private DotenvUtils() {
    }

    public static String getChromeDriverUrl() {
        return dotenv.get("CHROME_DRIVER_URL");
    }

}
