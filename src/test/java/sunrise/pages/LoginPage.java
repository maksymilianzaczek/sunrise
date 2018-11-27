package sunrise.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(id = "sociallogin_username")
    private WebElementFacade loginInput;
    @FindBy(id = "sociallogin_password")
    private WebElementFacade passwordInput;
    @FindBy(id = "login_submit")
    private WebElementFacade signInButton;


    public void typeLogin(final String login) {
        loginInput.type(login);
    }

    public void typePassword(final String password) {
        passwordInput.type(password);
    }

    public void clickOnSignIn() {
        signInButton.click();
    }
}
