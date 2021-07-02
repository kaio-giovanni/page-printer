package com.soft.kgl.page.factory;

import com.soft.kgl.exceptions.InvalidPagePrinterException;
import com.soft.kgl.page.AbstractPagePrinter;
import com.soft.kgl.page.enums.PagesEnum;
import com.soft.kgl.page.printer.github.GithubProfilePrinter;
import com.soft.kgl.page.printer.google.GoogleSearchPrinter;

public class PagePrinterFactory {

    private PagePrinterFactory(){
        // Do nothing
    }

    public static AbstractPagePrinter getPagePrinter(PagesEnum pagesEnum) throws InvalidPagePrinterException {
        switch (pagesEnum) {
            case GITHUB_PROFILE:
                return new GithubProfilePrinter();
            case GOOGLE_SEARCH:
                return new GoogleSearchPrinter();
            default:
                throw new InvalidPagePrinterException("Invalid page printer");
        }
    }
}
