package com.guru99;

import com.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewAccount extends BaseClass {
    public static void main(String[] args){
        firefox_launch();
        open_URL("http://demo.guru99.com/v4/");
        GuruLogin.managerLogin("mngr376177","YsUgYdE");
        New_Account_Form();
        firefox_close();
    }
    public static void New_Account_Form(){
        WebElement NewAccount=driver.findElement(By.linkText("New Account"));
        NewAccount.click();

        WebElement Customerid=driver.findElement(By.name("cusid"));
        Customerid.clear();
        Customerid.sendKeys("12345");

        WebElement AccountTypeDropDown=driver.findElement(By.name("selaccount"));
        Select sel=new Select(AccountTypeDropDown);
        sel.selectByVisibleText("Current");

        WebElement InitialDeposit=driver.findElement(By.name("inideposit"));
        InitialDeposit.clear();
        InitialDeposit.sendKeys("1000");

        WebElement Submit=driver.findElement(By.name("button2"));
        Submit.click();

        WebElement ResetBtn=driver.findElement(By.name("reset"));
        ResetBtn.click();
    }
}
