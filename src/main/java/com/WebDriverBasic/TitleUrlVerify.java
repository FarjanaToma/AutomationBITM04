package com.WebDriverBasic;

import com.Base.BaseClass;

public class TitleUrlVerify extends BaseClass {
    public static void main(String[] args) {
        firefox_launch();
        open_URL("http://google.com");
        title_verification();
        url_verification();
        firefox_close();
    }
    public static void title_verification(){
        String ExpectedTitle="Facebook";
        String ActualTitle=driver.getTitle();
        if(ExpectedTitle.equals(ActualTitle)) {
            System.out.println("Title matched.Test passed.");
        }
        else {
            System.out.println("Tilte did not matched.Test failed.");
        }
    }
    public static void url_verification(){
        String ExpectedUrl="Facebook";
        String ActualUrl=driver.getTitle();
        if(ExpectedUrl.equals(ActualUrl)) {
            System.out.println("Url matched.Test passed.");
        }
        else {
            System.out.println("Url did not matched.Test failed.");
        }
    }
}
