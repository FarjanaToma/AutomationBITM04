package Dataprovider;

import com.Base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.guru99.GuruLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class DP_GuruLogin extends BaseClass {
   // public static WebDriver driver;

    //Extent Report
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports reports;
    public static ExtentTest test;

    @BeforeSuite
    public static void launch_browser() {
        launch_browser("firefox");
        open_URL("http://demo.guru99.com/v4/");
        GuruLogin.managerLogin("mngr380255","sAnejan");
    }
    @AfterSuite
    public static void  browser_close() {
        browser_close("firefox");}

    @BeforeTest
    public static void before_test(){
        System.out.println("Before test executed");
    }
    @AfterTest
    public static void after_test(){
        System.out.println("After test executed");
    }

    @BeforeMethod
    public static void before_method(){
        System.out.println("Before method executed");
    }
    @AfterMethod
    public static void after_method(){
        System.out.println("After method executed");
    }

    @Test(dataProvider = "LoginData_valid")
    public static void managerLogin(String DP_UserId,String DP_Password){

        //Implement extent report
        htmlReporter=new ExtentHtmlReporter("./ExtentReports/Gurulogin.html");
        reports=new ExtentReports();
        reports.attachReporter(htmlReporter);

        //Information add to report
        reports.setSystemInfo("Project Name","Guru99");
        reports.setSystemInfo("Module Name","Login");
        reports.setSystemInfo("Browser","firefox");
        reports.setSystemInfo("Test By","Toma");

        test= reports.createTest("GuruLogin");

        WebElement UserId=driver.findElement(By.name("uid"));
        UserId.clear();
        UserId.sendKeys(DP_UserId);
        test.log(Status.INFO,"UserId type:" +DP_UserId);

        WebElement Password=driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys(DP_Password);
        test.log(Status.INFO,"Password type:" +DP_Password);

        WebElement LoginBtn=driver.findElement(By.name("btnLogin"));
        LoginBtn.click();

        test.log(Status.INFO,"LoginBtn button click");

        test.log(Status.PASS,"Test case executed");

        reports.flush();
    }

    @DataProvider(name="LoginData_valid")
    public Object [][] data (){
        Object [][] data =new Object[1][2];
        //set
        data [0][0]="mngr380255";
        data [0][1]="sAnejan";

        return data;

    }
}
