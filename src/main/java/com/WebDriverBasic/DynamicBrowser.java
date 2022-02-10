package com.WebDriverBasic;

import com.Base.BaseClass;

public class DynamicBrowser extends BaseClass {
    public static void main(String[] args) {
        launch_browser("firefox");
        open_URL("https://google.com");
        browser_close("firefox");
    }
}
