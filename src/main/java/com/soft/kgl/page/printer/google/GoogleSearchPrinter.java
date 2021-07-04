package com.soft.kgl.page.printer.google;

import com.soft.kgl.page.AbstractPagePrinter;
import com.soft.kgl.utils.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

public class GoogleSearchPrinter extends AbstractPagePrinter {

    public GoogleSearchPrinter () {
        super();
    }

    @Override
    protected String getPagePath () {
        return "https://google.com/";
    }

    @Override
    protected int getPageTimeout () {
        return 30;
    }

    @Override
    protected ExpectedCondition<Boolean> makeExpectedConditions () {
        String divBody = "html body div.L3eUgb ";
        String logoGoogle = divBody + "div.o3j99.LLD4me.yr19Zb.LS8OJ div img";
        String searchBar = divBody + "div.o3j99.ikrT4e.om7nvf form div div.A8SBwf div div div.a4bIc input";
        return ExpectedConditions.and(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By
                        .cssSelector(divBody)),
                ExpectedConditions.visibilityOfElementLocated(By
                        .cssSelector(logoGoogle)),
                ExpectedConditions.elementToBeClickable(By
                        .cssSelector(searchBar))
        );
    }

    @Override
    protected WebElement findWebElement () {
        String elementByCss = "html body div.L3eUgb";
        return webDriver.findElement(By.cssSelector(elementByCss));
    }

    @Override
    protected void processImage (BufferedImage img) {
        String fileName = String.format("/tmp/google-search-%s.png", LocalDateTime.now());
        FileUtils.saveImage(fileName, img);
    }
}
