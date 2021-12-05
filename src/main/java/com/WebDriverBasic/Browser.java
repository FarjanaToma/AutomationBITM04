package com.WebDriverBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Browser {
    public static void main(String[] args) {
        chrome_launch();
        firefox_launch();
        chrome_close();
        firefox_close();

    }
    public static void chrome_launch() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/Drivers/chromedriver.exe");
        driver=new ChromeDriver();
    }
    public static void firefox_launch() {
        System.setProperty("webdriver.gecko.driver", "./src/main/resources/Drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }



    }
}
