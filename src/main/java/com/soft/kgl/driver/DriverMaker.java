package com.soft.kgl.driver;

import com.soft.kgl.utils.DotEnvUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverMaker {

    private static DriverMaker instance;
    private static final int SCREEN_WIDTH = 1920;
    private static final int SCREEN_HEIGHT = 1080;
    private final WebDriver webDriver;

    private DriverMaker () {
        System.setProperty("webdriver.chrome.driver", DotEnvUtils.getChromeDriverUrl());
        this.webDriver = new ChromeDriver(getOptions());
        this.webDriver.manage().deleteAllCookies();
        this.webDriver.manage().window().setSize(getDimension());
    }

    public static DriverMaker getInstance () {
        if (instance == null) {
            instance = new DriverMaker();
        }

        return instance;
    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    private ChromeOptions getOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("start-fullscreen");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        return options;
    }

    private static Dimension getDimension () {
        return new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
    }
}
