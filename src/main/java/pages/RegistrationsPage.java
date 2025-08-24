package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationsPage {
    WebDriver driver;
    WebDriverWait wait;
    public RegistrationsPage (WebDriver driver){
        this.driver  =driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private final By secretConfidentialLevel = By.xpath("//div[@class='custom-toggle-wrapper toggleConfidentialNameWrapper']//div[2]//span[1]");
    private final By subjectInput = By.xpath("//textarea[@id='transaction-subject']");
    private final By nextStepButton = By.xpath("//*[@id=\"page-body\"]/app-root/app-layout/div[2]/perfect-scrollbar/div/div[1]/app-registrations/div/app-router/app-transaction-registration/div/div[2]/button");
    private final By dropdownButton =By.xpath("//*[@id=\"page-body\"]/app-root/app-layout/div[2]/perfect-scrollbar/div/div[1]/app-registrations/div/app-router/app-transaction-registration/div/div[3]/div[5]/app-transaction-referral/div/div[2]/div/form/div/div[2]/div/div/ng-select/div/span");
    private final By orgChoise = By.xpath("//div[@role=\"option\"][4]");
    private final By delegatonButton = By.xpath("//*[@id=\"page-body\"]/app-root/app-layout/div[2]/perfect-scrollbar/div/div[1]/app-registrations/div/app-router/app-transaction-registration/div/div[3]/div[5]/app-transaction-referral/div/div[4]/button[1]");
    private final By transactionNumber = By.xpath("//*[@id=\"page-body\"]/app-root/app-layout/div[2]/perfect-scrollbar/div/div[1]/app-registrations/div/app-router/app-transaction-registration/div/div[3]/div[6]/div[1]/div[2]/div/div[2]/p[2]");
    private final By goToDashboardButton = By.xpath("//*[@id=\"page-body\"]/app-root/app-layout/app-header/header/nav/a/img");


    public void clickOnSecretConfidentialLevel(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(secretConfidentialLevel));
        driver.findElement(secretConfidentialLevel).click();
    }
    public void enterTransactionSubject(String suject){
        wait.until(ExpectedConditions.visibilityOfElementLocated(subjectInput));
        driver.findElement(subjectInput).sendKeys(suject);
    }
    public void clickOnNextButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(nextStepButton));
        driver.findElement(nextStepButton).click();
    }
    public void clickOnNextButton2(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(nextStepButton));
        driver.findElement(nextStepButton).click();
    }
    public void openDropdown(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownButton));
        driver.findElement(dropdownButton).click();
    }
    public void chooseOrg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(orgChoise));
        driver.findElement(orgChoise).click();
    }
    public void clickOnDelegationButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(delegatonButton));
        driver.findElement(delegatonButton).click();
    }
    public String getTransactionNumber(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(transactionNumber));
        return driver.findElement(transactionNumber).getText();
    }
    public DashboardPage clickOnGoToDashboardButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(goToDashboardButton));
        driver.findElement(goToDashboardButton).click();
        return new DashboardPage(driver);
    }






}
