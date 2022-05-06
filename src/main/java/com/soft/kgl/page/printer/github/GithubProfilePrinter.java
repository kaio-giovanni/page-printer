package com.soft.kgl.page.printer.github;

import com.soft.kgl.page.AbstractPagePrinter;
import com.soft.kgl.utils.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.awt.image.BufferedImage;

public class GithubProfilePrinter extends AbstractPagePrinter {

    public GithubProfilePrinter () {
        super();
    }

    @Override
    protected String getPagePath () {
        return "https://github.com/kaio-giovanni";
    }

    @Override
    protected int getPageTimeout () {
        return 30;
    }

    @Override
    protected ExpectedCondition<Boolean> makeExpectedConditions () {
        return (driver -> ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }

    @Override
    protected WebElement findWebElement () {
        String elementByCss = "html body div.application-main main#js-pjax-container ";
        return webDriver.findElement(By.cssSelector(elementByCss));
    }

    @Override
    protected void processImage (BufferedImage img) {
        String fileName = String.format("github-profile-%s.png", System.currentTimeMillis());
        FileUtils.saveImage(fileName, img);
    }
}
