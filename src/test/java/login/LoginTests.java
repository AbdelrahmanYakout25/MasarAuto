package login;

import base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.DashboardPage;

import  static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    public void testvalidUsernameandPassword(){
        loginPage.insertUsername("admin");
        loginPage.insertPassword("P@$$w0rd");
       DashboardPage dashboardPage = loginPage.clickOnLoginButton();
        Assert.assertTrue(dashboardPage.assertOnLogo().isDisplayed());


    }

}
