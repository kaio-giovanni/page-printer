package com.soft.kgl;

import com.soft.kgl.page.enums.PagesEnum;
import com.soft.kgl.page.factory.PagePrinterFactory;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(name = "MainCli",
        mixinStandardHelpOptions = true,
        version = "1.0",
        description = "Main command line class of project")
public class Main implements Callable<Integer> {

    @Option(names = {"-p", "--page"},
            description = "Page name",
            required = true)
    private String page;

    public static void main (String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call () throws Exception {
        PagesEnum pagesEnum = PagesEnum.valueOf(page);
        var pagePrinter = PagePrinterFactory.getPagePrinter(pagesEnum);
        pagePrinter.makePrint();

        return 0;
    }
}
