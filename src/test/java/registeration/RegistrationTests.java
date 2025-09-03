package registeration;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.RegistrationsPage;


public class RegistrationTests extends BaseTests {

    /**
     * End-to-End Scenario: Create and delegate a transaction
     * Steps:
     * 1. Login using valid username and password.
     * 2. Create a new transaction by following the guided steps.
     * 3. Select "Secret" as the confidentiality level.
     * 4. Enter a subject for the transaction.
     * 5. Click on the "Next Step" button.
     * 6. In the attachment step, click on the "Next Step" button again.
     * 7. Open the organization dropdown list.
     * 8. Choose the required organization.
     * 9. Click on the "Delegation" button.
     * 10. Capture the transaction number when it appears.
     * 11. Assert that the transaction number is displayed at the top of the Outbox transactions list.
     */
    @Test
    public void testRegisterOutSecretTransaction() {
        // Step 1: Login using valid username and password.
        loginPage.insertUsername("admin");
        loginPage.insertPassword("P@$$w0rd");
        DashboardPage dashboardPage = loginPage.clickOnLoginButton();
        // Step 2: Create a new transaction by following the guided steps.
        dashboardPage.hoverOnRegistratinsIcon();
        RegistrationsPage registrationsPage = dashboardPage.clickOnTransactionRegistration();
        // Step 3: Select "Secret" as the confidentiality level.
        registrationsPage.clickOnSecretConfidentialLevel();
        // Step 4: Enter a subject for the transaction.
        String subject = "test automation";
        registrationsPage.enterTransactionSubject(subject);
        // Step 5: Click on the "Next Step" button.
        registrationsPage.clickOnNextButton();
        // Step 6: In the attachment step, click on the "Next Step" button again (wait for button to be clickable).
        // Wait for the attachment next step button to be clickable instead of Thread.sleep
        registrationsPage.clickOnAttachmentNextStepButton();
        // Step 7: Open the organization dropdown list.
        registrationsPage.openDropdown();
        // Step 8: Choose the required organization.
        registrationsPage.chooseOrg();
        // Step 9: Click on the "Delegation" button.
        registrationsPage.clickOnDelegationButton();
        // Step 10: Capture the transaction number when it appears.
        String expect = registrationsPage.getTransactionNumber();
        registrationsPage.clickOnGoToDashboardButton();
        dashboardPage.clickOnOutboxTab();
        String actual =dashboardPage.getTransactionNumber();
        Assert.assertEquals(actual,expect,"not match");
    }
    /**
     * End-to-End Scenario: Create and delegate a transaction
     * Steps:
     * 1. Login using valid username and password.
     * 2. Create a new transaction by following the guided steps.
     * 3. Select "Un Secret" as the confidentiality level(it is default).
     * 4. Enter a subject for the transaction.
     * 5. Click on the "Next Step" button.
     * 6. In the attachment step Upload file.
     * 7. wait for the attachement Uploaded and click on the "Next Step" button again.
     * 8. Open the organization dropdown list.
     * 9. Choose the required organization.
     * 10. Click on the "Delegation" button.
     * 11. Capture the transaction number when it appears.
     * 12. Assert that the transaction number is displayed at the top of the Outbox transactions list.
     */
    @Test
    public void testRegisterOutUnSecretTransaction() {
        // Step 1: Login using valid username and password.
        loginPage.insertUsername("admin");
        loginPage.insertPassword("P@$$w0rd");
        DashboardPage dashboardPage = loginPage.clickOnLoginButton();
        // Step 2: Create a new transaction by following the guided steps.
        dashboardPage.hoverOnRegistratinsIcon();
        RegistrationsPage registrationsPage = dashboardPage.clickOnTransactionRegistration();
        // Step 3: Select "Un Secret" as the confidentiality level(it is default).
        // Step 4: Enter a subject for the transaction.
        String subject = "test automation";
        registrationsPage.enterTransactionSubject(subject);
        // Step 5: Click on the "Next Step" button.
        registrationsPage.clickOnNextButton();
        // Step 6: In the attachment step, upload file.
        String filePath = "F:\\MASAR_test.png";
        registrationsPage.uploadFile(filePath);
        // Step 7: wait for the attachement Uploaded and click on the "Next Step" button again.
        registrationsPage.getAttachementFirestPage();
        registrationsPage.clickOnNextButton();
        // Step 8: Open the organization dropdown list.
        registrationsPage.openDropdown();
        // Step 9: Choose the required organization.
        registrationsPage.chooseOrg();
        // Step 10: Click on the "Delegation" button.
        registrationsPage.clickOnDelegationButton();
        // Step 11: Capture the transaction number when it appears.
        String expect = registrationsPage.getTransactionNumber();
        registrationsPage.clickOnGoToDashboardButton();
        dashboardPage.clickOnOutboxTab();
        String actual =dashboardPage.getTransactionNumber();
        Assert.assertEquals(actual,expect,"not match");
    }


}
