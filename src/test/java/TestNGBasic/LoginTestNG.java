package TestNGBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTestNG{
    public static WebDriver driver;

@BeforeTest
    public static void chrome_launch() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/index.php?route=account/login");
    }
    @AfterTest
    public static void chrome_close() {

        driver.close();
    }
    @Test
    public static void valid_TestCase(){

        WebElement Email=driver.findElement(By.id("input-email"));
        Email.clear();
        Email.sendKeys("farjana.toma.1990@gmail.com");

        WebElement Password=driver.findElement(By.id("input-password"));
        Password.clear();
        Password.sendKeys("Rahat0505@");

        WebElement LoginBtn=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        LoginBtn.click();
    }
    @Test
    public static void invalid_TestCase(){

        WebElement Email=driver.findElement(By.id("input-email"));
        Email.clear();
        Email.sendKeys("toma.farhan.4@gmail.com");

        WebElement Password=driver.findElement(By.id("input-password"));
        Password.clear();
        Password.sendKeys("2133213edfsfs");

        WebElement LoginBtn=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        LoginBtn.click();
    }
}
