package pages;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class LoginPage {
    WebDriver driver;
    Wait<WebDriver> wait;
    public LoginPage (WebDriver driver){
        this.driver  =driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50)); // ⬅️ اضفت التهيئة هنا

    }

    private final By userNameField = By.xpath("//input[@formcontrolname='username']");
    private final By passwordField = By.xpath("//input[@formcontrolname='password']");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By errorMessage = By.xpath("//strong[contains(text(), 'خطأ في إسم المستخدم')]");
    private final By langDropDownList = By.id("languageDropdown1");
    private final By enChoice = By.xpath("//a[contains(text(), 'اللغة الانجليزية')]");
    private final By arChoice = By.xpath("//a[contains(text(), ' Arabic Language ')]");
    private final By info = By.xpath(("//*[@id=\"login-space\"]/div[1]/div[2]/div[3]/p[1]"));




    public void insertUsername(String username){
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(d -> {
            d.findElement(userNameField);
            return true;
        });
        driver.findElement(userNameField).sendKeys(username);
    }
    public void insertPassword(String password){
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(d -> {
            d.findElement(passwordField);
            return true;
        });
        driver.findElement(passwordField).sendKeys(password);
    }
    public DashboardPage clickOnLoginButton() {
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);
    }
    public String getValidationMassage(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(d -> {
            d.findElement(errorMessage);
            return true;
        });
        return driver.findElement(errorMessage).getText();
    }
    public void clickOnLangDropDownList(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(langDropDownList));
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(d -> {
            d.findElement(langDropDownList).click();
            return true;
        });
//        driver.findElement(langDropDownList).click();
    }
    public void clickOnEnLangChoice(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(enChoice));
//        driver.findElement(enChoice).click();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(d -> {
            d.findElement(enChoice).click();
            return true;
        });
    }
    public void clickOnArLangChoice(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(arChoice));
//        driver.findElement(arChoice).click();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(d -> {
            d.findElement(arChoice).click();
            return true;
        });
    }
    public String getInfoText(){

        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(d -> {
            d.findElement(info);
            return true;
        });
        return driver.findElement(info).getText();
    }
}
