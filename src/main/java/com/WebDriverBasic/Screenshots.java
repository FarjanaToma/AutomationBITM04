package com.WebDriverBasic;

import com.Base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Screenshots extends BaseClass {
    public static void main(String[] args) throws IOException {
        launch_browser("firefox");
        open_URL("https://demo.opencart.com/");
        getVisiblePartScreenshots();
        browser_close("firefox");
    }
    public static void getVisiblePartScreenshots()throws IOException {
        //screenshot capture
        File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //save screenshot
        FileUtils.copyFile(screenshotFile,new File("./src/Screenshot/ScreenshotImages.png"),true);
    }
}
