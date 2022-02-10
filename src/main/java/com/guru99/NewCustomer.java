package com.guru99;

import com.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewCustomer extends BaseClass {
    public static void main(String[] args) {
        firefox_launch();
        open_URL("http://demo.guru99.com/v4/");
        GuruLogin.managerLogin("mngr376177","YsUgYdE");
        Add_New_Customer();
        firefox_close();
    }
    public static void Add_New_Customer(){
        WebElement NewCustomer=driver.findElement(By.linkText("New Customer"));
        NewCustomer.click();

        WebElement CustomerName=driver.findElement(By.name("name"));
        CustomerName.clear();
        CustomerName.sendKeys("Farhan");

        WebElement Gender=driver.findElement(By.name("rad1"));
        Gender.click();

        WebElement DateofBirth=driver.findElement(By.name("dob"));
        DateofBirth.clear();
        DateofBirth.sendKeys("2021-12-24");

        WebElement Address=driver.findElement(By.name("addr"));
        Address.clear();
        Address.sendKeys("Dhaka");

        WebElement City=driver.findElement(By.name("city"));
        City.clear();
        City.sendKeys("Dhaka");

        WebElement State=driver.findElement(By.name("state"));
        State.clear();
        State.sendKeys("Dhaka");

        WebElement Pin=driver.findElement(By.name("pinno"));
        Pin.clear();
        Pin.sendKeys("123456");

        WebElement MobileNumber=driver.findElement(By.name("telephoneno"));
        MobileNumber.clear();
        MobileNumber.sendKeys("01753856056");

        WebElement Email=driver.findElement(By.name("emailid"));
        Email.clear();
        Email.sendKeys("test@gmail.com");

        WebElement Password=driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys("F123");

        WebElement Submit=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[1]"));
        Submit.click();

        WebElement ResetBtn=driver.findElement(By.name("res"));
        ResetBtn.click();
    }
}
