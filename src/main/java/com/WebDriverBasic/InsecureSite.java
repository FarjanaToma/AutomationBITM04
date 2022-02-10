package com.WebDriverBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class InsecureSite {
    public static WebDriver driver;

    public static void main(String[] args) {

System.setProperty("webdriver.gecko.driver","./src/main/resources/Drivers/geckodriver.exe");
FirefoxOptions obj=new FirefoxOptions();
obj.setAcceptInsecureCerts(true);
driver=new FirefoxDriver();
driver.get("https://cacert.com/");
System.out.println(driver.getTitle());
    }
}
