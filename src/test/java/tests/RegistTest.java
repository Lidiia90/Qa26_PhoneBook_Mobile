package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthScreen;
import screens.ContactListScreen;

import java.util.Random;

public class RegistTest extends AppiumConfig {
    @Test
    public void registrationSuccess(){
        int i = new Random().nextInt(1000);
        new AuthScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email(i + "kate@gmail.com")
                        .password("kaT45#kit").build())
                .submitRegistration()
                .isAccountOpened()
                .logout();
    }

    @Test
    public void registrationWrongEmail(){
        new AuthScreen(driver).fillLoginRegistrationForm(Auth.builder().email("kate24gmail.com").password("klaR45#kit")
                        .build())
                .submitRegistrationNegative();
    }
    @Test
    public void registrationWrongPassword(){
        new AuthScreen(driver).fillLoginRegistrationForm(Auth.builder().email("kate24@gmail.com").password("kit")
                        .build())
                .submitRegistrationNegative();
    }
    @Test
    public void registrationRegisteredUser(){
        new AuthScreen(driver).fillLoginRegistrationForm(Auth.builder().email("kate24@gmail.com").password("kaT45#kit")
                        .build())
                .submitRegistrationNegative2()
                .isErrorMessageContainsText("User already exists");
    }

}

