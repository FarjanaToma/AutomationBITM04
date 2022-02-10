package com.guru99;

import com.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Withdraw extends BaseClass {
    public static void main(String[] args) {
        firefox_launch();
        open_URL("http://demo.guru99.com/v4/");
        GuruLogin.managerLogin("mngr376177","YsUgYdE");
        Amount_Withdrawal_Form();
        firefox_close();
    }
    public static void Amount_Withdrawal_Form(){
        WebElement WithdrawalMoney=driver.findElement(By.linkText("Withdrawal"));
        WithdrawalMoney.click();

        WebElement AccountNumber=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[6]/td[2]/input"));
        AccountNumber.clear();
        AccountNumber.sendKeys("5432212");

        WebElement Amount=driver.findElement(By.name("ammount"));
        Amount.clear();
        Amount.sendKeys("1000");

        WebElement Description=driver.findElement(By.name("desc"));
        Description.clear();
        Description.sendKeys("abcde");

        WebElement Submit=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[12]/td[2]/input[1]"));
        Submit.click();

        WebElement ResetBtn=driver.findElement(By.name("res"));
        ResetBtn.click();
    }
}
