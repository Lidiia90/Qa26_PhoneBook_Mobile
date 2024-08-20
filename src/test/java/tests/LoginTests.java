package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {

    @Test
    public void loginSuccess(){
       // boolean result = new SplashScreen(driver).checkCurrentVersion("Version 1.0.0")

        boolean result = new AuthScreen(driver)
                .fillEmail("kate24@gmail.com")
                .fillPassword("kaT45#kit")
                .submitLogin()
                .isActivityTitleDisplayed("Contact list");
        Assert.assertTrue(result);
    }
    @Test
    public void loginSuccessModel(){
     //  boolean result = new SplashScreen(driver)
              //  .checkCurrentVersion("Version 1.0.0")
        boolean result = new AuthScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("kate24@gmail.com").password("kaT45#kit")
                        .build())
                .submitLogin()
                .isActivityTitleDisplayed("Contact list");
        Assert.assertTrue(result);
    }
    @Test
    public void loginSuccessModel2() {
        Assert.assertTrue(new AuthScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("kate24@gmail.com")
                        .password("kaT45#kit").build())
                .submitLogin()
                .isActivityTitleDisplayed("Contact list"));
    }
    @Test
    public void loginWrongEmail(){
        new AuthScreen(driver).fillLoginRegistrationForm(Auth.builder().email("kate24gmail.com").password("kaT45#kit")
                        .build())
                .submitLoginNegative()
                .isErrorMessageContainsText("Login or Password incorrect");
    }
    @Test
    public void loginWrongPassword(){
        new AuthScreen(driver).fillLoginRegistrationForm(Auth.builder().email("kate24@gmail.com").password("kit")
                        .build())
                .submitLoginNegative()
                .isErrorMessageContainsText("Login or Password incorrect");
    }
    @Test
    public void loginUnregisteredUser(){
        new AuthScreen(driver).fillLoginRegistrationForm(Auth.builder().email("kate@gmail.com").password("kitT565*")
                        .build())
                .submitLoginNegative()
                .isErrorMessageContainsText("Login or Password incorrect");
    }

    @AfterMethod
    public void postCondition(){
        new ContactListScreen(driver).logout();
    }
}
