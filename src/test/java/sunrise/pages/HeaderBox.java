package sunrise.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class HeaderBox extends PageObject {

    @FindBy(xpath = "//*[contains(@class,'userinfo-sociallogin')]")
    private WebElementFacade signInOrRegisterButton;
    @FindBy(xpath = "//*[contains(@class,'signout')]")
    private WebElementFacade signOutButton;
    @FindBy()
    private WebElementFacade signInButton;


    public void clickOnSignInOrRegister() {
        signInOrRegisterButton.click();
    }


    public boolean isSignOutButtonVisible() {
        return signOutButton.isVisible();
    }

    public void clickOnSignOut() {
        signOutButton.click();
    }

    public boolean isSignInOrRegisterButtonVisible() {
        return signInOrRegisterButton.isVisible();
    }
}
