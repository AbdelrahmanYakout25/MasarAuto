package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    WebDriver driver;
    WebDriverWait wait;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private final By statChart = By.xpath("(//div[@class='col-6'])[3]");
    //private final By sideMenuIcon = By.xpath("//span[@class='sidebarToggle z-2 ng-star-inserted']");
    private final By registrationsIcon = By.xpath("//i[@class='icon-registrations']");
    private final By transactionRegisterationChoice =By.xpath("//a[@href='/registrations/transaction-registration']");
    private final By outboxTab = By.xpath("//*[@id=\"__Outbox\"]");
    private final By transactionNumberInDashboard = By.xpath("//*[@id=\"--transaction-table\"]/tbody/tr[1]/td/table/tbody/tr[1]/td[2]/span/span/a");


    public WebElement assertOnLogo(){
        // ننتظر ظهور اللوجو
        wait.until(ExpectedConditions.visibilityOfElementLocated(statChart));
        return driver.findElement(statChart);
    }

    public void hoverOnRegistratinsIcon(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(registrationsIcon));
        WebElement element = driver.findElement(registrationsIcon);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void clickOnOutboxTab (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(outboxTab));
        driver.findElement(outboxTab).click();
    }

    public String getTransactionNumber (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(transactionNumberInDashboard));
        return driver.findElement(transactionNumberInDashboard).getText();
    }

    public RegistrationsPage clickOnTransactionRegistration(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(transactionRegisterationChoice));
        driver.findElement(transactionRegisterationChoice).click();
        return  new RegistrationsPage(driver);
    }
}
