package sunrise.features;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import sunrise.data.UserInformation;
import sunrise.domain.RegistrationData;
import sunrise.pages.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RegisterFeatures {

    final private String randomString = RandomStringUtils.randomAlphanumeric(13);
    final private String randomEmail = String.format("%s@gmai.com", randomString);
    final private String thankYouMessage = "Thank You";

    private HomePage homePage;
    private HeaderBox headerBox;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private AfterRegisterPage afterRegisterPage;

    @Given("^User is on register page$")
    public void userIsOnRegisterPage() {
        homePage.open();
        headerBox.clickOnSignInOrRegister();
        loginPage.clickOnCreateAccount();
    }

    @When("^he submits form with unique e-mail$")
    public void heSubmitsFormWithUniqueEmail() {
        registerPage.typeEmailRegistration(randomEmail);
    }


    @When("^and with correct data$")
    public void andWithCorrectData() {

        final RegistrationData registrationData = UserInformation.NEW_ACCOUNT_CREATION;
        registerPage.typePassword(registrationData.getPassword());
        registerPage.typeConfirmPassword(registrationData.getConfirmPassword());
        registerPage.typeLastName(registrationData.getLastName());
        registerPage.clickRegister();
    }

    @Then("^new user is registered$")
    public void newUserIsRegistered() {
        final String isThankYouMessageDisplayed = afterRegisterPage.getThankYouMessageVisible();
        assertThat(isThankYouMessageDisplayed).containsIgnoringCase(thankYouMessage);
    }
}
