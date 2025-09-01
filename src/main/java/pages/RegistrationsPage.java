package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationsPage {
    WebDriver driver;
    Wait<WebDriver> wait;
    public RegistrationsPage (WebDriver driver){
        this.driver  =driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private final By secretConfidentialLevel = By.xpath("//div[@class='custom-toggle-wrapper toggleConfidentialNameWrapper']//div[2]//span[1]");
    private final By subjectInput = By.xpath("//textarea[@id='transaction-subject']");
    private final By nextStepButton = By.xpath("//button[@class='next-step btn btn-success ng-star-inserted']");
    private final By attachmentNextStepButton = By.xpath("//button[@class='next-step btn btn-success ng-star-inserted']");
    // More generic locator for dropdown: any element with 'ng-arrow-wrapper' in its class
    private final By dropdownButton = By.cssSelector("ng-select[name='selectedDelegateToInternalOrganizations'] span[class='ng-arrow-wrapper']");
    private final By orgChoise = By.xpath("//div[@role='option'][4]");
    private final By delegatonButton = By.xpath("//div[@class='action-btns mb-2 ng-star-inserted']//button[@style='padding: 0 40px']");
    private final By transactionNumber = By.xpath("//p[@class='number']");
    private final By masarLogo = By.xpath("//img[@alt='Masar Icon']");


    public void clickOnSecretConfidentialLevel(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(secretConfidentialLevel));
//        driver.findElement(secretConfidentialLevel).click();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(d -> {
            d.findElement(secretConfidentialLevel).click();
            return true;
        });

    }
    public void enterTransactionSubject(String suject){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(subjectInput));
//        driver.findElement(subjectInput).sendKeys(suject);
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(d -> {
            d.findElement(subjectInput);
            return true;
        });
        driver.findElement(subjectInput).sendKeys(suject);

    }
    public void clickOnNextButton(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(nextStepButton));
//        driver.findElement(nextStepButton).click();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(d -> {
            d.findElement(nextStepButton);
            return true;
        });
        driver.findElement(nextStepButton).click();
    }
    public void clickOnAttachmentNextStepButton(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(nextStepButton));
//        driver.findElement(nextStepButton).click();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(d -> {
            WebElement btn = d.findElement(attachmentNextStepButton);
            if (btn.isDisplayed() && btn.isEnabled()) {
                btn.click();
                return true;
            }
            return false;
        });
//        driver.findElement(attachmentNextStepButton).click();
    }
    public void openDropdown(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownMenue));
//        driver.findElement(dropdownMenue).click();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(d -> {
            d.findElement(dropdownButton);
            return true;
        });
        driver.findElement(dropdownButton).click();
    }
    public void chooseOrg(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(orgChoise));
//        driver.findElement(orgChoise).click();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(d -> {
            d.findElement(orgChoise).click();
            return true;
        });
    }
    public void clickOnDelegationButton(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(delegatonButton));
//        driver.findElement(delegatonButton).click();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(d -> {
            d.findElement(delegatonButton).click();
            return true;
        });
    }
    public String getTransactionNumber(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(transactionNumber));
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(d -> {
            d.findElement(transactionNumber);
            return true;
        });
        return driver.findElement(transactionNumber).getText();
    }
    public DashboardPage clickOnGoToDashboardButton(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(goToDashboardButton));
//        driver.findElement(goToDashboardButton).click();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(d -> {
            d.findElement(masarLogo).click();
            return true;
        });
        return new DashboardPage(driver);
    }






}
