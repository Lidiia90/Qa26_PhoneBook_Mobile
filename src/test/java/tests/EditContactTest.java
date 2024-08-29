package tests;

import config.AppiumConfig;
import models.Auth;
import models.Contact;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.AuthScreen;
import screens.ContactListScreen;

public class EditContactTest extends AppiumConfig {

    @BeforeClass
    public void preCondition() {
        new AuthScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("kate24@gmail.com")
                        .password("kaT45#kit").build())
                .submitLogin()
                .isActivityTitleDisplayed("Contact list");
    }

    @Test
    public void editContactEmailPositive() {
        String newEmail = "jane.doe@example.com";
        new ContactListScreen(driver)
                .editOneContact()
                .openContactForm()
                .editEmailField(newEmail)
                .submitConForm()
                .contactWasUpdated();
    }

    @AfterClass
    public void postCondition() {
        new ContactListScreen(driver).logout();
    }
}
