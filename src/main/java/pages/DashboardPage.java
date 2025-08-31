package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    WebDriver driver;
    Wait<WebDriver> wait;


    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

//    private final By statChart = By.xpath("(//div[@class='col-6'])[3]");
    private final By masarLogo = By.xpath("//img[@alt='Masar Icon']");
    //private final By sideMenuIcon = By.xpath("//span[@class='sidebarToggle z-2 ng-star-inserted']");
    private final By registrationsIcon = By.xpath("//i[@class='icon-registrations']");
    private final By transactionRegisterationChoice =By.xpath("//a[@href='/registrations/transaction-registration']");
    private final By outboxTab = By.xpath("//*[@id=\"__Outbox\"]");
    private final By transactionNumberInDashboard = By.xpath("(//a[@class='badge number ng-star-inserted'])[1]");


    public boolean assertOnLogo(){
        // ننتظر ظهور اللوجو
//        wait.until(ExpectedConditions.visibilityOfElementLocated(masarLogo));
//        return driver.findElement(masarLogo);
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(d -> {
            d.findElement(masarLogo);
            return true;
        });
        return true;
    }

    public void hoverOnRegistratinsIcon(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(registrationsIcon));
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(d -> {
            d.findElement(registrationsIcon);
            return true;
        });
        WebElement element = driver.findElement(registrationsIcon);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void clickOnOutboxTab (){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(outboxTab));
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(d -> {
            d.findElement(outboxTab).click();
            return true;
        });
//        driver.findElement(outboxTab).click();
    }

    public String getTransactionNumber (){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(transactionNumberInDashboard));
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(d -> {
            d.findElement(transactionNumberInDashboard);
            return true;
        });
        return driver.findElement(transactionNumberInDashboard).getText();
    }

    public RegistrationsPage clickOnTransactionRegistration(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(transactionRegisterationChoice));
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(d -> {
            d.findElement(transactionRegisterationChoice);
            return true;
        });
        driver.findElement(transactionRegisterationChoice).click();
        return  new RegistrationsPage(driver);
    }
}
