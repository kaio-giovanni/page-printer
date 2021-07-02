package com.soft.kgl.driver.chrome;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverOptions {

    private final ChromeOptions options;

    public ChromeDriverOptions () {
        options = new ChromeOptions();
        makeArgOptions();
    }

    private void makeArgOptions () {
        options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("start-fullscreen");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
    }

    public ChromeOptions getOptions () {
        return options;
    }
}
