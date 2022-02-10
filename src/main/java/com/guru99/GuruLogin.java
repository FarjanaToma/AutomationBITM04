package com.guru99;

import com.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GuruLogin extends BaseClass {

    public static void managerLogin(String UserID,String Pass){

        WebElement UserId=driver.findElement(By.name("uid"));
        UserId.clear();
        UserId.sendKeys(UserID);

        WebElement Password=driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys(Pass);

        WebElement LoginBtn=driver.findElement(By.name("btnLogin"));
        LoginBtn.click();
    }
    public static void customerLogin(String UserID,String Pass){

        WebElement UserId=driver.findElement(By.name("uid"));
        UserId.clear();
        UserId.sendKeys(UserID);

        WebElement Password=driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys(Pass);

        WebElement LoginBtn=driver.findElement(By.name("btnLogin"));
        LoginBtn.click();
    }
}
