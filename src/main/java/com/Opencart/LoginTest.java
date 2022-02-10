package com.Opencart;

import com.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest extends BaseClass {

    public static void main(String[] args) {
        chrome_launch();
        open_URL("https://demo.opencart.com/index.php?route=account/login");
        TC_Login_001();
    }
    public static void chrome_launch(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/Drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static void open_URL(String URL){driver.get(URL);}

    public static void TC_Login_001(){

        WebElement Email=driver.findElement(By.id("input-email"));
        Email.clear();
        Email.sendKeys("toma.farhan.4@gmail.com");

        WebElement Password=driver.findElement(By.id("input-password"));
        Password.clear();
        Password.sendKeys("Telephone");

        WebElement LoginBtn=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        LoginBtn.click();
    }
}
