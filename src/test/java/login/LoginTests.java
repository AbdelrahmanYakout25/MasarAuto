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

    @Test
    public void testInvalidUsername(){
        loginPage.insertUsername("adminxxx");
        loginPage.insertPassword("P@$$w0rd");
        loginPage.clickOnLoginButton();
        String actual = loginPage.getValidationMassage();
        String expect = "خطأ في إسم المستخدم أو كلمة المرور";
        assertTrue(actual.contains(expect));
    }

    @Test
    public void testInvalidPassword(){
        loginPage.insertUsername("admin");
        loginPage.insertPassword("P@$$w0rdxxx");
        loginPage.clickOnLoginButton();
        String actual = loginPage.getValidationMassage();
        String expect = "خطأ في إسم المستخدم أو كلمة المرور";
        assertTrue(actual.contains(expect));
    }

}
