package pages;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    public LoginPage (WebDriver driver){
        this.driver  =driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50)); // ⬅️ اضفت التهيئة هنا

    }

    private final By userNameField = By.xpath("//input[@formcontrolname='username']");
    private final By passwordField = By.xpath("//input[@formcontrolname='password']");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By errorMessage = By.xpath("//strong[contains(text(), 'خطأ في إسم المستخدم')]");



    public void insertUsername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        driver.findElement(userNameField).sendKeys(username);
    }

    public void insertPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public DashboardPage clickOnLoginButton() {
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);
    }

    public String getValidationMassage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return driver.findElement(errorMessage).getText();
    }
}
