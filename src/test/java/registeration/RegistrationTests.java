package registeration;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.RegistrationsPage;

import static org.testng.Assert.assertTrue;

public class RegistrationTests extends BaseTests {


    @Test
    public void testRegisterOutSecretTransaction() throws InterruptedException {
        loginPage.insertUsername("admin");
        loginPage.insertPassword("P@$$w0rd");
        DashboardPage dashboardPage = loginPage.clickOnLoginButton();
        dashboardPage.hoverOnRegistratinsIcon();
        RegistrationsPage registrationsPage = dashboardPage.clickOnTransactionRegistration();
        registrationsPage.clickOnSecretConfidentialLevel();
        String subject = "test automation";
        registrationsPage.enterTransactionSubject(subject);
        registrationsPage.clickOnNextButton();
        Thread.sleep(3000);
        registrationsPage.clickOnNextButton2();
        Thread.sleep(3000);
        registrationsPage.openDropdown();
        registrationsPage.chooseOrg();
        registrationsPage.clickOnDelegationButton();
        String expect = registrationsPage.getTransactionNumber();
        registrationsPage.clickOnGoToDashboardButton();
        dashboardPage.clickOnOutboxTab();
        String actual =dashboardPage.getTransactionNumber();
        assertTrue(actual.contains(expect));
    }

}
