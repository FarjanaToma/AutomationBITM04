package com.Opencart;

import com.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Registration extends BaseClass {

    public static void main(String[] args) {
        firefox_launch();
        open_URL("https://demo.opencart.com/");
        TC_Registration_001();
        firefox_close();
    }
    public static void TC_Registration_001(){
        WebElement MyAccount=driver.findElement(By.linkText("My Account"));
        MyAccount.click();

        WebElement Register=driver.findElement(By.linkText("Register"));
        Register.click();

        WebElement FirstName=driver.findElement(By.name("firstname"));
        FirstName.clear();
        FirstName.sendKeys("Farhan");

        WebElement LastName=driver.findElement(By.name("lastname"));
        LastName.clear();
        LastName.sendKeys("Rahat");

        WebElement Email=driver.findElement(By.name("email"));
        Email.clear();
        Email.sendKeys("toma.farhan.4@gmail.com");

        WebElement Telephone=driver.findElement(By.name("telephone"));
        Telephone.clear();
        Telephone.sendKeys("Telephone");

        WebElement Password=driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys("Telephone");

        WebElement ConfirmPassword=driver.findElement(By.name("confirm"));
        ConfirmPassword.clear();
        ConfirmPassword.sendKeys("Telephone");

        WebElement PrivacyPolicy=driver.findElement(By.name("agree"));
        PrivacyPolicy.click();

        WebElement Continue=driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
        Continue.click();

        WebElement Logout=driver.findElement(By.linkText("Logout"));
        Logout.click();
    }
}
