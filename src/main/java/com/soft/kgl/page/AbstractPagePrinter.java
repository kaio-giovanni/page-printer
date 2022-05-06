package com.soft.kgl.page;

import com.soft.kgl.driver.DriverMaker;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import java.awt.image.BufferedImage;

public abstract class AbstractPagePrinter implements IPagePrinter {

    protected final WebDriver webDriver;
    private static final Log logger = LogFactory.getLog(AbstractPagePrinter.class);

    protected AbstractPagePrinter () {
        webDriver = DriverMaker.getInstance().getWebDriver();
    }

    @Override
    public void makePrint () {
        logger.info("Initializing ...");
        int pageTimeout = getPageTimeout();
        String pagePath = getPagePath();
        var wait = new WebDriverWait(webDriver, pageTimeout);
        navigateTo(pagePath);
        WebElement element = loadWebElement(wait);
        Screenshot screenshot = takePrint(element);
        BufferedImage image = screenshot.getImage();
        processImage(image);
        logger.info("Finalizing ...");
    }

    private void navigateTo (String pagePath) {
        logger.info("Navigating to page " + pagePath);
        webDriver.navigate().to(pagePath);
    }

    private WebElement loadWebElement (WebDriverWait wait) {
        logger.info("Trying to load web element");
        int retries = 3;
        while (retries > 0) {
            try {
                wait.until(makeExpectedConditions());
                WebElement element = findWebElement();
                element.click();
                return element;
            } catch (StaleElementReferenceException e) {
                logger.info("Reference element is stale, trying reload");
                retries--;
            }
        }
        throw new NoSuchElementException("No such element");
    }

    public Screenshot takePrint (WebElement webElement) {
        logger.info("Taking screenshot of web element");
        return new AShot().coordsProvider(new WebDriverCoordsProvider())
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(webDriver, webElement);
    }

    protected abstract String getPagePath ();

    protected abstract int getPageTimeout ();

    protected abstract ExpectedCondition<Boolean> makeExpectedConditions ();

    protected abstract WebElement findWebElement ();

    protected abstract void processImage (BufferedImage img);
}
