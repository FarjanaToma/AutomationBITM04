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

public class DP_Deposit extends BaseClass {
    //public static WebDriver driver;

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

    @Test(dataProvider = "Deposit Data_valid")

    public static void Deposit_Data(String DP_AccountNumber,
                                    String DP_Amount,
                                    String DP_Description){

        //Implement extent report
        htmlReporter=new ExtentHtmlReporter("./ExtentReports/Deposit.html");
        reports=new ExtentReports();
        reports.attachReporter(htmlReporter);

        //Information add to report
        reports.setSystemInfo("Project Name","Guru99");
        reports.setSystemInfo("Module Name","Deposit");
        reports.setSystemInfo("Browser","firefox");
        reports.setSystemInfo("Test By","Toma");

        test= reports.createTest("Deposit");

        WebElement Deposit=driver.findElement(By.linkText("Deposit"));
        Deposit.click();
        test.log(Status.INFO,"Deposit button click");

        WebElement AccountNumber=driver.findElement(By.name("accountno"));
        AccountNumber.clear();
        AccountNumber.sendKeys(DP_AccountNumber);
        test.log(Status.INFO,"AccountNumber type:" +DP_AccountNumber);

        WebElement Amount=driver.findElement(By.name("ammount"));
        Amount.clear();
        Amount.sendKeys(DP_AccountNumber);
        test.log(Status.INFO,"Amount type:" +DP_Amount);

        WebElement Description=driver.findElement(By.name("desc"));
        Description.clear();
        Description.sendKeys(DP_Description);
        test.log(Status.INFO,"Description type:" +DP_Description);

        WebElement Submit=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[12]/td[2]/input[1]"));
        Submit.click();
        test.log(Status.INFO," Submit button click");

     //   WebElement ResetBtn=driver.findElement(By.name("res"));
      //  ResetBtn.click();
      //  test.log(Status.INFO,"ResetBtn button click");

        test.log(Status.PASS,"Test case executed");

        reports.flush();

    }

    @DataProvider(name="Deposit Data_valid")
    public Object [][] data(){
        Object [][] data=new Object[2][3];
        //set
        data [0][0]="5432212";
        data [0][1]="1000";
        data [0][2]="abcde";

        return data;

    }
}
