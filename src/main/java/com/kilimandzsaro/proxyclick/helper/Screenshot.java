package com.kilimandzsaro.proxyclick.helper;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Screenshot extends Driver {

    private static final String SCREENSHOT_FOLDER = "target/screenshots";

    public Screenshot(WebDriver webDriver) {
        super(webDriver);
    }

    public void capturePageScreenshot() { capturePageScreenshot(null);}

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] capturePageScreenshot(String filename) {
        String filePath = String.format("%s/%s", System.getProperty("user.dir"), SCREENSHOT_FOLDER);
        File logdir =  new File(filePath);
        logdir.mkdirs();
        File path = new File(logdir, normalizeFilename(filename));

        TakesScreenshot takesScreenshot = ((TakesScreenshot) webDriver);
        byte[] png = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        writeScreenshot(path, png);
        Reporter.log("<a href='"+ path.getAbsolutePath() + "'> <img src='"+ path.getAbsolutePath() + "' height='100' width='100'/> </a>");
        return (png);
    }

    // Internal Methods

    protected int screenshotIndex = 0;

    protected void writeScreenshot(File path, byte[] png) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            fos.write(png);
            fos.flush();
        } catch (IOException e) {
                System.out.printf("Can't write screenshot to %s", path.getAbsolutePath());
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    System.out.println("Can't even close stream");
                }
            }
        }
    }

    protected String normalizeFilename(String filename) {
        if (filename == null) {
            screenshotIndex++;
            filename = String.format("selenium-screenshot-%d.png", screenshotIndex);
        } else {
            filename = filename.replace('/', File.separatorChar);
        }
        return filename;
    }
 
    
}
