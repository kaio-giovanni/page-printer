package com.soft.kgl.driver;

import com.soft.kgl.driver.chrome.ChromeDriverOptions;
import com.soft.kgl.utils.DotenvUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverMaker {

    private static RemoteWebDriver webDriver;
    private static final int SCREEN_WIDTH = 1920;
    private static final int SCREEN_HEIGHT = 1080;

    private DriverMaker () {
        // Do nothing
    }

    public static RemoteWebDriver getInstance () {
        if (webDriver == null) {
            ChromeDriverOptions webDriverOptions = new ChromeDriverOptions();
            webDriver = new RemoteWebDriver(getRemoteUrlDriver(), webDriverOptions.getOptions());
            webDriver.manage().deleteAllCookies();
            webDriver.manage().window().setSize(getDimension());
        }

        return webDriver;
    }

    private static URL getRemoteUrlDriver () {
        try {
            return new URL(DotenvUtils.getChromeDriverUrl());
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private static Dimension getDimension () {
        return new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
    }
}
