package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthScreen;
import screens.ContactListScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig{
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
                .submitRegistrationNegative()
                .isErrorMessageContainsText("{usrename=must be a well-formed email address");
    }
    @Test
    public void registrationWrongPassword(){
        new AuthScreen(driver).fillLoginRegistrationForm(Auth.builder().email("kate24@gmail.com").password("kit")
                        .build())
                .submitRegistrationNegative()
                .isErrorMessageContainsText("{password= At least 8 characters; Must contain at least 1 uppercase letter, 1 lowercase letter, and 1 number; Can contain special characters [@$#^&*!]}");
    }
    @Test
    public void registrationRegisteredUser(){
        new AuthScreen(driver).fillLoginRegistrationForm(Auth.builder().email("kate24@gmail.com").password("kaT45#kit")
                        .build())
                .submitRegistrationNegative()
                .isErrorMessageContainsText("User already exists");
    }
}

