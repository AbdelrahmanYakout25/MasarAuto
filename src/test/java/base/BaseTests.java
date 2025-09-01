package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

public class BaseTests {

    protected WebDriver driver;

    protected LoginPage loginPage ;

    @BeforeClass
    public  void setUp (){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--force-device-scale-factor=0.7");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }
    @BeforeMethod
    public void goHome(){
        driver.get("http://tafeel-srv:4023/");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}