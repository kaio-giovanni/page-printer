package com.soft.kgl.page.printer.github;

import com.soft.kgl.page.AbstractPagePrinter;
import com.soft.kgl.utils.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

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
        String bodyPage = "html body div.application-main main#js-pjax-container " +
                "div.container-xl div.gutter-condensed ";
        String targetTag = bodyPage + "div.flex-shrink-0 div div.Box div.Box-body article";
        String elementToBeClickableByCss = bodyPage +
                "div.flex-shrink-0 div div div.Box div.Box-body div div a";
        return ExpectedConditions.and(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By
                        .cssSelector(bodyPage)),
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By
                        .cssSelector(targetTag)),
                ExpectedConditions.elementToBeClickable(By
                        .cssSelector(elementToBeClickableByCss))
        );
    }

    @Override
    protected WebElement findWebElement () {
        String elementByCss = "html body div.application-main main#js-pjax-container ";
        return webDriver.findElement(By.cssSelector(elementByCss));
    }

    @Override
    protected void processImage (BufferedImage img) {
        String fileName = String.format("/tmp/github-profile-%s.png", LocalDateTime.now());
        FileUtils.saveImage(fileName, img);
    }
}
