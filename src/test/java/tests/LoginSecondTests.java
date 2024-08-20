package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AuthScreen;

public class LoginSecondTests extends AppiumConfig {

    @Test
    public void loginSuccess() {
        new AuthScreen(driver)
                .fillEmail("kate24@gmail.com")
                .fillPassword("kaT45#kit")
                .submitLogin()
                .isAccountOpened()
                .logout();
    }

    @Test
    public void loginSuccessModel() {
        new AuthScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("kate24@gmail.com")
                        .password("kaT45#kit").build())
                .submitLogin()
                .isAccountOpened()
                .logout();
    }
    @Test
    public void loginWrongEmail(){
        new AuthScreen(driver).fillLoginRegistrationForm(Auth.builder().email("kate24gmail.com").password("kaT45#kit")
                        .build())
                .submitLoginNegative()
                .isErrorMessageContainsText("Login or Password incorrect");
    }
}
