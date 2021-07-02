package com.soft.kgl.page.printer.google;

import com.soft.kgl.page.AbstractPagePrinter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.awt.image.BufferedImage;

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
        return 10;
    }

    @Override
    protected ExpectedCondition<Boolean> makeExpectedConditions () {
        return null;
    }

    @Override
    protected WebElement findWebElement () {
        return null;
    }

    @Override
    protected void processImage (BufferedImage img) {
        // Do nothing
    }
}
