package com.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class BaseClass {
    public static WebDriver driver;

    public static void chrome_launch() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void firefox_launch() {
        System.setProperty("webdriver.gecko.driver", "./src/main/resources/Drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    public static void launch_browser(String browserName) {
        if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        } else {
            System.out.println("Plz enter valid Browser Name");
        }
    }

    public static void browser_close(String browserName) {
        driver.close();
    }


    public static void chrome_close() {

        driver.close();
    }

    public static void firefox_close() {

        driver.close();
    }

    public static void open_URL(String URL) {
        driver.get(URL);
    }


    //Find Element and click
    public static void findElementByIdAndClick(String id) {
        driver.findElement(By.id(id)).click();
    }

    public static void findElementByNameAndClick(String name) {
        driver.findElement(By.name(name)).click();
    }

    public static void findElementByXpathAndClick(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public static void findElementByCssAndClick(String css) {
        driver.findElement(By.cssSelector(css)).click();
    }

    //Find Element and Type
    public static void findElementByIdAndType(String id, String text) {
        driver.findElement(By.id(id)).sendKeys(text);
    }

    public static void findElementByNameAndType(String name, String text) {
        driver.findElement(By.name(name)).sendKeys(text);
    }

    public static void findElementByXpathAndType(String xpath, String text) {
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    public static void findElementByCssAndType(String css, String text) {
        driver.findElement(By.cssSelector(css)).sendKeys(text);
    }

    //Screenshots
    public static void getVisiblePartScreenshots(String ImageName) throws IOException {
        //screenshot capture
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //save
        FileUtils.copyFile(screenshotFile, new File("./src/ScreenshotImages/" + ImageName + ".jpeg"), true);
    }
}