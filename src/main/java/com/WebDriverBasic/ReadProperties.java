package com.WebDriverBasic;

import com.Base.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties extends BaseClass {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("./src/PropertiesFiles/config.properties");
        Properties prop=new Properties();
        prop.load(fis);
        System.out.println(prop.getProperty("valid_Email"));

    }
}
