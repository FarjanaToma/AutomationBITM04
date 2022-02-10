package com.Google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    public static WebDriver driver;
    public static void main(String[] args) {
        chrome_launch();
        open_URL("https://www.google.com/");
        Google_Search();
        chrome_close();

    }
    public static void chrome_launch(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/Drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static void open_URL(String URL){driver.get(URL);}

    public static void Google_Search(){
        WebElement GoogleSearch=driver.findElement(By.name("q"));
        GoogleSearch.clear();
        GoogleSearch.sendKeys("Dhaka");

        WebElement GoogleSearchBtn=driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]"));
        GoogleSearchBtn.click();
    }

    public static void chrome_close(){driver.close();}

}
