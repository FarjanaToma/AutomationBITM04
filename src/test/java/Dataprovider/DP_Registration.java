package Dataprovider;

import com.Base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class DP_Registration extends BaseClass {
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
        driver.get("https://demo.opencart.com");
        System.out.println("Before Suite Executed");
    }
    @AfterSuite
    public static void chrome_close() {driver.close();System.out.println("After suite executed");}

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

    @Test(dataProvider = "Registration_Data")
    public static void valid_TestCase(String DP_firstName,
                                      String DP_lastName,
                                      String DP_Email,
                                      String DP_Telephone,
                                      String DP_Password,
                                      String DP_ConfirmPassword){

        //Implement extent report
        htmlReporter=new ExtentHtmlReporter("./ExtentReports/Registration.html");
        reports=new ExtentReports();
        reports.attachReporter(htmlReporter);

        //Information add to report
        reports.setSystemInfo("Project Name","Opencart");
        reports.setSystemInfo("Module Name","Login");
        reports.setSystemInfo("Browser","Chrome");
        reports.setSystemInfo("Test By","Toma");

        test= reports.createTest("Registration");

            WebElement MyAccount=driver.findElement(By.linkText("My Account"));
            MyAccount.click();
            test.log(Status.INFO,"My Account button click");

            WebElement Register=driver.findElement(By.linkText("Register"));
            Register.click();
            test.log(Status.INFO,"Registration button click");

            WebElement FirstName=driver.findElement(By.name("firstname"));
            FirstName.clear();
            FirstName.sendKeys(DP_firstName);
            test.log(Status.INFO,"firstName type:" +DP_firstName);

            WebElement LastName=driver.findElement(By.name("lastname"));
            LastName.clear();
            LastName.sendKeys(DP_lastName);
            test.log(Status.INFO,"lastName type:" +DP_lastName);

            WebElement Email=driver.findElement(By.name("email"));
            Email.clear();
            Email.sendKeys(DP_Email);
            test.log(Status.INFO,"Email type:" +DP_Email);

            WebElement Telephone=driver.findElement(By.name("telephone"));
            Telephone.clear();
            Telephone.sendKeys(DP_Telephone);
            test.log(Status.INFO,"Telephone type:" +DP_Telephone);

            WebElement Password=driver.findElement(By.name("password"));
            Password.clear();
            Password.sendKeys(DP_Password);
            test.log(Status.INFO,"Password type:" +DP_Password);

            WebElement ConfirmPassword=driver.findElement(By.name("confirm"));
            ConfirmPassword.clear();
            ConfirmPassword.sendKeys(DP_ConfirmPassword);
            test.log(Status.INFO,"ConfirmPassword type:" +DP_ConfirmPassword);

            WebElement PrivacyPolicy=driver.findElement(By.name("agree"));
            PrivacyPolicy.click();
            test.log(Status.INFO,"PrivacyPolicy button click");

            WebElement Continue=driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
            Continue.click();
            test.log(Status.INFO,"Continue button click");

            WebElement Logout=driver.findElement(By.linkText("Logout"));
            Logout.click();
            test.log(Status.INFO,"Logout button click");

            reports.flush();
        }

        @DataProvider(name="Registration_Data")
        public Object [][] data(){
            Object [][] data=new Object[2][6];
            //set
            data [0][0]="Farhan";
            data [0][1]="Rahat";
            data [0][2]="falllrjana.toma55@gmail.com";
            data [0][3]="telephone";
            data [0][4]="rahat05";
            data [0][5]="rahat05";
            return data;
        }

    }

