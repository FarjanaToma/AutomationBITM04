package com.Opencart;

import com.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoginTest_Properties extends BaseClass {

    public static void main(String[] args) throws IOException {
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

    public static void TC_Login_001() throws IOException {

      FileInputStream fis=new FileInputStream("./src/PropertiesFiles/config.properties");
        Properties prop=new Properties();
        prop.load(fis);

        WebElement Email=driver.findElement(By.id("input-email"));
        Email.clear();
        Email.sendKeys(prop.getProperty("valid_Email"));

findElementByIdAndType("input-email","valid_Email");
        WebElement Password=driver.findElement(By.id("input-password"));
        Password.clear();
        Password.sendKeys("Telephone");

        WebElement LoginBtn=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        LoginBtn.click();
    }
}
