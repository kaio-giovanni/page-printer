package com.soft.kgl.utils;

import io.github.cdimascio.dotenv.Dotenv;

public class DotEnvUtils {

    private static final Dotenv dotenv = Dotenv.configure()
            .ignoreIfMissing()
            .load();

    private DotEnvUtils() {
    }

    public static String getChromeDriverUrl() {
        return dotenv.get("CHROME_DRIVER_URL");
    }

}
