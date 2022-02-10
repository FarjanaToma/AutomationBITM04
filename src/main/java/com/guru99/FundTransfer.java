package com.guru99;

import com.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FundTransfer extends BaseClass {
    public static void main(String[] args) {
        firefox_launch();
        open_URL("http://demo.guru99.com/v4/");
        GuruLogin.managerLogin("mngr376177","YsUgYdE");
        Fund_Transfer();
        firefox_close();
    }
    public static void Fund_Transfer(){
        WebElement FundTransfer=driver.findElement(By.linkText("Fund Transfer"));
        FundTransfer.click();

        WebElement PayersAccountNumber=driver.findElement(By.name("payersaccount"));
        PayersAccountNumber.clear();
        PayersAccountNumber.sendKeys("123456");

        WebElement PayeesAccountNumber=driver.findElement(By.name("payeeaccount"));
        PayeesAccountNumber.clear();
        PayeesAccountNumber.sendKeys("5432212");

        WebElement Amount=driver.findElement(By.name("ammount"));
        Amount.clear();
        Amount.sendKeys("1000");

        WebElement Description=driver.findElement(By.name("desc"));
        Description.clear();
        Description.sendKeys("abcde");

        WebElement Submit=driver.findElement(By.name("AccSubmit"));
        Submit.click();

        WebElement ResetBtn=driver.findElement(By.name("res"));
        ResetBtn.click();
    }
}
