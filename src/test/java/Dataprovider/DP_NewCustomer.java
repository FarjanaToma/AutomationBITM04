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
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class DP_NewCustomer extends BaseClass {
  // public static WebDriver driver;

    //Extent Report
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports reports;
    public static ExtentTest test;

    @BeforeSuite
    public static void  launch_browser() {
        launch_browser("firefox");
        open_URL("http://demo.guru99.com/v4/");
        GuruLogin.managerLogin("mngr380255","sAnejan");
        System.out.println("Before Suite Executed");
    }
    @AfterSuite
    public static void browser_close() {browser_close("firefox");System.out.println("After suite executed");}

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


    @Test(dataProvider = "NewCustomer_Data")
    public static void NewCustomer(String DP_CustomerName,
                                      String DP_DateOfBirth,
                                      String DP_Address,
                                      String DP_City,
                                      String DP_State,
                                      String DP_PIN,
                                      String DP_MobileNumber,
                                      String DP_Email,
                                      String DP_Password){

        //Implement extent report
        htmlReporter=new ExtentHtmlReporter("./ExtentReports/NewCustomer.html");
        reports=new ExtentReports();
        reports.attachReporter(htmlReporter);

        //Information add to report
        reports.setSystemInfo("Project Name","Guru99");
        reports.setSystemInfo("Module Name","New Customer");
        reports.setSystemInfo("Browser","firefox");
        reports.setSystemInfo("Test By","Toma");

        test= reports.createTest("NewCustomer");

        WebElement NewCustomer=driver.findElement(By.linkText("New Customer"));
        NewCustomer.click();
        test.log(Status.INFO,"New Customer button click");

        WebElement CustomerName=driver.findElement(By.name("name"));
        CustomerName.clear();
        CustomerName.sendKeys(DP_CustomerName);
        test.log(Status.INFO,"CustomerName type:" +DP_CustomerName);

        WebElement Gender=driver.findElement(By.name("rad1"));
        Gender.click();
        test.log(Status.INFO,"Gender button click");

        WebElement DateOfBirth=driver.findElement(By.name("dob"));
        DateOfBirth.clear();
        DateOfBirth.sendKeys(DP_DateOfBirth);
        test.log(Status.INFO,"DateOfBirth type:" +DP_DateOfBirth);

        WebElement Address=driver.findElement(By.name("addr"));
        Address.clear();
        Address.sendKeys(DP_Address);
        test.log(Status.INFO,"Address type:" +DP_Address);

        WebElement City=driver.findElement(By.name("city"));
        City.clear();
        City.sendKeys(DP_City);
        test.log(Status.INFO,"City type:" +DP_City);

        WebElement State=driver.findElement(By.name("state"));
        State.clear();
        State.sendKeys(DP_State);
        test.log(Status.INFO,"State type:" +DP_State);

        WebElement Pin=driver.findElement(By.name("pinno"));
        Pin.clear();
        Pin.sendKeys(DP_PIN);
        test.log(Status.INFO,"Pin type:" +DP_PIN);

        WebElement MobileNumber=driver.findElement(By.name("telephoneno"));
        MobileNumber.clear();
        MobileNumber.sendKeys(DP_MobileNumber);
        test.log(Status.INFO,"MobileNumber type:" +DP_MobileNumber);

        WebElement Email=driver.findElement(By.name("emailid"));
        Email.clear();
        Email.sendKeys(DP_Email);
        test.log(Status.INFO,"Pin type:" +DP_Email);

        WebElement Password=driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys(DP_Password);
        test.log(Status.INFO,"Password type:" +DP_Password);

        WebElement Submit=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[1]"));
        Submit.click();
        test.log(Status.INFO,"Submit button click");

       /* WebElement ResetBtn=driver.findElement(By.name("res"));
        ResetBtn.click();
        test.log(Status.INFO,"ResetBtn button click");*/

        reports.flush();
    }

    @DataProvider(name="NewCustomer_Data")
    public Object [][] data(){
        Object [][] data=new Object[2][9];
        //set
        data [0][0]="Farhan";
        data [0][1]="2022-01-01";
        data [0][2]="Dhaka";
        data [0][3]="Dhaka";
        data [0][4]="Dhaka";
        data [0][5]="12345";
        data [0][6]="01753856053";
        data [0][7]="test059@gmail.com";
        data [0][8]="t123";

        return data;
    }
}
