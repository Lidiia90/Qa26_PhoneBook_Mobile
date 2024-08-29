package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import models.Contact;
import org.openqa.selenium.support.FindBy;

public class AddNewContactScreen extends BaseScreen {
    public AddNewContactScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.sheygam.contactapp:id/inputName")
    AndroidElement nameEditText;
    @FindBy(id = "com.sheygam.contactapp:id/inputLastName")
    AndroidElement lastNameEditText;
    @FindBy(id = "com.sheygam.contactapp:id/inputEmail")
    AndroidElement emailEditText;
    @FindBy(id = "com.sheygam.contactapp:id/inputPhone")
    AndroidElement phoneEditText;
    @FindBy(id = "com.sheygam.contactapp:id/inputAddress")
    AndroidElement addressEditText;
    @FindBy(id = "com.sheygam.contactapp:id/inputDesc")
    AndroidElement descriptionEditText;
    @FindBy(id = "com.sheygam.contactapp:id/createBtn")
    AndroidElement createBtn;
    @FindBy(id = "com.sheygam.contactapp:id/updateBtn")
    AndroidElement updateBtn;
    @FindBy(id = "com.sheygam.contactapp:id/imageView2")
    AndroidElement textAboutUpdate;

    public AddNewContactScreen fillContactForm(Contact contact){
        should(nameEditText,5);
        type(nameEditText,contact.getName());
        type(lastNameEditText,contact.getLastName());
        type(emailEditText,contact.getEmail());
        type(phoneEditText,contact.getPhone());
        type(addressEditText,contact.getAddress());
        type(descriptionEditText,contact.getDescription());
        return this;
    }

    public ContactListScreen submitContactForm() {
        createBtn.click();
        return new ContactListScreen(driver);
    }


//    public ContactListScreen createContact(Contact contact){
//        should(nameEditText, 5);
//        type(nameEditText, contact.getName());
//        type(lastNameEditText, contact.getLastName());
//        type(emailEditText, contact.getEmail());
//        type(phoneEditText, contact.getPhone());
//        type(addressEditText, contact.getAddress());
//        type(descriptionEditText, contact.getDescription());
//        createBtn.click();
//        return new ContactListScreen(driver);
//    }

    public AddNewContactScreen submitContactFormNegative(){
        createBtn.click();
        return this;
    }

    public AddNewContactScreen isErrorContainsText(String text){
        checkAlertText(text);
        return this;
    }
    public AddNewContactScreen editEmailField(String newEmail) {
        should(emailEditText, 10);
        emailEditText.clear();
        emailEditText.sendKeys(newEmail);
        return this;
    }

    public AddNewContactScreen submitConForm() {
        updateBtn.click();
        return this;
    }

    public AddNewContactScreen contactWasUpdated() {
        should(textAboutUpdate, 15);
        //isShouldHave(textAboutUpdate, "Contact was updated!", 10);
        return this;
    }
}