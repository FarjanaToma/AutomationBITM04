package TestNGBasic;

import org.testng.annotations.*;

public class BasicAction {

    @BeforeTest
 public static void browserConfig(){
        System.out.println("Sucessfully Browser Config");
    }
    @AfterTest
    public static void closeTest(){
        System.out.println("Browser Close");
    }

    @BeforeMethod
public static void OpenTestUrl(){
        System.out.println("URL Launched");
    }
@AfterMethod
public static void Verification(){
        System.out.println("Verification Done");
}

    @Test
    public static void testcase_001(){
        System.out.println("Testcase 1 Executed");
    }
    @Test
    public static void testcase_002(){
        System.out.println("Testcase 2 Executed");
    }
}
