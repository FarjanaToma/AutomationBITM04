package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class LoginExtent {
    public static WebDriver driver;

    //Extent Report
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports reports;
    public static ExtentTest test;

    @BeforeSuite
    public static void chrome_launch() {
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/Drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.opencart.com/index.php?route=account/login");
            System.out.println("Before Suite Executed");
        }
        @AfterSuite
        public static void chrome_close() {

            driver.close();
            System.out.println("After suite executed");
        }
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

        @Test(description="Email and password are valid")
        public static void valid_TestCase(){

            //Implement extent report
            htmlReporter=new ExtentHtmlReporter("./ExtentReports/LoginTest.html");
            reports=new ExtentReports();
            reports.attachReporter(htmlReporter);

            //Information add to report
            reports.setSystemInfo("Project Name","Opencart");
            reports.setSystemInfo("Module Name","Login");
            reports.setSystemInfo("Browser","Chrome");
            reports.setSystemInfo("Test By","Toma");

            test= reports.createTest("Login test");

            WebElement Email=driver.findElement(By.id("input-email"));
            Email.clear();
            Email.sendKeys("farjana.toma.1990@gmail.com");
            test.log(Status.INFO,"Email type");

            WebElement Password=driver.findElement(By.id("input-password"));
            Password.clear();
            Password.sendKeys("Rahat0505@");
            test.log(Status.INFO,"Password type");

            WebElement LoginBtn=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
            LoginBtn.click();
            test.log(Status.INFO,"Login button click");
            System.out.println("Valid testcase executed");

            test.log(Status.PASS,"Test case executed");

            reports.flush();
        }

    }


