package sunrise.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageObject {


    @FindBy(id = "register_rep:userId")
    private WebElementFacade emailRegisterButton;
    @FindBy(id = "register_rep:password")
    private WebElementFacade passwordRegisterButton;
    @FindBy(id = "register_rep:password_confirm")
    private WebElementFacade confirmPasswordRegisterButton;
    @FindBy(id = "register_familyName")
    private WebElementFacade lastNameRegisterButton;
    @FindBy(xpath = "//*[@value='Register']")
    private WebElementFacade register;


    public void typeEmailRegistration(final String email) {
        emailRegisterButton.type(email);
    }

    public void typePassword(final String password) {
        passwordRegisterButton.type(password);

    }

    public void typeConfirmPassword(final String confirmPassword) {
        confirmPasswordRegisterButton.type(confirmPassword);
    }

    public void typeLastName(final String lastName) {
        lastNameRegisterButton.type(lastName);
    }

    public void clickRegister() {
        register.click();
    }
}