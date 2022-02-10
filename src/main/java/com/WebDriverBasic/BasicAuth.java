package com.WebDriverBasic;

import com.Base.BaseClass;

public class BasicAuth extends BaseClass {
    public static void main(String[] args) {
        firefox_launch();
        basic_auth();
        System.out.println(driver.getTitle());
    }
    public static void basic_auth(){
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
}
