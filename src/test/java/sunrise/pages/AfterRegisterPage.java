package sunrise.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class AfterRegisterPage extends PageObject {

    @FindBy(id = "main")
    private WebElementFacade ThankYouMessage;

    public String getThankYouMessageVisible() {
        return ThankYouMessage.getText();
    }
}
