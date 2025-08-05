package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public WebElement assertOnLogo(){
        // ننتظر ظهور اللوجو
        wait.until(ExpectedConditions.visibilityOfElementLocated(statChart));
        return driver.findElement(statChart);
    }
}
