package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.AuthScreen;
import screens.ContactListScreen;

public class DeleteContactTests extends AppiumConfig {

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
    public void deleteFirstContact() {
new ContactListScreen(driver)
        .deleteFirstContact()
        .isListSizeLessThenOne();
    }
    @Test
    public void removeAllContactSuccess(){
        new ContactListScreen(driver)
                .removeAllContacts()
                .inNoContactsHere();
    }
}

